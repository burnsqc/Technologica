package com.technologica.client.renderer.blockentity;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

public class TechnologicaSignRenderer implements BlockEntityRenderer<SignBlockEntity> {
	private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
	private static final Vec3 TEXT_OFFSET = new Vec3(0.0D, 0.33333334F, 0.046666667F);
	private final Map<WoodType, TechnologicaSignRenderer.SignModel> signModels;
	private final Font font;

	public TechnologicaSignRenderer(BlockEntityRendererProvider.Context context) {
		this.signModels = WoodType.values().collect(ImmutableMap.toImmutableMap((woodType) -> {
			return woodType;
		}, (woodType) -> {
			return new TechnologicaSignRenderer.SignModel(context.bakeLayer(ModelLayers.createSignModelName(woodType)));
		}));
		this.font = context.getFont();
	}

	@Override
	public void render(SignBlockEntity signBlockEntity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int lightColor, int overlayTexture) {
		BlockState blockState = signBlockEntity.getBlockState();
		SignBlock signblock = (SignBlock) blockState.getBlock();
		WoodType woodtype = SignBlock.getWoodType(signblock);
		TechnologicaSignRenderer.SignModel signrenderer$signmodel = this.signModels.get(woodtype);
		signrenderer$signmodel.stick.visible = blockState.getBlock() instanceof StandingSignBlock;
		this.renderSignWithText(signBlockEntity, poseStack, multiBufferSource, lightColor, overlayTexture, blockState, signblock, woodtype, signrenderer$signmodel);
	}

	public float getSignModelRenderScale() {
		return 0.6666667F;
	}

	public float getSignTextRenderScale() {
		return 0.6666667F;
	}

	void renderSignWithText(SignBlockEntity signBlockEntity, PoseStack poseStack, MultiBufferSource multiBufferSource, int lightColor, int overlayTexture, BlockState blockState, SignBlock signBlock, WoodType woodType, Model model) {
		poseStack.pushPose();
		this.translateSign(poseStack, -signBlock.getYRotationDegrees(blockState), blockState);
		this.renderSign(poseStack, multiBufferSource, lightColor, overlayTexture, woodType, model);
		this.renderSignText(signBlockEntity.getBlockPos(), signBlockEntity.getFrontText(), poseStack, multiBufferSource, lightColor, signBlockEntity.getTextLineHeight(), signBlockEntity.getMaxTextLineWidth(), true);
		this.renderSignText(signBlockEntity.getBlockPos(), signBlockEntity.getBackText(), poseStack, multiBufferSource, lightColor, signBlockEntity.getTextLineHeight(), signBlockEntity.getMaxTextLineWidth(), false);
		poseStack.popPose();
	}

	void translateSign(PoseStack poseStack, float rotY, BlockState blockState) {
		poseStack.translate(0.5F, 0.75F * this.getSignModelRenderScale(), 0.5F);
		poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
		if (!(blockState.getBlock() instanceof StandingSignBlock)) {
			poseStack.translate(0.0F, -0.3125F, -0.4375F);
		}

	}

	void renderSign(PoseStack poseStack, MultiBufferSource multiBufferSource, int lightColor, int textLineHeight, WoodType woodType, Model model) {
		poseStack.pushPose();
		float f = this.getSignModelRenderScale();
		poseStack.scale(f, -f, -f);
		Material material = this.getSignMaterial(woodType);
		VertexConsumer vertexconsumer = material.buffer(multiBufferSource, model::renderType);
		this.renderSignModel(poseStack, lightColor, textLineHeight, model, vertexconsumer);
		poseStack.popPose();
	}

	void renderSignModel(PoseStack poseStack, int lightColor, int textLineHeight, Model model, VertexConsumer vertexConsumer) {
		TechnologicaSignRenderer.SignModel signrenderer$signmodel = (TechnologicaSignRenderer.SignModel) model;
		signrenderer$signmodel.root.render(poseStack, vertexConsumer, lightColor, textLineHeight);
	}

	Material getSignMaterial(WoodType woodType) {
		return Sheets.getSignMaterial(woodType);
	}

