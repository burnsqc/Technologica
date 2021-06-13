package com.technologica.setup;

import static com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer.PULLEY_BELT_TEXTURE;

import com.technologica.block.ModBlocks;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.OstrichRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.client.renderer.tileentity.DisplayCaseTileEntityRenderer;
import com.technologica.client.renderer.tileentity.FruitTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftHangerTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer;
import com.technologica.client.renderer.tileentity.PotionTileEntityRenderer;
import com.technologica.entity.ModEntities;
import com.technologica.fluid.ModFluids;
import com.technologica.tileentity.ModTileEntities;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

   public static void init(final FMLClientSetupEvent event) {
      RenderingRegistry.registerEntityRenderingHandler(ModEntities.DUCK.get(), DuckRenderer::new);
      RenderingRegistry.registerEntityRenderingHandler(ModEntities.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
      RenderingRegistry.registerEntityRenderingHandler(ModEntities.OSTRICH.get(), OstrichRenderer::new);
      RenderingRegistry.registerEntityRenderingHandler(ModEntities.SHARK.get(), SharkRenderer::new);
      RenderingRegistry.registerEntityRenderingHandler(ModEntities.ZEBRA.get(), ZebraRenderer::new);

      event.enqueueWork(() -> {
         RenderTypeLookup.setRenderLayer(ModBlocks.BANANA_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.COCONUT_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.KIWI_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.LEMON_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.LIME_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.PEACH_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.PEAR_SAPLING.get(), RenderType.getCutoutMipped());

         RenderTypeLookup.setRenderLayer(ModBlocks.ANCIENT_AMBROSIA_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), RenderType.getCutoutMipped());

         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_BANANA_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_COCONUT_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_KIWI_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_LEMON_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_LIME_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ORANGE_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_PEACH_SAPLING.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_PEAR_SAPLING.get(), RenderType.getCutoutMipped());

         RenderTypeLookup.setRenderLayer(ModBlocks.BLUEBERRY_CROP.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.GRAPE_CROP.get(), RenderType.getCutoutMipped());
         RenderTypeLookup.setRenderLayer(ModBlocks.STRAWBERRY_CROP.get(), RenderType.getCutoutMipped());

         RenderTypeLookup.setRenderLayer(ModBlocks.DISPLAY_CASE.get(), RenderType.getTranslucent());

         RenderTypeLookup.setRenderLayer(ModBlocks.AQUAMARINE_CRYSTAL.get(), RenderType.getTranslucent());
         RenderTypeLookup.setRenderLayer(ModBlocks.FLUORITE_CRYSTAL.get(), RenderType.getTranslucent());
         RenderTypeLookup.setRenderLayer(ModBlocks.ULEXITE_CRYSTAL.get(), RenderType.getTranslucent());
         RenderTypeLookup.setRenderLayer(ModBlocks.DOLOMITE_CRYSTAL.get(), RenderType.getTranslucent());

         RenderTypeLookup.setRenderLayer(ModFluids.BRINE_SOURCE.get(), RenderType.getTranslucent());
         RenderTypeLookup.setRenderLayer(ModFluids.BRINE_FLOWING.get(), RenderType.getTranslucent());

         ClientRegistry.bindTileEntityRenderer(ModTileEntities.FRUIT_CROP.get(), FruitTileEntityRenderer::new);
         ClientRegistry.bindTileEntityRenderer(ModTileEntities.POTION_CROP.get(), PotionTileEntityRenderer::new);
         ClientRegistry.bindTileEntityRenderer(ModTileEntities.DISPLAY_TILE.get(), DisplayCaseTileEntityRenderer::new);
         ClientRegistry.bindTileEntityRenderer(ModTileEntities.LINE_SHAFT_TILE.get(), LineShaftTileEntityRenderer::new);
         ClientRegistry.bindTileEntityRenderer(ModTileEntities.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerTileEntityRenderer::new);
      });
   }
   
   public static void stitch(final TextureStitchEvent.Pre event) {
	   if (event.getMap().getTextureLocation().equals(PlayerContainer.LOCATION_BLOCKS_TEXTURE)) {
	       	event.addSprite(PULLEY_BELT_TEXTURE);
	   }
   }
}