package com.technologica.setup;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.VanillaCropsBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.InvisibleRenderer;
import com.technologica.client.renderer.entity.OstrichRenderer;
import com.technologica.client.renderer.entity.PeeperRenderer;
import com.technologica.client.renderer.entity.ScorpionRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.VanillaBoatRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.client.renderer.tileentity.DisplayCaseTileEntityRenderer;
import com.technologica.client.renderer.tileentity.FruitTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftHangerTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer;
import com.technologica.client.renderer.tileentity.PotionTileEntityRenderer;
import com.technologica.client.renderer.tileentity.SawmillTileEntityRenderer;
import com.technologica.client.renderer.tileentity.VanillaSignTileEntityRenderer;
import com.technologica.entity.TechnologicaEntities;
import com.technologica.fluid.TechnologicaFluids;
import com.technologica.tileentity.TechnologicaTileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

	public static void init(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.MOD_BOAT.get(), VanillaBoatRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.INVISIBLE_SEAT.get(), InvisibleRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.DUCK.get(), DuckRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.OSTRICH.get(), OstrichRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.SCORPION.get(), ScorpionRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.SHARK.get(), SharkRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.ZEBRA.get(), ZebraRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntities.PEEPER.get(), PeeperRenderer::new);

		event.enqueueWork(() -> {
			automaticCutoutMipped(TechnologicaBlocks.BLOCKS.getEntries());
      			
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.DISPLAY_CASE.get(), RenderType.getTranslucent());

			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), RenderType.getTranslucent());
    	  	
			RenderTypeLookup.setRenderLayer(TechnologicaFluids.BRINE_SOURCE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.BRINE_FLOWING.get(), RenderType.getTranslucent());

    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.MOD_SIGN.get(), VanillaSignTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.FRUIT_CROP.get(), FruitTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.POTION_CROP.get(), PotionTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.DISPLAY_TILE.get(), DisplayCaseTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.LINE_SHAFT_TILE.get(), LineShaftTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.SAWMILL_TILE.get(), SawmillTileEntityRenderer::new);
		});
	}
   
	public static void stitch(final TextureStitchEvent.Pre event) {
		if (event.getMap().getTextureLocation().equals(PlayerContainer.LOCATION_BLOCKS_TEXTURE)) {
			event.addSprite(new ResourceLocation(Technologica.MODID, "block/pulley_belt"));
		} else if (event.getMap().getTextureLocation().equals(Atlases.SIGN_ATLAS)) {
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/apricot"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/aspen"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/avocado"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/banana"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/cherry"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/chestnut"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/coconut"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/ebony"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/kiwi"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/lemon"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/lime"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/mahogany"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/maple"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/orange"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/peach"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/pear"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/plum"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/redwood"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/rosewood"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/rubber"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/teak"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/walnut"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/zebrawood"));
		}
	}
   
	private final static void automaticCutoutMipped(Collection<RegistryObject<Block>> blockCollection) {
		for(Supplier<? extends Block> blockSupplier:blockCollection) {
			Block block = blockSupplier.get();
			
			if (
				block.getClass().equals(VanillaCropsBlock.class) ||
				block.getClass().equals(TallCropsBlock.class) ||
				block.getClass().equals(WaterCropsBlock.class) ||
				block.getClass().equals(SaplingBlock.class) ||
				block.getClass().equals(FlowerPotBlock.class) ||
				block.getClass().equals(DoorBlock.class)||
				block.getClass().equals(TrapDoorBlock.class)) {
					RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
				}

		}
	}
}