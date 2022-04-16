package com.technologica.data.advancements;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;

import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaAdvancementProvider extends AdvancementProvider {
	private final List<Consumer<Consumer<Advancement>>> tabs = ImmutableList.of(new TechnologicaHusbandryAdvancements(fileHelper));

	public TechnologicaAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
		super(generatorIn, fileHelperIn);
	}

	@Override
	protected void registerAdvancements(Consumer<Advancement> consumer, net.minecraftforge.common.data.ExistingFileHelper fileHelper) {
		for (Consumer<Consumer<Advancement>> consumer1 : this.tabs) {
			consumer1.accept(consumer);
		}
	}
}
