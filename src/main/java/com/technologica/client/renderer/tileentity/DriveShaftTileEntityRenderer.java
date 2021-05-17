package com.technologica.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.block.ModDriveShaftBlock;
import com.technologica.tileentity.DriveShaftTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;

public class DriveShaftTileEntityRenderer extends TileEntityRenderer<DriveShaftTileEntity> {

	public DriveShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(DriveShaftTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {    
    	BlockRendererDispatcher blockRenderer = Minecraft.getInstance().getBlockRendererDispatcher();
    	long time = System.currentTimeMillis() * 6 * tileEntity.getRPM() / 1000;
    	float angle = time % 360;
    	
        matrixStack.push();  
        
        if (tileEntity.getBlockState().get(ModDriveShaftBlock.AXIS) == Direction.Axis.X) {
        	matrixStack.translate(0.0, 0.5, 0.5);
        	matrixStack.rotate(Vector3f.XP.rotationDegrees(angle));
        	matrixStack.translate(0.0, -0.5, -0.5);
        } else if (tileEntity.getBlockState().get(ModDriveShaftBlock.AXIS) == Direction.Axis.Y) {
        	matrixStack.translate(0.5, 0.0, 0.5);
        	matrixStack.rotate(Vector3f.YP.rotationDegrees(angle));
        	matrixStack.translate(-0.5, 0.0, -0.5);
        } else {
        	matrixStack.translate(0.5, 0.5, 0.0);
        	matrixStack.rotate(Vector3f.ZP.rotationDegrees(angle));
        	matrixStack.translate(-0.5, -0.5, 0.0);
        }
        
        blockRenderer.renderBlock(tileEntity.getBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, tileEntity.getModelData());
        matrixStack.pop();
        
    }
}