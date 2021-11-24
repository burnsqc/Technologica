package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.SlothEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;

public class SlothModel<T extends SlothEntity> extends QuadrupedModel<T> {

	public SlothModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

}
