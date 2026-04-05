package com.technologica.client.renderer.entity.mob;

import java.util.function.Consumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class TechnologicaMobRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M> {
	private final ResourceLocation texture;

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius) {
		super(context, model, shadowRadius);
		this.texture = texture;
	}

	public TechnologicaMobRenderer(Context context, M model, ResourceLocation texture, float shadowRadius, Consumer<TechnologicaMobRenderer<T, M>> layer) {
		super(context, model, shadowRadius);
		this.texture = texture;
		layer.accept(this);
	}

	@Override
	public final ResourceLocation getTextureLocation(T mob) {
		return texture;
	}
}
