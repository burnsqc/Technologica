package com.technologica.client.renderer.blockentity;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.technologica.util.text.TechnologicaLocation;
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
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.registries.ForgeRegistries;

public class SawmillRenderer implements BlockEntityRenderer<SawmillBlockEntity> {
	public static final ResourceLocation SAW_TEXTURE = new TechnologicaLocation("block/sawblade");

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

	@Override
	public void render(SawmillBlockEntity sawmillBlockEntityIn, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
		Boolean blade = sawmillBlockEntityIn.getBlade();
		ItemStack stack = sawmillBlockEntityIn.getLog();
		Block log = Block.byItem(stack.getItem());
		BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
		ModelBlockRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();
		if (blade) {
			matrixStack.pushPose();
			matrixStack.translate(0.5, 0.75, 0.5);
			switch (sawmillBlockEntityIn.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				break;
			case EAST:
				matrixStack.mulPose(Axis.YP.rotationDegrees(270));
				break;
			case SOUTH:
				matrixStack.mulPose(Axis.YP.rotationDegrees(180));
				break;
			case WEST:
				matrixStack.mulPose(Axis.YP.rotationDegrees(90));
				break;
			default:
				break;
			}
			long i = sawmillBlockEntityIn.getLevel().getGameTime();
			matrixStack.mulPose(this.angle(i, partialTicks));
			addBox(matrixStack, buffer);
			matrixStack.popPose();
		}
		if (!stack.isEmpty()) {
			matrixStack.pushPose();
			BlockState state = log.defaultBlockState();
			double logPos = -2.0D + 4.0D * (sawmillBlockEntityIn.getSawingProgress() / 100.0D);

			if (ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS).contains(stack.getItem())) {
				state = log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
			}

			switch (sawmillBlockEntityIn.getBlockState().getValue(SawmillBlock.NESW_FACING)) {
			case NORTH:
				matrixStack.mulPose(Axis.YP.rotationDegrees(90));
				matrixStack.translate(logPos - 1.0D, 1.0D, 0.0D);
				break;
			case EAST:
				matrixStack.translate(logPos, 1.0D, 0.0D);
				break;
			case SOUTH:
				matrixStack.mulPose(Axis.YP.rotationDegrees(270));
				matrixStack.translate(logPos, 1.0D, -1.0D);
				break;
			case WEST:
				matrixStack.mulPose(Axis.YP.rotationDegrees(180));
				matrixStack.translate(logPos - 1.0D, 1.0D, -1.0D);
				break;
			default:
				break;
			}
			blockModelRenderer.renderModel(matrixStack.last(), buffer.getBuffer(RenderType.translucentMovingBlock()), state, blockrendererdispatcher.getBlockModel(state), 0.0F, 0.0F, 0.0F, combinedLight, combinedOverlay, ModelData.EMPTY, RenderType.cutoutMipped());
			matrixStack.popPose();
		}
	}

	private Quaternionf angle(long time, float partialTicks) {
		float f = 30 * (Math.floorMod(time, 360) + partialTicks);
		Axis vector = Axis.XP;
		return vector.rotationDegrees(f);
	}
}