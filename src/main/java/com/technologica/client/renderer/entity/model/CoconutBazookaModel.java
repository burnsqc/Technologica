package com.technologica.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class CoconutBazookaModel extends Model {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(Technologica.MODID, "textures/entity/coconut_bazooka.png");
	private final ModelRenderer tubeBottom;
	private final ModelRenderer tubeLeft;
	private final ModelRenderer tubeRight;
	private final ModelRenderer tubeTop;
	private final ModelRenderer tubeBack;
	private final ModelRenderer gripRear; 
	private final ModelRenderer gripFront; 

	public CoconutBazookaModel() {
		super(RenderType::getEntitySolid);
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.tubeBottom = new ModelRenderer(this, 0, 19);
		this.tubeBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tubeBottom.addBox(-3.0F, 0.0F, -9.0F, 6.0F, 1.0F, 18.0F);
		
		this.tubeLeft = new ModelRenderer(this, 20, 42);
		this.tubeLeft.addBox(-3.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeLeft);
		
		this.tubeRight = new ModelRenderer(this, 0, 38);
		this.tubeRight.addBox(2.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeRight);
		
		this.tubeTop = new ModelRenderer(this, 0, 0);
		this.tubeTop.addBox(-3.0F, 5.0F, -9.0F, 6.0F, 1.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeTop);
		
		this.tubeBack = new ModelRenderer(this, 0, 0);
		this.tubeBack.addBox(-2.0F, 1.0F, 7.0F, 4.0F, 4.0F, 1.0F);
		this.tubeBottom.addChild(this.tubeBack);
		
		this.gripRear = new ModelRenderer(this, 0, 5);
		this.gripRear.addBox(-1.0F, -5.0F, -2.0F, 2.0F, 5.0F, 2.0F);
		this.tubeBottom.addChild(this.gripRear);
		
		this.gripFront = new ModelRenderer(this, 0, 5);
		this.gripFront.addBox(-1.0F, -5.0F, -7.0F, 2.0F, 5.0F, 2.0F);
		this.tubeBottom.addChild(this.gripFront);
	}

	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.tubeBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}