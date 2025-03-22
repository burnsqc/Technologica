package com.technologica.resourcegen.data.advancements;

import java.util.List;

import com.technologica.resourcegen.data.advancements.bronzeage.BronzeAgeAdvancementDataGenerator;
import com.technologica.resourcegen.data.advancements.stoneage.StoneAgeAdvancementDataGenerator;
import com.tlregen.api.resourcegen.MasterResourceGenerator;

import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class TLRGAdvancementGenerator extends ForgeAdvancementProvider {
	private final static List<AdvancementGenerator> SUB_GENERATORS = List.of(new StoneAgeAdvancementDataGenerator(), new BronzeAgeAdvancementDataGenerator());

	public TLRGAdvancementGenerator() {
		super(MasterResourceGenerator.packOutput, MasterResourceGenerator.lookupProvider, MasterResourceGenerator.helper, SUB_GENERATORS);
	}
}
