package com.technologica.client.model.geom;

import java.util.Set;

import com.google.common.collect.Sets;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.vehicle.TechnologicaBoat;

import net.minecraft.client.model.geom.ModelLayerLocation;

public class TechnologicaModelLayers {
	private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
	public static final ModelLayerLocation ALLIGATOR = register("alligator");
	public static final ModelLayerLocation BEAVER = register("beaver");
	public static final ModelLayerLocation BUFFALO = register("buffalo");
	public static final ModelLayerLocation CAMEL = register("camel");
	public static final ModelLayerLocation COBRA = register("cobra");
	public static final ModelLayerLocation COTTONMOUTH = register("cottonmouth");
	public static final ModelLayerLocation COYOTE = register("coyote");
	public static final ModelLayerLocation CRAB = register("crab");
	public static final ModelLayerLocation DEER = register("deer");
	public static final ModelLayerLocation DUCK = register("duck");
	public static final ModelLayerLocation ELEPHANT = register("elephant");
	public static final ModelLayerLocation FIGURE_EIGHT_PUFFERFISH_BIG = register("figure_eight_pufferfish_big");
	public static final ModelLayerLocation FIGURE_EIGHT_PUFFERFISH_MEDIUM = register("figure_eight_pufferfish_medium");
	public static final ModelLayerLocation FIGURE_EIGHT_PUFFERFISH_SMALL = register("figure_eight_pufferfish_small");
	public static final ModelLayerLocation FLAMINGO = register("flamingo");
	public static final ModelLayerLocation GIRAFFE = register("giraffe");
	public static final ModelLayerLocation GORILLA = register("gorilla");
	public static final ModelLayerLocation GRIZZLY_BEAR = register("grizzly_bear");
	public static final ModelLayerLocation JAGUAR = register("jaguar");
	public static final ModelLayerLocation KING_CRAB = register("king_crab");
	public static final ModelLayerLocation LEOPARD_SEAL = register("leopard_seal");
	public static final ModelLayerLocation LION = register("lion");
	public static final ModelLayerLocation LIZARD = register("lizard");
	public static final ModelLayerLocation MOOSE = register("moose");
	public static final ModelLayerLocation NARWHAL = register("narwhal");
	public static final ModelLayerLocation OCTOPUS = register("octopus");
	public static final ModelLayerLocation OSTRICH = register("ostrich");
	public static final ModelLayerLocation OWL = register("owl");
	public static final ModelLayerLocation PENGUIN = register("penguin");
	public static final ModelLayerLocation PIRANHA = register("piranha");
	public static final ModelLayerLocation POISON_DART_FROG = register("poison_dart_frog");
	public static final ModelLayerLocation RACCOON = register("raccoon");
	public static final ModelLayerLocation SCORPION = register("scorpion");
	public static final ModelLayerLocation SHARK = register("shark");
	public static final ModelLayerLocation SLOTH = register("sloth");
	public static final ModelLayerLocation STINGRAY = register("stringray");
	public static final ModelLayerLocation TURKEY = register("turkey");
	public static final ModelLayerLocation VULTURE = register("vulture");
	public static final ModelLayerLocation WALRUS = register("walrus");
	public static final ModelLayerLocation ZEBRA = register("zebra");

	public static final ModelLayerLocation ATOMIC_CREEPER = register("atomic_creeper");
	public static final ModelLayerLocation MUMMY = register("mummy");
	public static final ModelLayerLocation PEEPER = register("peeper");
	public static final ModelLayerLocation BEEPER = register("beeper");
	public static final ModelLayerLocation SLEEPER = register("sleeper");
	public static final ModelLayerLocation WEEPER = register("weeper");
	public static final ModelLayerLocation SWEEPER = register("sweeper");
	public static final ModelLayerLocation DUST_DEVIL = register("dust_devil");

	public static final ModelLayerLocation NAVAL_MINE = register("naval_mine");
	public static final ModelLayerLocation WINDMILL = register("windmill");
	public static final ModelLayerLocation ROCKET = register("rocket");

	public static final ModelLayerLocation COCONUT_BAZOOKA = register("coconut_bazooka");
	public static final ModelLayerLocation SPEAR_GUN = register("spear_gun");

	public static final ModelLayerLocation MINING_HELMET = register("mining_helmet");
	public static final ModelLayerLocation DIVING_HELMET = register("diving_helmet");

	public static ModelLayerLocation createBoatModelName(TechnologicaBoat.Type type) {
		return createLocation("boat/" + type.getName(), "main");
	}

	public static ModelLayerLocation createChestBoatModelName(TechnologicaBoat.Type type) {
		return createLocation("chest_boat/" + type.getName(), "main");
	}

	private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
		return new ModelLayerLocation(new TechnologicaLocation(p_171301_), p_171302_);
	}

	private static ModelLayerLocation register(String p_171294_) {
		return register(p_171294_, "main");
	}

	private static ModelLayerLocation register(String p_171296_, String p_171297_) {
		ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
		if (!ALL_MODELS.add(modellayerlocation)) {
			throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
		} else {
			return modellayerlocation;
		}
	}
}