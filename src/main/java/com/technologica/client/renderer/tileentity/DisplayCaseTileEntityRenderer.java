package com.technologica.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.tileentity.DisplayCaseTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class DisplayCaseTileEntityRenderer extends TileEntityRenderer<DisplayCaseTileEntity> {
    public DisplayCaseTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(DisplayCaseTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {       
    	ItemStack stack = tileEntity.getDisplayStack();
    	long time = System.currentTimeMillis();
    	float angle = (time / 25) % 360;
    	if (!stack.isEmpty()) {
        	matrixStack.push();       	
        	matrixStack.translate(0.5, 0.3, 0.5);
        	matrixStack.rotate(Vector3f.YN.rotationDegrees(angle));
        	ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        	IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(stack, tileEntity.getWorld(), null);
        	itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);       	
        	matrixStack.pop();
        }
    }
}