package com.technologica.resourcegen.util;

import java.util.List;

import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.TagsProvider;

public class TagIntermediateDataGenerator extends IntermediateDataGenerator {
	private List<DataProvider> subProviders; 

	@SafeVarargs
	public TagIntermediateDataGenerator(TagsProvider<?>... tagProvider) {
		subProviders = List.of(tagProvider);
	}
	
	public List<DataProvider> getSubProviders() {
		return subProviders;
	}
}