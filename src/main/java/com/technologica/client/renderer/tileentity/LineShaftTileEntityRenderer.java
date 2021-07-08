package com.technologica.client.renderer.tileentity;

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
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Random;

import static net.minecraft.block.RotatedPillarBlock.AXIS;

public class LineShaftTileEntityRenderer extends TileEntityRenderer<LineShaftTileEntity> {

   public static final ResourceLocation MAGICBLOCK_TEXTURE = new ResourceLocation(Technologica.MODID, "block/pulley");

   public LineShaftTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
      super(rendererDispatcherIn);
   }

   private void add(IVertexBuilder renderer, MatrixStack stack, float x, float y, float z, float u, float v) {
      renderer.pos(stack.getLast().getMatrix(), x, y, z).color(1.0f, 1.0f, 1.0f, 1.0f).tex(u, v).lightmap(0, 240).normal(1, 0, 0).endVertex();
   }

   @Override
   public void render(LineShaftTileEntity tileEntity, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
      TextureAtlasSprite sprite = Minecraft.getInstance().getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE).apply(MAGICBLOCK_TEXTURE);
      IVertexBuilder builder = buffer.getBuffer(RenderType.getSolid());

      long time = System.currentTimeMillis() * 6 * tileEntity.getRPM() / 1000;
      float angle = time % 360;
      BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
      BlockModelRenderer blockModelRenderer = blockrendererdispatcher.getBlockModelRenderer();

      matrixStack.push();

      if (tileEntity.getBeltPos() != null) {
         float radius1;
         float radius2;
         if (tileEntity.getBlockState().get(LineShaftBlock.PULLEY) == 1) {
            radius1 = 0.25F;
         } else if (tileEntity.getBlockState().get(LineShaftBlock.PULLEY) == 2) {
            radius1 = 0.5F;
         } else {
            radius1 = 1.0F;
         }
         if (tileEntity.getWorld().getTileEntity(tileEntity.getBeltPos()).getBlockState().get(LineShaftBlock.PULLEY) == 1) {
            radius2 = 0.25F;
         } else if (tileEntity.getWorld().getTileEntity(tileEntity.getBeltPos()).getBlockState().get(LineShaftBlock.PULLEY) == 2) {
            radius2 = 0.5F;
         } else {
            radius2 = 1.0F;
         }

         if (tileEntity.getBlockState().get(AXIS) == Direction.Axis.X) {

            double a = Math.asin(Math.abs(radius1 - radius2) / (Math.abs(tileEntity.getBeltPos().getY() - tileEntity.getPos().getY()) ^ 2 + Math.abs(tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ()) ^ 2));
            float yPos1 = (float) (Math.abs(radius1 - radius2) * Math.cos(a));
            float zPos1 = (float) (Math.abs(radius1 - radius2) * Math.sin(a));

            add(builder, matrixStack, 0.375f, 0.5f, 0.5f, sprite.getMinU() + 0.01f, sprite.getMinV());
            add(builder, matrixStack, 0.625f, 0.5f, 0.5f, sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.625f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.375f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU() + 0.01f, sprite.getMaxV());

            add(builder, matrixStack, 0.375f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU() + 0.01f, sprite.getMaxV());
            add(builder, matrixStack, 0.625f, 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.625f, 0.5f, 0.5f, sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.375f, 0.5f, 0.5f, sprite.getMinU() + 0.01f, sprite.getMinV());
         } else if (tileEntity.getBlockState().get(AXIS) == Direction.Axis.Y) {
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.375f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU() + 0.01f, sprite.getMinV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.625f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.5f, 0.625f, 0.5f, sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f, 0.375f, 0.5f, sprite.getMinU() + 0.01f, sprite.getMaxV());

            add(builder, matrixStack, 0.5f, 0.375f, 0.5f, sprite.getMinU() + 0.01f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f, 0.625f, 0.5f, sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.625f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.375f, 0.5f + tileEntity.getBeltPos().getZ() - tileEntity.getPos().getZ(), sprite.getMinU() + 0.01f, sprite.getMinV());
         } else {
            add(builder, matrixStack, 0.5f, 0.5f, 0.375f, sprite.getMinU() + 0.01f, sprite.getMinV());
            add(builder, matrixStack, 0.5f, 0.5f, 0.625f, sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.625f, sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.375f, sprite.getMinU() + 0.01f, sprite.getMaxV());

            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.375f, sprite.getMinU() + 0.01f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f + tileEntity.getBeltPos().getX() - tileEntity.getPos().getX(), 0.5f + tileEntity.getBeltPos().getY() - tileEntity.getPos().getY(), 0.625f, sprite.getMaxU() - 0.005f, sprite.getMaxV());
            add(builder, matrixStack, 0.5f, 0.5f, 0.625f, sprite.getMaxU() - 0.005f, sprite.getMinV());
            add(builder, matrixStack, 0.5f, 0.5f, 0.375f, sprite.getMinU() + 0.01f, sprite.getMinV());
         }
      }

      if (tileEntity.getBlockState().get(AXIS) == Direction.Axis.X) {
         matrixStack.translate(0.0, 0.5, 0.5);
         matrixStack.rotate(Vector3f.XP.rotationDegrees(angle));
         matrixStack.translate(0.0, -0.5, -0.5);
      } else if (tileEntity.getBlockState().get(AXIS) == Direction.Axis.Y) {
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

   @Override
   public boolean isGlobalRenderer(LineShaftTileEntity te) {
      return true;
   }
}
