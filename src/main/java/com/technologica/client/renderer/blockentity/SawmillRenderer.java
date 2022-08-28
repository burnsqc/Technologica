package com.technologica.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.technologica.Technologica;
import com.technologica.world.level.block.SawmillBlock;
import com.technologica.world.level.block.entity.SawmillBlockEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SawmillRenderer implements BlockEntityRenderer<SawmillBlockEntity> {
	public static final ResourceLocation SAW_TEXTURE = new ResourceLocation(Technologica.MODID, "block/sawblade");

	public SawmillRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	private void addBox(PoseStack matrixStack, MultiBufferSource buffer) {
		TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(SAW_TEXTURE);
		VertexConsumer builder = buffer.getBuffer(RenderType.cutoutMipped());

		add(builder, matrixStack, 0.0F, 2.0F, 2.0F, sprite.getU1(), sprite.getV1());
		add(builder, matrixStack, 0.0F, -2.0F, 2.0F, sprite.getU0(), sprite.getV1());
		add(builder, matrixStack, 0.0F, -2.0F, -2.0F, sprite.getU0(), sprite.getV0());
		add(builder, matrixStack, 0.0F, 2.0F, -2.0F, sprite.getU1(), sprite.getV0());

		add(builder, matrixStack, 0.0F, 2.0F, -2.0F, sprite.getU1(), sprite.getV0());
		add(builder, matrixStack, 0.0F, -2.0F, -2.0F, sprite.getU0(), sprite.getV0());
		add(builder, matrixStack, 0.0F, -2.0F, 2.0F, sprite.getU0(), sprite.getV1());
		add(builder, matrixStack, 0.0F, 2.0F, 2.0F, sprite.getU1(), sprite.getV1());
	}

	private void add(VertexConsumer renderer, PoseStack stack, float x, float y, float z, float u, float v) {
		renderer.vertex(stack.last().pose(), x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).uv(u, v).uv2(0, 240).normal(1, 0, 0).endVertex();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(SawmillBlockEntity tileEntity, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		ItemStack stack = tileEntity.getLog();

		Block log = Block.byItem(stack.getItem());
		BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
		ModelBlockRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();

		if (tileEntity.getBlade()) {

			matrixStack.pushPose();
			matrixStack.translate(0.5, 0.75, 0.5);

			switch (tileEntity.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				break;
			case EAST:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
				break;
			case SOUTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
				break;
			case WEST:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
				break;
			default:
				break;
			}
			long i = tileEntity.getLevel().getGameTime();
			matrixStack.mulPose(this.angle(i, partialTicks));
			addBox(matrixStack, buffer);
			matrixStack.popPose();
		}

		if (!stack.isEmpty()) {
			matrixStack.pushPose();
			BlockState state = log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);

			switch (tileEntity.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
				matrixStack.translate(tileEntity.getLogPos() - 1, 1.0, 0.0);
				break;
			case EAST:
				matrixStack.translate(tileEntity.getLogPos(), 1.0, 0.0);
				break;
			case SOUTH:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
				matrixStack.translate(tileEntity.getLogPos(), 1.0, -1.0);
				break;
			case WEST:
				matrixStack.mulPose(Vector3f.YP.rotationDegrees(180));
				matrixStack.translate(tileEntity.getLogPos() - 1, 1.0, -1.0);
				break;
			default:
				break;
			}

			blockModelRenderer.renderModel(matrixStack.last(), buffer.getBuffer(RenderType.translucentMovingBlock()), state, blockrendererdispatcher.getBlockModel(state), 0.0F, 0.0F, 0.0F, combinedLight, combinedOverlay);
			matrixStack.popPose();
		}
	}

	private Quaternion angle(long time, float partialTicks) {
		float f = 30 * (Math.floorMod(time, 360) + partialTicks);
		Vector3f vector = Vector3f.XP;
		return vector.rotationDegrees(f);
	}
}