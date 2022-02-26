package com.technologica.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.Technologica;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class SpearGunModel extends Model {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(Technologica.MODID, "textures/entity/spear_gun.png");
	/*
	private final ModelPart tubeBottom;
	private final ModelPart tubeLeft;
	private final ModelPart tubeRight;
	private final ModelPart tubeBack;
	private final ModelPart grip; 
	*/

	public SpearGunModel() {
		super(RenderType::entitySolid);
		/*
		this.texWidth = 64;
		this.texHeight = 64;
		
		this.tubeBottom = new ModelPart(this, 0, 0);
		this.tubeBottom.setPos(0.0F, 0.0F, 0.0F);
		this.tubeBottom.addBox(-1.5F, 0.0F, -9.0F, 3.0F, 2.0F, 18.0F);
		
		this.tubeLeft = new ModelPart(this, 0, 20);
		this.tubeLeft.addBox(-1.5F, 2.0F, -9.0F, 1.0F, 1.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeLeft);
		
		this.tubeRight = new ModelPart(this, 0, 20);
		this.tubeRight.addBox(0.5F, 2.0F, -9.0F, 1.0F, 1.0F, 18.0F);
		this.tubeBottom.addChild(this.tubeRight);
		
		this.tubeBack = new ModelPart(this, 0, 0);
		this.tubeBack.addBox(-1.5F, 0.0F, 9.0F, 3.0F, 3.0F, 1.0F);
		this.tubeBottom.addChild(this.tubeBack);
		
		this.grip = new ModelPart(this, 0, 4);
		this.grip.addBox(-1.0F, -5.0F, 4.0F, 2.0F, 5.0F, 2.0F);
		this.tubeBottom.addChild(this.grip);
		*/
	}

	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		//this.tubeBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}