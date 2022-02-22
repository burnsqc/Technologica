package com.technologica.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;
import com.technologica.client.renderer.entity.model.VanillaBoatModel;
import com.technologica.entity.item.VanillaBoatEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class VanillaBoatRenderer extends EntityRenderer<VanillaBoatEntity> {
	private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/apricot.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/aspen.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/avocado.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/banana.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/cherry.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/chestnut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/cinnamon.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/coconut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/ebony.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/kiwi.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/lemon.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/lime.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/mahogany.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/maple.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/olive.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/orange.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/peach.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/pear.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/plum.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/redwood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/rosewood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/rubber.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/teak.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/walnut.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/zebrawood.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/alchemical.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/benevolent.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/conductive.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/frostbitten.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/fruitful.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/infernal.png"),
			new ResourceLocation(Technologica.MODID, "textures/entity/boat/malevolent.png")};
	protected final VanillaBoatModel modelBoat = new VanillaBoatModel();

	public VanillaBoatRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
		this.shadowRadius = 0.8F;
	}

	public void render(VanillaBoatEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.0D, 0.375D, 0.0D);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entityIn.getHurtTime() - partialTicks;
		float f1 = entityIn.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float) entityIn.getHurtDir()));
		}

		float f2 = entityIn.getBubbleAngle(partialTicks);
		if (!MathHelper.equal(f2, 0.0F)) {
			matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entityIn.getBubbleAngle(partialTicks), true));
		}

		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
		this.modelBoat.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.modelBoat.renderType(this.getTextureLocation(entityIn)));
		this.modelBoat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		if (!entityIn.isUnderWater()) {
			IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
			this.modelBoat.waterPatch().render(matrixStackIn, ivertexbuilder1, packedLightIn,
					OverlayTexture.NO_OVERLAY);
		}

		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getTextureLocation(VanillaBoatEntity entity) {
		return BOAT_TEXTURES[entity.getVanillaBoatType().ordinal()];
	}
}
