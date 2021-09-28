package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.item.TechnologicaItems;
import com.technologica.util.text.StringHelper;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

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
				
			if (item instanceof BlockNamedItem) simpleItem(item);
			else if (item instanceof BlockItem && StringHelper.getPath(item).contains("_sapling")) simpleBlockItem(item);
			else if (!(item instanceof BlockItem)) simpleItem(item);
		}
	}
	
	public void simpleItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), ITEM_FOLDER + "/" + location.getPath()));
	}
	
	public void simpleBlockItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		this.getBuilder(location.getPath()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", new ResourceLocation(location.getNamespace(), "block/" + location.getPath()));
	}
}