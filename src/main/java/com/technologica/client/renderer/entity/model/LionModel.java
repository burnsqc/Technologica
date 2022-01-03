package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.LionEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class LionModel<T extends LionEntity> extends QuadrupedModel<T> {

	public LionModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
