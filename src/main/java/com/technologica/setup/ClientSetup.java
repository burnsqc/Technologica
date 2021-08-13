package com.technologica.setup;

import static com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer.PULLEY_BELT_TEXTURE;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.block.ModBlocks;
import com.technologica.block.TallCropsBlock;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.ModBoatRenderer;
import com.technologica.client.renderer.entity.OstrichRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.client.renderer.tileentity.DisplayCaseTileEntityRenderer;
import com.technologica.client.renderer.tileentity.FruitTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftHangerTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer;
import com.technologica.client.renderer.tileentity.ModSignTileEntityRenderer;
import com.technologica.client.renderer.tileentity.PotionTileEntityRenderer;
import com.technologica.entity.ModEntities;
import com.technologica.fluid.ModFluids;
import com.technologica.tileentity.ModTileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

	public static void init(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOD_BOAT.get(), ModBoatRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.DUCK.get(), DuckRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.OSTRICH.get(), OstrichRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.SHARK.get(), SharkRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.ZEBRA.get(), ZebraRenderer::new);

		event.enqueueWork(() -> {
			automaticCutoutMipped(ModBlocks.BLOCKS.getEntries());
      			
			RenderTypeLookup.setRenderLayer(ModBlocks.DISPLAY_CASE.get(), RenderType.getTranslucent());

			RenderTypeLookup.setRenderLayer(ModBlocks.AQUAMARINE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(ModBlocks.FLUORITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(ModBlocks.ULEXITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(ModBlocks.DOLOMITE_CRYSTAL.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(ModFluids.BRINE_SOURCE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(ModFluids.BRINE_FLOWING.get(), RenderType.getTranslucent());

    	  	ClientRegistry.bindTileEntityRenderer(ModTileEntities.MOD_SIGN.get(), ModSignTileEntityRenderer::new);
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
   
	private final static void automaticCutoutMipped(Collection<RegistryObject<Block>> blockCollection) {
		for(Supplier<? extends Block> blockSupplier:blockCollection) {
			Block block = blockSupplier.get();
			
			if (
				block.getClass().equals(CropsBlock.class) ||
				block.getClass().equals(TallCropsBlock.class) ||
				block.getClass().equals(SaplingBlock.class) ||
				block.getClass().equals(FlowerPotBlock.class) ||
				block.getClass().equals(DoorBlock.class)||
				block.getClass().equals(TrapDoorBlock.class)) {
					RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
				}

		}
	}
}