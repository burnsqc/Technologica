package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AbstractTropicalFishModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PiranhaModel<T extends Entity> extends AbstractTropicalFishModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer finLeft;
	private final ModelRenderer finRight;
	private final ModelRenderer finTop;
	private final ModelRenderer finBottom;

	public PiranhaModel() {
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.body = new ModelRenderer(this, 0, 20);
		this.body.addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F);
		this.body.setRotationPoint(0.0F, 21.0F, 6.0F);
		
		this.tail = new ModelRenderer(this, 21, 16);
		this.tail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F);
		this.tail.setRotationPoint(0.0F, 21.0F, 9.0F);
		
		this.finLeft = new ModelRenderer(this, 2, 12);
		this.finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finLeft.setRotationPoint(1.0F, 22.0F, 4.0F);
		
		this.finRight = new ModelRenderer(this, 2, 16);
		this.finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finRight.setRotationPoint(-1.0F, 22.0F, 4.0F);
		
		this.finTop = new ModelRenderer(this, 20, 11);
		this.finTop.addBox(0.0F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F);
		this.finTop.setRotationPoint(0.0F, 21.0F, 6.0F);
		
		this.finBottom = new ModelRenderer(this, 20, 21);
		this.finBottom.addBox(0.0F, 3.0F, -1.0F, 0.0F, 1.0F, 2.0F);
		this.finBottom.setRotationPoint(0.0F, 21.0F, 6.0F);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body, this.tail, this.finRight, this.finLeft, this.finTop, this.finBottom);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = (float) Math.PI / 4;
		this.finLeft.rotateAngleY = -(float) Math.PI / 4;
		this.finRight.rotateAngleY = (float) Math.PI / 4;
		this.finTop.rotateAngleX = -(float) Math.PI / 4;
		this.finBottom.rotateAngleX = (float) Math.PI / 4;
		this.tail.rotateAngleY = entityIn.isInWater()? 0.45F * MathHelper.sin(0.6F * ageInTicks) : 0.675F * MathHelper.sin(0.6F * ageInTicks);
	}
}