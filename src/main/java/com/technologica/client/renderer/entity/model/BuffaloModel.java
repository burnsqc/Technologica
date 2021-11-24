package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.BuffaloEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class BuffaloModel<T extends BuffaloEntity> extends QuadrupedModel<T> {

	public BuffaloModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
