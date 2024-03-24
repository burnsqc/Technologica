package com.technologica.resourcegen.assets;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.resourcegen.util.TLRGMasterResourceGenerator;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class TLRGSoundsGenerator extends SoundDefinitionsProvider {

	public TLRGSoundsGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".blockstates";
	}

	@Override
	public void registerSounds() {
		add(TechnologicaSoundEvents.DODGEBALL.get(), definition().with(sound(new TechnologicaLocation("dodgeball")).attenuationDistance(32)));
	}
}
