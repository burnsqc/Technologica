package com.technologica.client.renderer.entity;

import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.SlothModel;
import com.technologica.entity.passive.SlothEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public final class SlothRenderer extends MobRenderer<SlothEntity, SlothModel<SlothEntity>> {
	private static final ResourceLocation SLOTH_TEXTURE = new ResourceLocation(Technologica.MODID, "textures/entity/sloth.png");

	public SlothRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SlothModel<>(), 1.1F);
	}

	@Override
	public ResourceLocation getEntityTexture(SlothEntity entity) {
		return SLOTH_TEXTURE;
	}
}
