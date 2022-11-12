package com.technologica.client.renderer.blockentity;

import java.util.function.Function;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import com.technologica.Technologica;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CustomGlintRenderer extends BlockEntityWithoutLevelRenderer {
	private static final ResourceLocation MODEL_LOCATION = new ResourceLocation(Technologica.MODID, "item/model");
	private static final ResourceLocation GLINT_TEX_LOCATION = new ResourceLocation(Technologica.MODID, "textures/misc/custom_glint.png");
	private static ItemRenderer renderer = null;

	public CustomGlintRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet) {
		super(dispatcher, modelSet);
		if (renderer == null) {
			renderer = Minecraft.getInstance().getItemRenderer();
		}
	}

	@Override
	public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

		boolean glint = stack.hasFoil();
		BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(MODEL_LOCATION);
		for (BakedModel model : mainModel.getRenderPasses(stack, true)) {
			for (RenderType type : model.getRenderTypes(stack, true)) {
				VertexConsumer consumer = getFoilBuffer(buffer, type, glint);
				renderer.renderModelLists(model, stack, packedLight, packedOverlay, poseStack, consumer);
			}
		}
	}

	public static VertexConsumer getFoilBuffer(MultiBufferSource buffer, RenderType type, boolean glint) {
		if (glint) {
			return VertexMultiConsumer.create(buffer.getBuffer(CustomRenderType.CUSTOM_GLINT_DIRECT.apply(GLINT_TEX_LOCATION)), buffer.getBuffer(type));
		}
		return buffer.getBuffer(type);
	}

	public static final class CustomRenderType extends RenderStateShard {
		public static final Function<ResourceLocation, RenderType> CUSTOM_GLINT_DIRECT = Util.memoize((texture) -> RenderType.create("custom_glint_direct", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(texture, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(GLINT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false)));

		private CustomRenderType(String name, Runnable setupState, Runnable clearState) {
			super(name, setupState, clearState);
			throw new UnsupportedOperationException();
		}
	}
}