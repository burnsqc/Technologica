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
		this.texWidth = 16;
		this.texHeight = 16;
		
		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F);
		this.body.setPos(0.0F, 21.0F, 6.0F);
		
		this.tail = new ModelRenderer(this, 10, -2);
		this.tail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F);
		this.tail.setPos(0.0F, 21.0F, 9.0F);
		
		this.finLeft = new ModelRenderer(this, 0, 0);
		this.finLeft.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finLeft.setPos(1.0F, 22.0F, 5.0F);
		
		this.finRight = new ModelRenderer(this, 0, 0);
		this.finRight.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F);
		this.finRight.setPos(-1.0F, 22.0F, 5.0F);
		
		this.finTop = new ModelRenderer(this, 0, -1);
		this.finTop.addBox(0.0F, -4.0F, -2.0F, 0.0F, 1.0F, 2.0F);
		this.finTop.setPos(0.0F, 21.0F, 6.0F);
		
		this.finBottom = new ModelRenderer(this, 0, 0);
		this.finBottom.addBox(0.0F, 3.0F, -1.0F, 0.0F, 1.0F, 2.0F);
		this.finBottom.setPos(0.0F, 21.0F, 6.0F);
	}

	public Iterable<ModelRenderer> parts() {
		return ImmutableList.of(this.body, this.tail, this.finRight, this.finLeft, this.finTop, this.finBottom);
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xRot = (float) Math.PI / 4;
		this.finLeft.yRot = -(float) Math.PI / 4;
		this.finRight.yRot = (float) Math.PI / 4;
		this.finTop.xRot = -(float) Math.PI / 4;
		this.finBottom.xRot = (float) Math.PI / 4;
		this.tail.yRot = entityIn.isInWater()? 0.45F * MathHelper.sin(0.6F * ageInTicks) : 0.675F * MathHelper.sin(0.6F * ageInTicks);
	}
}