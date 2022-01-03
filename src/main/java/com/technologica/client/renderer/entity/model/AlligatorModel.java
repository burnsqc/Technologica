package com.technologica.client.renderer.entity.model;

import com.technologica.entity.passive.AlligatorEntity;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class AlligatorModel<T extends AlligatorEntity> extends QuadrupedModel<T> {

	private ModelRenderer tail;
	
	public AlligatorModel() {
		super(2, 0.0F, true, 10.0F, 4.0F, 2.0F, 2.0F, 24);
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, 10.0F, -6.0F, 6.0F, 6.0F, 8.0F);
		this.body.setRotationPoint(0.0F, 6.0F, 2.0F);

		this.tail = new ModelRenderer(this, 0, 22);
		this.tail.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F);
		this.tail.setRotationPoint(0.0F, 14.0F, 2.0F);
		this.body.addChild(this.tail);

		this.headModel = new ModelRenderer(this, 0, 14);
		this.headModel.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F);
		this.headModel.setRotationPoint(0.0F, 21.0F, -4.0F);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	
}
