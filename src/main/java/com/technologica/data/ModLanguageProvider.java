package com.technologica.data;

import com.technologica.MainMod;
import com.technologica.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
	public ModLanguageProvider(DataGenerator gen, String locale) {
		super(gen, MainMod.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		this.addBlock(Registration.DISPLAY_CASE, "Display Case");	
	}
}