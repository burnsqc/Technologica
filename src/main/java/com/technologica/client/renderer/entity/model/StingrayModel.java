package com.technologica.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class StingrayModel<T extends Entity> extends SegmentedModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer bodyLeft1;
	private final ModelRenderer bodyLeft2;
	private final ModelRenderer bodyLeft3;
	private final ModelRenderer bodyLeft4;
	private final ModelRenderer bodyRight1;
	private final ModelRenderer bodyRight2;
	private final ModelRenderer bodyRight3;
	private final ModelRenderer bodyRight4;
	private final ModelRenderer head;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;

	public StingrayModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3.0F, 0.0F, -8.0F, 6.0F, 1.0F, 16.0F);
		this.body.setRotationPoint(0.0F, 23.0F, 0.0F);
		
		this.bodyLeft1 = new ModelRenderer(this, 0, 17);
		this.bodyLeft1.addBox(0.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F, true);
		this.bodyLeft1.setRotationPoint(3.0F, 1.0F, 0.0F);
		this.body.addChild(this.bodyLeft1);
		
		this.bodyLeft2 = new ModelRenderer(this, 18, 17);
		this.bodyLeft2.addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F);
		this.bodyLeft2.setRotationPoint(2.0F, 0.0F, 0.0F);
		this.bodyLeft1.addChild(this.bodyLeft2);
		
		this.bodyLeft3 = new ModelRenderer(this, 32, 17);
		this.bodyLeft3.addBox(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F);
		this.bodyLeft3.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.bodyLeft2.addChild(this.bodyLeft3);
		
		this.bodyLeft4 = new ModelRenderer(this, 44, 17);
		this.bodyLeft4.addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F);
		this.bodyLeft4.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.bodyLeft3.addChild(this.bodyLeft4);
		
		this.bodyRight1 = new ModelRenderer(this, 0, 17);
		this.bodyRight1.addBox(-2.0F, -1.0F, -7.0F, 2.0F, 1.0F, 14.0F);
		this.bodyRight1.setRotationPoint(-3.0F, 1.0F, 0.0F);
		this.body.addChild(this.bodyRight1);
		
		this.bodyRight2 = new ModelRenderer(this, 18, 17);
		this.bodyRight2.addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 12.0F);
		this.bodyRight2.setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.bodyRight1.addChild(this.bodyRight2);
		
		this.bodyRight3 = new ModelRenderer(this, 32, 17);
		this.bodyRight3.addBox(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 10.0F);
		this.bodyRight3.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.bodyRight2.addChild(this.bodyRight3);
		
		this.bodyRight4 = new ModelRenderer(this, 44, 17);
		this.bodyRight4.addBox(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F);
		this.bodyRight4.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.bodyRight3.addChild(this.bodyRight4);

		this.head = new ModelRenderer(this, 28, 0);
		this.head.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 1.0F, 12.0F);
		this.body.addChild(this.head);

		this.tail1 = new ModelRenderer(this, 0, 0);
		this.tail1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F);
		this.tail1.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.body.addChild(this.tail1);
		
		this.tail2 = new ModelRenderer(this, 0, 8);
		this.tail2.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F);
		this.tail2.setRotationPoint(0.0F, 0.5F, 6.0F);
		this.tail1.addChild(this.tail2);
		
		this.tail3 = new ModelRenderer(this, 0, 17);
		this.tail3.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F);
		this.tail3.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail2.addChild(this.tail3);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.body);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.body.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		if (Entity.horizontalMag(entityIn.getMotion()) > 1.0E-7D) {
			
			this.tail1.rotateAngleY = 0.2F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail2.rotateAngleY = 0.2F * MathHelper.cos(ageInTicks * 0.3F);
			this.tail3.rotateAngleY = 0.2F * MathHelper.cos(ageInTicks * 0.3F);
		}
	}
}
