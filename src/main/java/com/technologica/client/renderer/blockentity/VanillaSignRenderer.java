package com.technologica.client.renderer.blockentity;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.technologica.world.level.block.entity.VanillaSignTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

public class VanillaSignRenderer implements BlockEntityRenderer<VanillaSignTileEntity> {
	private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
	private final Map<WoodType, SignRenderer.SignModel> signModels;
	private final Font font;

	public VanillaSignRenderer(BlockEntityRendererProvider.Context p_173636_) {
		this.signModels = WoodType.values().collect(ImmutableMap.toImmutableMap((p_173645_) -> {
			return p_173645_;
		}, (p_173651_) -> {
			return new SignRenderer.SignModel(p_173636_.bakeLayer(ModelLayers.createSignModelName(p_173651_)));
		}));
		this.font = p_173636_.getFont();
	}

	public void render(SignBlockEntity p_112497_, float p_112498_, PoseStack p_112499_, MultiBufferSource p_112500_,
			int p_112501_, int p_112502_) {
		BlockState blockstate = p_112497_.getBlockState();
		p_112499_.pushPose();
		WoodType woodtype = getWoodType(blockstate.getBlock());
		SignRenderer.SignModel signrenderer$signmodel = this.signModels.get(woodtype);
		if (blockstate.getBlock() instanceof StandingSignBlock) {
			p_112499_.translate(0.5D, 0.5D, 0.5D);
			float f1 = -((float) (blockstate.getValue(StandingSignBlock.ROTATION) * 360) / 16.0F);
			p_112499_.mulPose(Vector3f.YP.rotationDegrees(f1));
			signrenderer$signmodel.stick.visible = true;
		} else {
			p_112499_.translate(0.5D, 0.5D, 0.5D);
			float f4 = -blockstate.getValue(WallSignBlock.FACING).toYRot();
			p_112499_.mulPose(Vector3f.YP.rotationDegrees(f4));
			p_112499_.translate(0.0D, -0.3125D, -0.4375D);
			signrenderer$signmodel.stick.visible = false;
		}

		p_112499_.pushPose();
		p_112499_.scale(0.6666667F, -0.6666667F, -0.6666667F);
		Material material = Sheets.getSignMaterial(woodtype);
		VertexConsumer vertexconsumer = material.buffer(p_112500_, signrenderer$signmodel::renderType);
		signrenderer$signmodel.root.render(p_112499_, vertexconsumer, p_112501_, p_112502_);
		p_112499_.popPose();
		p_112499_.translate(0.0D, (double) 0.33333334F, (double) 0.046666667F);
		p_112499_.scale(0.010416667F, -0.010416667F, 0.010416667F);
		int i = getDarkColor(p_112497_);
		FormattedCharSequence[] aformattedcharsequence = p_112497_
				.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (p_173653_) -> {
					List<FormattedCharSequence> list = this.font.split(p_173653_, 90);
					return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
				});
		int k;
		boolean flag;
		int l;
		if (p_112497_.hasGlowingText()) {
			k = p_112497_.getColor().getTextColor();
			flag = isOutlineVisible(p_112497_, k);
			l = 15728880;
		} else {
			k = i;
			flag = false;
			l = p_112501_;
		}

		for (int i1 = 0; i1 < 4; ++i1) {
			FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
			float f3 = (float) (-this.font.width(formattedcharsequence) / 2);
			if (flag) {
				this.font.drawInBatch8xOutline(formattedcharsequence, f3, (float) (i1 * 10 - 20), k, i,
						p_112499_.last().pose(), p_112500_, l);
			} else {
				this.font.drawInBatch(formattedcharsequence, f3, (float) (i1 * 10 - 20), k, false,
						p_112499_.last().pose(), p_112500_, false, 0, l);
			}
		}

		p_112499_.popPose();
	}

	private static boolean isOutlineVisible(SignBlockEntity p_173642_, int p_173643_) {
		if (p_173643_ == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer localplayer = minecraft.player;
			if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
				return true;
			} else {
				Entity entity = minecraft.getCameraEntity();
				return entity != null && entity
						.distanceToSqr(Vec3.atCenterOf(p_173642_.getBlockPos())) < (double) OUTLINE_RENDER_DISTANCE;
			}
		}
	}

	private static int getDarkColor(SignBlockEntity p_173640_) {
		int i = p_173640_.getColor().getTextColor();
		int j = (int) ((double) NativeImage.getR(i) * 0.4D);
		int k = (int) ((double) NativeImage.getG(i) * 0.4D);
		int l = (int) ((double) NativeImage.getB(i) * 0.4D);
		return i == DyeColor.BLACK.getTextColor() && p_173640_.hasGlowingText() ? -988212
				: NativeImage.combine(0, l, k, j);
	}

	public static WoodType getWoodType(Block p_173638_) {
		WoodType woodtype;
		if (p_173638_ instanceof SignBlock) {
			woodtype = ((SignBlock) p_173638_).type();
		} else {
			woodtype = WoodType.OAK;
		}

		return woodtype;
	}

	@Override
	public void render(VanillaSignTileEntity p_112307_, float p_112308_, PoseStack p_112309_,
			MultiBufferSource p_112310_, int p_112311_, int p_112312_) {
		// TODO Auto-generated method stub

	}
}
