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
	public static final ResourceLocation PULLEY_BELT_TEXTURE = new ResourceLocation(Technologica.MODID, "block/pulley_belt");
	
	public LineShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

	private void addBox(MatrixStack matrixStack, IRenderTypeBuffer buffer, float x, float y, float z, float w, float h, float d) {
		TextureAtlasSprite sprite = Minecraft.getInstance().getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE).apply(PULLEY_BELT_TEXTURE);
        IVertexBuilder builder = buffer.getBuffer(RenderType.getSolid());

        //NORTH
        /*
        add(builder, matrixStack, x, 	 y, 	z + d, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x + w, y, 	z + d, sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x + w, y + h, z + d, sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x, 	 y + h, z + d, sprite.getMinU(), sprite.getMaxV());
        */
        
        //EAST
        add(builder, matrixStack, x + w, y, 	z + d, sprite.getInterpolatedU(1), sprite.getMinV());
        add(builder, matrixStack, x + w, y, 	z, 	   sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x + w, y + h, z, 	   sprite.getMinU(), sprite.getMaxV());
        add(builder, matrixStack, x + w, y + h, z + d, sprite.getInterpolatedU(1), sprite.getMaxV());
        
        //SOUTH
        /*
        add(builder, matrixStack, x + w, y, 	z,     sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x, 	 y, 	z,     sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x, 	 y + h, z,     sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x + w, y + h, z,     sprite.getMinU(), sprite.getMaxV());
        */
        
        //WEST
        add(builder, matrixStack, x, 	 y, 	z, 	   sprite.getInterpolatedU(15), sprite.getMinV());
        add(builder, matrixStack, x, 	 y, 	z + d, sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x, 	 y + h, z + d, sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x, 	 y + h, z, 	   sprite.getInterpolatedU(15), sprite.getMaxV());
        
        //UP
        add(builder, matrixStack, x, 	 y + h, z + d, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x + w, y + h, z + d, sprite.getInterpolatedU(4), sprite.getMinV());
        add(builder, matrixStack, x + w, y + h, z, 	   sprite.getInterpolatedU(4), sprite.getMaxV());
        add(builder, matrixStack, x, 	 y + h, z, 	   sprite.getMinU(), sprite.getMaxV());
        
        //DOWN
        add(builder, matrixStack, x, 	 y, 	z, 	   sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x + w, y, 	z, 	   sprite.getInterpolatedU(4), sprite.getMinV());
        add(builder, matrixStack, x + w, y, 	z + d, sprite.getInterpolatedU(4), sprite.getMaxV());
        add(builder, matrixStack, x, 	 y, 	z + d, sprite.getMinU(), sprite.getMaxV());
	}
	
	private void add(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v) {
        renderer.pos(stack.getLast().getMatrix(), x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).tex(u, v).lightmap(0, 240).normal(1, 0, 0).endVertex();
    }
	
    @Override
    public void render(LineShaftTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {  
    	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
    	BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();

        matrixStack.push();

		if (tileEntity.getBeltPos() != null) {		
			float angle = 0;
			float radius1 = tileEntity.getBlockState().get(LineShaftBlock.PULLEY);
			if (radius1 == 1) {
				radius1 = 0.25f;
			} else if (radius1 == 2) {
				radius1 = 0.5f;
			} else if (radius1 == 3) {
				radius1 = 1.0f;
			}
			
			if (tileEntity.getPos().getZ() - tileEntity.getBeltPos().getZ() != 0) {
				angle = (float) Math.atan((float) ((float) tileEntity.getPos().getY() - (float) tileEntity.getBeltPos().getY()) / ((float) tileEntity.getPos().getZ() - (float) tileEntity.getBeltPos().getZ())) * 180 / (float) Math.PI;
			} else {
				angle = (tileEntity.getPos().getY() > tileEntity.getBeltPos().getY()) ? (float) -90.0f: (float) 90.0f;
			}
			
			
			if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.X) {
				matrixStack.translate(0, 0.5d, 0.5d);
				matrixStack.rotate(Vector3f.XN.rotationDegrees(angle));
				
				addBox(matrixStack, buffer, 0.376f, 0, 0, 0.248f, 0.0625f, (float) Math.sqrt(Math.pow(tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), 2) + Math.pow(tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 2)));
				//0.5f + radius1 - 0.03125f, 0.5f
//				addBox(matrixStack, buffer, 0.376f, 0.5f - radius1 - 0.03125f, 0.5f, 0.248f, 0.0625f, tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ());
//				matrixStack.translate(-offset(tileEntity)[0], -offset(tileEntity)[1], -offset(tileEntity)[2]);
				
			} else if (tileEntity.getBlockState().get(LineShaftBlock.AXIS) == Direction.Axis.Y) {	
				matrixStack.rotate(Vector3f.ZP.rotationDegrees(90));
				matrixStack.translate(0, -1, 0);
				addBox(matrixStack, buffer, 0.375f, 0.5f, 0.5f, 0.25f, tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ());				
			} else {
				matrixStack.rotate(Vector3f.YP.rotationDegrees(90));
				matrixStack.translate(-1, 0, 0);
				addBox(matrixStack, buffer, 0.375f, 0.5f, 0.5f, 0.25f, tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ());
			}
		}
        matrixStack.pop();
		
		matrixStack.push();
		
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
