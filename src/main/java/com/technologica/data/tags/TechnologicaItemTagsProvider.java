package com.technologica.data.tags;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBlockTags;
import com.technologica.tags.TechnologicaItemTags;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaItemTagsProvider extends ItemTagsProvider {

	public TechnologicaItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper helperIn) {
		super(generatorIn, blockTagProvider, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void addTags() {
		tag(ItemTags.BOATS).add(TechnologicaItems.APRICOT_BOAT.get()); //Add all boats to this tag
		tag(ItemTags.LEAVES).add(TechnologicaItems.ALCHEMICAL_LEAVES_ITEM.get()); //Add all leaves to this tag
		tag(ItemTags.LOGS_THAT_BURN).addTag(TechnologicaItemTags.APRICOT_LOGS); //Add all new Technologica log Item tags to this tag
		tag(ItemTags.PLANKS).add(TechnologicaItems.APRICOT_PLANKS_ITEM.get()); //Add all planks to this tag
		tag(ItemTags.SAPLINGS).add(TechnologicaItems.APRICOT_SAPLING_ITEM.get()); //Add all non-potted saplings to this tag		
		tag(ItemTags.SIGNS).add(TechnologicaItems.APRICOT_SIGN_ITEM.get()); //Add all wall signs to this tag
		tag(ItemTags.WOODEN_BUTTONS).add(TechnologicaItems.APRICOT_BUTTON_ITEM.get()); //Add all buttons to this tag
		tag(ItemTags.WOODEN_DOORS).add(TechnologicaItems.APRICOT_DOOR_ITEM.get()); //Add all doors to this tag
		tag(ItemTags.WOODEN_FENCES).add(TechnologicaItems.APRICOT_FENCE_ITEM.get()); //Add all fences to this tag
		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(TechnologicaItems.APRICOT_PRESSURE_PLATE_ITEM.get()); //Add all pressure plates to this tag
		tag(ItemTags.WOODEN_SLABS).add(TechnologicaItems.APRICOT_SLAB_ITEM.get()); //Add all slabs to this tag
		tag(ItemTags.WOODEN_STAIRS).add(TechnologicaItems.APRICOT_STAIRS_ITEM.get()); //Add all stairs to this tag
		tag(ItemTags.WOODEN_TRAPDOORS).add(TechnologicaItems.APRICOT_TRAPDOOR_ITEM.get()); //Add all trapdoors to this tag
		
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
}