package com.technologica.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class CoconutBazookaModel extends Model {
	public static final ResourceLocation TEXTURE_LOCATION = new TechnologicaLocation("textures/entity/coconut_bazooka.png");
	private final ModelPart tubeBottom;

	public CoconutBazookaModel(ModelPart p_171016_) {
		super(RenderType::entitySolid);
		this.tubeBottom = p_171016_;
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("tubeBottom", CubeListBuilder.create().texOffs(0, 19).addBox(-3.0F, 0.0F, -9.0F, 6.0F, 1.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeLeft", CubeListBuilder.create().texOffs(20, 42).addBox(-3.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeRight", CubeListBuilder.create().texOffs(0, 38).addBox(2.0F, 1.0F, -9.0F, 1.0F, 4.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeTop", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 5.0F, -9.0F, 6.0F, 1.0F, 18.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("tubeBack", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 1.0F, 7.0F, 4.0F, 4.0F, 1.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("gripRear", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 5.0F, 2.0F), PartPose.ZERO);
		partdefinition1.addOrReplaceChild("gripFront", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -5.0F, -7.0F, 2.0F, 5.0F, 2.0F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		this.tubeBottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}