package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.damagetype.DamageTypeProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

/**
 * <p>
 * This class contains Resource Keys for Damage Types.
 * The corresponding Damage Types are created in json format during Data Generation in {@link DamageTypeProvider}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaDamageTypes extends MasterKeyCreator {
	public static final ResourceKey<DamageType> BLEED = damageType("bleed");
	public static final ResourceKey<DamageType> NITRO_BLAST = damageType("nitro_blast");
}