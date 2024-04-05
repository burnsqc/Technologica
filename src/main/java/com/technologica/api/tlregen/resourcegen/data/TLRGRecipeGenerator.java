package com.technologica.api.tlregen.resourcegen.data;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.data.recipes.RecipeProvider;

public abstract class TLRGRecipeGenerator extends RecipeProvider {
	public TLRGRecipeGenerator() {
		super(TLRGMasterResourceGenerator.packOutput);
	}

	@Override
	public final String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".recipes";
	}
}
