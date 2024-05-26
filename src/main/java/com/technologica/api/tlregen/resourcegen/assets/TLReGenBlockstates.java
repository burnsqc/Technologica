package com.technologica.api.tlregen.resourcegen.assets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.technologica.api.tlregen.resourcegen.TLReGenAssetGenerator;
import com.technologica.api.tlregen.resourcegen.util.TLReGenConfiguredModel;
import com.technologica.api.tlregen.resourcegen.util.TLReGenVariantBlockStateBuilder;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.IGeneratedBlockState;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLReGenBlockstates extends TLReGenAssetGenerator {
	protected final static Map<Block, IGeneratedBlockState> resources = new HashMap<>();

	@Override
	public final CompletableFuture<?> run(final CachedOutput cache) {
		resources.clear();
		populate();
		CompletableFuture<?>[] futures = new CompletableFuture<?>[resources.size()];
		int i = 0;
		for (Map.Entry<Block, IGeneratedBlockState> entry : resources.entrySet()) {
			ResourceLocation blockName = Preconditions.checkNotNull(ForgeRegistries.BLOCKS.getKey(entry.getKey()));
			futures[i++] = DataProvider.saveStable(cache, entry.getValue().toJson(), packOutput.getOutputFolder(target).resolve(modid).resolve("blockstates").resolve(blockName.getPath() + ".json"));
		}
		return CompletableFuture.allOf(futures);
	}

	@Override
	public final String getName() {
		return super.getName() + ".blockstates";
	}

	/*
	 * HELPER METHODS
	 */

	public static class ConfiguredModelList {
		private final List<TLReGenConfiguredModel> models;

		private ConfiguredModelList(List<TLReGenConfiguredModel> models) {
			Preconditions.checkArgument(!models.isEmpty());
			this.models = models;
		}

		public ConfiguredModelList(TLReGenConfiguredModel model) {
			this(ImmutableList.of(model));
		}

		public ConfiguredModelList(TLReGenConfiguredModel... models) {
			this(Arrays.asList(models));
		}

		public JsonElement toJSON() {
			if (models.size() == 1) {
				return models.get(0).toJSON(false);
			} else {
				JsonArray ret = new JsonArray();
				for (TLReGenConfiguredModel m : models) {
					ret.add(m.toJSON(true));
				}
				return ret;
			}
		}

		public ConfiguredModelList append(TLReGenConfiguredModel... models) {
			return new ConfiguredModelList(ImmutableList.<TLReGenConfiguredModel>builder().addAll(this.models).add(models).build());
		}
	}

	public static TLReGenVariantBlockStateBuilder getVariantBuilder(Block b) {
		if (resources.containsKey(b)) {
			IGeneratedBlockState old = resources.get(b);
			Preconditions.checkState(old instanceof TLReGenVariantBlockStateBuilder);
			return (TLReGenVariantBlockStateBuilder) old;
		} else {
			TLReGenVariantBlockStateBuilder ret = new TLReGenVariantBlockStateBuilder(b);
			resources.put(b, ret);
			return ret;
		}
	}

	public MultiPartBlockStateBuilder getMultipartBuilder(Block b) {
		if (resources.containsKey(b)) {
			IGeneratedBlockState old = resources.get(b);
			Preconditions.checkState(old instanceof MultiPartBlockStateBuilder);
			return (MultiPartBlockStateBuilder) old;
		} else {
			MultiPartBlockStateBuilder ret = new MultiPartBlockStateBuilder(b);
			resources.put(b, ret);
			return ret;
		}
	}

	public static ResourceLocation modLoc(String name) {
		return new ResourceLocation(modid, name);
	}

	public ResourceLocation mcLoc(String name) {
		return new ResourceLocation(name);
	}

	private static ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}

	private static String name(Block block) {
		return key(block).getPath();
	}

	public static ResourceLocation blockTexture(Block block) {
		ResourceLocation name = key(block);
		return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + name.getPath());
	}

	private ResourceLocation extend(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}

	public static void simpleBlock(Block block, ModelFile model) {
		simpleBlock(block, new TLReGenConfiguredModel(model));
	}

	public static void simpleBlockWithItem(Block block, ModelFile model) {
		simpleBlock(block, model);
	}

	public static ModelFile cubeAll(Block block) {
		return TLReGenModelsBlock.cubeAll(name(block), blockTexture(block));
	}

	public void simpleBlock(Block block) {
		simpleBlock(block, cubeAll(block));
	}

	public void simpleBlock(Block block, Function<ModelFile, TLReGenConfiguredModel[]> expander) {
		simpleBlock(block, expander.apply(cubeAll(block)));
	}

	public static void simpleBlock(Block block, TLReGenConfiguredModel... models) {
		getVariantBuilder(block).partialState().setModels(models);
	}

	public void axisBlock(RotatedPillarBlock block) {
		axisBlock(block, blockTexture(block));
	}

	public void logBlock(RotatedPillarBlock block) {
		axisBlock(block, blockTexture(block), extend(blockTexture(block), "_top"));
	}

	public void axisBlock(RotatedPillarBlock block, ResourceLocation baseName) {
		axisBlock(block, extend(baseName, "_side"), extend(baseName, "_end"));
	}

	public void axisBlock(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
		axisBlock(block, TLReGenModelsBlock.cubeColumn(name(block), side, end), TLReGenModelsBlock.cubeColumnHorizontal(name(block) + "_horizontal", side, end));
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, String renderType) {
		axisBlockWithRenderType(block, blockTexture(block), renderType);
	}

	public void logBlockWithRenderType(RotatedPillarBlock block, String renderType) {
		axisBlockWithRenderType(block, blockTexture(block), extend(blockTexture(block), "_top"), renderType);
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation baseName, String renderType) {
		axisBlockWithRenderType(block, extend(baseName, "_side"), extend(baseName, "_end"), renderType);
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, String renderType) {
		axisBlock(block, TLReGenModelsBlock.cubeColumn(name(block), side, end).renderType(renderType), TLReGenModelsBlock.cubeColumnHorizontal(name(block) + "_horizontal", side, end).renderType(renderType));
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation renderType) {
		axisBlockWithRenderType(block, blockTexture(block), renderType);
	}

	public void logBlockWithRenderType(RotatedPillarBlock block, ResourceLocation renderType) {
		axisBlockWithRenderType(block, blockTexture(block), extend(blockTexture(block), "_top"), renderType);
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation baseName, ResourceLocation renderType) {
		axisBlockWithRenderType(block, extend(baseName, "_side"), extend(baseName, "_end"), renderType);
	}

	public void axisBlockWithRenderType(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end, ResourceLocation renderType) {
		axisBlock(block, TLReGenModelsBlock.cubeColumn(name(block), side, end).renderType(renderType), TLReGenModelsBlock.cubeColumnHorizontal(name(block) + "_horizontal", side, end).renderType(renderType));
	}

	public void axisBlock(RotatedPillarBlock block, ModelFile vertical, ModelFile horizontal) {
		getVariantBuilder(block).partialState().with(RotatedPillarBlock.AXIS, Axis.Y).modelForState().modelFile(vertical).addModel().partialState().with(RotatedPillarBlock.AXIS, Axis.Z).modelForState().modelFile(horizontal).rotationX(90).addModel().partialState().with(RotatedPillarBlock.AXIS, Axis.X).modelForState().modelFile(horizontal).rotationX(90).rotationY(90).addModel();
	}

	private static final int DEFAULT_ANGLE_OFFSET = 180;

	public void horizontalBlock(Block block, ResourceLocation side, ResourceLocation front, ResourceLocation top) {
		horizontalBlock(block, TLReGenModelsBlock.orientable(name(block), side, front, top));
	}

	public void horizontalBlock(Block block, ModelFile model) {
		horizontalBlock(block, model, DEFAULT_ANGLE_OFFSET);
	}

	public void horizontalBlock(Block block, ModelFile model, int angleOffset) {
		horizontalBlock(block, $ -> model, angleOffset);
	}

	public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
		horizontalBlock(block, modelFunc, DEFAULT_ANGLE_OFFSET);
	}

	public void horizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
		getVariantBuilder(block).forAllStates(state -> TLReGenConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + angleOffset) % 360).build());
	}

	public void horizontalFaceBlock(Block block, ModelFile model) {
		horizontalFaceBlock(block, model, DEFAULT_ANGLE_OFFSET);
	}

	public void horizontalFaceBlock(Block block, ModelFile model, int angleOffset) {
		horizontalFaceBlock(block, $ -> model, angleOffset);
	}

	public void horizontalFaceBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
		horizontalFaceBlock(block, modelFunc, DEFAULT_ANGLE_OFFSET);
	}

	public void horizontalFaceBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
		getVariantBuilder(block).forAllStates(state -> TLReGenConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationX(state.getValue(BlockStateProperties.ATTACH_FACE).ordinal() * 90).rotationY((((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + angleOffset) + (state.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING ? 180 : 0)) % 360).build());
	}

	public void directionalBlock(Block block, ModelFile model) {
		directionalBlock(block, model, DEFAULT_ANGLE_OFFSET);
	}

	public void directionalBlock(Block block, ModelFile model, int angleOffset) {
		directionalBlock(block, $ -> model, angleOffset);
	}

	public void directionalBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
		directionalBlock(block, modelFunc, DEFAULT_ANGLE_OFFSET);
	}

	public void directionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
		getVariantBuilder(block).forAllStates(state -> {
			Direction dir = state.getValue(BlockStateProperties.FACING);
			return TLReGenConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationX(dir == Direction.DOWN ? 180 : dir.getAxis().isHorizontal() ? 90 : 0).rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + angleOffset) % 360).build();
		});
	}

	public void stairsBlock(StairBlock block, ResourceLocation texture) {
		stairsBlock(block, texture, texture, texture);
	}

	public void stairsBlock(StairBlock block, String name, ResourceLocation texture) {
		stairsBlock(block, name, texture, texture, texture);
	}

	public void stairsBlock(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		stairsBlockInternal(block, key(block).toString(), side, bottom, top);
	}

	public void stairsBlock(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		stairsBlockInternal(block, name + "_stairs", side, bottom, top);
	}

	public void stairsBlockWithRenderType(StairBlock block, ResourceLocation texture, String renderType) {
		stairsBlockWithRenderType(block, texture, texture, texture, renderType);
	}

	public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation texture, String renderType) {
		stairsBlockWithRenderType(block, name, texture, texture, texture, renderType);
	}

	public void stairsBlockWithRenderType(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType) {
		stairsBlockInternalWithRenderType(block, key(block).toString(), side, bottom, top, ResourceLocation.tryParse(renderType));
	}

	public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, String renderType) {
		stairsBlockInternalWithRenderType(block, name + "_stairs", side, bottom, top, ResourceLocation.tryParse(renderType));
	}

	public void stairsBlockWithRenderType(StairBlock block, ResourceLocation texture, ResourceLocation renderType) {
		stairsBlockWithRenderType(block, texture, texture, texture, renderType);
	}

	public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation texture, ResourceLocation renderType) {
		stairsBlockWithRenderType(block, name, texture, texture, texture, renderType);
	}

	public void stairsBlockWithRenderType(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		stairsBlockInternalWithRenderType(block, key(block).toString(), side, bottom, top, renderType);
	}

	public void stairsBlockWithRenderType(StairBlock block, String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		stairsBlockInternalWithRenderType(block, name + "_stairs", side, bottom, top, renderType);
	}

	private void stairsBlockInternal(StairBlock block, String baseName, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		ModelFile stairs = TLReGenModelsBlock.stairs(baseName, side, bottom, top);
		ModelFile stairsInner = TLReGenModelsBlock.stairsInner(baseName + "_inner", side, bottom, top);
		ModelFile stairsOuter = TLReGenModelsBlock.stairsOuter(baseName + "_outer", side, bottom, top);
		stairsBlock(block, stairs, stairsInner, stairsOuter);
	}

	private void stairsBlockInternalWithRenderType(StairBlock block, String baseName, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		ModelFile stairs = TLReGenModelsBlock.stairs(baseName, side, bottom, top).renderType(renderType);
		ModelFile stairsInner = TLReGenModelsBlock.stairsInner(baseName + "_inner", side, bottom, top).renderType(renderType);
		ModelFile stairsOuter = TLReGenModelsBlock.stairsOuter(baseName + "_outer", side, bottom, top).renderType(renderType);
		stairsBlock(block, stairs, stairsInner, stairsOuter);
	}

	public void stairsBlock(StairBlock block, ModelFile stairs, ModelFile stairsInner, ModelFile stairsOuter) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			Direction facing = state.getValue(StairBlock.FACING);
			Half half = state.getValue(StairBlock.HALF);
			StairsShape shape = state.getValue(StairBlock.SHAPE);
			int yRot = (int) facing.getClockWise().toYRot(); // Stairs model is rotated 90 degrees clockwise for some reason
			if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
				yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
			}
			if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
				yRot += 90; // Top stairs are rotated 90 degrees clockwise
			}
			yRot %= 360;
			boolean uvlock = yRot != 0 || half == Half.TOP; // Don't set uvlock for states that have no rotation
			return TLReGenConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? stairsInner : stairsOuter).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(uvlock).build();
		}, StairBlock.WATERLOGGED);
	}

	public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
		slabBlock(block, doubleslab, texture, texture, texture);
	}

	public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
		slabBlock(block, TLReGenModelsBlock.slab(name(block), side, bottom, top), TLReGenModelsBlock.slabTop(name(block) + "_top", side, bottom, top), TLReGenModelsBlock.getExistingFile(doubleslab));
	}

	public void slabBlock(SlabBlock block, ModelFile bottom, ModelFile top, ModelFile doubleslab) {
		getVariantBuilder(block).partialState().with(SlabBlock.TYPE, SlabType.BOTTOM).addModels(new TLReGenConfiguredModel(bottom)).partialState().with(SlabBlock.TYPE, SlabType.TOP).addModels(new TLReGenConfiguredModel(top)).partialState().with(SlabBlock.TYPE, SlabType.DOUBLE).addModels(new TLReGenConfiguredModel(doubleslab));
	}

	public void buttonBlock(ButtonBlock block, ResourceLocation texture) {
		ModelFile button = TLReGenModelsBlock.button(name(block), texture);
		ModelFile buttonPressed = TLReGenModelsBlock.buttonPressed(name(block) + "_pressed", texture);
		buttonBlock(block, button, buttonPressed);
	}

	public void buttonBlock(ButtonBlock block, ModelFile button, ModelFile buttonPressed) {
		getVariantBuilder(block).forAllStates(state -> {
			Direction facing = state.getValue(ButtonBlock.FACING);
			AttachFace face = state.getValue(ButtonBlock.FACE);
			boolean powered = state.getValue(ButtonBlock.POWERED);
			return TLReGenConfiguredModel.builder().modelFile(powered ? buttonPressed : button).rotationX(face == AttachFace.FLOOR ? 0 : (face == AttachFace.WALL ? 90 : 180)).rotationY((int) (face == AttachFace.CEILING ? facing : facing.getOpposite()).toYRot()).uvLock(face == AttachFace.WALL).build();
		});
	}

	public void pressurePlateBlock(PressurePlateBlock block, ResourceLocation texture) {
		ModelFile pressurePlate = TLReGenModelsBlock.pressurePlate(name(block), texture);
		ModelFile pressurePlateDown = TLReGenModelsBlock.pressurePlateDown(name(block) + "_down", texture);
		pressurePlateBlock(block, pressurePlate, pressurePlateDown);
	}

	public void pressurePlateBlock(PressurePlateBlock block, ModelFile pressurePlate, ModelFile pressurePlateDown) {
		getVariantBuilder(block).partialState().with(PressurePlateBlock.POWERED, true).addModels(new TLReGenConfiguredModel(pressurePlateDown)).partialState().with(PressurePlateBlock.POWERED, false).addModels(new TLReGenConfiguredModel(pressurePlate));
	}

	public void pressurePlateBlockWithRenderType(PressurePlateBlock block, ResourceLocation texture, String renderType) {
		ModelFile pressurePlate = TLReGenModelsBlock.pressurePlate(name(block), texture).renderType(renderType);
		ModelFile pressurePlateDown = TLReGenModelsBlock.pressurePlateDown(name(block) + "_down", texture).renderType(renderType);
		pressurePlateBlock(block, pressurePlate, pressurePlateDown);
	}

	public void signBlock(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ResourceLocation texture) {
		ModelFile sign = TLReGenModelsBlock.sign(name(signBlock), texture);
		signBlock(signBlock, wallSignBlock, sign);
	}

	public void signBlock(StandingSignBlock signBlock, WallSignBlock wallSignBlock, ModelFile sign) {
		simpleBlock(signBlock, sign);
		simpleBlock(wallSignBlock, sign);
	}

	public void fourWayBlock(CrossCollisionBlock block, ModelFile post, ModelFile side) {
		MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().end();
		fourWayMultipart(builder, side);
	}

	public void fourWayMultipart(MultiPartBlockStateBuilder builder, ModelFile side) {
		PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(e -> {
			Direction dir = e.getKey();
			if (dir.getAxis().isHorizontal()) {
				builder.part().modelFile(side).rotationY((((int) dir.toYRot()) + 180) % 360).uvLock(true).addModel().condition(e.getValue(), true);
			}
		});
	}

	public void fenceBlock(FenceBlock block, ResourceLocation texture) {
		String baseName = key(block).toString();
		fourWayBlock(block, TLReGenModelsBlock.fencePost(baseName + "_post", texture), TLReGenModelsBlock.fenceSide(baseName + "_side", texture));
	}

	public void fenceBlock(FenceBlock block, String name, ResourceLocation texture) {
		fourWayBlock(block, TLReGenModelsBlock.fencePost(name + "_fence_post", texture), TLReGenModelsBlock.fenceSide(name + "_fence_side", texture));
	}

	public void fenceBlockWithRenderType(FenceBlock block, ResourceLocation texture, String renderType) {
		String baseName = key(block).toString();
		fourWayBlock(block, TLReGenModelsBlock.fencePost(baseName + "_post", texture).renderType(renderType), TLReGenModelsBlock.fenceSide(baseName + "_side", texture).renderType(renderType));
	}

	public void fenceBlockWithRenderType(FenceBlock block, String name, ResourceLocation texture, String renderType) {
		fourWayBlock(block, TLReGenModelsBlock.fencePost(name + "_fence_post", texture).renderType(renderType), TLReGenModelsBlock.fenceSide(name + "_fence_side", texture).renderType(renderType));
	}

	public void fenceBlockWithRenderType(FenceBlock block, ResourceLocation texture, ResourceLocation renderType) {
		String baseName = key(block).toString();
		fourWayBlock(block, TLReGenModelsBlock.fencePost(baseName + "_post", texture).renderType(renderType), TLReGenModelsBlock.fenceSide(baseName + "_side", texture).renderType(renderType));
	}

	public void fenceBlockWithRenderType(FenceBlock block, String name, ResourceLocation texture, ResourceLocation renderType) {
		fourWayBlock(block, TLReGenModelsBlock.fencePost(name + "_fence_post", texture).renderType(renderType), TLReGenModelsBlock.fenceSide(name + "_fence_side", texture).renderType(renderType));
	}

	public void fenceGateBlock(FenceGateBlock block, ResourceLocation texture) {
		fenceGateBlockInternal(block, key(block).toString(), texture);
	}

	public void fenceGateBlock(FenceGateBlock block, String name, ResourceLocation texture) {
		fenceGateBlockInternal(block, name + "_fence_gate", texture);
	}

	public void fenceGateBlockWithRenderType(FenceGateBlock block, ResourceLocation texture, String renderType) {
		fenceGateBlockInternalWithRenderType(block, key(block).toString(), texture, ResourceLocation.tryParse(renderType));
	}

	public void fenceGateBlockWithRenderType(FenceGateBlock block, String name, ResourceLocation texture, String renderType) {
		fenceGateBlockInternalWithRenderType(block, name + "_fence_gate", texture, ResourceLocation.tryParse(renderType));
	}

	public void fenceGateBlockWithRenderType(FenceGateBlock block, ResourceLocation texture, ResourceLocation renderType) {
		fenceGateBlockInternalWithRenderType(block, key(block).toString(), texture, renderType);
	}

	public void fenceGateBlockWithRenderType(FenceGateBlock block, String name, ResourceLocation texture, ResourceLocation renderType) {
		fenceGateBlockInternalWithRenderType(block, name + "_fence_gate", texture, renderType);
	}

	private void fenceGateBlockInternal(FenceGateBlock block, String baseName, ResourceLocation texture) {
		ModelFile gate = TLReGenModelsBlock.fenceGate(baseName, texture);
		ModelFile gateOpen = TLReGenModelsBlock.fenceGateOpen(baseName + "_open", texture);
		ModelFile gateWall = TLReGenModelsBlock.fenceGateWall(baseName + "_wall", texture);
		ModelFile gateWallOpen = TLReGenModelsBlock.fenceGateWallOpen(baseName + "_wall_open", texture);
		fenceGateBlock(block, gate, gateOpen, gateWall, gateWallOpen);
	}

	private void fenceGateBlockInternalWithRenderType(FenceGateBlock block, String baseName, ResourceLocation texture, ResourceLocation renderType) {
		ModelFile gate = TLReGenModelsBlock.fenceGate(baseName, texture).renderType(renderType);
		ModelFile gateOpen = TLReGenModelsBlock.fenceGateOpen(baseName + "_open", texture).renderType(renderType);
		ModelFile gateWall = TLReGenModelsBlock.fenceGateWall(baseName + "_wall", texture).renderType(renderType);
		ModelFile gateWallOpen = TLReGenModelsBlock.fenceGateWallOpen(baseName + "_wall_open", texture).renderType(renderType);
		fenceGateBlock(block, gate, gateOpen, gateWall, gateWallOpen);
	}

	public void fenceGateBlock(FenceGateBlock block, ModelFile gate, ModelFile gateOpen, ModelFile gateWall, ModelFile gateWallOpen) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			ModelFile model = gate;
			if (state.getValue(FenceGateBlock.IN_WALL)) {
				model = gateWall;
			}
			if (state.getValue(FenceGateBlock.OPEN)) {
				model = model == gateWall ? gateWallOpen : gateOpen;
			}
			return TLReGenConfiguredModel.builder().modelFile(model).rotationY((int) state.getValue(FenceGateBlock.FACING).toYRot()).uvLock(true).build();
		}, FenceGateBlock.POWERED);
	}

	public void wallBlock(WallBlock block, ResourceLocation texture) {
		wallBlockInternal(block, key(block).toString(), texture);
	}

	public void wallBlock(WallBlock block, String name, ResourceLocation texture) {
		wallBlockInternal(block, name + "_wall", texture);
	}

	public void wallBlockWithRenderType(WallBlock block, ResourceLocation texture, String renderType) {
		wallBlockInternalWithRenderType(block, key(block).toString(), texture, ResourceLocation.tryParse(renderType));
	}

	public void wallBlockWithRenderType(WallBlock block, String name, ResourceLocation texture, String renderType) {
		wallBlockInternalWithRenderType(block, name + "_wall", texture, ResourceLocation.tryParse(renderType));
	}

	public void wallBlockWithRenderType(WallBlock block, ResourceLocation texture, ResourceLocation renderType) {
		wallBlockInternalWithRenderType(block, key(block).toString(), texture, renderType);
	}

	public void wallBlockWithRenderType(WallBlock block, String name, ResourceLocation texture, ResourceLocation renderType) {
		wallBlockInternalWithRenderType(block, name + "_wall", texture, renderType);
	}

	private void wallBlockInternal(WallBlock block, String baseName, ResourceLocation texture) {
		wallBlock(block, TLReGenModelsBlock.wallPost(baseName + "_post", texture), TLReGenModelsBlock.wallSide(baseName + "_side", texture), TLReGenModelsBlock.wallSideTall(baseName + "_side_tall", texture));
	}

	private void wallBlockInternalWithRenderType(WallBlock block, String baseName, ResourceLocation texture, ResourceLocation renderType) {
		wallBlock(block, TLReGenModelsBlock.wallPost(baseName + "_post", texture).renderType(renderType), TLReGenModelsBlock.wallSide(baseName + "_side", texture).renderType(renderType), TLReGenModelsBlock.wallSideTall(baseName + "_side_tall", texture).renderType(renderType));
	}

	public static final ImmutableMap<Direction, Property<WallSide>> WALL_PROPS = ImmutableMap.<Direction, Property<WallSide>>builder().put(Direction.EAST, BlockStateProperties.EAST_WALL).put(Direction.NORTH, BlockStateProperties.NORTH_WALL).put(Direction.SOUTH, BlockStateProperties.SOUTH_WALL).put(Direction.WEST, BlockStateProperties.WEST_WALL).build();

	public void wallBlock(WallBlock block, ModelFile post, ModelFile side, ModelFile sideTall) {
		MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().condition(WallBlock.UP, true).end();
		WALL_PROPS.entrySet().stream().filter(e -> e.getKey().getAxis().isHorizontal()).forEach(e -> {
			wallSidePart(builder, side, e, WallSide.LOW);
			wallSidePart(builder, sideTall, e, WallSide.TALL);
		});
	}

	private void wallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<WallSide>> entry, WallSide height) {
		builder.part().modelFile(model).rotationY((((int) entry.getKey().toYRot()) + 180) % 360).uvLock(true).addModel().condition(entry.getValue(), height);
	}

	public void paneBlock(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge) {
		paneBlockInternal(block, key(block).toString(), pane, edge);
	}

	public void paneBlock(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge) {
		paneBlockInternal(block, name + "_pane", pane, edge);
	}

	public void paneBlockWithRenderType(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, String renderType) {
		paneBlockInternalWithRenderType(block, key(block).toString(), pane, edge, ResourceLocation.tryParse(renderType));
	}

	public void paneBlockWithRenderType(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, String renderType) {
		paneBlockInternalWithRenderType(block, name + "_pane", pane, edge, ResourceLocation.tryParse(renderType));
	}

	public void paneBlockWithRenderType(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType) {
		paneBlockInternalWithRenderType(block, key(block).toString(), pane, edge, renderType);
	}

	public void paneBlockWithRenderType(IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType) {
		paneBlockInternalWithRenderType(block, name + "_pane", pane, edge, renderType);
	}

	private void paneBlockInternal(IronBarsBlock block, String baseName, ResourceLocation pane, ResourceLocation edge) {
		ModelFile post = TLReGenModelsBlock.panePost(baseName + "_post", pane, edge);
		ModelFile side = TLReGenModelsBlock.paneSide(baseName + "_side", pane, edge);
		ModelFile sideAlt = TLReGenModelsBlock.paneSideAlt(baseName + "_side_alt", pane, edge);
		ModelFile noSide = TLReGenModelsBlock.paneNoSide(baseName + "_noside", pane);
		ModelFile noSideAlt = TLReGenModelsBlock.paneNoSideAlt(baseName + "_noside_alt", pane);
		paneBlock(block, post, side, sideAlt, noSide, noSideAlt);
	}

	private void paneBlockInternalWithRenderType(IronBarsBlock block, String baseName, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType) {
		ModelFile post = TLReGenModelsBlock.panePost(baseName + "_post", pane, edge).renderType(renderType);
		ModelFile side = TLReGenModelsBlock.paneSide(baseName + "_side", pane, edge).renderType(renderType);
		ModelFile sideAlt = TLReGenModelsBlock.paneSideAlt(baseName + "_side_alt", pane, edge).renderType(renderType);
		ModelFile noSide = TLReGenModelsBlock.paneNoSide(baseName + "_noside", pane).renderType(renderType);
		ModelFile noSideAlt = TLReGenModelsBlock.paneNoSideAlt(baseName + "_noside_alt", pane).renderType(renderType);
		paneBlock(block, post, side, sideAlt, noSide, noSideAlt);
	}

	public void paneBlock(IronBarsBlock block, ModelFile post, ModelFile side, ModelFile sideAlt, ModelFile noSide, ModelFile noSideAlt) {
		MultiPartBlockStateBuilder builder = getMultipartBuilder(block).part().modelFile(post).addModel().end();
		PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(e -> {
			Direction dir = e.getKey();
			if (dir.getAxis().isHorizontal()) {
				boolean alt = dir == Direction.SOUTH;
				builder.part().modelFile(alt || dir == Direction.WEST ? sideAlt : side).rotationY(dir.getAxis() == Axis.X ? 90 : 0).addModel().condition(e.getValue(), true).end().part().modelFile(alt || dir == Direction.EAST ? noSideAlt : noSide).rotationY(dir == Direction.WEST ? 270 : dir == Direction.SOUTH ? 90 : 0).addModel().condition(e.getValue(), false);
			}
		});
	}

	public void doorBlock(DoorBlock block, ResourceLocation bottom, ResourceLocation top) {
		doorBlockInternal(block, key(block).toString(), bottom, top);
	}

	public void doorBlock(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top) {
		doorBlockInternal(block, name + "_door", bottom, top);
	}

	public void doorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, String renderType) {
		doorBlockInternalWithRenderType(block, key(block).toString(), bottom, top, ResourceLocation.tryParse(renderType));
	}

	public void doorBlockWithRenderType(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, String renderType) {
		doorBlockInternalWithRenderType(block, name + "_door", bottom, top, ResourceLocation.tryParse(renderType));
	}

	public void doorBlockWithRenderType(DoorBlock block, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		doorBlockInternalWithRenderType(block, key(block).toString(), bottom, top, renderType);
	}

	public void doorBlockWithRenderType(DoorBlock block, String name, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		doorBlockInternalWithRenderType(block, name + "_door", bottom, top, renderType);
	}

	private void doorBlockInternal(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top) {
		ModelFile bottomLeft = TLReGenModelsBlock.doorBottomLeft(baseName + "_bottom_left", bottom, top);
		ModelFile bottomLeftOpen = TLReGenModelsBlock.doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top);
		ModelFile bottomRight = TLReGenModelsBlock.doorBottomRight(baseName + "_bottom_right", bottom, top);
		ModelFile bottomRightOpen = TLReGenModelsBlock.doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top);
		ModelFile topLeft = TLReGenModelsBlock.doorTopLeft(baseName + "_top_left", bottom, top);
		ModelFile topLeftOpen = TLReGenModelsBlock.doorTopLeftOpen(baseName + "_top_left_open", bottom, top);
		ModelFile topRight = TLReGenModelsBlock.doorTopRight(baseName + "_top_right", bottom, top);
		ModelFile topRightOpen = TLReGenModelsBlock.doorTopRightOpen(baseName + "_top_right_open", bottom, top);
		doorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
	}

	private void doorBlockInternalWithRenderType(DoorBlock block, String baseName, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
		ModelFile bottomLeft = TLReGenModelsBlock.doorBottomLeft(baseName + "_bottom_left", bottom, top).renderType(renderType);
		ModelFile bottomLeftOpen = TLReGenModelsBlock.doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top).renderType(renderType);
		ModelFile bottomRight = TLReGenModelsBlock.doorBottomRight(baseName + "_bottom_right", bottom, top).renderType(renderType);
		ModelFile bottomRightOpen = TLReGenModelsBlock.doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top).renderType(renderType);
		ModelFile topLeft = TLReGenModelsBlock.doorTopLeft(baseName + "_top_left", bottom, top).renderType(renderType);
		ModelFile topLeftOpen = TLReGenModelsBlock.doorTopLeftOpen(baseName + "_top_left_open", bottom, top).renderType(renderType);
		ModelFile topRight = TLReGenModelsBlock.doorTopRight(baseName + "_top_right", bottom, top).renderType(renderType);
		ModelFile topRightOpen = TLReGenModelsBlock.doorTopRightOpen(baseName + "_top_right_open", bottom, top).renderType(renderType);
		doorBlock(block, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
	}

	public void doorBlock(DoorBlock block, ModelFile bottomLeft, ModelFile bottomLeftOpen, ModelFile bottomRight, ModelFile bottomRightOpen, ModelFile topLeft, ModelFile topLeftOpen, ModelFile topRight, ModelFile topRightOpen) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 90;
			boolean right = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
			boolean open = state.getValue(DoorBlock.OPEN);
			boolean lower = state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER;
			if (open) {
				yRot += 90;
			}
			if (right && open) {
				yRot += 180;
			}
			yRot %= 360;

			ModelFile model = null;
			if (lower && right && open) {
				model = bottomRightOpen;
			} else if (lower && !right && open) {
				model = bottomLeftOpen;
			}
			if (lower && right && !open) {
				model = bottomRight;
			} else if (lower && !right && !open) {
				model = bottomLeft;
			}
			if (!lower && right && open) {
				model = topRightOpen;
			} else if (!lower && !right && open) {
				model = topLeftOpen;
			}
			if (!lower && right && !open) {
				model = topRight;
			} else if (!lower && !right && !open) {
				model = topLeft;
			}

			return TLReGenConfiguredModel.builder().modelFile(model).rotationY(yRot).build();
		}, DoorBlock.POWERED);
	}

	public void trapdoorBlock(TrapDoorBlock block, ResourceLocation texture, boolean orientable) {
		trapdoorBlockInternal(block, key(block).toString(), texture, orientable);
	}

	public void trapdoorBlock(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable) {
		trapdoorBlockInternal(block, name + "_trapdoor", texture, orientable);
	}

	public void trapdoorBlockWithRenderType(TrapDoorBlock block, ResourceLocation texture, boolean orientable, String renderType) {
		trapdoorBlockInternalWithRenderType(block, key(block).toString(), texture, orientable, ResourceLocation.tryParse(renderType));
	}

	public void trapdoorBlockWithRenderType(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, String renderType) {
		trapdoorBlockInternalWithRenderType(block, name + "_trapdoor", texture, orientable, ResourceLocation.tryParse(renderType));
	}

	public void trapdoorBlockWithRenderType(TrapDoorBlock block, ResourceLocation texture, boolean orientable, ResourceLocation renderType) {
		trapdoorBlockInternalWithRenderType(block, key(block).toString(), texture, orientable, renderType);
	}

	public void trapdoorBlockWithRenderType(TrapDoorBlock block, String name, ResourceLocation texture, boolean orientable, ResourceLocation renderType) {
		trapdoorBlockInternalWithRenderType(block, name + "_trapdoor", texture, orientable, renderType);
	}

	private void trapdoorBlockInternal(TrapDoorBlock block, String baseName, ResourceLocation texture, boolean orientable) {
		ModelFile bottom = orientable ? TLReGenModelsBlock.trapdoorOrientableBottom(baseName + "_bottom", texture) : TLReGenModelsBlock.trapdoorBottom(baseName + "_bottom", texture);
		ModelFile top = orientable ? TLReGenModelsBlock.trapdoorOrientableTop(baseName + "_top", texture) : TLReGenModelsBlock.trapdoorTop(baseName + "_top", texture);
		ModelFile open = orientable ? TLReGenModelsBlock.trapdoorOrientableOpen(baseName + "_open", texture) : TLReGenModelsBlock.trapdoorOpen(baseName + "_open", texture);
		trapdoorBlock(block, bottom, top, open, orientable);
	}

	private void trapdoorBlockInternalWithRenderType(TrapDoorBlock block, String baseName, ResourceLocation texture, boolean orientable, ResourceLocation renderType) {
		ModelFile bottom = orientable ? TLReGenModelsBlock.trapdoorOrientableBottom(baseName + "_bottom", texture).renderType(renderType) : TLReGenModelsBlock.trapdoorBottom(baseName + "_bottom", texture).renderType(renderType);
		ModelFile top = orientable ? TLReGenModelsBlock.trapdoorOrientableTop(baseName + "_top", texture).renderType(renderType) : TLReGenModelsBlock.trapdoorTop(baseName + "_top", texture).renderType(renderType);
		ModelFile open = orientable ? TLReGenModelsBlock.trapdoorOrientableOpen(baseName + "_open", texture).renderType(renderType) : TLReGenModelsBlock.trapdoorOpen(baseName + "_open", texture).renderType(renderType);
		trapdoorBlock(block, bottom, top, open, orientable);
	}

	public void trapdoorBlock(TrapDoorBlock block, ModelFile bottom, ModelFile top, ModelFile open, boolean orientable) {
		getVariantBuilder(block).forAllStatesExcept(state -> {
			int xRot = 0;
			int yRot = ((int) state.getValue(TrapDoorBlock.FACING).toYRot()) + 180;
			boolean isOpen = state.getValue(TrapDoorBlock.OPEN);
			if (orientable && isOpen && state.getValue(TrapDoorBlock.HALF) == Half.TOP) {
				xRot += 180;
				yRot += 180;
			}
			if (!orientable && !isOpen) {
				yRot = 0;
			}
			yRot %= 360;
			return TLReGenConfiguredModel.builder().modelFile(isOpen ? open : state.getValue(TrapDoorBlock.HALF) == Half.TOP ? top : bottom).rotationX(xRot).rotationY(yRot).build();
		}, TrapDoorBlock.POWERED, TrapDoorBlock.WATERLOGGED);
	}
}
