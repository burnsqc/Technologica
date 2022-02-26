package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.util.text.ResourceLocationHelper;
import com.technologica.world.item.ModSpawnEggItem;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void registerModels() {
		automaticItemModel(TechnologicaItems.ITEMS.getEntries());
	}
	
	private final void automaticItemModel(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> itemSupplier:collection) {
			Item item = itemSupplier.get();
				
			if (item instanceof ModSpawnEggItem) simpleSpawnEggItem(item);
			else if (item instanceof ItemNameBlockItem) simpleItem(item);
			else if (item instanceof BlockItem && ResourceLocationHelper.getPath(item).contains("_sapling")) simpleBlockItem(item);
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
	
	public void simpleSpawnEggItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
	}
	
	public void simpleBlockItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), BLOCK_FOLDER + "/" + location.getPath()));
	}
}