package com.technologica.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.block.LineShaftBlock;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;

public class LineShaftTileEntityRenderer extends TileEntityRenderer<LineShaftTileEntity> {

	public LineShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(LineShaftTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {  
    	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
    	BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();
      	long time = System.currentTimeMillis() * 6 * tileEntity.getRPM() / 1000;
    	float angle = time % 360;
    	
        matrixStack.push();  
        
        if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.X) {
        	matrixStack.translate(0.0, 0.5, 0.5);
        	matrixStack.rotate(Vector3f.XP.rotationDegrees(angle));
        	matrixStack.translate(0.0, -0.5, -0.5);
        } else if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.Y) {
        	matrixStack.translate(0.5, 0.0, 0.5);
        	matrixStack.rotate(Vector3f.YP.rotationDegrees(angle));
        	matrixStack.translate(-0.5, 0.0, -0.5);
        } else {
        	matrixStack.translate(0.5, 0.5, 0.0);
        	matrixStack.rotate(Vector3f.ZP.rotationDegrees(angle));
        	matrixStack.translate(-0.5, -0.5, 0.0);
        }
        
        blockModelRenderer.renderModel(tileEntity.getWorld(), blockrendererdispatcher.getModelForState(tileEntity.getBlockState()), tileEntity.getBlockState(), tileEntity.getPos(), matrixStack, buffer.getBuffer(RenderType.getSolid()), false, new Random(), 42, combinedOverlay, tileEntity.getModelData());
        matrixStack.pop();
        
    }
}