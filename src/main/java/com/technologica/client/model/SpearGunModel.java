package com.technologica.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.Technologica;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SpearGunModel extends Model {
	public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(Technologica.MODID, "textures/entity/spear_gun.png");
	private final ModelPart tubeBottom;

	public SpearGunModel(ModelPart p_171016_) {
		super(RenderType::entitySolid);
		this.tubeBottom = p_171016_;
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("tubeBottom", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -9.0F, 3.0F, 2.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeLeft", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, 2.0F, -9.0F, 1.0F, 1.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeRight", CubeListBuilder.create().texOffs(0, 20).addBox(0.5F, 2.0F, -9.0F, 1.0F, 1.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeBack", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 9.0F, 3.0F, 3.0F, 1.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("grip", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -5.0F, 4.0F, 2.0F, 5.0F, 2.0F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.tubeBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}