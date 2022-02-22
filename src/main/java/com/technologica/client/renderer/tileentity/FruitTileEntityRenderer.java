package com.technologica.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.tileentity.FruitTileEntity;

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

public class FruitTileEntityRenderer extends TileEntityRenderer<FruitTileEntity> {
    public FruitTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(FruitTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {       
    	ItemStack stack = tileEntity.getFruitStack();
    	Minecraft minecraft = Minecraft.getInstance();
    	ClientPlayerEntity clientplayerentity = minecraft.player;
    	if (!stack.isEmpty()) {
        	matrixStack.pushPose();       	
        	matrixStack.translate(0.5, -0.3, 0.5);
        	matrixStack.mulPose(Vector3f.YN.rotationDegrees(clientplayerentity.yRot));
        	ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        	IBakedModel ibakedmodel = itemRenderer.getModel(stack, tileEntity.getLevel(), null);
        	itemRenderer.render(stack, ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel);       	
        	matrixStack.popPose();
        }
    }
}