package com.technologica.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.item.TechnologicaItems;
import com.technologica.tileentity.SawmillTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.model.data.EmptyModelData;

public class SawmillTileEntityRenderer extends TileEntityRenderer<SawmillTileEntity> {
    public SawmillTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(SawmillTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {       
    	ItemStack stack = tileEntity.getLog();
    	
    	Block log = Block.byItem(stack.getItem());
    	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
		BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();
    	
		ItemStack blade = new ItemStack(TechnologicaItems.SAWBLADE.get().getItem(), 1);
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
    	IBakedModel ibakedmodel = itemRenderer.getModel(blade, tileEntity.getLevel(), null);
		
    	if (tileEntity.getBlade()) {
    		matrixStack.pushPose();
    		matrixStack.translate(0.5, 0.9, 0.5);
    		matrixStack.mulPose(angle());
    		matrixStack.scale(2.25F, 2.25F, 1.0F);
    		itemRenderer.render(blade, ItemCameraTransforms.TransformType.NONE, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel); 
    		matrixStack.popPose();
    	}
    		
    	if (!stack.isEmpty()) {
    		matrixStack.pushPose();
    		BlockState state = log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
    		matrixStack.translate(tileEntity.getLogPos(), 1.0, 0.0);
    		blockModelRenderer.renderModel(tileEntity.getLevel(), blockrendererdispatcher.getBlockModel(state), state, tileEntity.getBlockPos(), matrixStack, buffer.getBuffer(RenderType.solid()), false, new Random(), 42, combinedOverlay, EmptyModelData.INSTANCE);
    		matrixStack.popPose();
    	}
    }
    
    private Quaternion angle() {
    	long time = System.currentTimeMillis() * 6;
    	float angle = time % 360;
    	Vector3f vector = Vector3f.ZP;

    	return vector.rotationDegrees(angle);
    }
}