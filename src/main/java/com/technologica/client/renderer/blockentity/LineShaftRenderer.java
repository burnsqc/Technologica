package com.technologica.client.renderer.blockentity;

import java.util.Arrays;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.Technologica;
import com.technologica.util.Radius;
import com.technologica.util.math.MathHelper;
import com.technologica.world.level.block.LineShaftBlock;
import com.technologica.world.level.block.entity.LineShaftBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LineShaftRenderer implements BlockEntityRenderer<LineShaftBlockEntity> {
	public static final ResourceLocation PULLEY_BELT_TEXTURE = new ResourceLocation(Technologica.MODID, "block/pulley_belt");

	public LineShaftRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	private void addBox(PoseStack matrixStack, MultiBufferSource buffer, float x1, float y1, float z1, float x2, float y2, float z2, float y3, float z3, float y4, float z4) {
		TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(PULLEY_BELT_TEXTURE);
		VertexConsumer builder = buffer.getBuffer(RenderType.solid());

		// EAST
		add(builder, matrixStack, x2, y4, z4, sprite.getU(1), sprite.getV0());
		add(builder, matrixStack, x2, y3, z3, sprite.getU0(), sprite.getV0());
		add(builder, matrixStack, x2, y2, z2, sprite.getU0(), sprite.getV1());
		add(builder, matrixStack, x2, y1, z1, sprite.getU(1), sprite.getV1());

		// WEST
		add(builder, matrixStack, x1, y1, z1, sprite.getU(15), sprite.getV0());
		add(builder, matrixStack, x1, y2, z2, sprite.getU1(), sprite.getV0());
		add(builder, matrixStack, x1, y3, z3, sprite.getU1(), sprite.getV1());
		add(builder, matrixStack, x1, y4, z4, sprite.getU(15), sprite.getV1());

		// UP
		add(builder, matrixStack, x1, y3, z3, sprite.getU0(), sprite.getV0());
		add(builder, matrixStack, x2, y3, z3, sprite.getU(4), sprite.getV0());
		add(builder, matrixStack, x2, y4, z4, sprite.getU(4), sprite.getV1());
		add(builder, matrixStack, x1, y4, z4, sprite.getU0(), sprite.getV1());

		// DOWN
		add(builder, matrixStack, x1, y1, z1, sprite.getU0(), sprite.getV0());
		add(builder, matrixStack, x2, y1, z1, sprite.getU(4), sprite.getV0());
		add(builder, matrixStack, x2, y2, z2, sprite.getU(4), sprite.getV1());
		add(builder, matrixStack, x1, y2, z2, sprite.getU0(), sprite.getV1());
	}

	private void add(VertexConsumer renderer, PoseStack stack, float x, float y, float z, float u, float v) {
		renderer.vertex(stack.last().pose(), x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).uv(u, v).uv2(0, 240).normal(1, 0, 0).endVertex();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(LineShaftBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
		ModelBlockRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();

		matrixStack.pushPose();

		if (tileEntity.getBeltPos() != null) {

			Radius radius1 = tileEntity.getBlockState().getValue(LineShaftBlock.RADIUS);
			Radius radius2;

			if (tileEntity.getLevel().getBlockEntity(tileEntity.getBeltPos()) instanceof LineShaftBlockEntity) {
				radius2 = tileEntity.getLevel().getBlockState(tileEntity.getBeltPos()).getValue(LineShaftBlock.RADIUS);
			} else {
				radius2 = Radius.NONE;
			}

			if (radius2 != Radius.NONE) {
				float[] coords;
				float[][] coords2;

				switch (tileEntity.getBlockState().getValue(LineShaftBlock.AXIS)) {
				case X:
					matrixStack.translate(0, 0.5d, 0.5d);
					coords = MathHelper.circleTangents(tileEntity.getBlockPos().getZ(), tileEntity.getBlockPos().getY(), tileEntity.getBeltPos().getZ(), tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
					addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getBlockPos().getY(), coords[0] - tileEntity.getBlockPos().getZ(), 0.624f, coords[3] - tileEntity.getBlockPos().getY(), coords[2] - tileEntity.getBlockPos().getZ(), coords[5] - tileEntity.getBlockPos().getY(), coords[4] - tileEntity.getBlockPos().getZ(), coords[7] - tileEntity.getBlockPos().getY(), coords[6] - tileEntity.getBlockPos().getZ());
					coords2 = MathHelper.remainingCircumference(tileEntity.getBlockPos().getZ(), tileEntity.getBlockPos().getY(), tileEntity.getBeltPos().getZ(), tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
					for (int i = 0; i < coords2.length; i++) {
						addBox(matrixStack, buffer, 0.376f, coords2[i][1] - tileEntity.getBlockPos().getY(), coords2[i][0] - tileEntity.getBlockPos().getZ(), 0.624f, coords2[i][3] - tileEntity.getBlockPos().getY(), coords2[i][2] - tileEntity.getBlockPos().getZ(), coords2[i][5] - tileEntity.getBlockPos().getY(), coords2[i][4] - tileEntity.getBlockPos().getZ(), coords2[i][7] - tileEntity.getBlockPos().getY(), coords2[i][6] - tileEntity.getBlockPos().getZ());
					}
					break;
				case Y:
					matrixStack.mulPose(Axis.YP.rotationDegrees(90));
					matrixStack.mulPose(Axis.ZP.rotationDegrees(90));
					matrixStack.translate(0, 0.5d, 0.5d);
					coords = MathHelper.circleTangents(tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getZ(), tileEntity.getBeltPos().getX(), tileEntity.getBeltPos().getZ(), radius1.getRadius(), radius2.getRadius());
					addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getBlockPos().getZ(), coords[0] - tileEntity.getBlockPos().getX(), 0.624f, coords[3] - tileEntity.getBlockPos().getZ(), coords[2] - tileEntity.getBlockPos().getX(), coords[5] - tileEntity.getBlockPos().getZ(), coords[4] - tileEntity.getBlockPos().getX(), coords[7] - tileEntity.getBlockPos().getZ(), coords[6] - tileEntity.getBlockPos().getX());
					coords2 = MathHelper.remainingCircumference(tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getZ(), tileEntity.getBeltPos().getX(), tileEntity.getBeltPos().getZ(), radius1.getRadius(), radius2.getRadius());
					for (int i = 0; i < coords2.length; i++) {
						addBox(matrixStack, buffer, 0.376f, coords2[i][1] - tileEntity.getBlockPos().getZ(), coords2[i][0] - tileEntity.getBlockPos().getX(), 0.624f, coords2[i][3] - tileEntity.getBlockPos().getZ(), coords2[i][2] - tileEntity.getBlockPos().getX(), coords2[i][5] - tileEntity.getBlockPos().getZ(), coords2[i][4] - tileEntity.getBlockPos().getX(), coords2[i][7] - tileEntity.getBlockPos().getZ(), coords2[i][6] - tileEntity.getBlockPos().getX());
					}
					break;
				case Z:
					matrixStack.mulPose(Axis.YP.rotationDegrees(90));
					matrixStack.translate(-1, 0.5d, 0.5d);
					coords = MathHelper.circleTangents(tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBeltPos().getX(), tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
					addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getBlockPos().getY(), coords[0] - tileEntity.getBlockPos().getX(), 0.624f, coords[3] - tileEntity.getBlockPos().getY(), coords[2] - tileEntity.getBlockPos().getX(), coords[5] - tileEntity.getBlockPos().getY(), coords[4] - tileEntity.getBlockPos().getX(), coords[7] - tileEntity.getBlockPos().getY(), coords[6] - tileEntity.getBlockPos().getX());
					coords2 = MathHelper.remainingCircumference(tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBeltPos().getX(), tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
					for (int i = 0; i < coords2.length; i++) {
						addBox(matrixStack, buffer, 0.376f, coords2[i][1] - tileEntity.getBlockPos().getY(), coords2[i][0] - tileEntity.getBlockPos().getX(), 0.624f, coords2[i][3] - tileEntity.getBlockPos().getY(), coords2[i][2] - tileEntity.getBlockPos().getX(), coords2[i][5] - tileEntity.getBlockPos().getY(), coords2[i][4] - tileEntity.getBlockPos().getX(), coords2[i][7] - tileEntity.getBlockPos().getY(), coords2[i][6] - tileEntity.getBlockPos().getX());
					}
					break;
				}
			}

		}
		matrixStack.popPose();

		matrixStack.pushPose();

		matrixStack.translate(offset(tileEntity)[0], offset(tileEntity)[1], offset(tileEntity)[2]);
		matrixStack.mulPose(angle(tileEntity));
		matrixStack.translate(-offset(tileEntity)[0], -offset(tileEntity)[1], -offset(tileEntity)[2]);

		blockModelRenderer.renderModel(matrixStack.last(), buffer.getBuffer(RenderType.solid()), tileEntity.getBlockState(), blockrendererdispatcher.getBlockModel(tileEntity.getBlockState()), 0.0F, 0.0F, 0.0F, combinedLight, combinedOverlay);
		matrixStack.popPose();
	}

	private double[] offset(BlockEntity tileEntityIn) {
		double[] offset = new double[3];
		Arrays.fill(offset, 0.5f);

		switch (tileEntityIn.getBlockState().getValue(LineShaftBlock.AXIS)) {
		case X:
			offset[0] = 0.0d;
			break;
		case Y:
			offset[1] = 0.0d;
			break;
		case Z:
			offset[2] = 0.0d;
			break;
		}

		return offset;
	}

	private Quaternionf angle(BlockEntity tileEntityIn) {
		long time = System.currentTimeMillis() * 6 * (int) ((LineShaftBlockEntity) tileEntityIn).getRPM() / 1000;
		float angle = time % 360;
		Axis vector = Axis.XP;

		switch (tileEntityIn.getBlockState().getValue(LineShaftBlock.AXIS)) {
		case X:
			vector = Axis.XP;
			break;
		case Y:
			vector = Axis.YP;
			break;
		case Z:
			vector = Axis.ZP;
			break;
		}

		return vector.rotationDegrees(angle);
	}

	@Override
	public boolean shouldRenderOffScreen(LineShaftBlockEntity te) {
		return true;
	}
}
