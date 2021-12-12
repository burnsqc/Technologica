package com.technologica.setup;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TallCropsBlock;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.block.VanillaCropsBlock;
import com.technologica.block.WaterCropsBlock;
import com.technologica.client.renderer.MoonRenderer;
import com.technologica.client.renderer.entity.AlligatorRenderer;
import com.technologica.client.renderer.entity.BeaverRenderer;
import com.technologica.client.renderer.entity.BuffaloRenderer;
import com.technologica.client.renderer.entity.CamelRenderer;
import com.technologica.client.renderer.entity.CobraRenderer;
import com.technologica.client.renderer.entity.CottonmouthRenderer;
import com.technologica.client.renderer.entity.CoyoteRenderer;
import com.technologica.client.renderer.entity.CrabRenderer;
import com.technologica.client.renderer.entity.DeerRenderer;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.ElephantRenderer;
import com.technologica.client.renderer.entity.FlamingoRenderer;
import com.technologica.client.renderer.entity.FrogRenderer;
import com.technologica.client.renderer.entity.GiraffeRenderer;
import com.technologica.client.renderer.entity.GorillaRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.InvisibleRenderer;
import com.technologica.client.renderer.entity.JaguarRenderer;
import com.technologica.client.renderer.entity.KingCrabRenderer;
import com.technologica.client.renderer.entity.LeopardSealRenderer;
import com.technologica.client.renderer.entity.LionRenderer;
import com.technologica.client.renderer.entity.LizardRenderer;
import com.technologica.client.renderer.entity.MooseRenderer;
import com.technologica.client.renderer.entity.NarwhalRenderer;
import com.technologica.client.renderer.entity.OctopusRenderer;
import com.technologica.client.renderer.entity.OstrichRenderer;
import com.technologica.client.renderer.entity.OwlRenderer;
import com.technologica.client.renderer.entity.PeeperRenderer;
import com.technologica.client.renderer.entity.PenguinRenderer;
import com.technologica.client.renderer.entity.PoisonDartFrogRenderer;
import com.technologica.client.renderer.entity.RaccoonRenderer;
import com.technologica.client.renderer.entity.ScorpionRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.SlothRenderer;
import com.technologica.client.renderer.entity.StingrayRenderer;
import com.technologica.client.renderer.entity.SweeperRenderer;
import com.technologica.client.renderer.entity.TurkeyRenderer;
import com.technologica.client.renderer.entity.VanillaBoatRenderer;
import com.technologica.client.renderer.entity.VultureRenderer;
import com.technologica.client.renderer.entity.WalrusRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.client.renderer.tileentity.DisplayCaseTileEntityRenderer;
import com.technologica.client.renderer.tileentity.FruitTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftHangerTileEntityRenderer;
import com.technologica.client.renderer.tileentity.LineShaftTileEntityRenderer;
import com.technologica.client.renderer.tileentity.PotionTileEntityRenderer;
import com.technologica.client.renderer.tileentity.SawmillTileEntityRenderer;
import com.technologica.client.renderer.tileentity.VanillaSignTileEntityRenderer;
import com.technologica.entity.TechnologicaEntityType;
import com.technologica.fluid.TechnologicaFluids;
import com.technologica.tileentity.TechnologicaTileEntities;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

	@SuppressWarnings("unchecked")
	public static void init(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.MOD_BOAT.get(), VanillaBoatRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.INVISIBLE_SEAT.get(), InvisibleRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.DODGEBALL.get(), renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.ALLIGATOR.get(), AlligatorRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.BEAVER.get(), BeaverRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.BUFFALO.get(), BuffaloRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.CAMEL.get(), CamelRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.COBRA.get(), CobraRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.COTTONMOUTH.get(), CottonmouthRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.COYOTE.get(), CoyoteRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.CRAB.get(), CrabRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.DEER.get(), DeerRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.DUCK.get(), DuckRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.ELEPHANT.get(), ElephantRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.FLAMINGO.get(), FlamingoRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.FROG.get(), FrogRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.GIRAFFE.get(), GiraffeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.GORILLA.get(), GorillaRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.JAGUAR.get(), JaguarRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.KING_CRAB.get(), KingCrabRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSealRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.LION.get(), LionRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.LIZARD.get(), LizardRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.MOOSE.get(), MooseRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.NARWHAL.get(), NarwhalRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.OCTOPUS.get(), OctopusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.OSTRICH.get(), OstrichRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.OWL.get(), OwlRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.PENGUIN.get(), PenguinRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrogRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.RACCOON.get(), RaccoonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.SCORPION.get(), ScorpionRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.SHARK.get(), SharkRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.SLOTH.get(), SlothRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.STINGRAY.get(), StingrayRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.TURKEY.get(), TurkeyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.VULTURE.get(), VultureRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.WALRUS.get(), WalrusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.ZEBRA.get(), ZebraRenderer::new);
		
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.PEEPER.get(), PeeperRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TechnologicaEntityType.SWEEPER.get(), SweeperRenderer::new);

		event.enqueueWork(() -> {
			automaticCutoutMipped(TechnologicaBlocks.BLOCKS.getEntries());
      			
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.DISPLAY_CASE.get(), RenderType.getTranslucent());

			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), RenderType.getTranslucent());
    	  	
			RenderTypeLookup.setRenderLayer(TechnologicaFluids.HYDROGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_HYDROGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.HELIUM.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_HELIUM.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.NITROGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_NITROGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.OXYGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_OXYGEN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLUORINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_FLUORINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.NEON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_NEON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.CHLORINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_CHLORINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.ARGON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_ARGON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.KRYPTON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_KRYPTON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.XENON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_XENON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.RADON.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_RADON.get(), RenderType.getTranslucent());
    	  	
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.BROMINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_BROMINE.get(), RenderType.getTranslucent());
			
			RenderTypeLookup.setRenderLayer(TechnologicaFluids.BRINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_BRINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.NATURAL_GAS.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_NATURAL_GAS.get(), RenderType.getTranslucent());
    	  	
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.MAPLE_SYRUP.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_MAPLE_SYRUP.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.RUBBER_RESIN.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_RUBBER_RESIN.get(), RenderType.getTranslucent());
    	  	
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.GASOLINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_GASOLINE.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.MACHINE_OIL.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_MACHINE_OIL.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.COOLANT.get(), RenderType.getTranslucent());
    	  	RenderTypeLookup.setRenderLayer(TechnologicaFluids.FLOWING_COOLANT.get(), RenderType.getTranslucent());
    	  	
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.MOD_SIGN.get(), VanillaSignTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.FRUIT_CROP.get(), FruitTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.POTION_CROP.get(), PotionTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.DISPLAY_TILE.get(), DisplayCaseTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.LINE_SHAFT_TILE.get(), LineShaftTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerTileEntityRenderer::new);
    	  	ClientRegistry.bindTileEntityRenderer(TechnologicaTileEntities.SAWMILL_TILE.get(), SawmillTileEntityRenderer::new);
		});
		
		Field effects = ObfuscationReflectionHelper.findField(DimensionRenderInfo.class, "field_239208_a_");
		DimensionRenderInfo dimensionRenderInfo = new DimensionRenderInfo.Overworld();
		dimensionRenderInfo.setSkyRenderHandler(new MoonRenderer());
		dimensionRenderInfo.setCloudRenderHandler((ticks, partialTicks, matrixStack, world, mc, viewEntityX, viewEntityY, viewEntityZ) -> {});
        try {
			((Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) effects.get(null)).put(new ResourceLocation(Technologica.MODID, "moon"), dimensionRenderInfo);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
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
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/cinnamon"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/coconut"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/ebony"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/kiwi"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/lemon"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/lime"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/mahogany"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/maple"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "entity/signs/olive"));
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