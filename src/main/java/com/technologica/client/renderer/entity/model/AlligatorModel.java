package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.AlligatorEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class AlligatorModel<T extends AlligatorEntity> extends QuadrupedModel<T> {

	public AlligatorModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
