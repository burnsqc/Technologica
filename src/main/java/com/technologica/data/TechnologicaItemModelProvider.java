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
		simpleItem(TechnologicaItems.ASPARAGUS_SEEDS.get()); //Start here
		simpleItem(TechnologicaItems.BARLEY_SEEDS.get()); //Continue for each seed
		
		simpleBlockItem(TechnologicaItems.APRICOT_SAPLING_ITEM.get()); //Start here
		simpleBlockItem(TechnologicaItems.ASPEN_SAPLING_ITEM.get()); //Continue for each sapling
		
		simpleSpawnEggItem(TechnologicaItems.ALLIGATOR_SPAWN_EGG.get()); //Start here
		simpleSpawnEggItem(TechnologicaItems.BEAVER_SPAWN_EGG.get()); //Continue for each spawn egg
		//And so on and so forth until all items are accounted for.  Check the generated data item models to see if you caught them all.
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