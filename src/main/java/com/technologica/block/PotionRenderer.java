package com.technologica.block;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.tileentity.PotionTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class PotionRenderer extends TileEntityRenderer<PotionTileEntity> {
    public PotionRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(PotionTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {       
    	ItemStack stack = tileEntity.getPotionStack();
    	ClientPlayerEntity clientplayerentity = Minecraft.getInstance().player;
    	if (!stack.isEmpty()) {
        	matrixStack.push();       	
        	matrixStack.translate(0.5, -0.2, 0.5);
        	matrixStack.rotate(Vector3f.YN.rotationDegrees(clientplayerentity.rotationYaw));
        	ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        	IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(stack, tileEntity.getWorld(), null);
        	itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);       	
        	matrixStack.pop();
        }
    }
}