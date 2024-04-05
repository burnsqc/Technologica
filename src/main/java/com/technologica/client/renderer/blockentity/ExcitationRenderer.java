package com.technologica.client.renderer.blockentity;

import java.util.SortedMap;
import java.util.function.Function;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.RenderTypeHelper;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class ExcitationRenderer extends BlockEntityWithoutLevelRenderer {
	private ResourceLocation BASE_MODEL_LOCATION;
	private static final ResourceLocation EXCITATION_TEXTURE_LOCATION = new TechnologicaLocation("textures/misc/excitation_item_glint.png");
	private static ItemRenderer renderer = null;

	public ExcitationRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet, ResourceLocation baseModelLocation) {
		super(dispatcher, modelSet);
		BASE_MODEL_LOCATION = baseModelLocation;
		if (renderer == null) {
			renderer = Minecraft.getInstance().getItemRenderer();
		}
	}

	@Override
	public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
		poseStack.popPose();
		poseStack.pushPose();
		BakedModel mainModel = Minecraft.getInstance().getModelManager().getModel(BASE_MODEL_LOCATION);
		mainModel = mainModel.applyTransform(transformType, poseStack, isLeftHand(transformType));
		poseStack.translate(-.5, -.5, -.5);
		boolean glint = stack.hasFoil();
		for (BakedModel model : mainModel.getRenderPasses(stack, true)) {
			for (RenderType type : model.getRenderTypes(stack, true)) {
				type = RenderTypeHelper.getEntityRenderType(type, true);
				VertexConsumer consumer = getFoilBuffer(buffer, type, glint);
				renderer.renderModelLists(model, stack, packedLight, packedOverlay, poseStack, consumer);
			}
		}
	}

	private static boolean isLeftHand(ItemDisplayContext type) {
		return type == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || type == ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
	}

	private static VertexConsumer getFoilBuffer(MultiBufferSource buffer, RenderType type, boolean glint) {
		if (glint) {
			return VertexMultiConsumer.create(buffer.getBuffer(CustomRenderType.CUSTOM_GLINT_DIRECT.apply(EXCITATION_TEXTURE_LOCATION)), buffer.getBuffer(type));
		}
		return buffer.getBuffer(type);
	}

	public static final class CustomRenderType extends RenderStateShard {
		public static final Function<ResourceLocation, RenderType> CUSTOM_GLINT_DIRECT = Util.memoize(texture -> {
			RenderType type = RenderType.create("custom_glint_direct", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(texture, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false));
			SortedMap<RenderType, BufferBuilder> fixedBuffers = ObfuscationReflectionHelper.getPrivateValue(RenderBuffers.class, Minecraft.getInstance().renderBuffers(), "f_110093_");
			fixedBuffers.put(type, new BufferBuilder(type.bufferSize()));
			return type;
		});

		private CustomRenderType(String name, Runnable setupState, Runnable clearState) {
			super(name, setupState, clearState);
			throw new UnsupportedOperationException();
		}
	}
}