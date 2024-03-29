package com.technologica.world.food;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TechnologicaFoods {
	public static final FoodProperties APRICOT = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties ASPARAGUS = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties AVOCADO = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BANANA = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BROCCOLI = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BLACKBERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BLUEBERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CELERY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CHERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CHESTNUT = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CHILI_PEPPER = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	
	public static final FoodProperties COCONUT = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CORN = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CRANBERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CUCUMBER = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties GARLIC = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties GINGER = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties GRAPE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties KIWI = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties LEMON = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties LETTUCE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties LIME = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties MUSTARD_GREENS = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties OLIVE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties ONION = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties ORANGE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEAS = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEACH = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEANUT = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEAR = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	
	public static final FoodProperties PINEAPPLE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PLUM = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PURPLE_CABBAGE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties RADISH = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties RASPBERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	
	public static final FoodProperties SQUASH = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties SWEET_POTATO = (new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).build());
	public static final FoodProperties STRAWBERRY = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	
	public static final FoodProperties TOMATO = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties TURNIP = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties WALNUT = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties ZUCCHINI = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());

	public static final FoodProperties RAW_ALLIGATOR = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties RAW_BEAR = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_BISON = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_CRAB_LEGS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_DUCK = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties RAW_OCTOPUS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_OSTRICH = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties RAW_PIRANHA = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
	public static final FoodProperties RAW_SHARK = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
	public static final FoodProperties RAW_TURKEY = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
	public static final FoodProperties RAW_VENISON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
	public static final FoodProperties BLUBBER = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();

	public static final FoodProperties BANANAS_FOSTER = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BLACK_FOREST_CAKE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties BLUEBERRY_CHEESECAKE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties COCONUT_CREAM_PIE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties GRAPE_SHAVED_ICE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties KEY_LIME_MOUSSE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties KIWI_SORBET = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties LEMON_BAR = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties ORANGE_DREAMSICLE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEACH_COBBLER = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties PEAR_TART = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties STRAWBERRY_SHORTCAKE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties TAPENADE = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties CINNAMON_ROLL = (new FoodProperties.Builder().nutrition(4).saturationMod(0.1F).alwaysEat().build());
	public static final FoodProperties OLIVE_OIL = (new FoodProperties.Builder().build());

	public static final FoodProperties IODINE_PILL = (new FoodProperties.Builder().alwaysEat().fast().build());

	public static final FoodProperties BATRACHOTOXIN_SAC = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(TechnologicaMobEffects.HALLUCINIATION.get(), 1200, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties HEMOTOXIN_SAC = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(TechnologicaMobEffects.HEMORRHAGE.get(), 1200, 9), 1.0F).alwaysEat().build();
	public static final FoodProperties NECROTOXIN_SAC = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(TechnologicaMobEffects.NECROSIS.get(), 1200, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties NEUROTOXIN_SAC = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(TechnologicaMobEffects.NEUROPATHY.get(), 1200, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties TETRODOTOXIN_SAC = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).effect(() -> new MobEffectInstance(TechnologicaMobEffects.PARALYSIS.get(), 1200, 0), 1.0F).alwaysEat().build();
}
