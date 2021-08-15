package com.technologica.item;

import static com.technologica.Technologica.MODID;

import com.technologica.block.ModBlocks;
import com.technologica.entity.item.ModBoatEntity;
import com.technologica.fluid.ModFluids;

import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	/**
	 * FLORA
	 */
	
	public static final RegistryObject<Item> ASPARAGUS_SEEDS = ITEMS.register("asparagus_seeds", () -> new BlockNamedItem(ModBlocks.ASPARAGUS_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> BARLEY_SEEDS = ITEMS.register("barley_seeds", () -> new BlockNamedItem(ModBlocks.BARLEY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> BLACKBERRY_SEEDS = ITEMS.register("blackberry_seeds", () -> new BlockNamedItem(ModBlocks.BLACKBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", () -> new BlockNamedItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds", () -> new BlockNamedItem(ModBlocks.BROCCOLI_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> CELERY_SEEDS = ITEMS.register("celery_seeds", () -> new BlockNamedItem(ModBlocks.CELERY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds", () -> new BlockNamedItem(ModBlocks.CHILI_PEPPER_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new BlockNamedItem(ModBlocks.COFFEE_BEAN_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds", () -> new BlockNamedItem(ModBlocks.CORN_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds", () -> new BlockNamedItem(ModBlocks.COTTON_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", () -> new BlockNamedItem(ModBlocks.CUCUMBER_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds", () -> new BlockNamedItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> GINGER_SEEDS = ITEMS.register("ginger_seeds", () -> new BlockNamedItem(ModBlocks.GINGER_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new BlockNamedItem(ModBlocks.GRAPE_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new BlockNamedItem(ModBlocks.LETTUCE_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> MUSTARD_SEEDS = ITEMS.register("mustard_seeds", () -> new BlockNamedItem(ModBlocks.MUSTARD_GREENS_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> OATS_SEEDS = ITEMS.register("oats_seeds", () -> new BlockNamedItem(ModBlocks.OATS_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds", () -> new BlockNamedItem(ModBlocks.ONION_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> PEA_SEEDS = ITEMS.register("pea_seeds", () -> new BlockNamedItem(ModBlocks.PEA_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> PEANUT_SEEDS = ITEMS.register("peanut_seeds", () -> new BlockNamedItem(ModBlocks.PEANUT_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
//    public static final RegistryObject<Item> PEPPERCORNS = ITEMS.register("peppercorns", () -> new BlockNamedItem(ModBlocks.PEPPERCORN_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
//    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds", () -> new BlockNamedItem(ModBlocks.PINEAPPLE_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PURPLE_CABBAGE_SEEDS = ITEMS.register("purple_cabbage_seeds", () -> new BlockNamedItem(ModBlocks.PURPLE_CABBAGE_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> RADISH_SEEDS = ITEMS.register("radish_seeds", () -> new BlockNamedItem(ModBlocks.RADISH_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> RASPBERRY_SEEDS = ITEMS.register("raspberry_seeds", () -> new BlockNamedItem(ModBlocks.RASPBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> RED_BEANS = ITEMS.register("red_beans", () -> new BlockNamedItem(ModBlocks.RED_BEAN_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds", () -> new BlockNamedItem(ModBlocks.RICE_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> RYE_SEEDS = ITEMS.register("rye_seeds", () -> new BlockNamedItem(ModBlocks.RYE_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> SOYBEANS = ITEMS.register("soybeans", () -> new BlockNamedItem(ModBlocks.SOYBEAN_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds", () -> new BlockNamedItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> SQUASH_SEEDS = ITEMS.register("squash_seeds", () -> new BlockNamedItem(ModBlocks.SQUASH_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> SWEET_POTATO_SEEDS = ITEMS.register("sweet_potato_seeds", () -> new BlockNamedItem(ModBlocks.SWEET_POTATO_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> TEA_SEEDS = ITEMS.register("tea_seeds", () -> new BlockNamedItem(ModBlocks.TEA_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new BlockNamedItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> TURNIP_SEEDS = ITEMS.register("turnip_seeds", () -> new BlockNamedItem(ModBlocks.TURNIP_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> ZUCCHINI_SEEDS = ITEMS.register("zucchini_seeds", () -> new BlockNamedItem(ModBlocks.ZUCCHINI_CROP.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    
//    public static final RegistryObject<Item> APRICOT_SAPLING_ITEM = ITEMS.register("apricot_sapling", () -> new BlockItem(ModBlocks.APRICOT_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> ASPEN_SAPLING_ITEM = ITEMS.register("aspen_sapling", () -> new BlockItem(ModBlocks.ASPEN_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> AVOCADO_SAPLING_ITEM = ITEMS.register("avacado_sapling", () -> new BlockItem(ModBlocks.AVACADO_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> BANANA_SAPLING_ITEM = ITEMS.register("banana_sapling", () -> new BlockItem(ModBlocks.BANANA_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling", () -> new BlockItem(ModBlocks.CHERRY_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> CHESTNUT_SAPLING_ITEM = ITEMS.register("chectnut_sapling", () -> new BlockItem(ModBlocks.CHESTNUT_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));   
    public static final RegistryObject<Item> COCONUT_SAPLING_ITEM = ITEMS.register("coconut_sapling", () -> new BlockItem(ModBlocks.COCONUT_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA))); 
//    public static final RegistryObject<Item> EBONY_SAPLING_ITEM = ITEMS.register("ebony_sapling", () -> new BlockItem(ModBlocks.EBONY_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> KIWI_SAPLING_ITEM = ITEMS.register("kiwi_sapling", () -> new BlockItem(ModBlocks.KIWI_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));
	public static final RegistryObject<Item> LEMON_SAPLING_ITEM = ITEMS.register("lemon_sapling", () -> new BlockItem(ModBlocks.LEMON_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));   	
    public static final RegistryObject<Item> LIME_SAPLING_ITEM = ITEMS.register("lime_sapling", () -> new BlockItem(ModBlocks.LIME_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));   
//    public static final RegistryObject<Item> MAHOGANY_SAPLING_ITEM = ITEMS.register("mahogany_sapling", () -> new BlockItem(ModBlocks.MAHOGANY_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> MAPLE_SAPLING_ITEM = ITEMS.register("maple_sapling", () -> new BlockItem(ModBlocks.MAPLE_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = ITEMS.register("orange_sapling", () -> new BlockItem(ModBlocks.ORANGE_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));      
    public static final RegistryObject<Item> PEACH_SAPLING_ITEM = ITEMS.register("peach_sapling", () -> new BlockItem(ModBlocks.PEACH_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));    
    public static final RegistryObject<Item> PEAR_SAPLING_ITEM = ITEMS.register("pear_sapling", () -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> PLUM_SAPLING_ITEM = ITEMS.register("plum_sapling", () -> new BlockItem(ModBlocks.PLUM_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> REDWOOD_SAPLING_ITEM = ITEMS.register("redwood_sapling", () -> new BlockItem(ModBlocks.REDWOOD_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> RUBBER_SAPLING_ITEM = ITEMS.register("rubber_sapling", () -> new BlockItem(ModBlocks.RUBBER_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> TEAK_SAPLING_ITEM = ITEMS.register("teak_sapling", () -> new BlockItem(ModBlocks.TEAK_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> WALNUT_SAPLING_ITEM = ITEMS.register("walnut_sapling", () -> new BlockItem(ModBlocks.WALNUT_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
//    public static final RegistryObject<Item> ZEBRAWOOD_SAPLING_ITEM = ITEMS.register("zebrawood_sapling", () -> new BlockItem(ModBlocks.ZEBRAWOOD_SAPLING.get(), new Item.Properties().group(ModItemGroup.FLORA)));  
    public static final RegistryObject<Item> ANCIENT_AMBROSIA_SAPLING_ITEM = ITEMS.register("ancient_ambrosia_sapling", () -> new BlockItem(ModBlocks.ANCIENT_AMBROSIA_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> CRYOGENIC_SPIRE_SAPLING_ITEM = ITEMS.register("cryogenic_spire_sapling", () -> new BlockItem(ModBlocks.CRYOGENIC_SPIRE_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> THUNDEROUS_CONDUCTOR_SAPLING_ITEM = ITEMS.register("thunderous_conductor_sapling", () -> new BlockItem(ModBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> TOWERING_INFERNO_SAPLING_ITEM = ITEMS.register("towering_inferno_sapling", () -> new BlockItem(ModBlocks.TOWERING_INFERNO_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> SERENDIPITOUS_APOTHECARY_SAPLING_ITEM = ITEMS.register("serendipitous_apothecary_sapling", () -> new BlockItem(ModBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_APOTHECARY_SAPLING_ITEM = ITEMS.register("benevolent_apothecary_sapling", () -> new BlockItem(ModBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_APOTHECARY_SAPLING_ITEM = ITEMS.register("malevolent_apothecary_sapling", () -> new BlockItem(ModBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));	
	
//    public static final RegistryObject<Item> APRICOT_LEAVES_ITEM = ITEMS.register("apricot_leaves", () -> new BlockItem(ModBlocks.APRICOT_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> ASPEN_LEAVES_ITEM = ITEMS.register("aspen_leaves", () -> new BlockItem(ModBlocks.ASPEN_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));	
//    public static final RegistryObject<Item> AVOCADO_LEAVES_ITEM = ITEMS.register("avacado_leaves", () -> new BlockItem(ModBlocks.AVACADO_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves", () -> new BlockItem(ModBlocks.BANANA_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves", () -> new BlockItem(ModBlocks.CHERRY_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> CHESTNUT_LEAVES_ITEM = ITEMS.register("chestnut_leaves", () -> new BlockItem(ModBlocks.CHESTNUT_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));    
    public static final RegistryObject<Item> COCONUT_LEAVES_ITEM = ITEMS.register("coconut_leaves", () -> new BlockItem(ModBlocks.COCONUT_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> EBONY_LEAVES_ITEM = ITEMS.register("ebony_leaves", () -> new BlockItem(ModBlocks.EBONY_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> KIWI_LEAVES_ITEM = ITEMS.register("kiwi_leaves", () -> new BlockItem(ModBlocks.KIWI_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> LEMON_LEAVES_ITEM = ITEMS.register("lemon_leaves", () -> new BlockItem(ModBlocks.LEMON_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> LIME_LEAVES_ITEM = ITEMS.register("lime_leaves", () -> new BlockItem(ModBlocks.LIME_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> MAHOGANY_LEAVES_ITEM = ITEMS.register("mahogany_leaves", () -> new BlockItem(ModBlocks.MAHOGANY_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> MAPLE_LEAVES_ITEM = ITEMS.register("maple_leaves", () -> new BlockItem(ModBlocks.MAPLE_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> ORANGE_LEAVES_ITEM = ITEMS.register("orange_leaves", () -> new BlockItem(ModBlocks.ORANGE_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> PEACH_LEAVES_ITEM = ITEMS.register("peach_leaves", () -> new BlockItem(ModBlocks.PEACH_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> PEAR_LEAVES_ITEM = ITEMS.register("pear_leaves", () -> new BlockItem(ModBlocks.PEAR_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> PLUM_LEAVES_ITEM = ITEMS.register("plum_leaves", () -> new BlockItem(ModBlocks.PLUM_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));    
//    public static final RegistryObject<Item> REDWOOD_LEAVES_ITEM = ITEMS.register("redwood_leaves", () -> new BlockItem(ModBlocks.REDWOOD_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> RUBBER_LEAVES_ITEM = ITEMS.register("rubber_leaves", () -> new BlockItem(ModBlocks.RUBBER_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> TEAK_LEAVES_ITEM = ITEMS.register("teak_leaves", () -> new BlockItem(ModBlocks.TEAK_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> WALNUT_LEAVES_ITEM = ITEMS.register("walnut_leaves", () -> new BlockItem(ModBlocks.WALNUT_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
//    public static final RegistryObject<Item> ZEBRAWOOD_LEAVES_ITEM = ITEMS.register("zebrawood_leaves", () -> new BlockItem(ModBlocks.ZEBRAWOOD_LEAVES.get(), new Item.Properties().group(ModItemGroup.FLORA)));
    public static final RegistryObject<Item> FRUITFUL_LEAVES_ITEM = ITEMS.register("fruitful_leaves", () -> new BlockItem(ModBlocks.FRUITFUL_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LEAVES_ITEM = ITEMS.register("alchemical_leaves", () -> new BlockItem(ModBlocks.ALCHEMICAL_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LEAVES_ITEM = ITEMS.register("benevolent_leaves", () -> new BlockItem(ModBlocks.BENEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LEAVES_ITEM = ITEMS.register("malevolent_leaves", () -> new BlockItem(ModBlocks.MALEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LEAVES_ITEM = ITEMS.register("conductive_leaves", () -> new BlockItem(ModBlocks.CONDUCTIVE_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LEAVES_ITEM = ITEMS.register("frostbitten_leaves", () -> new BlockItem(ModBlocks.FROSTBITTEN_LEAVES.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    
    public static final RegistryObject<Item> COTTON = ITEMS.register("cotton", () -> new Item(new Item.Properties().group(ModItemGroup.FLORA)));
    
    /**
	 * FAUNA
	 */
    
    public static final RegistryObject<Item> DUCK_SPAWN_EGG = ITEMS.register("duck_spawn_egg", () -> new ModSpawnEggItem(1)); 
    public static final RegistryObject<Item> GRIZZLY_BEAR_SPAWN_EGG = ITEMS.register("grizzly_bear_spawn_egg", () -> new ModSpawnEggItem(2));
    public static final RegistryObject<Item> OSTRICH_SPAWN_EGG = ITEMS.register("ostrich_spawn_egg", () -> new ModSpawnEggItem(3));
    public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg", () -> new ModSpawnEggItem(4));
    public static final RegistryObject<Item> ZEBRA_SPAWN_EGG = ITEMS.register("zebra_spawn_egg", () -> new ModSpawnEggItem(5));
    public static final RegistryObject<Item> SCORPION_SPAWN_EGG = ITEMS.register("scorpion_spawn_egg", () -> new ModSpawnEggItem(6));
    
    /**
     * MINERAL
     */
    
    public static final RegistryObject<Item> SALT_ITEM = ITEMS.register("salt", () -> new BlockItem(ModBlocks.SALT.get(), new Item.Properties().group(ModItemGroup.MINERAL)));   
    public static final RegistryObject<Item> LITHIUM_CLAY_ITEM = ITEMS.register("lithium_clay", () -> new BlockItem(ModBlocks.LITHIUM_CLAY.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    
    public static final RegistryObject<Item> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore", () -> new BlockItem(ModBlocks.BAUXITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> CHROMITE_ORE_ITEM = ITEMS.register("chromite_ore", () -> new BlockItem(ModBlocks.CHROMITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ILMENITE_ORE_ITEM = ITEMS.register("ilmenite_ore", () -> new BlockItem(ModBlocks.ILMENITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> PYROLUSITE_ORE_ITEM = ITEMS.register("pyrolusite_ore", () -> new BlockItem(ModBlocks.PYROLUSITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> COBALTITE_ORE_ITEM = ITEMS.register("cobaltite_ore", () -> new BlockItem(ModBlocks.COBALTITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> GARNIERITE_ORE_ITEM = ITEMS.register("garnierite_ore", () -> new BlockItem(ModBlocks.GARNIERITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> BORAX_ORE_ITEM = ITEMS.register("borax_ore", () -> new BlockItem(ModBlocks.BORAX_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL))); 
    public static final RegistryObject<Item> MAGNESITE_ORE_ITEM = ITEMS.register("magnesite_ore", () -> new BlockItem(ModBlocks.MAGNESITE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL))); 
    public static final RegistryObject<Item> SPODUMENE_ORE_ITEM = ITEMS.register("spodumene_ore", () -> new BlockItem(ModBlocks.SPODUMENE_ORE.get(), new Item.Properties().group(ModItemGroup.MINERAL)));     
    
    public static final RegistryObject<Item> AQUAMARINE_CRYSTAL_ITEM = ITEMS.register("aquamarine_crystal", () -> new BlockItem(ModBlocks.AQUAMARINE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> DOLOMITE_CRYSTAL_ITEM = ITEMS.register("dolomite_crystal", () -> new BlockItem(ModBlocks.DOLOMITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> FLUORITE_CRYSTAL_ITEM = ITEMS.register("fluorite_crystal", () -> new BlockItem(ModBlocks.FLUORITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.MINERAL))); 
    public static final RegistryObject<Item> ULEXITE_CRYSTAL_ITEM = ITEMS.register("ulexite_crystal", () -> new BlockItem(ModBlocks.ULEXITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.MINERAL))); 
      
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> TECHNETIUM_INGOT = ITEMS.register("technetium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> CAESIUM_INGOT = ITEMS.register("caesium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> PRAESODYMIUM_INGOT = ITEMS.register("praesodymium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> PROMETHIUM_INGOT = ITEMS.register("promethium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> POLONIUM_INGOT = ITEMS.register("polonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> PROTACTINIUM_INGOT = ITEMS.register("protactinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> NEPTUNIUM_INGOT = ITEMS.register("neptunium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> AMERICIUM_INGOT = ITEMS.register("americium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> CURIUM_INGOT = ITEMS.register("curium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> BERKELIUM_INGOT = ITEMS.register("berkelium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> CALIFORNIUM_INGOT = ITEMS.register("californium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> EINSTEINIUM_INGOT = ITEMS.register("einsteinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> FERMIUM_INGOT = ITEMS.register("fermium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> MENDELEVIUM_INGOT = ITEMS.register("mendelevium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> NOBELIUM_INGOT = ITEMS.register("nobelium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> LAWRENCIUM_INGOT = ITEMS.register("lawrencium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> RUTHERFORDIUM_INGOT = ITEMS.register("rutherfordium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> DUBNIUM_INGOT = ITEMS.register("dubnium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> SEABORGIUM_INGOT = ITEMS.register("seaborgium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> BOHRIUM_INGOT = ITEMS.register("bohrium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> HASSIUM_INGOT = ITEMS.register("hassium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> MEITNERIUM_INGOT = ITEMS.register("meitnerium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> DARMSTADTIUM_INGOT = ITEMS.register("darmstadtium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> ROENTGENIUM_INGOT = ITEMS.register("roentgenuim_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> COPERNICIUM_INGOT = ITEMS.register("copernicium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> NIHONIUM_INGOT = ITEMS.register("nihonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> FLEVORIUM_INGOT = ITEMS.register("flevorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> MOSCOVIUM_INGOT = ITEMS.register("moscovium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> LIVERMORIUM_INGOT = ITEMS.register("livermorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> TENNESINE_INGOT = ITEMS.register("tennessine_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
//    public static final RegistryObject<Item> OGANESSON_INGOT = ITEMS.register("oganesson_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    
    public static final RegistryObject<Item> LITHIUM_CLAY_BALL = ITEMS.register("lithium_clay_ball", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> BORON_CHUNK = ITEMS.register("boron_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> CARBON_CHUNK = ITEMS.register("carbon_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SILICON_CHUNK = ITEMS.register("silicon_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> PHOSPHORUS_CHUNK = ITEMS.register("phosphorus_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SULFUR_CHUNK = ITEMS.register("sulfur_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> GERMANIUM_CHUNK = ITEMS.register("germanium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ARSENIC_CHUNK = ITEMS.register("arsenic_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> SELENIUM_CHUNK = ITEMS.register("selenium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ANTIMONY_CHUNK = ITEMS.register("antimony_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> TELLURIUM_CHUNK = ITEMS.register("tellurium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> IODINE_CHUNK = ITEMS.register("iodine_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.MINERAL)));
    public static final RegistryObject<Item> ASTATINE_CHUNK = ITEMS.register("astatine_chunk", () -> new Item(new Properties().group(ModItemGroup.MINERAL)));
    
    public static final RegistryObject<Item> BRINE_BUCKET = ITEMS.register("brine_bucket", () -> new BucketItem(ModFluids.BRINE_SOURCE, new Properties().group(ModItemGroup.MINERAL).maxStackSize(1)));
    public static final RegistryObject<Item> MERCURY_BUCKET = ITEMS.register("mercury_bucket", () -> new BucketItem(ModFluids.MERCURY_SOURCE, new Properties().group(ModItemGroup.MINERAL).maxStackSize(1)));
    public static final RegistryObject<Item> HYDROGEN_BUCKET = ITEMS.register("hydrogen_bucket", () -> new BucketItem(ModFluids.HYDROGEN_SOURCE, new Properties().group(ModItemGroup.MINERAL).maxStackSize(1)));
    
    /**
     * FOOD
     */
    
    public static final RegistryObject<Item> APRICOT = ITEMS.register("apricot", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ASPARAGUS = ITEMS.register("asparagus", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BARLEY = ITEMS.register("barley", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD)));
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> CELERY = ITEMS.register("celery", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> CHESTNUT = ITEMS.register("chestnut", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GINGER = ITEMS.register("ginger", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> KIWI = ITEMS.register("kiwi", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(2).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
//    public static final RegistryObject<Item> MUSTARD_GREENS = ITEMS.register("mustard_greens", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> OATS = ITEMS.register("oats", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD)));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAS = ITEMS.register("peas", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
//    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
//    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
//    public static final RegistryObject<Item> PLUM = ITEMS.register("plum", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PURPLE_CABBAGE = ITEMS.register("purple_cabbage", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> RADISH = ITEMS.register("radish", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> RYE = ITEMS.register("rye", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD)));
    public static final RegistryObject<Item> SQUASH = ITEMS.register("squash", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> SWEET_POTATO = ITEMS.register("sweet_potato", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));  
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
//    public static final RegistryObject<Item> WALNUT = ITEMS.register("walnut", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ZUCCHINI = ITEMS.register("zucchini", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    
    public static final RegistryObject<Item> BANANAS_FOSTER = ITEMS.register("bananas_foster", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLACK_FOREST_CAKE = ITEMS.register("black_forest_cake", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLUEBERRY_CHEESECAKE = ITEMS.register("blueberry_cheesecake", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> COCONUT_CREAM_PIE = ITEMS.register("coconut_cream_pie", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GRAPE_SHAVED_ICE = ITEMS.register("grape_shaved_ice", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> KEY_LIME_MOUSSE = ITEMS.register("key_lime_mousse", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> KIWI_SORBET = ITEMS.register("kiwi_sorbet", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LEMON_BAR = ITEMS.register("lemon_bar", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ORANGE_DREAMSICLE = ITEMS.register("orange_dreamsicle", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEACH_COBBLER = ITEMS.register("peach_cobbler", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAR_TART = ITEMS.register("pear_tart", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> STRAWBERRY_SHORTCAKE = ITEMS.register("strawberry_shortcake", () -> new Item(new Item.Properties().group(ModItemGroup.FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    

    /**
     * CONSTRUCTION
     */
    
//    public static final RegistryObject<Item> APRICOT_LOG_ITEM = ITEMS.register("apricot_log", () -> new BlockItem(ModBlocks.APRICOT_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ASPEN_LOG_ITEM = ITEMS.register("aspen_log", () -> new BlockItem(ModBlocks.ASPEN_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//    public static final RegistryObject<Item> AVOCADO_LOG_ITEM = ITEMS.register("avacado_log", () -> new BlockItem(ModBlocks.AVACADO_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> BANANA_LOG_ITEM = ITEMS.register("banana_log", () -> new BlockItem(ModBlocks.BANANA_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_LOG_ITEM = ITEMS.register("cherry_log", () -> new BlockItem(ModBlocks.CHERRY_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//    public static final RegistryObject<Item> CHESTNUT_LOG_ITEM = ITEMS.register("chestnut_log", () -> new BlockItem(ModBlocks.CHESTNUT_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
    public static final RegistryObject<Item> COCONUT_LOG_ITEM = ITEMS.register("coconut_log", () -> new BlockItem(ModBlocks.COCONUT_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//    public static final RegistryObject<Item> EBONY_LOG_ITEM = ITEMS.register("ebony_log", () -> new BlockItem(ModBlocks.EBONY_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
    public static final RegistryObject<Item> KIWI_LOG_ITEM = ITEMS.register("kiwi_log", () -> new BlockItem(ModBlocks.KIWI_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_LOG_ITEM = ITEMS.register("lemon_log", () -> new BlockItem(ModBlocks.LEMON_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_LOG_ITEM = ITEMS.register("lime_log", () -> new BlockItem(ModBlocks.LIME_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//    public static final RegistryObject<Item> MAHOGANY_LOG_ITEM = ITEMS.register("mahogany_log", () -> new BlockItem(ModBlocks.MAHOGANY_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
//    public static final RegistryObject<Item> MAPLE_LOG_ITEM = ITEMS.register("maple_log", () -> new BlockItem(ModBlocks.MAPLE_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_LOG_ITEM = ITEMS.register("orange_log", () -> new BlockItem(ModBlocks.ORANGE_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_LOG_ITEM = ITEMS.register("peach_log",	() -> new BlockItem(ModBlocks.PEACH_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_LOG_ITEM = ITEMS.register("pear_log", () -> new BlockItem(ModBlocks.PEAR_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION))); 
//  public static final RegistryObject<Item> PLUM_LOG_ITEM = ITEMS.register("plum_log", () -> new BlockItem(ModBlocks.PLUM_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
//  public static final RegistryObject<Item> REDWOOD_LOG_ITEM = ITEMS.register("redwood_log", () -> new BlockItem(ModBlocks.REDWOOD_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> RUBBER_LOG_ITEM = ITEMS.register("rubber_log", () -> new BlockItem(ModBlocks.RUBBER_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> TEAK_LOG_ITEM = ITEMS.register("teak_log", () -> new BlockItem(ModBlocks.TEAK_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> WALNUT_LOG_ITEM = ITEMS.register("walnut_log", () -> new BlockItem(ModBlocks.WALNUT_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> ZEBRAWOOD_LOG_ITEM = ITEMS.register("zebrawood_log", () -> new BlockItem(ModBlocks.ZEBRAWOOD_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> FRUITFUL_LOG_ITEM = ITEMS.register("fruitful_log", () -> new BlockItem(ModBlocks.FRUITFUL_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LOG_ITEM = ITEMS.register("alchemical_log", () -> new BlockItem(ModBlocks.ALCHEMICAL_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LOG_ITEM = ITEMS.register("benevolent_log", () -> new BlockItem(ModBlocks.BENEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LOG_ITEM = ITEMS.register("malevolent_log", () -> new BlockItem(ModBlocks.MALEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LOG_ITEM = ITEMS.register("conductive_log", () -> new BlockItem(ModBlocks.CONDUCTIVE_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LOG_ITEM = ITEMS.register("frostbitten_log", () -> new BlockItem(ModBlocks.FROSTBITTEN_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> INFERNAL_LOG_ITEM = ITEMS.register("infernal_log", () -> new BlockItem(ModBlocks.INFERNAL_LOG.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    
    public static final RegistryObject<Item> STRIPPED_CHERRY_LOG_ITEM = ITEMS.register("stripped_cherry_log", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_LOG.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
//  public static final RegistryObject<Item> APRICOT_WOOD_ITEM = ITEMS.register("apricot_wood", () -> new BlockItem(ModBlocks.APRICOT_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> ASPEN_WOOD_ITEM = ITEMS.register("aspen_wood", () -> new BlockItem(ModBlocks.ASPEN_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> AVOCADO_WOOD_ITEM = ITEMS.register("avacado_wood", () -> new BlockItem(ModBlocks.AVACADO_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> BANANA_WOOD_ITEM = ITEMS.register("banana_wood", () -> new BlockItem(ModBlocks.BANANA_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_WOOD_ITEM = ITEMS.register("cherry_wood", () -> new BlockItem(ModBlocks.CHERRY_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> CHESTNUT_WOOD_ITEM = ITEMS.register("chestnut_wood", () -> new BlockItem(ModBlocks.CHESTNUT_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
    public static final RegistryObject<Item> COCONUT_WOOD_ITEM = ITEMS.register("coconut_wood", () -> new BlockItem(ModBlocks.COCONUT_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> EBONY_WOOD_ITEM = ITEMS.register("ebony_wood", () -> new BlockItem(ModBlocks.EBONY_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
    public static final RegistryObject<Item> KIWI_WOOD_ITEM = ITEMS.register("kiwi_wood", () -> new BlockItem(ModBlocks.KIWI_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_WOOD_ITEM = ITEMS.register("lemon_wood", () -> new BlockItem(ModBlocks.LEMON_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_WOOD_ITEM = ITEMS.register("lime_wood", () -> new BlockItem(ModBlocks.LIME_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//  public static final RegistryObject<Item> MAHOGANY_WOOD_ITEM = ITEMS.register("mahogany_wood", () -> new BlockItem(ModBlocks.MAHOGANY_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
//  public static final RegistryObject<Item> MAPLE_WOOD_ITEM = ITEMS.register("maple_wood", () -> new BlockItem(ModBlocks.MAPLE_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_WOOD_ITEM = ITEMS.register("orange_wood", () -> new BlockItem(ModBlocks.ORANGE_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_WOOD_ITEM = ITEMS.register("peach_wood",	() -> new BlockItem(ModBlocks.PEACH_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_WOOD_ITEM = ITEMS.register("pear_wood", () -> new BlockItem(ModBlocks.PEAR_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION))); 
//public static final RegistryObject<Item> PLUM_WOOD_ITEM = ITEMS.register("plum_wood", () -> new BlockItem(ModBlocks.PLUM_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));    
//public static final RegistryObject<Item> REDWOOD_WOOD_ITEM = ITEMS.register("redwood_wood", () -> new BlockItem(ModBlocks.REDWOOD_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//public static final RegistryObject<Item> RUBBER_WOOD_ITEM = ITEMS.register("rubber_wood", () -> new BlockItem(ModBlocks.RUBBER_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//public static final RegistryObject<Item> TEAK_WOOD_ITEM = ITEMS.register("teak_wood", () -> new BlockItem(ModBlocks.TEAK_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//public static final RegistryObject<Item> WALNUT_WOOD_ITEM = ITEMS.register("walnut_wood", () -> new BlockItem(ModBlocks.WALNUT_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
//public static final RegistryObject<Item> ZEBRAWOOD_WOOD_ITEM = ITEMS.register("zebrawood_wood", () -> new BlockItem(ModBlocks.ZEBRAWOOD_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> FRUITFUL_WOOD_ITEM = ITEMS.register("fruitful_wood", () -> new BlockItem(ModBlocks.FRUITFUL_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_WOOD_ITEM = ITEMS.register("alchemical_wood", () -> new BlockItem(ModBlocks.ALCHEMICAL_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_WOOD_ITEM = ITEMS.register("benevolent_wood", () -> new BlockItem(ModBlocks.BENEVOLENT_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_WOOD_ITEM = ITEMS.register("malevolent_wood", () -> new BlockItem(ModBlocks.MALEVOLENT_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_WOOD_ITEM = ITEMS.register("conductive_wood", () -> new BlockItem(ModBlocks.CONDUCTIVE_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_WOOD_ITEM = ITEMS.register("frostbitten_wood", () -> new BlockItem(ModBlocks.FROSTBITTEN_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    public static final RegistryObject<Item> INFERNAL_WOOD_ITEM = ITEMS.register("infernal_wood", () -> new BlockItem(ModBlocks.INFERNAL_WOOD.get(), new Item.Properties().group(ModItemGroup.CRYPTICA)));
    
    public static final RegistryObject<Item> STRIPPED_CHERRY_WOOD_ITEM = ITEMS.register("stripped_cherry_wood", () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_WOOD.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_PLANKS_ITEM = ITEMS.register("banana_planks", () -> new BlockItem(ModBlocks.BANANA_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_PLANKS_ITEM = ITEMS.register("cherry_planks", () -> new BlockItem(ModBlocks.CHERRY_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_PLANKS_ITEM = ITEMS.register("coconut_planks", () -> new BlockItem(ModBlocks.COCONUT_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_PLANKS_ITEM = ITEMS.register("kiwi_planks", () -> new BlockItem(ModBlocks.KIWI_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_PLANKS_ITEM = ITEMS.register("lemon_planks", () -> new BlockItem(ModBlocks.LEMON_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_PLANKS_ITEM = ITEMS.register("lime_planks", () -> new BlockItem(ModBlocks.LIME_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_PLANKS_ITEM = ITEMS.register("orange_planks", () -> new BlockItem(ModBlocks.ORANGE_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_PLANKS_ITEM = ITEMS.register("peach_planks", () -> new BlockItem(ModBlocks.PEACH_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_PLANKS_ITEM = ITEMS.register("pear_planks", () -> new BlockItem(ModBlocks.PEAR_PLANKS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> SPRUCE_BOOKSHELF_ITEM = ITEMS.register("spruce_bookshelf", () -> new BlockItem(ModBlocks.SPRUCE_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> BIRCH_BOOKSHELF_ITEM = ITEMS.register("birch_bookshelf", () -> new BlockItem(ModBlocks.BIRCH_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> JUNGLE_BOOKSHELF_ITEM = ITEMS.register("jungle_bookshelf", () -> new BlockItem(ModBlocks.JUNGLE_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ACACIA_BOOKSHELF_ITEM = ITEMS.register("acacia_bookshelf", () -> new BlockItem(ModBlocks.ACACIA_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> DARK_OAK_BOOKSHELF_ITEM = ITEMS.register("dark_oak_bookshelf", () -> new BlockItem(ModBlocks.DARK_OAK_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CRIMSON_BOOKSHELF_ITEM = ITEMS.register("crimson_bookshelf", () -> new BlockItem(ModBlocks.CRIMSON_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> WARPED_BOOKSHELF_ITEM = ITEMS.register("warped_bookshelf", () -> new BlockItem(ModBlocks.WARPED_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
       
    public static final RegistryObject<Item> BANANA_BOOKSHELF_ITEM = ITEMS.register("banana_bookshelf", () -> new BlockItem(ModBlocks.BANANA_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_BOOKSHELF_ITEM = ITEMS.register("cherry_bookshelf", () -> new BlockItem(ModBlocks.CHERRY_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_BOOKSHELF_ITEM = ITEMS.register("coconut_bookshelf", () -> new BlockItem(ModBlocks.COCONUT_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_BOOKSHELF_ITEM = ITEMS.register("kiwi_bookshelf", () -> new BlockItem(ModBlocks.KIWI_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_BOOKSHELF_ITEM = ITEMS.register("lemon_bookshelf", () -> new BlockItem(ModBlocks.LEMON_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_BOOKSHELF_ITEM = ITEMS.register("lime_bookshelf", () -> new BlockItem(ModBlocks.LIME_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_BOOKSHELF_ITEM = ITEMS.register("orange_bookshelf", () -> new BlockItem(ModBlocks.ORANGE_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_BOOKSHELF_ITEM = ITEMS.register("peach_bookshelf",	() -> new BlockItem(ModBlocks.PEACH_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_BOOKSHELF_ITEM = ITEMS.register("pear_bookshelf", () -> new BlockItem(ModBlocks.PEAR_BOOKSHELF.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION))); 
    
    public static final RegistryObject<Item> BANANA_SLAB_ITEM = ITEMS.register("banana_slab", () -> new BlockItem(ModBlocks.BANANA_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_SLAB_ITEM = ITEMS.register("cherry_slab", () -> new BlockItem(ModBlocks.CHERRY_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_SLAB_ITEM = ITEMS.register("coconut_slab", () -> new BlockItem(ModBlocks.COCONUT_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_SLAB_ITEM = ITEMS.register("kiwi_slab", () -> new BlockItem(ModBlocks.KIWI_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_SLAB_ITEM = ITEMS.register("lemon_slab", () -> new BlockItem(ModBlocks.LEMON_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_SLAB_ITEM = ITEMS.register("lime_slab", () -> new BlockItem(ModBlocks.LIME_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_SLAB_ITEM = ITEMS.register("orange_slab", () -> new BlockItem(ModBlocks.ORANGE_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_SLAB_ITEM = ITEMS.register("peach_slab", () -> new BlockItem(ModBlocks.PEACH_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_SLAB_ITEM = ITEMS.register("pear_slab", () -> new BlockItem(ModBlocks.PEAR_SLAB.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_STAIRS_ITEM = ITEMS.register("banana_stairs", () -> new BlockItem(ModBlocks.BANANA_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_STAIRS_ITEM = ITEMS.register("cherry_stairs", () -> new BlockItem(ModBlocks.CHERRY_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_STAIRS_ITEM = ITEMS.register("coconut_stairs", () -> new BlockItem(ModBlocks.COCONUT_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_STAIRS_ITEM = ITEMS.register("kiwi_stairs", () -> new BlockItem(ModBlocks.KIWI_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_STAIRS_ITEM = ITEMS.register("lemon_stairs", () -> new BlockItem(ModBlocks.LEMON_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_STAIRS_ITEM = ITEMS.register("lime_stairs", () -> new BlockItem(ModBlocks.LIME_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_STAIRS_ITEM = ITEMS.register("orange_stairs", () -> new BlockItem(ModBlocks.ORANGE_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_STAIRS_ITEM = ITEMS.register("peach_stairs", () -> new BlockItem(ModBlocks.PEACH_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_STAIRS_ITEM = ITEMS.register("pear_stairs", () -> new BlockItem(ModBlocks.PEAR_STAIRS.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_FENCE_ITEM = ITEMS.register("banana_fence", () -> new BlockItem(ModBlocks.BANANA_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_FENCE_ITEM = ITEMS.register("cherry_fence", () -> new BlockItem(ModBlocks.CHERRY_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_FENCE_ITEM = ITEMS.register("coconut_fence", () -> new BlockItem(ModBlocks.COCONUT_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_FENCE_ITEM = ITEMS.register("kiwi_fence", () -> new BlockItem(ModBlocks.KIWI_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_FENCE_ITEM = ITEMS.register("lemon_fence", () -> new BlockItem(ModBlocks.LEMON_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_FENCE_ITEM = ITEMS.register("lime_fence", () -> new BlockItem(ModBlocks.LIME_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_FENCE_ITEM = ITEMS.register("orange_fence", () -> new BlockItem(ModBlocks.ORANGE_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_FENCE_ITEM = ITEMS.register("peach_fence", () -> new BlockItem(ModBlocks.PEACH_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_FENCE_ITEM = ITEMS.register("pear_fence", () -> new BlockItem(ModBlocks.PEAR_FENCE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_FENCE_GATE_ITEM = ITEMS.register("banana_fence_gate", () -> new BlockItem(ModBlocks.BANANA_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_FENCE_GATE_ITEM = ITEMS.register("cherry_fence_gate", () -> new BlockItem(ModBlocks.CHERRY_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_FENCE_GATE_ITEM = ITEMS.register("coconut_fence_gate", () -> new BlockItem(ModBlocks.COCONUT_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_FENCE_GATE_ITEM = ITEMS.register("kiwi_fence_gate", () -> new BlockItem(ModBlocks.KIWI_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_FENCE_GATE_ITEM = ITEMS.register("lemon_fence_gate", () -> new BlockItem(ModBlocks.LEMON_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_FENCE_GATE_ITEM = ITEMS.register("lime_fence_gate", () -> new BlockItem(ModBlocks.LIME_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_FENCE_GATE_ITEM = ITEMS.register("orange_fence_gate", () -> new BlockItem(ModBlocks.ORANGE_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_FENCE_GATE_ITEM = ITEMS.register("peach_fence_gate", () -> new BlockItem(ModBlocks.PEACH_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_FENCE_GATE_ITEM = ITEMS.register("pear_fence_gate", () -> new BlockItem(ModBlocks.PEAR_FENCE_GATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_DOOR_ITEM = ITEMS.register("banana_door", () -> new BlockItem(ModBlocks.BANANA_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_DOOR_ITEM = ITEMS.register("cherry_door", () -> new BlockItem(ModBlocks.CHERRY_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_DOOR_ITEM = ITEMS.register("coconut_door", () -> new BlockItem(ModBlocks.COCONUT_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_DOOR_ITEM = ITEMS.register("kiwi_door", () -> new BlockItem(ModBlocks.KIWI_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_DOOR_ITEM = ITEMS.register("lemon_door", () -> new BlockItem(ModBlocks.LEMON_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_DOOR_ITEM = ITEMS.register("lime_door", () -> new BlockItem(ModBlocks.LIME_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_DOOR_ITEM = ITEMS.register("orange_door", () -> new BlockItem(ModBlocks.ORANGE_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_DOOR_ITEM = ITEMS.register("peach_door", () -> new BlockItem(ModBlocks.PEACH_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_DOOR_ITEM = ITEMS.register("pear_door", () -> new BlockItem(ModBlocks.PEAR_DOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_TRAPDOOR_ITEM = ITEMS.register("banana_trapdoor", () -> new BlockItem(ModBlocks.BANANA_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_TRAPDOOR_ITEM = ITEMS.register("cherry_trapdoor", () -> new BlockItem(ModBlocks.CHERRY_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_TRAPDOOR_ITEM = ITEMS.register("coconut_trapdoor", () -> new BlockItem(ModBlocks.COCONUT_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_TRAPDOOR_ITEM = ITEMS.register("kiwi_trapdoor", () -> new BlockItem(ModBlocks.KIWI_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_TRAPDOOR_ITEM = ITEMS.register("lemon_trapdoor", () -> new BlockItem(ModBlocks.LEMON_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_TRAPDOOR_ITEM = ITEMS.register("lime_trapdoor", () -> new BlockItem(ModBlocks.LIME_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_TRAPDOOR_ITEM = ITEMS.register("orange_trapdoor", () -> new BlockItem(ModBlocks.ORANGE_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_TRAPDOOR_ITEM = ITEMS.register("peach_trapdoor", () -> new BlockItem(ModBlocks.PEACH_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_TRAPDOOR_ITEM = ITEMS.register("pear_trapdoor", () -> new BlockItem(ModBlocks.PEAR_TRAPDOOR.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_PRESSURE_PLATE_ITEM = ITEMS.register("banana_pressure_plate", () -> new BlockItem(ModBlocks.BANANA_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_PRESSURE_PLATE_ITEM = ITEMS.register("cherry_pressure_plate", () -> new BlockItem(ModBlocks.CHERRY_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_PRESSURE_PLATE_ITEM = ITEMS.register("coconut_pressure_plate", () -> new BlockItem(ModBlocks.COCONUT_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_PRESSURE_PLATE_ITEM = ITEMS.register("kiwi_pressure_plate", () -> new BlockItem(ModBlocks.KIWI_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_PRESSURE_PLATE_ITEM = ITEMS.register("lemon_pressure_plate", () -> new BlockItem(ModBlocks.LEMON_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_PRESSURE_PLATE_ITEM = ITEMS.register("lime_pressure_plate", () -> new BlockItem(ModBlocks.LIME_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_PRESSURE_PLATE_ITEM = ITEMS.register("orange_pressure_plate", () -> new BlockItem(ModBlocks.ORANGE_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_PRESSURE_PLATE_ITEM = ITEMS.register("peach_pressure_plate", () -> new BlockItem(ModBlocks.PEACH_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_PRESSURE_PLATE_ITEM = ITEMS.register("pear_pressure_plate", () -> new BlockItem(ModBlocks.PEAR_PRESSURE_PLATE.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_BUTTON_ITEM = ITEMS.register("banana_button", () -> new BlockItem(ModBlocks.BANANA_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_BUTTON_ITEM = ITEMS.register("cherry_button", () -> new BlockItem(ModBlocks.CHERRY_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> COCONUT_BUTTON_ITEM = ITEMS.register("coconut_button", () -> new BlockItem(ModBlocks.COCONUT_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> KIWI_BUTTON_ITEM = ITEMS.register("kiwi_button", () -> new BlockItem(ModBlocks.KIWI_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LEMON_BUTTON_ITEM = ITEMS.register("lemon_button", () -> new BlockItem(ModBlocks.LEMON_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> LIME_BUTTON_ITEM = ITEMS.register("lime_button", () -> new BlockItem(ModBlocks.LIME_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> ORANGE_BUTTON_ITEM = ITEMS.register("orange_button", () -> new BlockItem(ModBlocks.ORANGE_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEACH_BUTTON_ITEM = ITEMS.register("peach_button", () -> new BlockItem(ModBlocks.PEACH_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> PEAR_BUTTON_ITEM = ITEMS.register("pear_button", () -> new BlockItem(ModBlocks.PEAR_BUTTON.get(), new Item.Properties().group(ModItemGroup.CONSTRUCTION)));
    
    public static final RegistryObject<Item> BANANA_SIGN_ITEM = ITEMS.register("banana_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.BANANA_SIGN.get(), ModBlocks.BANANA_WALL_SIGN.get()));
    public static final RegistryObject<Item> CHERRY_SIGN_ITEM = ITEMS.register("cherry_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.CHERRY_SIGN.get(), ModBlocks.CHERRY_WALL_SIGN.get()));
    public static final RegistryObject<Item> COCONUT_SIGN_ITEM = ITEMS.register("coconut_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.COCONUT_SIGN.get(), ModBlocks.COCONUT_WALL_SIGN.get()));
    public static final RegistryObject<Item> KIWI_SIGN_ITEM = ITEMS.register("kiwi_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.KIWI_SIGN.get(), ModBlocks.KIWI_WALL_SIGN.get()));
    public static final RegistryObject<Item> LEMON_SIGN_ITEM = ITEMS.register("lemon_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.LEMON_SIGN.get(), ModBlocks.LEMON_WALL_SIGN.get()));
    public static final RegistryObject<Item> LIME_SIGN_ITEM = ITEMS.register("lime_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.LIME_SIGN.get(), ModBlocks.LIME_WALL_SIGN.get()));
    public static final RegistryObject<Item> ORANGE_SIGN_ITEM = ITEMS.register("orange_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.ORANGE_SIGN.get(), ModBlocks.ORANGE_WALL_SIGN.get()));
    public static final RegistryObject<Item> PEACH_SIGN_ITEM = ITEMS.register("peach_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.PEACH_SIGN.get(), ModBlocks.PEACH_WALL_SIGN.get()));
    public static final RegistryObject<Item> PEAR_SIGN_ITEM = ITEMS.register("pear_sign", () -> new ModSignItem((new Item.Properties()).maxStackSize(16).group(ModItemGroup.CONSTRUCTION), ModBlocks.PEAR_SIGN.get(), ModBlocks.PEAR_WALL_SIGN.get()));
    
    public static final RegistryObject<Item> BANANA_BOAT = ITEMS.register("banana_boat", () -> new ModBoatItem(ModBoatEntity.Type.BANANA, (new Item.Properties()).maxStackSize(1).group(ModItemGroup.CONSTRUCTION)));
    public static final RegistryObject<Item> CHERRY_BOAT = ITEMS.register("cherry_boat", () -> new ModBoatItem(ModBoatEntity.Type.CHERRY, (new Item.Properties()).maxStackSize(1).group(ModItemGroup.CONSTRUCTION)));
    
    /**
     * MACHINERY
     */
    
    public static final RegistryObject<Item> LINE_SHAFT_HANGER_ITEM = ITEMS.register("line_shaft_hanger", () -> new BlockItem(ModBlocks.LINE_SHAFT_HANGER.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> STEEL_SHAFT = ITEMS.register("steel_shaft", () -> new Item(new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> SMALL_PULLEY_ITEM = ITEMS.register("small_pulley", () -> new BlockNamedItem(ModBlocks.SMALL_PULLEY.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> MEDIUM_PULLEY_ITEM = ITEMS.register("medium_pulley", () -> new BlockNamedItem(ModBlocks.MEDIUM_PULLEY.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> LARGE_PULLEY_ITEM = ITEMS.register("large_pulley", () -> new BlockNamedItem(ModBlocks.LARGE_PULLEY.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> PULLEY_BELT = ITEMS.register("pulley_belt", PulleyBeltItem::new);
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> PIPE_WRENCH = ITEMS.register("pipe_wrench", () -> new PipeWrenchItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> MOTOR_1HP_ITEM = ITEMS.register("motor_1hp", () -> new BlockItem(ModBlocks.MOTOR_1HP.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> MOTOR_5HP_ITEM = ITEMS.register("motor_5hp", () -> new BlockItem(ModBlocks.MOTOR_5HP.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    public static final RegistryObject<Item> MOTOR_20HP_ITEM = ITEMS.register("motor_20hp", () -> new BlockItem(ModBlocks.MOTOR_20HP.get(), new Item.Properties().group(ModItemGroup.MACHINERY)));
    
    /**
     * DECORATIVE
     */
    
    public static final RegistryObject<Item> DISPLAY_CASE_ITEM = ITEMS.register("display_case", () -> new BlockItem(ModBlocks.DISPLAY_CASE.get(), new Item.Properties().group(ModItemGroup.DECORATIVE)));
    
    
    
    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
	
