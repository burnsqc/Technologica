package com.technologica.resourcegen.data.advancements;

import java.util.List;

import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.resourcegen.data.advancements.dominion.DominionAdvancementDataGenerator;
import com.technologica.resourcegen.data.advancements.husbandry.HusbandryAdvancementDataGenerator;
import com.technologica.resourcegen.data.advancements.technology.TechnologyAdvancementDataProvider;
import com.technologica.resourcegen.data.advancements.tribulation.TribulationAdvancementDataGenerator;

import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class TLRGAdvancementGenerator extends ForgeAdvancementProvider {
	private final static List<AdvancementGenerator> SUB_GENERATORS = List.of(new DominionAdvancementDataGenerator(), new HusbandryAdvancementDataGenerator(), new TechnologyAdvancementDataProvider(), new TribulationAdvancementDataGenerator());

	public TLRGAdvancementGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.helper, SUB_GENERATORS);
	}
}
