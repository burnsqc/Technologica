package com.technologica.items;

import static com.technologica.Technologica.MODID;

import com.technologica.block.ModBlocks;
import com.technologica.fluid.ModFluids;
import com.technologica.setup.ModItemGroup;

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
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	private ModItems() {
       // use private constructor to hide default constructor
   }

	public static final RegistryObject<Item> BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves", () -> new BlockItem(ModBlocks.BANANA_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves", () -> new BlockItem(ModBlocks.CHERRY_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_LEAVES_ITEM = ITEMS.register("coconut_leaves", () -> new BlockItem(ModBlocks.COCONUT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_LEAVES_ITEM = ITEMS.register("kiwi_leaves", () -> new BlockItem(ModBlocks.KIWI_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_LEAVES_ITEM = ITEMS.register("lemon_leaves", () -> new BlockItem(ModBlocks.LEMON_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_LEAVES_ITEM = ITEMS.register("lime_leaves", () -> new BlockItem(ModBlocks.LIME_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_LEAVES_ITEM = ITEMS.register("orange_leaves", () -> new BlockItem(ModBlocks.ORANGE_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_LEAVES_ITEM = ITEMS.register("peach_leaves", () -> new BlockItem(ModBlocks.PEACH_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_LEAVES_ITEM = ITEMS.register("pear_leaves", () -> new BlockItem(ModBlocks.PEAR_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> FRUITFUL_LEAVES_ITEM = ITEMS.register("fruitful_leaves", () -> new BlockItem(ModBlocks.FRUITFUL_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LEAVES_ITEM = ITEMS.register("alchemical_leaves", () -> new BlockItem(ModBlocks.ALCHEMICAL_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LEAVES_ITEM = ITEMS.register("benevolent_leaves", () -> new BlockItem(ModBlocks.BENEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LEAVES_ITEM = ITEMS.register("malevolent_leaves", () -> new BlockItem(ModBlocks.MALEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LEAVES_ITEM = ITEMS.register("conductive_leaves", () -> new BlockItem(ModBlocks.CONDUCTIVE_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LEAVES_ITEM = ITEMS.register("frostbitten_leaves", () -> new BlockItem(ModBlocks.FROSTBITTEN_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BANANA_LOG_ITEM = ITEMS.register("banana_log", () -> new BlockItem(ModBlocks.BANANA_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_LOG_ITEM = ITEMS.register("cherry_log", () -> new BlockItem(ModBlocks.CHERRY_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_LOG_ITEM = ITEMS.register("coconut_log", () -> new BlockItem(ModBlocks.COCONUT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_LOG_ITEM = ITEMS.register("kiwi_log", () -> new BlockItem(ModBlocks.KIWI_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_LOG_ITEM = ITEMS.register("lemon_log", () -> new BlockItem(ModBlocks.LEMON_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_LOG_ITEM = ITEMS.register("lime_log", () -> new BlockItem(ModBlocks.LIME_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_LOG_ITEM = ITEMS.register("orange_log", () -> new BlockItem(ModBlocks.ORANGE_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_LOG_ITEM = ITEMS.register("peach_log",	() -> new BlockItem(ModBlocks.PEACH_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_LOG_ITEM = ITEMS.register("pear_log", () -> new BlockItem(ModBlocks.PEAR_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA))); 
    public static final RegistryObject<Item> FRUITFUL_LOG_ITEM = ITEMS.register("fruitful_log", () -> new BlockItem(ModBlocks.FRUITFUL_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LOG_ITEM = ITEMS.register("alchemical_log", () -> new BlockItem(ModBlocks.ALCHEMICAL_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LOG_ITEM = ITEMS.register("benevolent_log", () -> new BlockItem(ModBlocks.BENEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LOG_ITEM = ITEMS.register("melvolent_log", () -> new BlockItem(ModBlocks.MALEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LOG_ITEM = ITEMS.register("conductive_log", () -> new BlockItem(ModBlocks.CONDUCTIVE_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LOG_ITEM = ITEMS.register("frostbitten_log", () -> new BlockItem(ModBlocks.FROSTBITTEN_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BANANA_PLANKS_ITEM = ITEMS.register("banana_planks", () -> new BlockItem(ModBlocks.BANANA_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_PLANKS_ITEM = ITEMS.register("cherry_planks", () -> new BlockItem(ModBlocks.CHERRY_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_PLANKS_ITEM = ITEMS.register("coconut_planks", () -> new BlockItem(ModBlocks.COCONUT_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_PLANKS_ITEM = ITEMS.register("kiwi_planks", () -> new BlockItem(ModBlocks.KIWI_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_PLANKS_ITEM = ITEMS.register("lemon_planks", () -> new BlockItem(ModBlocks.LEMON_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_PLANKS_ITEM = ITEMS.register("lime_planks", () -> new BlockItem(ModBlocks.LIME_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_PLANKS_ITEM = ITEMS.register("orange_planks", () -> new BlockItem(ModBlocks.ORANGE_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_PLANKS_ITEM = ITEMS.register("peach_planks", () -> new BlockItem(ModBlocks.PEACH_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_PLANKS_ITEM = ITEMS.register("pear_planks", () -> new BlockItem(ModBlocks.PEAR_PLANKS.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> BANANA_SLAB_ITEM = ITEMS.register("banana_slab", () -> new BlockItem(ModBlocks.BANANA_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_SLAB_ITEM = ITEMS.register("cherry_slab", () -> new BlockItem(ModBlocks.CHERRY_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_SLAB_ITEM = ITEMS.register("coconut_slab", () -> new BlockItem(ModBlocks.COCONUT_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_SLAB_ITEM = ITEMS.register("kiwi_slab", () -> new BlockItem(ModBlocks.KIWI_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_SLAB_ITEM = ITEMS.register("lemon_slab", () -> new BlockItem(ModBlocks.LEMON_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_SLAB_ITEM = ITEMS.register("lime_slab", () -> new BlockItem(ModBlocks.LIME_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_SLAB_ITEM = ITEMS.register("orange_slab", () -> new BlockItem(ModBlocks.ORANGE_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_SLAB_ITEM = ITEMS.register("peach_slab", () -> new BlockItem(ModBlocks.PEACH_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_SLAB_ITEM = ITEMS.register("pear_slab", () -> new BlockItem(ModBlocks.PEAR_SLAB.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> BANANA_SAPLING_ITEM = ITEMS.register("banana_sapling", () -> new BlockItem(ModBlocks.BANANA_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));  
    public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling", () -> new BlockItem(ModBlocks.CHERRY_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_SAPLING_ITEM = ITEMS.register("coconut_sapling", () -> new BlockItem(ModBlocks.COCONUT_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA))); 
    public static final RegistryObject<Item> KIWI_SAPLING_ITEM = ITEMS.register("kiwi_sapling", () -> new BlockItem(ModBlocks.KIWI_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
	public static final RegistryObject<Item> LEMON_SAPLING_ITEM = ITEMS.register("lemon_sapling", () -> new BlockItem(ModBlocks.LEMON_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));   	
    public static final RegistryObject<Item> LIME_SAPLING_ITEM = ITEMS.register("lime_sapling", () -> new BlockItem(ModBlocks.LIME_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));   
    public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = ITEMS.register("orange_sapling", () -> new BlockItem(ModBlocks.ORANGE_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));      
    public static final RegistryObject<Item> PEACH_SAPLING_ITEM = ITEMS.register("peach_sapling", () -> new BlockItem(ModBlocks.PEACH_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));    
    public static final RegistryObject<Item> PEAR_SAPLING_ITEM = ITEMS.register("pear_sapling", () -> new BlockItem(ModBlocks.PEAR_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ANCIENT_AMBROSIA_SAPLING_ITEM = ITEMS.register("ancient_ambrosia_sapling", () -> new BlockItem(ModBlocks.ANCIENT_AMBROSIA_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CRYOGENIC_SPIRE_SAPLING_ITEM = ITEMS.register("cryogenic_spire_sapling", () -> new BlockItem(ModBlocks.CRYOGENIC_SPIRE_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> THUNDEROUS_CONDUCTOR_SAPLING_ITEM = ITEMS.register("thunderous_conductor_sapling", () -> new BlockItem(ModBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> TOWERING_INFERNO_SAPLING_ITEM = ITEMS.register("towering_inferno_sapling", () -> new BlockItem(ModBlocks.TOWERING_INFERNO_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> SERENDIPITOUS_APOTHECARY_SAPLING_ITEM = ITEMS.register("serendipitous_apothecary_sapling", () -> new BlockItem(ModBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_APOTHECARY_SAPLING_ITEM = ITEMS.register("benevolent_apothecary_sapling", () -> new BlockItem(ModBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_APOTHECARY_SAPLING_ITEM = ITEMS.register("malevolent_apothecary_sapling", () -> new BlockItem(ModBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", () -> new BlockNamedItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new BlockNamedItem(ModBlocks.GRAPE_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds", () -> new BlockNamedItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> LITHIUM_CLAY_ITEM = ITEMS.register("lithium_clay", () -> new BlockItem(ModBlocks.LITHIUM_CLAY.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SALT_ITEM = ITEMS.register("salt", () -> new BlockItem(ModBlocks.SALT.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));   
    public static final RegistryObject<Item> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore", () -> new BlockItem(ModBlocks.BAUXITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CHROMITE_ORE_ITEM = ITEMS.register("chromite_ore", () -> new BlockItem(ModBlocks.CHROMITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ILMENITE_ORE_ITEM = ITEMS.register("ilmenite_ore", () -> new BlockItem(ModBlocks.ILMENITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PYROLUSITE_ORE_ITEM = ITEMS.register("pyrolusite_ore", () -> new BlockItem(ModBlocks.PYROLUSITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> COBALTITE_ORE_ITEM = ITEMS.register("cobaltite_ore", () -> new BlockItem(ModBlocks.COBALTITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> GARNIERITE_ORE_ITEM = ITEMS.register("garnierite_ore", () -> new BlockItem(ModBlocks.GARNIERITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BORAX_ORE_ITEM = ITEMS.register("borax_ore", () -> new BlockItem(ModBlocks.BORAX_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> MAGNESITE_ORE_ITEM = ITEMS.register("magnesite_ore", () -> new BlockItem(ModBlocks.MAGNESITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> SPODUMENE_ORE_ITEM = ITEMS.register("spodumene_ore", () -> new BlockItem(ModBlocks.SPODUMENE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));     
    public static final RegistryObject<Item> AQUAMARINE_CRYSTAL_ITEM = ITEMS.register("aquamarine_crystal", () -> new BlockItem(ModBlocks.AQUAMARINE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> DOLOMITE_CRYSTAL_ITEM = ITEMS.register("dolomite_crystal", () -> new BlockItem(ModBlocks.DOLOMITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> FLUORITE_CRYSTAL_ITEM = ITEMS.register("fluorite_crystal", () -> new BlockItem(ModBlocks.FLUORITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> ULEXITE_CRYSTAL_ITEM = ITEMS.register("ulexite_crystal", () -> new BlockItem(ModBlocks.ULEXITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
      
    public static final RegistryObject<Item> DISPLAY_CASE_ITEM = ITEMS.register("display_case", () -> new BlockItem(ModBlocks.DISPLAY_CASE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_DECORATIVE)));
    
    public static final RegistryObject<Item> SMALL_PULLEY_ITEM = ITEMS.register("small_pulley", () -> new BlockNamedItem(ModBlocks.SMALL_PULLEY.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    public static final RegistryObject<Item> MEDIUM_PULLEY_ITEM = ITEMS.register("medium_pulley", () -> new BlockNamedItem(ModBlocks.MEDIUM_PULLEY.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    public static final RegistryObject<Item> LARGE_PULLEY_ITEM = ITEMS.register("large_pulley", () -> new BlockNamedItem(ModBlocks.LARGE_PULLEY.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    
    public static final RegistryObject<Item> STEEL_SHAFT = ITEMS.register("steel_shaft", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    public static final RegistryObject<Item> PULLEY_BELT = ITEMS.register("pulley_belt", PulleyBeltItem::new);
    public static final RegistryObject<Item> LINE_SHAFT_HANGER_ITEM = ITEMS.register("line_shaft_hanger", () -> new BlockItem(ModBlocks.LINE_SHAFT_HANGER.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> KIWI = ITEMS.register("kiwi", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(2).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));  
   
    public static final RegistryObject<Item> BANANAS_FOSTER = ITEMS.register("bananas_foster", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLACK_FOREST_CAKE = ITEMS.register("black_forest_cake", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLUEBERRY_CHEESECAKE = ITEMS.register("blueberry_cheesecake", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> COCONUT_CREAM_PIE = ITEMS.register("coconut_cream_pie", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GRAPE_SHAVED_ICE = ITEMS.register("grape_shaved_ice", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> KEY_LIME_MOUSSE = ITEMS.register("key_lime_mousse", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> KIWI_SORBET = ITEMS.register("kiwi_sorbet", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LEMON_BAR = ITEMS.register("lemon_bar", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ORANGE_DREAMSICLE = ITEMS.register("orange_dreamsicle", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEACH_COBBLER = ITEMS.register("peach_cobbler", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAR_TART = ITEMS.register("pear_tart", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> STRAWBERRY_SHORTCAKE = ITEMS.register("strawberry_shortcake", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TECHNETIUM_INGOT = ITEMS.register("technetium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CAESIUM_INGOT = ITEMS.register("caesium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PRAESODYMIUM_INGOT = ITEMS.register("praesodymium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PROMETHIUM_INGOT = ITEMS.register("promethium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> POLONIUM_INGOT = ITEMS.register("polonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PROTACTINIUM_INGOT = ITEMS.register("protactinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NEPTUNIUM_INGOT = ITEMS.register("neptunium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PLUTONIUM_INGOT = ITEMS.register("plutonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> AMERICIUM_INGOT = ITEMS.register("americium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CURIUM_INGOT = ITEMS.register("curium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BERKELIUM_INGOT = ITEMS.register("berkelium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CALIFORNIUM_INGOT = ITEMS.register("californium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> EINSTEINIUM_INGOT = ITEMS.register("einsteinium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> FERMIUM_INGOT = ITEMS.register("fermium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MENDELEVIUM_INGOT = ITEMS.register("mendelevium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NOBELIUM_INGOT = ITEMS.register("nobelium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> LAWRENCIUM_INGOT = ITEMS.register("lawrencium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> RUTHERFORDIUM_INGOT = ITEMS.register("rutherfordium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> DUBNIUM_INGOT = ITEMS.register("dubnium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SEABORGIUM_INGOT = ITEMS.register("seaborgium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BOHRIUM_INGOT = ITEMS.register("bohrium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> HASSIUM_INGOT = ITEMS.register("hassium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MEITNERIUM_INGOT = ITEMS.register("meitnerium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> DARMSTADTIUM_INGOT = ITEMS.register("darmstadtium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ROENTGENIUM_INGOT = ITEMS.register("roentgenuim_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> COPERNICIUM_INGOT = ITEMS.register("copernicium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> NIHONIUM_INGOT = ITEMS.register("nihonium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> FLEVORIUM_INGOT = ITEMS.register("flevorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MOSCOVIUM_INGOT = ITEMS.register("moscovium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> LIVERMORIUM_INGOT = ITEMS.register("livermorium_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TENNESINE_INGOT = ITEMS.register("tennessine_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> OGANESSON_INGOT = ITEMS.register("oganesson_ingot", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    
    public static final RegistryObject<Item> LITHIUM_CLAY_BALL = ITEMS.register("lithium_clay_ball", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BORON_CHUNK = ITEMS.register("boron_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CARBON_CHUNK = ITEMS.register("carbon_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SILICON_CHUNK = ITEMS.register("silicon_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PHOSPHORUS_CHUNK = ITEMS.register("phosphorus_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SULFUR_CHUNK = ITEMS.register("sulfur_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> GERMANIUM_CHUNK = ITEMS.register("germanium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ARSENIC_CHUNK = ITEMS.register("arsenic_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SELENIUM_CHUNK = ITEMS.register("selenium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ANTIMONY_CHUNK = ITEMS.register("antimony_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TELLURIUM_CHUNK = ITEMS.register("tellurium_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> IODINE_CHUNK = ITEMS.register("iodine_chunk", () -> new Item(new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ASTATINE_CHUNK = ITEMS.register("astatine_chunk", () -> new Item(new Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
         
    public static final RegistryObject<Item> DUCK_SPAWN_EGG = ITEMS.register("duck_spawn_egg", () -> new ModSpawnEggItem(1)); 
    public static final RegistryObject<Item> GRIZZLY_BEAR_SPAWN_EGG = ITEMS.register("grizzly_bear_spawn_egg", () -> new ModSpawnEggItem(2));
    public static final RegistryObject<Item> OSTRICH_SPAWN_EGG = ITEMS.register("ostrich_spawn_egg", () -> new ModSpawnEggItem(3));
    public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg", () -> new ModSpawnEggItem(4));
    public static final RegistryObject<Item> ZEBRA_SPAWN_EGG = ITEMS.register("zebra_spawn_egg", () -> new ModSpawnEggItem(5));
    
    public static final RegistryObject<Item> BRINE_BUCKET = ITEMS.register("brine_bucket", () -> new BucketItem(ModFluids.BRINE_SOURCE, new Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL).maxStackSize(1)));
    public static final RegistryObject<Item> MERCURY_BUCKET = ITEMS.register("mercury_bucket", () -> new BucketItem(ModFluids.MERCURY_SOURCE, new Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL).maxStackSize(1)));
    public static final RegistryObject<Item> HYDROGEN_BUCKET = ITEMS.register("hydrogen_bucket", () -> new BucketItem(ModFluids.HYDROGEN_SOURCE, new Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL).maxStackSize(1)));
    
    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    public static final RegistryObject<Item> PIPE_WRENCH = ITEMS.register("pipe_wrench", () -> new PipeWrenchItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench", () -> new PickaxeItem(ItemTier.IRON, 1, -2.8F, (new Item.Properties()).group(ModItemGroup.TECHNOLOGICA_MACHINERY)));
    
    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
	
