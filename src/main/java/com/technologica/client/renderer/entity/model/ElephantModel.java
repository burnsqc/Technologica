package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.ElephantEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class ElephantModel<T extends ElephantEntity> extends QuadrupedModel<T> {

	public ElephantModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
