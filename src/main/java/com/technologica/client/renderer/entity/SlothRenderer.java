package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SlothModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Sloth;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class SlothRenderer extends MobRenderer<Sloth, SlothModel<Sloth>> {
	private static final ResourceLocation SLOTH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/sloth.png");

	public SlothRenderer(Context contextIn) {
		super(contextIn, new SlothModel<>(contextIn.bakeLayer(TechnologicaModelLayers.SLOTH)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sloth slothIn) {
		return SLOTH_TEXTURE;
	}
}