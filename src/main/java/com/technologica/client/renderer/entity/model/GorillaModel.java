package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.GorillaEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class GorillaModel<T extends GorillaEntity> extends QuadrupedModel<T> {

	public GorillaModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
