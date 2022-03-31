package com.technologica.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.Technologica;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class CoconutBazookaModel extends Model {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(Technologica.MODID, "textures/entity/coconut_bazooka.png");
	/*
	private final ModelPart tubeBottom;
	private final ModelPart tubeLeft;
	private final ModelPart tubeRight;
	private final ModelPart tubeTop;
	private final ModelPart tubeBack;
	private final ModelPart gripRear; 
	private final ModelPart gripFront; 
	*/

	public CoconutBazookaModel() {
		super(RenderType::entitySolid);
		/*
		this.texWidth = 64;
		this.texHeight = 64;
		
		this.tubeBottom = new ModelPart(this, 0, 19);
		this.tubeBottom.setPos(0.0F, 0.0F, 0.0F);
		this.tubeBottom.addBox(-3.0F, 0.0F, -9.0F, 6.0F, 1.0F, 18.0F);
		
		this.tubeLeft = new ModelPart(this, 20, 42);
		this.tubeLeft.addBox(-3.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeLeft);
		
		this.tubeRight = new ModelPart(this, 0, 38);
		this.tubeRight.addBox(2.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeRight);
		
		this.tubeTop = new ModelPart(this, 0, 0);
		this.tubeTop.addBox(-3.0F, 5.0F, -9.0F, 6.0F, 1.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeTop);
		
		this.tubeBack = new ModelPart(this, 0, 0);
		this.tubeBack.addBox(-2.0F, 1.0F, 7.0F, 4.0F, 4.0F, 1.0F);
		this.tubeBottom.addChild(this.tubeBack);
		
		this.gripRear = new ModelPart(this, 0, 5);
		this.gripRear.addBox(-1.0F, -5.0F, -2.0F, 2.0F, 5.0F, 2.0F);
		this.tubeBottom.addChild(this.gripRear);
		
		this.gripFront = new ModelPart(this, 0, 5);
		this.gripFront.addBox(-1.0F, -5.0F, -7.0F, 2.0F, 5.0F, 2.0F);
		this.tubeBottom.addChild(this.gripFront);
		*/
	}

	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		//this.tubeBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}