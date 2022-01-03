package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.JaguarEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class JaguarModel<T extends JaguarEntity> extends QuadrupedModel<T> {

	public JaguarModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
