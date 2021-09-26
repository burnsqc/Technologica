package com.technologica.client.renderer.tileentity;

import java.util.Arrays;
import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.technologica.Technologica;
import com.technologica.block.LineShaftBlock;
import com.technologica.tileentity.LineShaftTileEntity;
import com.technologica.util.Radius;
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

        //EAST
        add(builder, matrixStack, x2, y4, z4, sprite.getInterpolatedU(1), sprite.getMinV());
        add(builder, matrixStack, x2, y3, z3, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x2, y2, z2, sprite.getMinU(), sprite.getMaxV());
        add(builder, matrixStack, x2, y1, z1, sprite.getInterpolatedU(1), sprite.getMaxV());
        
        //WEST
        add(builder, matrixStack, x1, y1, z1, sprite.getInterpolatedU(15), sprite.getMinV());
        add(builder, matrixStack, x1, y2, z2, sprite.getMaxU(), sprite.getMinV());
        add(builder, matrixStack, x1, y3, z3, sprite.getMaxU(), sprite.getMaxV());
        add(builder, matrixStack, x1, y4, z4, sprite.getInterpolatedU(15), sprite.getMaxV());
        
        //UP
        add(builder, matrixStack, x1, y3, z3, sprite.getMinU(), sprite.getMinV());
        add(builder, matrixStack, x2, y3, z3, sprite.getInterpolatedU(4), sprite.getMinV());
        add(builder, matrixStack, x2, y4, z4, sprite.getInterpolatedU(4), sprite.getMaxV());
        add(builder, matrixStack, x1, y4, z4, sprite.getMinU(), sprite.getMaxV());
        
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
			
			Radius radius1 = tileEntity.getBlockState().get(LineShaftBlock.RADIUS);
			Radius radius2;
			
			if (tileEntity.getWorld().getTileEntity(tileEntity.getBeltPos()) instanceof LineShaftTileEntity) {
				radius2 = tileEntity.getWorld().getBlockState(tileEntity.getBeltPos()).get(LineShaftBlock.RADIUS);
			} else {
				radius2 = null;
			}
			
			float[] coords;
			
			switch(tileEntity.getBlockState().get(LineShaftBlock.AXIS)) {
			case X:
				matrixStack.translate(0, 0.5d, 0.5d);
				coords = ModMathHelper.CircleTangents((float) tileEntity.getPos().getZ(), (float) tileEntity.getPos().getY(), (float) tileEntity.getBeltPos().getZ(), (float) tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
				addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getPos().getY(), coords[0] - tileEntity.getPos().getZ(), 0.624f, coords[3] - tileEntity.getPos().getY(), coords[2] - tileEntity.getPos().getZ(), coords[5] - tileEntity.getPos().getY(), coords[4] - tileEntity.getPos().getZ(), coords[7] - tileEntity.getPos().getY(), coords[6] - tileEntity.getPos().getZ());
				break;
			case Y:
				matrixStack.rotate(Vector3f.YP.rotationDegrees(90));
				matrixStack.rotate(Vector3f.ZP.rotationDegrees(90));
				matrixStack.translate(0, 0.5d, 0.5d);
				coords = ModMathHelper.CircleTangents((float) tileEntity.getPos().getX(), (float) tileEntity.getPos().getZ(), (float) tileEntity.getBeltPos().getX(), (float) tileEntity.getBeltPos().getZ(), radius1.getRadius(), radius2.getRadius());
				addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getPos().getZ(), coords[0] - tileEntity.getPos().getX(), 0.624f, coords[3] - tileEntity.getPos().getZ(), coords[2] - tileEntity.getPos().getX(), coords[5] - tileEntity.getPos().getZ(), coords[4] - tileEntity.getPos().getX(), coords[7] - tileEntity.getPos().getZ(), coords[6] - tileEntity.getPos().getX());
				break;
			case Z:
				matrixStack.rotate(Vector3f.YP.rotationDegrees(90));
				matrixStack.translate(-1, 0.5d, 0.5d);
				coords = ModMathHelper.CircleTangents((float) tileEntity.getPos().getX(), (float) tileEntity.getPos().getY(), (float) tileEntity.getBeltPos().getX(), (float) tileEntity.getBeltPos().getY(), radius1.getRadius(), radius2.getRadius());
				addBox(matrixStack, buffer, 0.376f, coords[1] - tileEntity.getPos().getY(), coords[0] - tileEntity.getPos().getX(), 0.624f, coords[3] - tileEntity.getPos().getY(), coords[2] - tileEntity.getPos().getX(), coords[5] - tileEntity.getPos().getY(), coords[4] - tileEntity.getPos().getX(), coords[7] - tileEntity.getPos().getY(), coords[6] - tileEntity.getPos().getX());
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
