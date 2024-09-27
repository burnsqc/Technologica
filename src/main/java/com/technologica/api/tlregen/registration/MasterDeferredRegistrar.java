package com.technologica.api.tlregen.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaAttributes;
import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaFeatures;
import com.technologica.registration.deferred.TechnologicaFluidTypes;
import com.technologica.registration.deferred.TechnologicaFluids;
import com.technologica.registration.deferred.TechnologicaFoliagePlacerTypes;
import com.technologica.registration.deferred.TechnologicaGlobalLootModifierSerializers;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.deferred.TechnologicaPaintingVariants;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.registration.deferred.TechnologicaPlacementModifierTypes;
import com.technologica.registration.deferred.TechnologicaPoisonDartFrogVariant;
import com.technologica.registration.deferred.TechnologicaRecipeSerializers;
import com.technologica.registration.deferred.TechnologicaRecipeTypes;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.registration.deferred.TechnologicaStructurePieceTypes;
import com.technologica.registration.deferred.TechnologicaStructureTypes;
import com.technologica.registration.deferred.TechnologicaTrunkPlacerTypes;
import com.technologica.util.text.TextUtil;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class MasterDeferredRegistrar {
	private static Map<ResourceKey<? extends Registry<?>>, RegistrationTracker<?>> registries = new HashMap<>();

	public static final DeferredRegister<Attribute> ATTRIBUTES = addRegister(ForgeRegistries.Keys.ATTRIBUTES, () -> TechnologicaAttributes.DIVER);
	public static final DeferredRegister<Block> BLOCKS = addRegister(ForgeRegistries.Keys.BLOCKS, () -> TechnologicaBlocks.ACACIA_BOOKSHELF);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = addRegister(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, () -> TechnologicaBlockEntityTypes.ANNUNCIATOR_TILE);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = addRegister(Registries.CREATIVE_MODE_TAB, () -> TechnologicaCreativeModeTabs.ARMORY);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = addRegister(ForgeRegistries.Keys.ENTITY_TYPES, () -> TechnologicaEntityTypes.ALLIGATOR);
	public static final DeferredRegister<Feature<?>> FEATURES = addRegister(ForgeRegistries.Keys.FEATURES, () -> TechnologicaFeatures.AQUAMARINE_DECORATED_ORE);
	public static final DeferredRegister<Fluid> FLUIDS = addRegister(ForgeRegistries.Keys.FLUIDS, () -> TechnologicaFluids.ARGON);
	public static final DeferredRegister<FluidType> FLUID_TYPES = addRegister(ForgeRegistries.Keys.FLUID_TYPES, () -> TechnologicaFluidTypes.ARGON_TYPE);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = addRegister(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, () -> TechnologicaFoliagePlacerTypes.CONICAL);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = addRegister(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, () -> TechnologicaGlobalLootModifierSerializers.FERN_LOOT_MODIFIER);
	public static final DeferredRegister<Item> ITEMS = addRegister(ForgeRegistries.Keys.ITEMS, () -> TechnologicaItems.ACACIA_BOOKSHELF_ITEM);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = addRegister(ForgeRegistries.Keys.MENU_TYPES, () -> TechnologicaMenuTypes.ANNUNCIATOR);
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = addRegister(ForgeRegistries.Keys.MOB_EFFECTS, () -> TechnologicaMobEffects.HALLUCINIATION);
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = addRegister(ForgeRegistries.Keys.PAINTING_VARIANTS, () -> TechnologicaPaintingVariants.AMNESIA);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = addRegister(ForgeRegistries.Keys.PARTICLE_TYPES, () -> TechnologicaParticleTypes.DRIPPING_BRINE);
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES = addRegister(Registries.PLACEMENT_MODIFIER_TYPE, () -> TechnologicaPlacementModifierTypes.BOUNDED_HEIGHTMAP);
	public static final DeferredRegister<FrogVariant> POSION_DART_FROG_VARIANTS = addRegister(Registries.FROG_VARIANT, () -> TechnologicaPoisonDartFrogVariant.BLUE);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = addRegister(ForgeRegistries.Keys.RECIPE_SERIALIZERS, () -> TechnologicaRecipeSerializers.SAWMILL);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = addRegister(ForgeRegistries.Keys.RECIPE_TYPES, () -> TechnologicaRecipeTypes.SAWMILL);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = addRegister(ForgeRegistries.Keys.SOUND_EVENTS, () -> TechnologicaSoundEvents.BUFFALO_AMBIENT);
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = addRegister(Registries.STRUCTURE_TYPE, () -> TechnologicaStructureTypes.DEEP_SEA);
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = addRegister(Registries.STRUCTURE_PIECE, () -> TechnologicaStructurePieceTypes.WHALE_CARCASS);
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = addRegister(Registries.TRUNK_PLACER_TYPE, () -> TechnologicaTrunkPlacerTypes.HUGE_TRUNK_PLACER);

	public static <R> DeferredRegister<R> addRegister(ResourceKey<? extends Registry<R>> key, Supplier<RegistryObject<?>> bootstrap) {
		DeferredRegister<R> deferredRegister = DeferredRegister.create(key, Technologica.MOD_ID);
		deferredRegister.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		registries.put(key, new RegistrationTracker<R>(deferredRegister, bootstrap, 0, 0));
		return deferredRegister;
	}

	public static void initDeferredRegisters() {
		registries.forEach((reg, counter) -> { 
			counter.bootstrap.get();
			counter.initialized =  counter.deferredRegister.getEntries().size();
			Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(reg.toString()) + " - " + counter.initialized, 0);
		});
	}

	@SubscribeEvent
	public static void onRegisterEvent(final RegisterEvent event) {
		long initialized = 0;
		long registered = 0;

		if (registries.containsKey(event.getRegistryKey())) {
			initialized = (long) registries.get(event.getRegistryKey()).initialized;
		}

		if (event.getForgeRegistry() != null) {
			registered = event.getForgeRegistry().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
		} else if (event.getVanillaRegistry() != null) {
			registered = event.getVanillaRegistry().entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();

		}

		Technologica.LOGGER.info("REGISTRATION - " + TextUtil.stringToAllCapsName(TextUtil.getPath(event.getRegistryKey())) + " - " + registered + " OF " + initialized);
		if (registered != initialized) {
			Technologica.LOGGER.error("REGISTRATION ERROR - " + TextUtil.stringToAllCapsName(TextUtil.getPath(event.getRegistryKey())) + " - MISSING " + (initialized - registered));
		}
	}
	
	protected static int init() {
		return 0;
	}
	
	public static class RegistrationTracker<R> {
		DeferredRegister<R> deferredRegister;
		Supplier<RegistryObject<?>> bootstrap;
		long initialized;
		long registered;
		
		public RegistrationTracker(DeferredRegister<R> deferredRegister, Supplier<RegistryObject<?>> bootstrap, long initialized, long registered) {
			this.deferredRegister = deferredRegister;
			this.bootstrap = bootstrap;
			this.initialized = initialized;
			this.registered = registered;
		}
	}
}
