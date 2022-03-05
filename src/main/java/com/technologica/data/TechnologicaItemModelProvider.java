package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaItemModelProvider extends ItemModelProvider {

	public TechnologicaItemModelProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void registerModels() {
		simpleItem(TechnologicaItems.ASPARAGUS_SEEDS.get()); 
		simpleItem(TechnologicaItems.BARLEY_SEEDS.get()); 
		simpleItem(TechnologicaItems.BLACKBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.BLUEBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.BROCCOLI_SEEDS.get());
		simpleItem(TechnologicaItems.CELERY_SEEDS.get());
		simpleItem(TechnologicaItems.CHILI_PEPPER_SEEDS.get());
		simpleItem(TechnologicaItems.COFFEE_BEANS.get());
		simpleItem(TechnologicaItems.CORN_SEEDS.get());
		simpleItem(TechnologicaItems.COTTON_SEEDS.get());
		simpleItem(TechnologicaItems.CRANBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.CUCUMBER_SEEDS.get());
		simpleItem(TechnologicaItems.GARLIC_SEEDS.get());
		simpleItem(TechnologicaItems.GINGER_SEEDS.get());
		simpleItem(TechnologicaItems.GRAPE_SEEDS.get());
		simpleItem(TechnologicaItems.LETTUCE_SEEDS.get());
		simpleItem(TechnologicaItems.MUSTARD_SEEDS.get());
		simpleItem(TechnologicaItems.OATS_SEEDS.get());
		simpleItem(TechnologicaItems.ONION_SEEDS.get());
		simpleItem(TechnologicaItems.PEA_SEEDS.get());
		simpleItem(TechnologicaItems.PEANUT_SEEDS.get());
		simpleItem(TechnologicaItems.PEPPERCORN_SEEDS.get());
		simpleItem(TechnologicaItems.PINEAPPLE_SEEDS.get());
		simpleItem(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get());
		simpleItem(TechnologicaItems.RADISH_SEEDS.get());
		simpleItem(TechnologicaItems.RASPBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.RED_BEANS.get());
		simpleItem(TechnologicaItems.RICE_SEEDS.get());
		simpleItem(TechnologicaItems.RYE_SEEDS.get());
		simpleItem(TechnologicaItems.SOYBEANS.get());
		simpleItem(TechnologicaItems.STRAWBERRY_SEEDS.get());
		simpleItem(TechnologicaItems.SQUASH_SEEDS.get());
		simpleItem(TechnologicaItems.SWEET_POTATO_SEEDS.get());
		simpleItem(TechnologicaItems.TEA_SEEDS.get());
		simpleItem(TechnologicaItems.TOMATO_SEEDS.get());
		simpleItem(TechnologicaItems.TURNIP_SEEDS.get());
		simpleItem(TechnologicaItems.ZUCCHINI_SEEDS.get());

		simpleBlockItem(TechnologicaItems.APRICOT_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.ASPEN_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.AVOCADO_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.BANANA_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.CHERRY_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.CHESTNUT_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.CINNAMON_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.COCONUT_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.EBONY_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.KIWI_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.LEMON_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.LIME_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.MAHOGANY_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.MAPLE_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.OLIVE_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.ORANGE_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.PEACH_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.PEAR_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.PLUM_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.REDWOOD_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.ROSEWOOD_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.RUBBER_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.TEAK_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.WALNUT_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.ZEBRAWOOD_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.ANCIENT_AMBROSIA_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.CRYOGENIC_SPIRE_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.THUNDEROUS_CONDUCTOR_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.TOWERING_INFERNO_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.SERENDIPITOUS_APOTHECARY_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.BENEVOLENT_APOTHECARY_SAPLING_ITEM.get()); 
		simpleBlockItem(TechnologicaItems.MALEVOLENT_APOTHECARY_SAPLING_ITEM.get());
		simpleBlockItem(TechnologicaItems.NECROTIC_SAPLING_ITEM.get());
		
		simpleSpawnEggItem(TechnologicaItems.ALLIGATOR_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.BEAVER_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.BUFFALO_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.CAMEL_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.COBRA_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.COTTONMOUTH_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.COYOTE_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.CRAB_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.DEER_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.DUCK_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.ELEPHANT_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.FLAMINGO_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.FROG_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.GIRAFFE_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.GORILLA_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.GRIZZLY_BEAR_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.JAGUAR_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.KING_CRAB_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.LEOPARD_SEAL_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.LION_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.LIZARD_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.MOOSE_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.NARWHAL_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.OCTOPUS_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.OSTRICH_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.OWL_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.PENGUIN_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.PIRANHA_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.POISON_DART_FROG_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.RACCOON_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.SCORPION_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.SHARK_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.SLOTH_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.STINGRAY_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.TURKEY_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.VULTURE_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.WALRUS_SPAWN_EGG.get()); 
		simpleSpawnEggItem(TechnologicaItems.ZEBRA_SPAWN_EGG.get()); 
		
		simpleSpawnEggItem(TechnologicaItems.PEEPER_SPAWN_EGG.get());
		simpleSpawnEggItem(TechnologicaItems.SWEEPER_SPAWN_EGG.get());
		
		automaticItemModel(TechnologicaItems.ITEMS.getEntries());
	}
	
	private final void automaticItemModel(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> itemSupplier:collection) {
			Item item = itemSupplier.get();
				
			if (item instanceof ForgeSpawnEggItem) simpleSpawnEggItem(item); //Once you've added all spawn eggs, you can delete this line
			else if (item instanceof ItemNameBlockItem) simpleItem(item);
			else if (item instanceof BlockItem && ResourceLocationHelper.getPath(item).contains("_sapling")) simpleBlockItem(item); //Once you've added all saplings, you can delete this line
			else if (!(item instanceof BlockItem)) { 
				if (!item.getRegistryName().getPath().contains("bazooka") && !item.getRegistryName().getPath().contains("spear_gun") && !item.getRegistryName().getPath().contains("_spawn_egg")) {
					simpleItem(item);
				}
			}
		}
	}
	
	public void simpleItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
	
	public void simpleSpawnEggItem(Item item) { //Once you've added all spawn eggs, you can delete this method
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
	}
	
	public void simpleBlockItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), BLOCK_FOLDER + "/" + location.getPath()));
	}
}