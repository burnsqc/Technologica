package com.technologica.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.technologica.world.entity.animal.Zebra;

import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.DyeableHorseArmorItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;

public class ZebraArmorLayer extends RenderLayer<Zebra, HorseModel<Zebra>> {
	private final HorseModel<Zebra> model;

	public ZebraArmorLayer(RenderLayerParent<Zebra, HorseModel<Zebra>> renderLayerParent, EntityModelSet entityModelSet) {
		super(renderLayerParent);
		this.model = new HorseModel<>(entityModelSet.bakeLayer(ModelLayers.HORSE_ARMOR));
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, Zebra zebra, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		ItemStack itemstack = zebra.getArmor();
		if (itemstack.getItem() instanceof HorseArmorItem) {
			HorseArmorItem horsearmoritem = (HorseArmorItem) itemstack.getItem();
			this.getParentModel().copyPropertiesTo(this.model);
			this.model.prepareMobModel(zebra, limbSwing, limbSwingAmount, partialTicks);
			this.model.setupAnim(zebra, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			float f;
			float f1;
			float f2;
			if (horsearmoritem instanceof DyeableHorseArmorItem) {
				int i = ((DyeableHorseArmorItem) horsearmoritem).getColor(itemstack);
				f = (i >> 16 & 255) / 255.0F;
				f1 = (i >> 8 & 255) / 255.0F;
				f2 = (i & 255) / 255.0F;
			} else {
				f = 1.0F;
				f1 = 1.0F;
				f2 = 1.0F;
			}
			VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(horsearmoritem.getTexture()));
			this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, f, f1, f2, 1.0F);
		}
	}
}
