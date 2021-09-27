package com.technologica.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.technologica.item.ModItems;
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
    	
    	Block log = Block.getBlockFromItem(stack.getItem());
    	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
		BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();
    	
		ItemStack blade = new ItemStack(ModItems.SAWBLADE.get().getItem(), 1);
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
    	IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(blade, tileEntity.getWorld(), null);
		
		matrixStack.push();
    	matrixStack.translate(0.5, 0.9, 0.5);
    	matrixStack.rotate(angle());
    	matrixStack.scale(2.25F, 2.25F, 1.0F);
    	itemRenderer.renderItem(blade, ItemCameraTransforms.TransformType.NONE, true, matrixStack, buffer, combinedLight, combinedOverlay, ibakedmodel); 
    	matrixStack.pop();
		
    	if (!stack.isEmpty()) {
    		matrixStack.push();
    		BlockState state = log.getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.X);
    		matrixStack.translate(tileEntity.getLogPos(), 1.0, 0.0);
    		blockModelRenderer.renderModel(tileEntity.getWorld(), blockrendererdispatcher.getModelForState(state), state, tileEntity.getPos(), matrixStack, buffer.getBuffer(RenderType.getSolid()), false, new Random(), 42, combinedOverlay, EmptyModelData.INSTANCE);
    		matrixStack.pop();
    	}
    }
    
    private Quaternion angle() {
    	long time = System.currentTimeMillis() * 6;
    	float angle = time % 360;
    	Vector3f vector = Vector3f.ZP;

    	return vector.rotationDegrees(angle);
    }
}