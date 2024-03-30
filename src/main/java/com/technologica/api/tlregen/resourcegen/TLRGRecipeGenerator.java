package com.technologica.api.tlregen.resourcegen;

import com.technologica.Technologica;

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
