package com.technologica.api.tlregen.resourcegen.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.jetbrains.annotations.Nullable;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenBlockstates;

import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraftforge.client.model.generators.ModelFile;

public final class TLReGenConfiguredModel {
	public static final int DEFAULT_WEIGHT = 1;
	public final ModelFile model;
	public final int rotationX;
	public final int rotationY;
	public final boolean uvLock;
	public final int weight;

	private static IntStream validRotations() {
		return IntStream.range(0, 4).map(i -> i * 90);
	}

	public static TLReGenConfiguredModel[] allYRotations(ModelFile model, int x, boolean uvlock) {
		return allYRotations(model, x, uvlock, DEFAULT_WEIGHT);
	}

	public static TLReGenConfiguredModel[] allYRotations(ModelFile model, int x, boolean uvlock, int weight) {
		return validRotations().mapToObj(y -> new TLReGenConfiguredModel(model, x, y, uvlock, weight)).toArray(TLReGenConfiguredModel[]::new);
	}

	public static TLReGenConfiguredModel[] allRotations(ModelFile model, boolean uvlock) {
		return allRotations(model, uvlock, DEFAULT_WEIGHT);
	}

	public static TLReGenConfiguredModel[] allRotations(ModelFile model, boolean uvlock, int weight) {
		return validRotations().mapToObj(x -> allYRotations(model, x, uvlock, weight)).flatMap(Arrays::stream).toArray(TLReGenConfiguredModel[]::new);
	}

	public TLReGenConfiguredModel(ModelFile model, int rotationX, int rotationY, boolean uvLock, int weight) {
		Preconditions.checkNotNull(model);
		this.model = model;
		checkRotation(rotationX, rotationY);
		this.rotationX = rotationX;
		this.rotationY = rotationY;
		this.uvLock = uvLock;
		checkWeight(weight);
		this.weight = weight;
	}

	public TLReGenConfiguredModel(ModelFile model, int rotationX, int rotationY, boolean uvLock) {
		this(model, rotationX, rotationY, uvLock, DEFAULT_WEIGHT);
	}

	public TLReGenConfiguredModel(ModelFile model) {
		this(model, 0, 0, false);
	}

	static void checkRotation(int rotationX, int rotationY) {
		Preconditions.checkArgument(BlockModelRotation.by(rotationX, rotationY) != null, "Invalid model rotation x=%d, y=%d", rotationX, rotationY);
	}

	static void checkWeight(int weight) {
		Preconditions.checkArgument(weight >= 1, "Model weight must be greater than or equal to 1. Found: %d", weight);
	}

	public JsonObject toJSON(boolean includeWeight) {
		JsonObject modelJson = new JsonObject();
		modelJson.addProperty("model", model.getLocation().toString());
		if (rotationX != 0)
			modelJson.addProperty("x", rotationX);
		if (rotationY != 0)
			modelJson.addProperty("y", rotationY);
		if (uvLock)
			modelJson.addProperty("uvlock", uvLock);
		if (includeWeight && weight != DEFAULT_WEIGHT)
			modelJson.addProperty("weight", weight);
		return modelJson;
	}

	public static Builder<?> builder() {
		return new Builder<>();
	}

	static Builder<TLReGenVariantBlockStateBuilder> builder(TLReGenVariantBlockStateBuilder outer, TLReGenVariantBlockStateBuilder.PartialBlockstate state) {
		return new Builder<>(models -> outer.setModels(state, models), ImmutableList.of());
	}

	static Builder<TLReGenMultiPartBlockStateBuilder.PartBuilder> builder(TLReGenMultiPartBlockStateBuilder outer) {
		return new Builder<TLReGenMultiPartBlockStateBuilder.PartBuilder>(models -> {
			TLReGenMultiPartBlockStateBuilder.PartBuilder ret = outer.new PartBuilder(new TLReGenBlockstates.ConfiguredModelList(models));
			outer.addPart(ret);
			return ret;
		}, ImmutableList.of());
	}

	public static class Builder<T> {
		private ModelFile model;
		@Nullable
		private final Function<TLReGenConfiguredModel[], T> callback;
		private final List<TLReGenConfiguredModel> otherModels;
		private int rotationX;
		private int rotationY;
		private boolean uvLock;
		private int weight = DEFAULT_WEIGHT;

		Builder() {
			this(null, ImmutableList.of());
		}

		Builder(@Nullable Function<TLReGenConfiguredModel[], T> callback, List<TLReGenConfiguredModel> otherModels) {
			this.callback = callback;
			this.otherModels = otherModels;
		}

		public Builder<T> modelFile(ModelFile model) {
			Preconditions.checkNotNull(model, "Model must not be null");
			this.model = model;
			return this;
		}

		public Builder<T> rotationX(int value) {
			checkRotation(value, rotationY);
			rotationX = value;
			return this;
		}

		public Builder<T> rotationY(int value) {
			checkRotation(rotationX, value);
			rotationY = value;
			return this;
		}

		public Builder<T> uvLock(boolean value) {
			uvLock = value;
			return this;
		}

		public Builder<T> weight(int value) {
			checkWeight(value);
			weight = value;
			return this;
		}

		public TLReGenConfiguredModel buildLast() {
			return new TLReGenConfiguredModel(model, rotationX, rotationY, uvLock, weight);
		}

		public TLReGenConfiguredModel[] build() {
			return ObjectArrays.concat(otherModels.toArray(new TLReGenConfiguredModel[0]), buildLast());
		}

		public T addModel() {
			Preconditions.checkNotNull(callback, "Cannot use addModel() without an owning builder present");
			return callback.apply(build());
		}

		public Builder<T> nextModel() {
			return new Builder<>(callback, Arrays.asList(build()));
		}
	}
}