	void renderSignText(BlockPos p_279403_, SignText p_279361_, PoseStack p_279234_, MultiBufferSource p_279338_, int p_279300_, int p_279179_, int p_279357_, boolean p_279325_) {
		p_279234_.pushPose();
		this.translateSignText(p_279234_, p_279325_, this.getTextOffset());
		int i = getDarkColor(p_279361_);
		int j = 4 * p_279179_ / 2;
		FormattedCharSequence[] aformattedcharsequence = p_279361_.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (p_277227_) -> {
			List<FormattedCharSequence> list = this.font.split(p_277227_, p_279357_);
			return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
		});
		int k;
		boolean flag;
		int l;
		if (p_279361_.hasGlowingText()) {
			k = p_279361_.getColor().getTextColor();
			flag = isOutlineVisible(p_279403_, k);
			l = 15728880;
		} else {
			k = i;
			flag = false;
			l = p_279300_;
		}

		for (int i1 = 0; i1 < 4; ++i1) {
			FormattedCharSequence formattedcharsequence = aformattedcharsequence[i1];
			float f = -this.font.width(formattedcharsequence) / 2;
			if (flag) {
				this.font.drawInBatch8xOutline(formattedcharsequence, f, i1 * p_279179_ - j, k, i, p_279234_.last().pose(), p_279338_, l);
			} else {
				this.font.drawInBatch(formattedcharsequence, f, i1 * p_279179_ - j, k, false, p_279234_.last().pose(), p_279338_, Font.DisplayMode.POLYGON_OFFSET, 0, l);
			}
		}

		p_279234_.popPose();
	}

	private void translateSignText(PoseStack p_279133_, boolean p_279134_, Vec3 p_279280_) {
		if (!p_279134_) {
			p_279133_.mulPose(Axis.YP.rotationDegrees(180.0F));
		}

		float f = 0.015625F * this.getSignTextRenderScale();
		p_279133_.translate(p_279280_.x, p_279280_.y, p_279280_.z);
		p_279133_.scale(f, -f, f);
	}

	Vec3 getTextOffset() {
		return TEXT_OFFSET;
	}

	static boolean isOutlineVisible(BlockPos p_277741_, int p_278022_) {
		if (p_278022_ == DyeColor.BLACK.getTextColor()) {
			return true;
		} else {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer localplayer = minecraft.player;
			if (localplayer != null && minecraft.options.getCameraType().isFirstPerson() && localplayer.isScoping()) {
				return true;
			} else {
				Entity entity = minecraft.getCameraEntity();
				return entity != null && entity.distanceToSqr(Vec3.atCenterOf(p_277741_)) < OUTLINE_RENDER_DISTANCE;
			}
		}
	}

	public static int getDarkColor(SignText p_277914_) {
		int i = p_277914_.getColor().getTextColor();
		if (i == DyeColor.BLACK.getTextColor() && p_277914_.hasGlowingText()) {
			return -988212;
		} else {
			int j = (int) (FastColor.ARGB32.red(i) * 0.4D);
			int k = (int) (FastColor.ARGB32.green(i) * 0.4D);
			int l = (int) (FastColor.ARGB32.blue(i) * 0.4D);
			return FastColor.ARGB32.color(0, j, k, l);
		}
	}

	public static SignRenderer.SignModel createSignModel(EntityModelSet p_173647_, WoodType p_173648_) {
		return new SignRenderer.SignModel(p_173647_.bakeLayer(ModelLayers.createSignModelName(p_173648_)));
	}

	public static LayerDefinition createSignLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("sign", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F), PartPose.ZERO);
		partdefinition.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public static final class SignModel extends Model {
		public final ModelPart root;
		public final ModelPart stick;

		public SignModel(ModelPart p_173657_) {
			super(RenderType::entityTranslucent);
			this.root = p_173657_;
			this.stick = p_173657_.getChild("stick");
		}

		@Override
		public void renderToBuffer(PoseStack p_112510_, VertexConsumer p_112511_, int p_112512_, int p_112513_, float p_112514_, float p_112515_, float p_112516_, float p_112517_) {
			this.root.render(p_112510_, p_112511_, p_112512_, p_112513_, p_112514_, p_112515_, p_112516_, p_112517_);
		}
	}
}