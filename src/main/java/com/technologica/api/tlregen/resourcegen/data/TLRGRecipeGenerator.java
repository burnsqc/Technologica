package com.technologica.api.tlregen.resourcegen.data;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLReGenMasterResourceGenerator;

import net.minecraft.data.recipes.RecipeProvider;

public abstract class TLRGRecipeGenerator extends RecipeProvider {
	public TLRGRecipeGenerator() {
		super(TLReGenMasterResourceGenerator.packOutput);
	}

	@Override
	public final String getName() {
		return "data." + Technologica.MOD_ID + ".recipes";
	}
}
