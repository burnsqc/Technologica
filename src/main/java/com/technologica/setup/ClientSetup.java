package com.technologica.setup;

import java.lang.reflect.Field;

import com.technologica.Technologica;
import com.technologica.client.gui.screens.inventory.AnnunciatorScreen;
import com.technologica.client.renderer.MoonRenderer;
import com.technologica.world.inventory.TechnologicaContainerType;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.state.properties.TechnologicaWoodType;
import com.technologica.world.level.material.TechnologicaFluids;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class ClientSetup {

	@SuppressWarnings("unchecked")
	public static void init(final FMLClientSetupEvent event) {
		MenuScreens.register(TechnologicaContainerType.ANNUNCIATOR.get(), AnnunciatorScreen::new);
		
		event.enqueueWork(() -> {			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ASPARAGUS_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BARLEY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BLACKBERRY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BLUEBERRY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BROCCOLI_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CELERY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHILI_PEPPER_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.COFFEE_BEAN_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.COTTON_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CUCUMBER_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.GARLIC_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.GINGER_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.GRAPE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LETTUCE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MUSTARD_GREENS_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.OATS_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ONION_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEA_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEANUT_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PINEAPPLE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PURPLE_CABBAGE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RADISH_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RASPBERRY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RED_BEAN_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RYE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.SOYBEAN_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.SQUASH_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.STRAWBERRY_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.SWEET_POTATO_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TEA_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TOMATO_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TURNIP_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ZUCCHINI_CROP.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CORN_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEPPERCORN_CROP.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RICE_CROP.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CRANBERRY_CROP.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.APRICOT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ASPEN_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.AVOCADO_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BANANA_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHERRY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHESTNUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CINNAMON_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.COCONUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.EBONY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.KIWI_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LEMON_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LIME_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAHOGANY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAPLE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.OLIVE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ORANGE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEACH_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEAR_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PLUM_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.REDWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RUBBER_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TEAK_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.WALNUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.NECROTIC_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_LIME_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.APRICOT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ASPEN_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.AVOCADO_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BANANA_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHERRY_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHESTNUT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CINNAMON_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.COCONUT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.EBONY_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.KIWI_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LEMON_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LIME_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAHOGANY_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAPLE_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.OLIVE_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ORANGE_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEACH_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEAR_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PLUM_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.REDWOOD_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ROSEWOOD_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RUBBER_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TEAK_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.WALNUT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ALCHEMICAL_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BENEVOLENT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CONDUCTIVE_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.FROSTBITTEN_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.FRUITFUL_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.INFERNAL_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MALEVOLENT_DOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.NECROTIC_DOOR.get(), RenderType.cutoutMipped());
			

			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ASPEN_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BANANA_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHERRY_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.COCONUT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.EBONY_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.KIWI_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LEMON_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.LIME_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MAPLE_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.OLIVE_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ORANGE_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEACH_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PEAR_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.PLUM_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.RUBBER_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.TEAK_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.WALNUT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.NECROTIC_TRAPDOOR.get(), RenderType.cutoutMipped());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.NAVAL_MINE_CHAIN.get(), RenderType.cutoutMipped());
      			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.DISPLAY_CASE.get(), RenderType.translucent());

			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.FLUORITE_CRYSTAL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.ULEXITE_CRYSTAL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.DOLOMITE_CRYSTAL.get(), RenderType.translucent());
    	  	
			ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.HYDROGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_HYDROGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.HELIUM.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_HELIUM.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.NITROGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_NITROGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.OXYGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_OXYGEN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLUORINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_FLUORINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.NEON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_NEON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.CHLORINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_CHLORINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.ARGON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_ARGON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.KRYPTON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_KRYPTON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.XENON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_XENON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.RADON.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_RADON.get(), RenderType.translucent());
    	  	
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.BROMINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_BROMINE.get(), RenderType.translucent());
			
			ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.BRINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_BRINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.NATURAL_GAS.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_NATURAL_GAS.get(), RenderType.translucent());
    	  	
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.MAPLE_SYRUP.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_MAPLE_SYRUP.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.RUBBER_RESIN.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_RUBBER_RESIN.get(), RenderType.translucent());
    	  	
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.GASOLINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_GASOLINE.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.MACHINE_OIL.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_MACHINE_OIL.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.COOLANT.get(), RenderType.translucent());
    	  	ItemBlockRenderTypes.setRenderLayer(TechnologicaFluids.FLOWING_COOLANT.get(), RenderType.translucent());
    	  	
    	  	Sheets.addWoodType(TechnologicaWoodType.ALCHEMICAL);
			Sheets.addWoodType(TechnologicaWoodType.APRICOT);
			Sheets.addWoodType(TechnologicaWoodType.ASPEN);
			Sheets.addWoodType(TechnologicaWoodType.AVOCADO);
			Sheets.addWoodType(TechnologicaWoodType.BANANA);
			Sheets.addWoodType(TechnologicaWoodType.BENEVOLENT);
			Sheets.addWoodType(TechnologicaWoodType.CHERRY);
			Sheets.addWoodType(TechnologicaWoodType.CHESTNUT);
			Sheets.addWoodType(TechnologicaWoodType.CINNAMON);
			Sheets.addWoodType(TechnologicaWoodType.COCONUT);
			Sheets.addWoodType(TechnologicaWoodType.CONDUCTIVE);
			Sheets.addWoodType(TechnologicaWoodType.EBONY);
			Sheets.addWoodType(TechnologicaWoodType.FROSTBITTEN);
			Sheets.addWoodType(TechnologicaWoodType.FRUITFUL);
			Sheets.addWoodType(TechnologicaWoodType.INFERNAL);
			Sheets.addWoodType(TechnologicaWoodType.KIWI);
			Sheets.addWoodType(TechnologicaWoodType.LEMON);
			Sheets.addWoodType(TechnologicaWoodType.LIME);
			Sheets.addWoodType(TechnologicaWoodType.MAHOGANY);
			Sheets.addWoodType(TechnologicaWoodType.MALEVOLENT);
			Sheets.addWoodType(TechnologicaWoodType.MAPLE);
			Sheets.addWoodType(TechnologicaWoodType.NECROTIC);
			Sheets.addWoodType(TechnologicaWoodType.OLIVE);
			Sheets.addWoodType(TechnologicaWoodType.ORANGE);
			Sheets.addWoodType(TechnologicaWoodType.PEACH);
			Sheets.addWoodType(TechnologicaWoodType.PEAR);
			Sheets.addWoodType(TechnologicaWoodType.PLUM);
			Sheets.addWoodType(TechnologicaWoodType.REDWOOD);
			Sheets.addWoodType(TechnologicaWoodType.ROSEWOOD);
			Sheets.addWoodType(TechnologicaWoodType.RUBBER);
			Sheets.addWoodType(TechnologicaWoodType.TEAK);
			Sheets.addWoodType(TechnologicaWoodType.WALNUT);
			Sheets.addWoodType(TechnologicaWoodType.ZEBRAWOOD);
		});
		
		Field effects = ObfuscationReflectionHelper.findField(DimensionSpecialEffects.class, "EFFECTS");
		DimensionSpecialEffects dimensionRenderInfo = new DimensionSpecialEffects.OverworldEffects();
		dimensionRenderInfo.setSkyRenderHandler(new MoonRenderer());
		dimensionRenderInfo.setCloudRenderHandler((ticks, partialTicks, matrixStack, world, mc, viewEntityX, viewEntityY, viewEntityZ) -> {});
        try {
			((Object2ObjectMap<ResourceLocation, DimensionSpecialEffects>) effects.get(null)).put(new ResourceLocation(Technologica.MODID, "moon"), dimensionRenderInfo);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
   
	public static void stitch(final TextureStitchEvent.Pre event) {
		if (event.getAtlas().location().equals(InventoryMenu.BLOCK_ATLAS)) 
			event.addSprite(new ResourceLocation(Technologica.MODID, "block/pulley_belt"));}}
