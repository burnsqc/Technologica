package com.technologica.resourcegen.assets;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundsDataGenerator extends SoundDefinitionsProvider {

	public SoundsDataGenerator(PackOutput output, ExistingFileHelper helper) {
		super(output, Technologica.MOD_ID, helper);
	}

	@Override
	public void registerSounds() {
		add(TechnologicaSoundEvents.DODGEBALL.get(), definition().with(sound(new TechnologicaLocation("dodgeball")).attenuationDistance(32)));
	}
	
	@Override
    public String getName() {
        return "Sounds: " + Technologica.MOD_ID;
    }
}