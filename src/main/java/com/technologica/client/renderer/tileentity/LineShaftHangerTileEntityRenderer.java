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
    		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
    		BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();
	      BlockState state; // this state assignment will always be overwritten later in the method
    		LineShaftTileEntity tileEntity2 = new LineShaftTileEntity();
    		
    		matrixStack.push();  
        
    		if (tileEntity.getBlockState().get(TwelveDirectionBlock.AXIS) == Direction.Axis.X) {
    			state = TechnologicaBlocks.LINE_SHAFT.get().getDefaultState().with(TwelveDirectionBlock.AXIS, Direction.Axis.X);
    			matrixStack.translate(0.0, 0.5, 0.5);
    			matrixStack.rotate(Vector3f.XP.rotationDegrees(angle));
    			matrixStack.translate(0.0, -0.5, -0.5);        	
    		} else if (tileEntity.getBlockState().get(TwelveDirectionBlock.AXIS) == Direction.Axis.Y) {
    			state = TechnologicaBlocks.LINE_SHAFT.get().getDefaultState().with(TwelveDirectionBlock.AXIS, Direction.Axis.Y);
    			matrixStack.translate(0.5, 0.0, 0.5);
    			matrixStack.rotate(Vector3f.YP.rotationDegrees(angle));
    			matrixStack.translate(-0.5, 0.0, -0.5);
    		} else {
    			state = TechnologicaBlocks.LINE_SHAFT.get().getDefaultState().with(TwelveDirectionBlock.AXIS, Direction.Axis.Z);
    			matrixStack.translate(0.5, 0.5, 0.0);
    			matrixStack.rotate(Vector3f.ZP.rotationDegrees(angle));
    			matrixStack.translate(-0.5, -0.5, 0.0);
    		}
       
    		blockModelRenderer.renderModel(tileEntity.getWorld(), blockrendererdispatcher.getModelForState(state), state, tileEntity.getPos(), matrixStack, buffer.getBuffer(RenderType.getSolid()), false, new Random(), 42, combinedOverlay, tileEntity2.getModelData());
    		matrixStack.pop();
    	}
    }
}
