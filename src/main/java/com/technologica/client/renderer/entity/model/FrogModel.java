package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.FrogEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class FrogModel<T extends FrogEntity> extends QuadrupedModel<T> {

	public FrogModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
