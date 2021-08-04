package com.technologica.client.renderer.tileentity;

import java.util.Arrays;
import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;
import com.technologica.block.LineShaftBlock;
import com.technologica.tileentity.LineShaftTileEntity;
import com.technologica.util.math.ModMathHelper;

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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class LineShaftTileEntityRenderer extends TileEntityRenderer<LineShaftTileEntity> {
	public static final ResourceLocation PULLEY_BELT_TEXTURE = new ResourceLocation(Technologica.MODID, "block/pulley_belt");
	
	public LineShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

	private void addBox(MatrixStack matrixStack, IRenderTypeBuffer buffer, float x1, float y1, float z1, float x2, float y2, float z2, float y3, float z3, float y4, float z4) {
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
        add(builder, matrixStack, x2, y2, z4, sprite.getInterpolatedU(1), sprite.getMinV());
        add(builder, matrixStack, x2, y1, z3, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x2, y3, z1, sprite.getMinU(), sprite.getMaxV());
        add(builder, matrixStack, x2, y4, z2, sprite.getInterpolatedU(1), sprite.getMaxV());
        
        //SOUTH
        /*
        add(builder, matrixStack, x + w, y, 	z,     sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x, 	 y, 	z,     sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x, 	 y + h, z,     sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x + w, y + h, z,     sprite.getMinU(), sprite.getMaxV());
        */
        
        //WEST
        add(builder, matrixStack, x1, y1, z1, sprite.getInterpolatedU(15), sprite.getMinV());
        add(builder, matrixStack, x1, y2, z2, sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x1, y4, z4, sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x1, y3, z3, sprite.getInterpolatedU(15), sprite.getMaxV());
        
        //UP
        add(builder, matrixStack, x1, y4, z4, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x2, y4, z4, sprite.getInterpolatedU(4), sprite.getMinV());
        add(builder, matrixStack, x2, y3, z3, sprite.getInterpolatedU(4), sprite.getMaxV());
        add(builder, matrixStack, x1, y3, z3, sprite.getMinU(), sprite.getMaxV());
        
        //DOWN
        add(builder, matrixStack, x1, y1, z1, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x2, y1, z1, sprite.getInterpolatedU(4), sprite.getMinV());
        add(builder, matrixStack, x2, y2, z2, sprite.getInterpolatedU(4), sprite.getMaxV());
        add(builder, matrixStack, x1, y2, z2, sprite.getMinU(), sprite.getMaxV());
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
			float radius2;
			if (tileEntity.getWorld().getTileEntity(tileEntity.getBeltPos()) instanceof LineShaftTileEntity) {
				radius2 = tileEntity.getWorld().getBlockState(tileEntity.getBeltPos()).get(LineShaftBlock.PULLEY);
			} else {
				radius2 = 1F;
			}
			if (radius1 == 1) {
				radius1 = 0.25f;
			} else if (radius1 == 2) {
				radius1 = 0.5f;
			} else if (radius1 == 3) {
				radius1 = 1.0f;
			}
			
			if (radius2 == 1) {
				radius2 = 0.25f;
			} else if (radius2 == 2) {
				radius2 = 0.5f;
			} else if (radius2 == 3) {
				radius2 = 1.0f;
			}
			
			if (tileEntity.getPos().getZ() - tileEntity.getBeltPos().getZ() != 0) {
				angle = (float) Math.atan((float) ((float) tileEntity.getPos().getY() - (float) tileEntity.getBeltPos().getY()) / ((float) tileEntity.getPos().getZ() - (float) tileEntity.getBeltPos().getZ())) * 180 / (float) Math.PI;
			} else {
				angle = (tileEntity.getPos().getY() > tileEntity.getBeltPos().getY()) ? (float) -90.0f: (float) 90.0f;
			}
			
			switch(tileEntity.getBlockState().get(LineShaftBlock.AXIS)) {
			case X:
				matrixStack.translate(0, 0.5d, 0.5d);
				matrixStack.rotate(Vector3f.XN.rotationDegrees(angle));
				float[] coords = ModMathHelper.CircleTangents((float) tileEntity.getPos().getZ(), (float) tileEntity.getPos().getY(), (float) tileEntity.getBeltPos().getZ(), (float) tileEntity.getBeltPos().getY(), radius1, radius2);
				addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getPos().getY(), coords[0] - tileEntity.getPos().getZ(), 0.624f, coords[3] - tileEntity.getPos().getY(), coords[2] - tileEntity.getPos().getZ(), coords[5] - tileEntity.getPos().getY(), coords[4] - tileEntity.getPos().getZ(), coords[7] - tileEntity.getPos().getY(), coords[6] - tileEntity.getPos().getZ());
				break;
			case Y:
				matrixStack.rotate(Vector3f.ZP.rotationDegrees(90));
				matrixStack.translate(0, -1, 0);
//				addBox(matrixStack, buffer, 0.376f, 0.5f, 0.5f, 0.248f, tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ());				
				break;
			case Z:
				matrixStack.rotate(Vector3f.YP.rotationDegrees(90));
				matrixStack.translate(-1, 0, 0);
//				addBox(matrixStack, buffer, 0.376f, 0.5f, 0.5f, 0.248f, tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ());
				break;
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
