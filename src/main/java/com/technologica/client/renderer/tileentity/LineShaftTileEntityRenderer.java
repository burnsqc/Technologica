package com.technologica.client.renderer.tileentity;

import java.util.Arrays;
import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;
import com.technologica.block.LineShaftBlock;
import com.technologica.tileentity.LineShaftTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class LineShaftTileEntityRenderer extends TileEntityRenderer<LineShaftTileEntity> {
	public static final ResourceLocation PULLEY_BELT_TEXTURE = new ResourceLocation(Technologica.MODID, "block/pulley");
	
	public LineShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

	private void add(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v) {
        renderer.pos(stack.getLast().getMatrix(), x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).tex(u, v).lightmap(0, 240).normal(1, 0, 0).endVertex();
    }
	
    @Override
    public void render(LineShaftTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {  
    	TextureAtlasSprite sprite = Minecraft.getInstance().getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE).apply(PULLEY_BELT_TEXTURE);
        IVertexBuilder builder = buffer.getBuffer(RenderType.getSolid());
    	
    	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
    	BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();
      	
        matrixStack.push();  
        
		if (tileEntity.getBeltPos() != null) {
			if (tileEntity.getRatio() == 1.0) {
				
			}
			
			if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.X) {	
				
//				double a = Math.asin(Math.abs(radius1-radius2)/(Math.abs(tileEntity.getBeltPos().getY()-tileEntity.getPos().getY())^2+Math.abs(tileEntity.getBeltPos().getZ()-tileEntity.getPos().getZ())^2));
//				float yPos1 = (float) ((float) Math.abs(radius1-radius2)*Math.cos(a));
//				float zPos1 = (float) ((float) Math.abs(radius1-radius2)*Math.sin(a));
				
				add(builder, matrixStack, 0.375f, 0.5f, 0.5f, sprite.getMinU()+0.01f, sprite.getMinV());
		        add(builder, matrixStack, 0.625f, 0.5f, 0.5f, sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.625f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.375f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU()+0.01f, sprite.getMaxV());

		        add(builder, matrixStack, 0.375f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU()+0.01f, sprite.getMaxV());
		        add(builder, matrixStack, 0.625f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.625f, 0.5f, 0.5f, sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.375f, 0.5f, 0.5f, sprite.getMinU()+0.01f, sprite.getMinV());  
			} else if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.Y) {		
				add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.375f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU()+0.01f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.625f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f, 0.625f, 0.5f, sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f, 0.375f, 0.5f, sprite.getMinU()+0.01f, sprite.getMaxV());
		        
		        add(builder, matrixStack, 0.5f, 0.375f, 0.5f, sprite.getMinU()+0.01f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f, 0.625f, 0.5f, sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.625f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.375f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU()+0.01f, sprite.getMinV());  
			} else {
				add(builder, matrixStack, 0.5f, 0.5f, 0.375f, sprite.getMinU()+0.01f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f, 0.5f, 0.625f, sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.625f, sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.375f, sprite.getMinU()+0.01f, sprite.getMaxV());
		        
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.375f, sprite.getMinU()+0.01f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.625f, sprite.getMaxU()-0.005f, sprite.getMaxV());
		        add(builder, matrixStack, 0.5f, 0.5f, 0.625f, sprite.getMaxU()-0.005f, sprite.getMinV());
		        add(builder, matrixStack, 0.5f, 0.5f, 0.375f, sprite.getMinU()+0.01f, sprite.getMinV());  
			}
		}
        
        matrixStack.translate(offset(tileEntity)[0], offset(tileEntity)[1], offset(tileEntity)[2]);
        matrixStack.rotate(angle(tileEntity));
        matrixStack.translate(-offset(tileEntity)[0], -offset(tileEntity)[1], -offset(tileEntity)[2]);
        
        blockModelRenderer.renderModel(tileEntity.getWorld(), blockrendererdispatcher.getModelForState(tileEntity.getBlockState()), tileEntity.getBlockState(), tileEntity.getPos(), matrixStack, buffer.getBuffer(RenderType.getSolid()), false, new Random(), 42, combinedOverlay, tileEntity.getModelData());
        matrixStack.pop(); 
    }    
    
    private double[] offset(TileEntity tileEntityIn) {
    	double[] offset = new double[3];
    	Arrays.fill(offset,  0.5f);
    	
    	switch(tileEntityIn.getBlockState().get(LineShaftBlock.AXIS)) {
		case X:
			offset[0] = 0.0d;
			break;
		case Y:
			offset[1] = 0.0d;
			break;
		case Z:
			offset[2] = 0.0d;
			break;
    	}

    	return offset;
    }
    
    private Quaternion angle(TileEntity tileEntityIn) {
    	long time = System.currentTimeMillis() * 6 * ((LineShaftTileEntity) tileEntityIn).getRPM() / 1000;
    	float angle = time % 360;
    	Vector3f vector = Vector3f.XP;
    	
    	switch (tileEntityIn.getBlockState().get(LineShaftBlock.AXIS)) {
		case X:
			vector = Vector3f.XP;
			break;
		case Y:
			vector = Vector3f.YP;
			break;
		case Z:
			vector = Vector3f.ZP;
			break;    	
    	}
    
    	return vector.rotationDegrees(angle);
    }
    
    @Override
    public boolean isGlobalRenderer(LineShaftTileEntity te) {
        return true;
     }
}