package com.technologica.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.TwelveDirectionBlock;
import com.technologica.tileentity.LineShaftHangerTileEntity;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;

public class LineShaftHangerTileEntityRenderer extends TileEntityRenderer<LineShaftHangerTileEntity> {
	
	public LineShaftHangerTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(LineShaftHangerTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {  
    	if (tileEntity.getShaft()) {
    		long time = System.currentTimeMillis() * 6 * (int) tileEntity.getRPM() / 1000;
    		float angle = time % 360;
    		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
    		BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getModelRenderer();
	      BlockState state; // this state assignment will always be overwritten later in the method
    		LineShaftTileEntity tileEntity2 = new LineShaftTileEntity();
    		
    		matrixStack.pushPose();  
        
    		if (tileEntity.getBlockState().getValue(TwelveDirectionBlock.AXIS) == Direction.Axis.X) {
    			state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.X);
    			matrixStack.translate(0.0, 0.5, 0.5);
    			matrixStack.mulPose(Vector3f.XP.rotationDegrees(angle));
    			matrixStack.translate(0.0, -0.5, -0.5);        	
    		} else if (tileEntity.getBlockState().getValue(TwelveDirectionBlock.AXIS) == Direction.Axis.Y) {
    			state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.Y);
    			matrixStack.translate(0.5, 0.0, 0.5);
    			matrixStack.mulPose(Vector3f.YP.rotationDegrees(angle));
    			matrixStack.translate(-0.5, 0.0, -0.5);
    		} else {
    			state = TechnologicaBlocks.LINE_SHAFT.get().defaultBlockState().setValue(TwelveDirectionBlock.AXIS, Direction.Axis.Z);
    			matrixStack.translate(0.5, 0.5, 0.0);
    			matrixStack.mulPose(Vector3f.ZP.rotationDegrees(angle));
    			matrixStack.translate(-0.5, -0.5, 0.0);
    		}
       
    		blockModelRenderer.renderModel(tileEntity.getLevel(), blockrendererdispatcher.getBlockModel(state), state, tileEntity.getBlockPos(), matrixStack, buffer.getBuffer(RenderType.solid()), false, new Random(), 42, combinedOverlay, tileEntity2.getModelData());
    		matrixStack.popPose();
    	}
    }
}
