package com.technologica.api.tlregen.resourcegen.data;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.MasterResourceGenerator;

import net.minecraft.data.recipes.RecipeProvider;

public abstract class TLRGRecipeGenerator extends RecipeProvider {
	public TLRGRecipeGenerator() {
		super(MasterResourceGenerator.packOutput);
	}

	@Override
	public final String getName() {
		return "data." + Technologica.MOD_ID + ".recipes";
	}
}
