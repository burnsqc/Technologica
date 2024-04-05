package com.technologica.api.tlregen.resourcegen.data;

import java.util.List;
import java.util.function.Supplier;

public class TLRGTagsGenerator {
	protected static Supplier<TLRGTagsBlocksGenerator> TagBlocksGenerator;
	protected static Supplier<TLRGTagsEntityTypesGenerator> TagEntityTypeGenerator;
	protected static Supplier<TLRGTagsItemsGenerator> TagItemsGenerator;

	public TLRGTagsGenerator(Supplier<TLRGTagsBlocksGenerator> TLRGTagBlocksGenerator, Supplier<TLRGTagsEntityTypesGenerator> TLRGTagEntityTypeGenerator, Supplier<TLRGTagsItemsGenerator> TLRGTagItemsGenerator) {
		TagBlocksGenerator = TLRGTagBlocksGenerator;
		TagEntityTypeGenerator = TLRGTagEntityTypeGenerator;
		TagItemsGenerator = TLRGTagItemsGenerator;
	}

	public List<Supplier<?>> getSubProviders() {
		return List.of(TagBlocksGenerator, TagEntityTypeGenerator, TagItemsGenerator);
	}
}
