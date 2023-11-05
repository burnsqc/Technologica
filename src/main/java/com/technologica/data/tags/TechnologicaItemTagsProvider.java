package com.technologica.data.tags;

import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBlockTags;
import com.technologica.tags.TechnologicaItemTags;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaItemTagsProvider extends ItemTagsProvider {
	public TechnologicaItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTagProvider, Technologica.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider p_256380_) {
		tag(ItemTags.BOATS).add(TechnologicaItems.APRICOT_BOAT.get(), TechnologicaItems.ASPEN_BOAT.get(), TechnologicaItems.AVOCADO_BOAT.get(), TechnologicaItems.BANANA_BOAT.get(), TechnologicaItems.CHERRY_BOAT.get(), TechnologicaItems.CHESTNUT_BOAT.get(), TechnologicaItems.CINNAMON_BOAT.get(), TechnologicaItems.COCONUT_BOAT.get(), TechnologicaItems.EBONY_BOAT.get(), TechnologicaItems.KIWI_BOAT.get(), TechnologicaItems.LEMON_BOAT.get(), TechnologicaItems.LIME_BOAT.get(), TechnologicaItems.MAHOGANY_BOAT.get(), TechnologicaItems.MAPLE_BOAT.get(), TechnologicaItems.OLIVE_BOAT.get(), TechnologicaItems.ORANGE_BOAT.get(), TechnologicaItems.PEACH_BOAT.get(), TechnologicaItems.PEAR_BOAT.get(), TechnologicaItems.PLUM_BOAT.get(), TechnologicaItems.REDWOOD_BOAT.get(), TechnologicaItems.ROSEWOOD_BOAT.get(), TechnologicaItems.RUBBER_BOAT.get(), TechnologicaItems.TEAK_BOAT.get(), TechnologicaItems.WALNUT_BOAT.get(), TechnologicaItems.ZEBRAWOOD_BOAT.get(), TechnologicaItems.ALCHEMICAL_BOAT.get(), TechnologicaItems.BENEVOLENT_BOAT.get(), TechnologicaItems.CONDUCTIVE_BOAT.get(), TechnologicaItems.FROSTBITTEN_BOAT.get(), TechnologicaItems.FRUITFUL_BOAT.get(), TechnologicaItems.INFERNAL_BOAT.get(), TechnologicaItems.MALEVOLENT_BOAT.get());
		tag(ItemTags.LEAVES).add(TechnologicaItems.ALCHEMICAL_LEAVES_ITEM.get(), TechnologicaItems.APRICOT_LEAVES_ITEM.get(), TechnologicaItems.ASPEN_LEAVES_ITEM.get(), TechnologicaItems.AVOCADO_LEAVES_ITEM.get(), TechnologicaItems.BANANA_LEAVES_ITEM.get(), TechnologicaItems.CHERRY_LEAVES_ITEM.get(), TechnologicaItems.CHESTNUT_LEAVES_ITEM.get(), TechnologicaItems.CINNAMON_LEAVES_ITEM.get(), TechnologicaItems.COCONUT_LEAVES_ITEM.get(), TechnologicaItems.EBONY_LEAVES_ITEM.get(), TechnologicaItems.KIWI_LEAVES_ITEM.get(), TechnologicaItems.LEMON_LEAVES_ITEM.get(), TechnologicaItems.LIME_LEAVES_ITEM.get(), TechnologicaItems.MAHOGANY_LEAVES_ITEM.get(), TechnologicaItems.MAPLE_LEAVES_ITEM.get(), TechnologicaItems.OLIVE_LEAVES_ITEM.get(), TechnologicaItems.ORANGE_LEAVES_ITEM.get(), TechnologicaItems.PEACH_LEAVES_ITEM.get(), TechnologicaItems.PEAR_LEAVES_ITEM.get(), TechnologicaItems.PLUM_LEAVES_ITEM.get(), TechnologicaItems.REDWOOD_LEAVES_ITEM.get(), TechnologicaItems.ROSEWOOD_LEAVES_ITEM.get(), TechnologicaItems.RUBBER_LEAVES_ITEM.get(), TechnologicaItems.TEAK_LEAVES_ITEM.get(), TechnologicaItems.WALNUT_LEAVES_ITEM.get(), TechnologicaItems.ZEBRAWOOD_LEAVES_ITEM.get(), TechnologicaItems.FRUITFUL_LEAVES_ITEM.get(), TechnologicaItems.BENEVOLENT_LEAVES_ITEM.get(), TechnologicaItems.MALEVOLENT_LEAVES_ITEM.get(), TechnologicaItems.CONDUCTIVE_LEAVES_ITEM.get(), TechnologicaItems.FROSTBITTEN_LEAVES_ITEM.get(), TechnologicaItems.CURSED_LEAVES_ITEM.get());
		tag(ItemTags.LOGS_THAT_BURN).addTag(TechnologicaItemTags.APRICOT_LOGS).addTag(TechnologicaItemTags.ASPEN_LOGS).addTag(TechnologicaItemTags.AVOCADO_LOGS).addTag(TechnologicaItemTags.BANANA_LOGS).addTag(TechnologicaItemTags.CHERRY_LOGS).addTag(TechnologicaItemTags.CHESTNUT_LOGS).addTag(TechnologicaItemTags.APRICOT_LOGS).addTag(TechnologicaItemTags.CINNAMON_LOGS).addTag(TechnologicaItemTags.COCONUT_LOGS).addTag(TechnologicaItemTags.EBONY_LOGS).addTag(TechnologicaItemTags.KIWI_LOGS).addTag(TechnologicaItemTags.LEMON_LOGS).addTag(TechnologicaItemTags.LIME_LOGS).addTag(TechnologicaItemTags.MAHOGANY_LOGS).addTag(TechnologicaItemTags.MAPLE_LOGS).addTag(TechnologicaItemTags.OLIVE_LOGS).addTag(TechnologicaItemTags.ORANGE_LOGS).addTag(TechnologicaItemTags.PEACH_LOGS).addTag(TechnologicaItemTags.PEAR_LOGS).addTag(TechnologicaItemTags.PLUM_LOGS).addTag(TechnologicaItemTags.REDWOOD_LOGS).addTag(TechnologicaItemTags.ROSEWOOD_LOGS).addTag(TechnologicaItemTags.RUBBER_LOGS).addTag(TechnologicaItemTags.TEAK_LOGS).addTag(TechnologicaItemTags.WALNUT_LOGS).addTag(TechnologicaItemTags.ZEBRAWOOD_LOGS).addTag(TechnologicaItemTags.FRUITFUL_LOGS).addTag(TechnologicaItemTags.ALCHEMICAL_LOGS).addTag(TechnologicaItemTags.BENEVOLENT_LOGS).addTag(TechnologicaItemTags.MALEVOLENT_LOGS).addTag(TechnologicaItemTags.CONDUCTIVE_LOGS).addTag(TechnologicaItemTags.FROSTBITTEN_LOGS).addTag(TechnologicaItemTags.INFERNAL_LOGS);
		tag(ItemTags.PLANKS).add(TechnologicaItems.APRICOT_PLANKS_ITEM.get(), TechnologicaItems.ASPEN_PLANKS_ITEM.get(), TechnologicaItems.AVOCADO_PLANKS_ITEM.get(), TechnologicaItems.BANANA_PLANKS_ITEM.get(), TechnologicaItems.CHESTNUT_PLANKS_ITEM.get(), TechnologicaItems.CHERRY_PLANKS_ITEM.get(), TechnologicaItems.CINNAMON_PLANKS_ITEM.get(), TechnologicaItems.COCONUT_PLANKS_ITEM.get(), TechnologicaItems.EBONY_PLANKS_ITEM.get(), TechnologicaItems.KIWI_PLANKS_ITEM.get(), TechnologicaItems.LEMON_PLANKS_ITEM.get(), TechnologicaItems.LIME_PLANKS_ITEM.get(), TechnologicaItems.MAHOGANY_PLANKS_ITEM.get(), TechnologicaItems.MAPLE_PLANKS_ITEM.get(), TechnologicaItems.OLIVE_PLANKS_ITEM.get(), TechnologicaItems.ORANGE_PLANKS_ITEM.get(), TechnologicaItems.PEACH_PLANKS_ITEM.get(), TechnologicaItems.PEAR_PLANKS_ITEM.get(), TechnologicaItems.PLUM_PLANKS_ITEM.get(), TechnologicaItems.REDWOOD_PLANKS_ITEM.get(), TechnologicaItems.ROSEWOOD_PLANKS_ITEM.get(), TechnologicaItems.RUBBER_PLANKS_ITEM.get(), TechnologicaItems.TEAK_PLANKS_ITEM.get(), TechnologicaItems.WALNUT_PLANKS_ITEM.get(), TechnologicaItems.ZEBRAWOOD_PLANKS_ITEM.get(), TechnologicaItems.ALCHEMICAL_PLANKS_ITEM.get(), TechnologicaItems.BENEVOLENT_PLANKS_ITEM.get(), TechnologicaItems.CONDUCTIVE_PLANKS_ITEM.get(), TechnologicaItems.FROSTBITTEN_PLANKS_ITEM.get(), TechnologicaItems.FRUITFUL_PLANKS_ITEM.get(), TechnologicaItems.INFERNAL_PLANKS_ITEM.get(), TechnologicaItems.MALEVOLENT_PLANKS_ITEM.get());
		tag(ItemTags.SAPLINGS).add(TechnologicaItems.APRICOT_SAPLING_ITEM.get(), TechnologicaItems.ASPEN_SAPLING_ITEM.get(), TechnologicaItems.AVOCADO_SAPLING_ITEM.get(), TechnologicaItems.BANANA_SAPLING_ITEM.get(), TechnologicaItems.CHERRY_SAPLING_ITEM.get(), TechnologicaItems.CHESTNUT_SAPLING_ITEM.get(), TechnologicaItems.CINNAMON_SAPLING_ITEM.get(), TechnologicaItems.COCONUT_SAPLING_ITEM.get(), TechnologicaItems.EBONY_SAPLING_ITEM.get(), TechnologicaItems.APRICOT_SAPLING_ITEM.get(), TechnologicaItems.KIWI_SAPLING_ITEM.get(), TechnologicaItems.LEMON_SAPLING_ITEM.get(), TechnologicaItems.LIME_SAPLING_ITEM.get(), TechnologicaItems.MAHOGANY_SAPLING_ITEM.get(), TechnologicaItems.MAPLE_SAPLING_ITEM.get(), TechnologicaItems.OLIVE_SAPLING_ITEM.get(), TechnologicaItems.ORANGE_SAPLING_ITEM.get(), TechnologicaItems.PEACH_SAPLING_ITEM.get(), TechnologicaItems.PEAR_SAPLING_ITEM.get(), TechnologicaItems.PLUM_SAPLING_ITEM.get(), TechnologicaItems.REDWOOD_SAPLING_ITEM.get(), TechnologicaItems.ROSEWOOD_SAPLING_ITEM.get(), TechnologicaItems.RUBBER_SAPLING_ITEM.get(), TechnologicaItems.TEAK_SAPLING_ITEM.get(), TechnologicaItems.WALNUT_SAPLING_ITEM.get(), TechnologicaItems.ZEBRAWOOD_SAPLING_ITEM.get(), TechnologicaItems.ANCIENT_AMBROSIA_SAPLING_ITEM.get(), TechnologicaItems.CRYOGENIC_SPIRE_SAPLING_ITEM.get(), TechnologicaItems.THUNDEROUS_CONDUCTOR_SAPLING_ITEM.get(), TechnologicaItems.TOWERING_INFERNO_SAPLING_ITEM.get(), TechnologicaItems.SERENDIPITOUS_APOTHECARY_SAPLING_ITEM.get(), TechnologicaItems.BENEVOLENT_APOTHECARY_SAPLING_ITEM.get(), TechnologicaItems.MALEVOLENT_APOTHECARY_SAPLING_ITEM.get(), TechnologicaItems.NECROTIC_SAPLING_ITEM.get());
		tag(ItemTags.SIGNS).add(TechnologicaItems.APRICOT_SIGN_ITEM.get(), TechnologicaItems.ASPEN_SIGN_ITEM.get(), TechnologicaItems.AVOCADO_SIGN_ITEM.get(), TechnologicaItems.BANANA_SIGN_ITEM.get(), TechnologicaItems.CHERRY_SIGN_ITEM.get(), TechnologicaItems.CHESTNUT_SIGN_ITEM.get(), TechnologicaItems.CINNAMON_SIGN_ITEM.get(), TechnologicaItems.COCONUT_SIGN_ITEM.get(), TechnologicaItems.EBONY_SIGN_ITEM.get(), TechnologicaItems.KIWI_SIGN_ITEM.get(), TechnologicaItems.LEMON_SIGN_ITEM.get(), TechnologicaItems.LIME_SIGN_ITEM.get(), TechnologicaItems.MAHOGANY_SIGN_ITEM.get(), TechnologicaItems.MAPLE_SIGN_ITEM.get(), TechnologicaItems.OLIVE_SIGN_ITEM.get(), TechnologicaItems.ORANGE_SIGN_ITEM.get(), TechnologicaItems.PEACH_SIGN_ITEM.get(), TechnologicaItems.PEAR_SIGN_ITEM.get(), TechnologicaItems.PLUM_SIGN_ITEM.get(), TechnologicaItems.REDWOOD_SIGN_ITEM.get(), TechnologicaItems.ROSEWOOD_SIGN_ITEM.get(), TechnologicaItems.RUBBER_SIGN_ITEM.get(), TechnologicaItems.TEAK_SIGN_ITEM.get(), TechnologicaItems.WALNUT_SIGN_ITEM.get(), TechnologicaItems.ZEBRAWOOD_SIGN_ITEM.get(), TechnologicaItems.ALCHEMICAL_SIGN_ITEM.get(), TechnologicaItems.BENEVOLENT_SIGN_ITEM.get(), TechnologicaItems.CONDUCTIVE_SIGN_ITEM.get(), TechnologicaItems.FROSTBITTEN_SIGN_ITEM.get(), TechnologicaItems.FRUITFUL_SIGN_ITEM.get(), TechnologicaItems.INFERNAL_SIGN_ITEM.get(), TechnologicaItems.MALEVOLENT_SIGN_ITEM.get());
		tag(ItemTags.WOODEN_BUTTONS).add(TechnologicaItems.APRICOT_BUTTON_ITEM.get(), TechnologicaItems.ASPEN_BUTTON_ITEM.get(), TechnologicaItems.AVOCADO_BUTTON_ITEM.get(), TechnologicaItems.BANANA_BUTTON_ITEM.get(), TechnologicaItems.CHERRY_BUTTON_ITEM.get(), TechnologicaItems.CHESTNUT_BUTTON_ITEM.get(), TechnologicaItems.CINNAMON_BUTTON_ITEM.get(), TechnologicaItems.COCONUT_BUTTON_ITEM.get(), TechnologicaItems.EBONY_BUTTON_ITEM.get(), TechnologicaItems.KIWI_BUTTON_ITEM.get(), TechnologicaItems.LEMON_BUTTON_ITEM.get(), TechnologicaItems.LIME_BUTTON_ITEM.get(), TechnologicaItems.MAHOGANY_BUTTON_ITEM.get(), TechnologicaItems.MAPLE_BUTTON_ITEM.get(), TechnologicaItems.OLIVE_BUTTON_ITEM.get(), TechnologicaItems.ORANGE_BUTTON_ITEM.get(), TechnologicaItems.PEACH_BUTTON_ITEM.get(), TechnologicaItems.PEAR_BUTTON_ITEM.get(), TechnologicaItems.PLUM_BUTTON_ITEM.get(), TechnologicaItems.REDWOOD_BUTTON_ITEM.get(), TechnologicaItems.ROSEWOOD_BUTTON_ITEM.get(), TechnologicaItems.RUBBER_BUTTON_ITEM.get(), TechnologicaItems.TEAK_BUTTON_ITEM.get(), TechnologicaItems.WALNUT_BUTTON_ITEM.get(), TechnologicaItems.ZEBRAWOOD_BUTTON_ITEM.get(), TechnologicaItems.ALCHEMICAL_BUTTON_ITEM.get(), TechnologicaItems.BENEVOLENT_BUTTON_ITEM.get(), TechnologicaItems.CONDUCTIVE_BUTTON_ITEM.get(), TechnologicaItems.FROSTBITTEN_BUTTON_ITEM.get(), TechnologicaItems.FRUITFUL_BUTTON_ITEM.get(), TechnologicaItems.INFERNAL_BUTTON_ITEM.get(), TechnologicaItems.MALEVOLENT_BUTTON_ITEM.get());
		tag(ItemTags.WOODEN_DOORS).add(TechnologicaItems.APRICOT_DOOR_ITEM.get(), TechnologicaItems.ASPEN_DOOR_ITEM.get(), TechnologicaItems.AVOCADO_DOOR_ITEM.get(), TechnologicaItems.BANANA_DOOR_ITEM.get(), TechnologicaItems.CHERRY_DOOR_ITEM.get(), TechnologicaItems.CHESTNUT_DOOR_ITEM.get(), TechnologicaItems.CINNAMON_DOOR_ITEM.get(), TechnologicaItems.COCONUT_DOOR_ITEM.get(), TechnologicaItems.EBONY_DOOR_ITEM.get(), TechnologicaItems.KIWI_DOOR_ITEM.get(), TechnologicaItems.LEMON_DOOR_ITEM.get(), TechnologicaItems.LIME_DOOR_ITEM.get(), TechnologicaItems.MAHOGANY_DOOR_ITEM.get(), TechnologicaItems.MAPLE_DOOR_ITEM.get(), TechnologicaItems.OLIVE_DOOR_ITEM.get(), TechnologicaItems.ORANGE_DOOR_ITEM.get(), TechnologicaItems.PEACH_DOOR_ITEM.get(), TechnologicaItems.PEAR_DOOR_ITEM.get(), TechnologicaItems.PLUM_DOOR_ITEM.get(), TechnologicaItems.REDWOOD_DOOR_ITEM.get(), TechnologicaItems.ROSEWOOD_DOOR_ITEM.get(), TechnologicaItems.RUBBER_DOOR_ITEM.get(), TechnologicaItems.TEAK_DOOR_ITEM.get(), TechnologicaItems.WALNUT_DOOR_ITEM.get(), TechnologicaItems.ZEBRAWOOD_DOOR_ITEM.get(), TechnologicaItems.ALCHEMICAL_DOOR_ITEM.get(), TechnologicaItems.BENEVOLENT_DOOR_ITEM.get(), TechnologicaItems.CONDUCTIVE_DOOR_ITEM.get(), TechnologicaItems.FROSTBITTEN_DOOR_ITEM.get(), TechnologicaItems.FRUITFUL_DOOR_ITEM.get(), TechnologicaItems.INFERNAL_DOOR_ITEM.get(), TechnologicaItems.MALEVOLENT_DOOR_ITEM.get());
		tag(ItemTags.WOODEN_FENCES).add(TechnologicaItems.APRICOT_FENCE_ITEM.get(), TechnologicaItems.ASPEN_FENCE_ITEM.get(), TechnologicaItems.AVOCADO_FENCE_ITEM.get(), TechnologicaItems.BANANA_FENCE_ITEM.get(), TechnologicaItems.CHERRY_FENCE_ITEM.get(), TechnologicaItems.CHESTNUT_FENCE_ITEM.get(), TechnologicaItems.CINNAMON_FENCE_ITEM.get(), TechnologicaItems.COCONUT_FENCE_ITEM.get(), TechnologicaItems.EBONY_FENCE_ITEM.get(), TechnologicaItems.KIWI_FENCE_ITEM.get(), TechnologicaItems.LEMON_FENCE_ITEM.get(), TechnologicaItems.LIME_FENCE_ITEM.get(), TechnologicaItems.MAHONGANY_FENCE_ITEM.get(), TechnologicaItems.MAPLE_FENCE_ITEM.get(), TechnologicaItems.OLIVE_FENCE_ITEM.get(), TechnologicaItems.ORANGE_FENCE_ITEM.get(), TechnologicaItems.PEACH_FENCE_ITEM.get(), TechnologicaItems.PEAR_FENCE_ITEM.get(), TechnologicaItems.PLUM_FENCE_ITEM.get(), TechnologicaItems.REDWOOD_FENCE_ITEM.get(), TechnologicaItems.ROSEWOOD_FENCE_ITEM.get(), TechnologicaItems.RUBBER_FENCE_ITEM.get(), TechnologicaItems.TEAK_FENCE_ITEM.get(), TechnologicaItems.WALNUT_FENCE_ITEM.get(), TechnologicaItems.ZEBRAWOOD_FENCE_ITEM.get(), TechnologicaItems.ALCHEMICAL_FENCE_ITEM.get(), TechnologicaItems.BENEVOLENT_FENCE_ITEM.get(), TechnologicaItems.CONDUCTIVE_FENCE_ITEM.get(), TechnologicaItems.FROSTBITTEN_FENCE_ITEM.get(), TechnologicaItems.FRUITFUL_FENCE_ITEM.get(), TechnologicaItems.INFERNAL_FENCE_ITEM.get(), TechnologicaItems.MALEVOLENT_FENCE_ITEM.get());
		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(TechnologicaItems.APRICOT_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.ASPEN_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.AVOCADO_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.BANANA_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.CHERRY_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.CHESTNUT_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.CINNAMON_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.COCONUT_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.EBONY_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.KIWI_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.LEMON_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.LIME_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.MAHOGANY_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.MAPLE_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.OLIVE_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.ORANGE_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.PEACH_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.PEAR_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.PLUM_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.REDWOOD_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.ROSEWOOD_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.RUBBER_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.TEAK_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.WALNUT_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.ZEBRAWOOD_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.ALCHEMICAL_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.BENEVOLENT_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.CONDUCTIVE_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.FROSTBITTEN_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.FRUITFUL_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.INFERNAL_PRESSURE_PLATE_ITEM.get(), TechnologicaItems.MALEVOLENT_PRESSURE_PLATE_ITEM.get());
		tag(ItemTags.WOODEN_SLABS).add(TechnologicaItems.APRICOT_SLAB_ITEM.get(), TechnologicaItems.ASPEN_SLAB_ITEM.get(), TechnologicaItems.AVOCADO_SLAB_ITEM.get(), TechnologicaItems.BANANA_SLAB_ITEM.get(), TechnologicaItems.CHERRY_SLAB_ITEM.get(), TechnologicaItems.CHESTNUT_SLAB_ITEM.get(), TechnologicaItems.CINNAMON_SLAB_ITEM.get(), TechnologicaItems.COCONUT_SLAB_ITEM.get(), TechnologicaItems.EBONY_SLAB_ITEM.get(), TechnologicaItems.KIWI_SLAB_ITEM.get(), TechnologicaItems.LEMON_SLAB_ITEM.get(), TechnologicaItems.LIME_SLAB_ITEM.get(), TechnologicaItems.MAHOGANY_SLAB_ITEM.get(), TechnologicaItems.MAPLE_SLAB_ITEM.get(), TechnologicaItems.OLIVE_SLAB_ITEM.get(), TechnologicaItems.ORANGE_SLAB_ITEM.get(), TechnologicaItems.PEACH_SLAB_ITEM.get(), TechnologicaItems.PEAR_SLAB_ITEM.get(), TechnologicaItems.PLUM_SLAB_ITEM.get(), TechnologicaItems.REDWOOD_SLAB_ITEM.get(), TechnologicaItems.ROSEWOOD_SLAB_ITEM.get(), TechnologicaItems.RUBBER_SLAB_ITEM.get(), TechnologicaItems.TEAK_SLAB_ITEM.get(), TechnologicaItems.WALNUT_SLAB_ITEM.get(), TechnologicaItems.ZEBRAWOOD_SLAB_ITEM.get(), TechnologicaItems.ALCHEMICAL_SLAB_ITEM.get(), TechnologicaItems.BENEVOLENT_SLAB_ITEM.get(), TechnologicaItems.CONDUCTIVE_SLAB_ITEM.get(), TechnologicaItems.FROSTBITTEN_SLAB_ITEM.get(), TechnologicaItems.FRUITFUL_SLAB_ITEM.get(), TechnologicaItems.INFERNAL_SLAB_ITEM.get(), TechnologicaItems.MALEVOLENT_SLAB_ITEM.get());
		tag(ItemTags.WOODEN_STAIRS).add(TechnologicaItems.APRICOT_STAIRS_ITEM.get(), TechnologicaItems.ASPEN_STAIRS_ITEM.get(), TechnologicaItems.AVOCADO_STAIRS_ITEM.get(), TechnologicaItems.BANANA_STAIRS_ITEM.get(), TechnologicaItems.CHERRY_STAIRS_ITEM.get(), TechnologicaItems.CHESTNUT_STAIRS_ITEM.get(), TechnologicaItems.CINNAMON_STAIRS_ITEM.get(), TechnologicaItems.COCONUT_STAIRS_ITEM.get(), TechnologicaItems.EBONY_STAIRS_ITEM.get(), TechnologicaItems.KIWI_STAIRS_ITEM.get(), TechnologicaItems.LEMON_STAIRS_ITEM.get(), TechnologicaItems.LIME_STAIRS_ITEM.get(), TechnologicaItems.MAHOGANY_STAIRS_ITEM.get(), TechnologicaItems.MAPLE_STAIRS_ITEM.get(), TechnologicaItems.OLIVE_STAIRS_ITEM.get(), TechnologicaItems.ORANGE_STAIRS_ITEM.get(), TechnologicaItems.PEACH_STAIRS_ITEM.get(), TechnologicaItems.PEAR_STAIRS_ITEM.get(), TechnologicaItems.PLUM_STAIRS_ITEM.get(), TechnologicaItems.REDWOOD_STAIRS_ITEM.get(), TechnologicaItems.ROSEWOOD_STAIRS_ITEM.get(), TechnologicaItems.RUBBER_STAIRS_ITEM.get(), TechnologicaItems.TEAK_STAIRS_ITEM.get(), TechnologicaItems.WALNUT_STAIRS_ITEM.get(), TechnologicaItems.ZEBRAWOOD_STAIRS_ITEM.get(), TechnologicaItems.ALCHEMICAL_STAIRS_ITEM.get(), TechnologicaItems.BENEVOLENT_STAIRS_ITEM.get(), TechnologicaItems.CONDUCTIVE_STAIRS_ITEM.get(), TechnologicaItems.FROSTBITTEN_STAIRS_ITEM.get(), TechnologicaItems.FRUITFUL_STAIRS_ITEM.get(), TechnologicaItems.INFERNAL_STAIRS_ITEM.get(), TechnologicaItems.MALEVOLENT_STAIRS_ITEM.get());
		tag(ItemTags.WOODEN_TRAPDOORS).add(TechnologicaItems.APRICOT_TRAPDOOR_ITEM.get(), TechnologicaItems.ASPEN_TRAPDOOR_ITEM.get(), TechnologicaItems.AVOCADO_TRAPDOOR_ITEM.get(), TechnologicaItems.BANANA_TRAPDOOR_ITEM.get(), TechnologicaItems.CHERRY_TRAPDOOR_ITEM.get(), TechnologicaItems.CHESTNUT_TRAPDOOR_ITEM.get(), TechnologicaItems.CINNAMON_TRAPDOOR_ITEM.get(), TechnologicaItems.COCONUT_TRAPDOOR_ITEM.get(), TechnologicaItems.EBONY_TRAPDOOR_ITEM.get(), TechnologicaItems.KIWI_TRAPDOOR_ITEM.get(), TechnologicaItems.LEMON_TRAPDOOR_ITEM.get(), TechnologicaItems.LIME_TRAPDOOR_ITEM.get(), TechnologicaItems.MAHOGANY_TRAPDOOR_ITEM.get(), TechnologicaItems.MAPLE_TRAPDOOR_ITEM.get(), TechnologicaItems.OLIVE_TRAPDOOR_ITEM.get(), TechnologicaItems.ORANGE_TRAPDOOR_ITEM.get(), TechnologicaItems.PEACH_TRAPDOOR_ITEM.get(), TechnologicaItems.PEAR_TRAPDOOR_ITEM.get(), TechnologicaItems.PLUM_TRAPDOOR_ITEM.get(), TechnologicaItems.REDWOOD_TRAPDOOR_ITEM.get(), TechnologicaItems.ROSEWOOD_TRAPDOOR_ITEM.get(), TechnologicaItems.RUBBER_TRAPDOOR_ITEM.get(), TechnologicaItems.TEAK_TRAPDOOR_ITEM.get(), TechnologicaItems.WALNUT_TRAPDOOR_ITEM.get(), TechnologicaItems.ZEBRAWOOD_TRAPDOOR_ITEM.get(), TechnologicaItems.ALCHEMICAL_TRAPDOOR_ITEM.get(), TechnologicaItems.BENEVOLENT_TRAPDOOR_ITEM.get(), TechnologicaItems.CONDUCTIVE_TRAPDOOR_ITEM.get(), TechnologicaItems.FROSTBITTEN_TRAPDOOR_ITEM.get(), TechnologicaItems.FRUITFUL_TRAPDOOR_ITEM.get(), TechnologicaItems.INFERNAL_TRAPDOOR_ITEM.get(), TechnologicaItems.MALEVOLENT_TRAPDOOR_ITEM.get());

		copy(TechnologicaBlockTags.APRICOT_LOGS, TechnologicaItemTags.APRICOT_LOGS);
		copy(TechnologicaBlockTags.ASPEN_LOGS, TechnologicaItemTags.ASPEN_LOGS);
		copy(TechnologicaBlockTags.AVOCADO_LOGS, TechnologicaItemTags.AVOCADO_LOGS);
		copy(TechnologicaBlockTags.BANANA_LOGS, TechnologicaItemTags.BANANA_LOGS);
		copy(TechnologicaBlockTags.CHERRY_LOGS, TechnologicaItemTags.CHERRY_LOGS);
		copy(TechnologicaBlockTags.CHESTNUT_LOGS, TechnologicaItemTags.CHESTNUT_LOGS);
		copy(TechnologicaBlockTags.CINNAMON_LOGS, TechnologicaItemTags.CINNAMON_LOGS);
		copy(TechnologicaBlockTags.COCONUT_LOGS, TechnologicaItemTags.COCONUT_LOGS);
		copy(TechnologicaBlockTags.EBONY_LOGS, TechnologicaItemTags.EBONY_LOGS);
		copy(TechnologicaBlockTags.KIWI_LOGS, TechnologicaItemTags.KIWI_LOGS);
		copy(TechnologicaBlockTags.LEMON_LOGS, TechnologicaItemTags.LEMON_LOGS);
		copy(TechnologicaBlockTags.LIME_LOGS, TechnologicaItemTags.LIME_LOGS);
		copy(TechnologicaBlockTags.MAHOGANY_LOGS, TechnologicaItemTags.MAHOGANY_LOGS);
		copy(TechnologicaBlockTags.MAPLE_LOGS, TechnologicaItemTags.MAPLE_LOGS);
		copy(TechnologicaBlockTags.OLIVE_LOGS, TechnologicaItemTags.OLIVE_LOGS);
		copy(TechnologicaBlockTags.ORANGE_LOGS, TechnologicaItemTags.ORANGE_LOGS);
		copy(TechnologicaBlockTags.PEACH_LOGS, TechnologicaItemTags.PEACH_LOGS);
		copy(TechnologicaBlockTags.PEAR_LOGS, TechnologicaItemTags.PEAR_LOGS);
		copy(TechnologicaBlockTags.PLUM_LOGS, TechnologicaItemTags.PLUM_LOGS);
		copy(TechnologicaBlockTags.REDWOOD_LOGS, TechnologicaItemTags.REDWOOD_LOGS);
		copy(TechnologicaBlockTags.ROSEWOOD_LOGS, TechnologicaItemTags.ROSEWOOD_LOGS);
		copy(TechnologicaBlockTags.RUBBER_LOGS, TechnologicaItemTags.RUBBER_LOGS);
		copy(TechnologicaBlockTags.TEAK_LOGS, TechnologicaItemTags.TEAK_LOGS);
		copy(TechnologicaBlockTags.WALNUT_LOGS, TechnologicaItemTags.WALNUT_LOGS);
		copy(TechnologicaBlockTags.ZEBRAWOOD_LOGS, TechnologicaItemTags.ZEBRAWOOD_LOGS);
		copy(TechnologicaBlockTags.ALCHEMICAL_LOGS, TechnologicaItemTags.ALCHEMICAL_LOGS);
		copy(TechnologicaBlockTags.BENEVOLENT_LOGS, TechnologicaItemTags.BENEVOLENT_LOGS);
		copy(TechnologicaBlockTags.CONDUCTIVE_LOGS, TechnologicaItemTags.CONDUCTIVE_LOGS);
		copy(TechnologicaBlockTags.FROSTBITTEN_LOGS, TechnologicaItemTags.FROSTBITTEN_LOGS);
		copy(TechnologicaBlockTags.FRUITFUL_LOGS, TechnologicaItemTags.FRUITFUL_LOGS);
		copy(TechnologicaBlockTags.INFERNAL_LOGS, TechnologicaItemTags.INFERNAL_LOGS);
		copy(TechnologicaBlockTags.MALEVOLENT_LOGS, TechnologicaItemTags.MALEVOLENT_LOGS);
	}

	@Override
	public String getName() {
		return "Technologica Item Tags";
	}
}