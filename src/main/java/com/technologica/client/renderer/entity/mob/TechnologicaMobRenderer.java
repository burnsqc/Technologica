package com.technologica.client.renderer.entity.mob;

import java.util.function.Consumer;

import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class TechnologicaMobRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M> {
	private final ResourceLocation texture;
	private Vector3f scale = new Vector3f(1.0F, 1.0F, 1.0F);

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius) {
		super(context, model, shadowRadius);
		this.texture = texture;
	}

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius, Vector3f scale) {
		super(context, model, shadowRadius);
		this.texture = texture;
		this.scale = scale;
	}

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius, Consumer<TechnologicaMobRenderer<T, M>> layer) {
		super(context, model, shadowRadius);
		this.texture = texture;
		layer.accept(this);
	}

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius, Vector3f scale, Consumer<TechnologicaMobRenderer<T, M>> layer) {
		super(context, model, shadowRadius);
		this.texture = texture;
		this.scale = scale;
		layer.accept(this);
	}

	@Override
	public final ResourceLocation getTextureLocation(T mob) {
		return texture;
	}

	@Override
	protected void scale(T mob, PoseStack poseStack, float partialTicks) {
		poseStack.scale(scale.x, scale.y, scale.z);
		super.scale(mob, poseStack, partialTicks);
	}
}
