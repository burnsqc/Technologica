package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.model.SlothModel;
import com.technologica.world.entity.animal.SlothEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public final class SlothRenderer extends MobRenderer<SlothEntity, SlothModel<SlothEntity>> {
	private static final ResourceLocation SLOTH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/sloth.png");

	public SlothRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SlothModel<>(renderManagerIn.bakeLayer(null)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(SlothEntity entity) {
		return SLOTH_TEXTURE;
	}
}