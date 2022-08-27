package com.technologica.setup;

import java.lang.reflect.Field;

import com.technologica.Technologica;
import com.technologica.client.gui.screens.inventory.AnnunciatorScreen;
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
			TechnologicaItemBlockRenderTypes();

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
		// dimensionRenderInfo.setSkyRenderHandler(new MoonRenderer());
		// dimensionRenderInfo.setCloudRenderHandler((ticks, partialTicks, matrixStack, world, mc, viewEntityX, viewEntityY, viewEntityZ) -> {
		// });
		try {
			((Object2ObjectMap<ResourceLocation, DimensionSpecialEffects>) effects.get(null)).put(new ResourceLocation(Technologica.MODID, "moon"), dimensionRenderInfo);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void TechnologicaItemBlockRenderTypes() {
		ItemBlockRenderTypes.setRenderLayer(TechnologicaBlocks.GLUE.get(), RenderType.cutoutMipped());

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
	}

	public static void stitch(final TextureStitchEvent.Pre event) {
		if (event.getAtlas().location().equals(InventoryMenu.BLOCK_ATLAS)) {
			event.addSprite(new ResourceLocation(Technologica.MODID, "block/pulley_belt"));
			event.addSprite(new ResourceLocation(Technologica.MODID, "block/sawblade"));
		}
	}
}