package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SlothModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.animal.Sloth;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class SlothRenderer extends MobRenderer<Sloth, SlothModel<Sloth>> {
	private static final ResourceLocation SLOTH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/sloth.png");

	public SlothRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SlothModel<>(renderManagerIn.bakeLayer(TechnologicaModelLayers.SLOTH)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sloth entity) {
		return SLOTH_TEXTURE;
	}
}