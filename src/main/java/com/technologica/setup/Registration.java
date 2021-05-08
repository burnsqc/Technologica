package com.technologica.setup;

import static com.technologica.MainMod.MODID;

import com.technologica.block.DisplayCaseBlock;
import com.technologica.block.ModCropsBlock;
import com.technologica.block.ModCrystalBlock;
import com.technologica.block.ModLeavesBlock;
import com.technologica.block.ModLogBlock;
import com.technologica.block.ModMagicLeavesBlock;
import com.technologica.block.ModOreBlock;
import com.technologica.block.ModPotionLeavesBlock;
import com.technologica.block.ModSaplingBlock;
import com.technologica.block.trees.AncientAmbrosiaTree;
import com.technologica.block.trees.BananaTree;
import com.technologica.block.trees.BenevolentApothecaryTree;
import com.technologica.block.trees.CherryTree;
import com.technologica.block.trees.CoconutTree;
import com.technologica.block.trees.CryogenicSpireTree;
import com.technologica.block.trees.KiwiTree;
import com.technologica.block.trees.LemonTree;
import com.technologica.block.trees.LimeTree;
import com.technologica.block.trees.MalevolentApothecaryTree;
import com.technologica.block.trees.OrangeTree;
import com.technologica.block.trees.PeachTree;
import com.technologica.block.trees.PearTree;
import com.technologica.block.trees.SerendipitousApothecaryTree;
import com.technologica.block.trees.ThunderousConductorTree;
import com.technologica.block.trees.ToweringInfernoTree;
import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.ZebraEntity;
import com.technologica.fluid.FluidRegistration;
import com.technologica.items.ModSpawnEggItem;
import com.technologica.tileentity.DisplayCaseTileEntity;
import com.technologica.tileentity.FruitTileEntity;
import com.technologica.tileentity.PotionTileEntity;
import com.technologica.world.gen.feature.OasisFeature;
import com.technologica.world.gen.foliageplacer.ConicalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.CylindricalFoliagePlacer;
import com.technologica.world.gen.foliageplacer.DishFoliagePlacer;
import com.technologica.world.gen.foliageplacer.PalmFoliagePlacer;
import com.technologica.world.gen.foliageplacer.TeardropFoliagePlacer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration 
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);
    private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, MODID);
    private static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MODID);
    
    public static void init() 
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
        FOLIAGES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
        PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
       
//BLOCKS
    public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves", () -> new ModLeavesBlock(1));
    public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new ModLeavesBlock(2));
    public static final RegistryObject<Block> COCONUT_LEAVES = BLOCKS.register("coconut_leaves", () -> new ModLeavesBlock(3));         
    public static final RegistryObject<Block> KIWI_LEAVES = BLOCKS.register("kiwi_leaves", () -> new ModLeavesBlock(4));
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new ModLeavesBlock(5));
    public static final RegistryObject<Block> LIME_LEAVES = BLOCKS.register("lime_leaves", () -> new ModLeavesBlock(6));   
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new ModLeavesBlock(7)); 
    public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", () -> new ModLeavesBlock(8)); 
    public static final RegistryObject<Block> PEAR_LEAVES = BLOCKS.register("pear_leaves", () -> new ModLeavesBlock(9));
    public static final RegistryObject<Block> FRUITFUL_LEAVES = BLOCKS.register("fruitful_leaves", () -> new ModLeavesBlock(10));
    public static final RegistryObject<Block> ALCHEMICAL_LEAVES = BLOCKS.register("alchemical_leaves", () -> new ModLeavesBlock(11));
    
    public static final RegistryObject<Block> BENEVOLENT_LEAVES = BLOCKS.register("benevolent_leaves", () -> new ModPotionLeavesBlock(1));
    public static final RegistryObject<Block> MALEVOLENT_LEAVES = BLOCKS.register("malevolent_leaves", () -> new ModPotionLeavesBlock(2));
    
    public static final RegistryObject<Block> CONDUCTIVE_LEAVES = BLOCKS.register("conductive_leaves", () -> new ModMagicLeavesBlock(1));
    public static final RegistryObject<Block> FROSTBITTEN_LEAVES = BLOCKS.register("frostbitten_leaves", () -> new ModMagicLeavesBlock(2)); 
       
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", ModLogBlock::new);
    public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", ModLogBlock::new);
    public static final RegistryObject<Block> COCONUT_LOG = BLOCKS.register("coconut_log", ModLogBlock::new);
    public static final RegistryObject<Block> KIWI_LOG = BLOCKS.register("kiwi_log", ModLogBlock::new);
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", ModLogBlock::new);
    public static final RegistryObject<Block> LIME_LOG = BLOCKS.register("lime_log", ModLogBlock::new);
    public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEACH_LOG = BLOCKS.register("peach_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEAR_LOG = BLOCKS.register("pear_log", ModLogBlock::new);
    public static final RegistryObject<Block> FRUITFUL_LOG = BLOCKS.register("fruitful_log", ModLogBlock::new);
    public static final RegistryObject<Block> ALCHEMICAL_LOG = BLOCKS.register("alchemical_log", ModLogBlock::new); 
    public static final RegistryObject<Block> BENEVOLENT_LOG = BLOCKS.register("benevolent_log", ModLogBlock::new);
    public static final RegistryObject<Block> MALEVOLENT_LOG = BLOCKS.register("malevolent_log", ModLogBlock::new);
    public static final RegistryObject<Block> CONDUCTIVE_LOG = BLOCKS.register("conductive_log", ModLogBlock::new);
    public static final RegistryObject<Block> FROSTBITTEN_LOG = BLOCKS.register("frostbitten_log", ModLogBlock::new);
         
    public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new ModSaplingBlock(new BananaTree()));
    public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new ModSaplingBlock(new CherryTree()));
    public static final RegistryObject<Block> COCONUT_SAPLING = BLOCKS.register("coconut_sapling", () -> new ModSaplingBlock(new CoconutTree()));
    public static final RegistryObject<Block> KIWI_SAPLING = BLOCKS.register("kiwi_sapling", () -> new ModSaplingBlock(new KiwiTree()));
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new ModSaplingBlock(new LemonTree()));
    public static final RegistryObject<Block> LIME_SAPLING = BLOCKS.register("lime_sapling", () -> new ModSaplingBlock(new LimeTree()));
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new ModSaplingBlock(new OrangeTree()));
    public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> new ModSaplingBlock(new PeachTree()));
    public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new ModSaplingBlock(new PearTree()));
    public static final RegistryObject<Block> ANCIENT_AMBROSIA_SAPLING = BLOCKS.register("ancient_ambrosia_sapling", () -> new ModSaplingBlock(new AncientAmbrosiaTree()));
    public static final RegistryObject<Block> SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("serendipitous_apothecary_sapling", () -> new ModSaplingBlock(new SerendipitousApothecaryTree()));
    public static final RegistryObject<Block> BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("benevolent_apothecary_sapling", () -> new ModSaplingBlock(new BenevolentApothecaryTree()));
    public static final RegistryObject<Block> MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("malevolent_apothecary_sapling", () -> new ModSaplingBlock(new MalevolentApothecaryTree()));
    public static final RegistryObject<Block> TOWERING_INFERNO_SAPLING = BLOCKS.register("towering_inferno_sapling", () -> new ModSaplingBlock(new ToweringInfernoTree()));
    public static final RegistryObject<Block> THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("thunderous_conductor_sapling", () -> new ModSaplingBlock(new ThunderousConductorTree()));
    public static final RegistryObject<Block> CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("cryogenic_spire_sapling", () -> new ModSaplingBlock(new CryogenicSpireTree()));
    	
    public static final RegistryObject<Block> POTTED_BANANA_SAPLING = BLOCKS.register("potted_banana_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BANANA_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = BLOCKS.register("potted_cherry_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHERRY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_COCONUT_SAPLING = BLOCKS.register("potted_coconut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, COCONUT_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_KIWI_SAPLING = BLOCKS.register("potted_kiwi_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, KIWI_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_LEMON_SAPLING = BLOCKS.register("potted_lemon_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LEMON_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_LIME_SAPLING = BLOCKS.register("potted_lime_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LIME_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_ORANGE_SAPLING = BLOCKS.register("potted_orange_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_PEACH_SAPLING = BLOCKS.register("potted_peach_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEACH_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_PEAR_SAPLING = BLOCKS.register("potted_pear_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEAR_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop", () -> new ModCropsBlock(1));
    public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop", () -> new ModCropsBlock(2));
    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop", () -> new ModCropsBlock(3));
    
    public static final RegistryObject<Block> LITHIUM_CLAY = BLOCKS.register("lithium_clay", () -> new Block(AbstractBlock.Properties.create(Material.CLAY).hardnessAndResistance(0.6F).sound(SoundType.GROUND)));
    public static final RegistryObject<Block> SALT = BLOCKS.register("salt", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)));
    
    public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> CHROMITE_ORE = BLOCKS.register("chromite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> ILMENITE_ORE = BLOCKS.register("ilmenite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> PYROLUSITE_ORE = BLOCKS.register("pyrolusite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> COBALTITE_ORE = BLOCKS.register("cobaltite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> GARNIERITE_ORE = BLOCKS.register("garnierite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> BORAX_ORE = BLOCKS.register("borax_ore", ModOreBlock::new);
    public static final RegistryObject<Block> MAGNESITE_ORE = BLOCKS.register("magnesite_ore", ModOreBlock::new);
    public static final RegistryObject<Block> SPODUMENE_ORE = BLOCKS.register("spodumene_ore", ModOreBlock::new); 
    
    public static final RegistryObject<Block> AQUAMARINE_CRYSTAL = BLOCKS.register("aquamarine_crystal", ModCrystalBlock::new);
    public static final RegistryObject<Block> DOLOMITE_CRYSTAL = BLOCKS.register("dolomite_crystal", ModCrystalBlock::new);
    public static final RegistryObject<Block> FLUORITE_CRYSTAL = BLOCKS.register("fluorite_crystal", ModCrystalBlock::new);
    public static final RegistryObject<Block> ULEXITE_CRYSTAL = BLOCKS.register("ulexite_crystal", ModCrystalBlock::new);
    
    public static final RegistryObject<FlowingFluidBlock> BRINE = BLOCKS.register("brine", () -> new FlowingFluidBlock(FluidRegistration.BRINE_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    
    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", DisplayCaseBlock::new);   
    
//ITEMBLOCKS
    public static final RegistryObject<Item> BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves", () -> new BlockItem(BANANA_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves", () -> new BlockItem(CHERRY_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_LEAVES_ITEM = ITEMS.register("coconut_leaves", () -> new BlockItem(COCONUT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_LEAVES_ITEM = ITEMS.register("kiwi_leaves", () -> new BlockItem(KIWI_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_LEAVES_ITEM = ITEMS.register("lemon_leaves", () -> new BlockItem(LEMON_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_LEAVES_ITEM = ITEMS.register("lime_leaves", () -> new BlockItem(LIME_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_LEAVES_ITEM = ITEMS.register("orange_leaves", () -> new BlockItem(ORANGE_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_LEAVES_ITEM = ITEMS.register("peach_leaves", () -> new BlockItem(PEACH_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_LEAVES_ITEM = ITEMS.register("pear_leaves", () -> new BlockItem(PEAR_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> FRUITFUL_LEAVES_ITEM = ITEMS.register("fruitful_leaves", () -> new BlockItem(FRUITFUL_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LEAVES_ITEM = ITEMS.register("alchemical_leaves", () -> new BlockItem(ALCHEMICAL_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LEAVES_ITEM = ITEMS.register("benevolent_leaves", () -> new BlockItem(BENEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LEAVES_ITEM = ITEMS.register("malevolent_leaves", () -> new BlockItem(MALEVOLENT_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LEAVES_ITEM = ITEMS.register("conductive_leaves", () -> new BlockItem(CONDUCTIVE_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LEAVES_ITEM = ITEMS.register("frostbitten_leaves", () -> new BlockItem(FROSTBITTEN_LEAVES.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BANANA_LOG_ITEM = ITEMS.register("banana_log", () -> new BlockItem(BANANA_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_LOG_ITEM = ITEMS.register("cherry_log", () -> new BlockItem(CHERRY_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_LOG_ITEM = ITEMS.register("coconut_log", () -> new BlockItem(COCONUT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> KIWI_LOG_ITEM = ITEMS.register("kiwi_log", () -> new BlockItem(KIWI_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_LOG_ITEM = ITEMS.register("lemon_log", () -> new BlockItem(LEMON_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_LOG_ITEM = ITEMS.register("lime_log", () -> new BlockItem(LIME_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_LOG_ITEM = ITEMS.register("orange_log", () -> new BlockItem(ORANGE_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_LOG_ITEM = ITEMS.register("peach_log",	() -> new BlockItem(PEACH_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEAR_LOG_ITEM = ITEMS.register("pear_log", () -> new BlockItem(PEAR_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA))); 
    public static final RegistryObject<Item> FRUITFUL_LOG_ITEM = ITEMS.register("fruitful_log", () -> new BlockItem(FRUITFUL_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> ALCHEMICAL_LOG_ITEM = ITEMS.register("alchemical_log", () -> new BlockItem(ALCHEMICAL_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_LOG_ITEM = ITEMS.register("benevolent_log", () -> new BlockItem(BENEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_LOG_ITEM = ITEMS.register("melvolent_log", () -> new BlockItem(MALEVOLENT_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CONDUCTIVE_LOG_ITEM = ITEMS.register("conductive_log", () -> new BlockItem(CONDUCTIVE_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> FROSTBITTEN_LOG_ITEM = ITEMS.register("frostbitten_log", () -> new BlockItem(FROSTBITTEN_LOG.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BANANA_SAPLING_ITEM = 						ITEMS.register("banana_sapling", () -> 						new BlockItem(BANANA_SAPLING.get(), 					new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));  
    public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = 						ITEMS.register("cherry_sapling", () -> 						new BlockItem(CHERRY_SAPLING.get(), 					new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_SAPLING_ITEM = 					ITEMS.register("coconut_sapling", () -> 					new BlockItem(COCONUT_SAPLING.get(), 					new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA))); 
    public static final RegistryObject<Item> KIWI_SAPLING_ITEM = 						ITEMS.register("kiwi_sapling", () -> 						new BlockItem(KIWI_SAPLING.get(), 						new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
	public static final RegistryObject<Item> LEMON_SAPLING_ITEM = 						ITEMS.register("lemon_sapling", () -> 						new BlockItem(LEMON_SAPLING.get(), 						new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));   	
    public static final RegistryObject<Item> LIME_SAPLING_ITEM = 						ITEMS.register("lime_sapling", () -> 						new BlockItem(LIME_SAPLING.get(), 						new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));   
    public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = 						ITEMS.register("orange_sapling", () -> 						new BlockItem(ORANGE_SAPLING.get(), 					new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));      
    public static final RegistryObject<Item> PEACH_SAPLING_ITEM = 						ITEMS.register("peach_sapling", () -> 						new BlockItem(PEACH_SAPLING.get(), 						new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));    
    public static final RegistryObject<Item> PEAR_SAPLING_ITEM = 						ITEMS.register("pear_sapling", () -> 						new BlockItem(PEAR_SAPLING.get(), 						new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ANCIENT_AMBROSIA_SAPLING_ITEM = 			ITEMS.register("ancient_ambrosia_sapling", () -> 			new BlockItem(ANCIENT_AMBROSIA_SAPLING.get(), 			new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> CRYOGENIC_SPIRE_SAPLING_ITEM = 			ITEMS.register("cryogenic_spire_sapling", () -> 			new BlockItem(CRYOGENIC_SPIRE_SAPLING.get(), 			new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> THUNDEROUS_CONDUCTOR_SAPLING_ITEM = 		ITEMS.register("thunderous_conductor_sapling", () -> 		new BlockItem(THUNDEROUS_CONDUCTOR_SAPLING.get(), 		new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> TOWERING_INFERNO_SAPLING_ITEM = 			ITEMS.register("towering_inferno_sapling", () -> 			new BlockItem(TOWERING_INFERNO_SAPLING.get(), 			new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> SERENDIPITOUS_APOTHECARY_SAPLING_ITEM =	ITEMS.register("serendipitous_apothecary_sapling", () -> 	new BlockItem(SERENDIPITOUS_APOTHECARY_SAPLING.get(), 	new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> BENEVOLENT_APOTHECARY_SAPLING_ITEM = 		ITEMS.register("benevolent_apothecary_sapling", () -> 		new BlockItem(BENEVOLENT_APOTHECARY_SAPLING.get(), 		new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    public static final RegistryObject<Item> MALEVOLENT_APOTHECARY_SAPLING_ITEM = 		ITEMS.register("malevolent_apothecary_sapling", () -> 		new BlockItem(MALEVOLENT_APOTHECARY_SAPLING.get(), 		new Item.Properties().group(ModItemGroup.TECHNOLOGICA_CRYPTICA)));
    
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", () -> new BlockNamedItem(BLUEBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new BlockNamedItem(GRAPE_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds", () -> new BlockNamedItem(STRAWBERRY_CROP.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> LITHIUM_CLAY_ITEM = ITEMS.register("lithium_clay", () -> new BlockItem(LITHIUM_CLAY.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SALT_ITEM = ITEMS.register("salt", () -> new BlockItem(SALT.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));   
    public static final RegistryObject<Item> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore", () -> new BlockItem(BAUXITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CHROMITE_ORE_ITEM = ITEMS.register("chromite_ore", () -> new BlockItem(CHROMITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ILMENITE_ORE_ITEM = ITEMS.register("ilmenite_ore", () -> new BlockItem(ILMENITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> PYROLUSITE_ORE_ITEM = ITEMS.register("pyrolusite_ore", () -> new BlockItem(PYROLUSITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> COBALTITE_ORE_ITEM = ITEMS.register("cobaltite_ore", () -> new BlockItem(COBALTITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> GARNIERITE_ORE_ITEM = ITEMS.register("garnierite_ore", () -> new BlockItem(GARNIERITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BORAX_ORE_ITEM = ITEMS.register("borax_ore", () -> new BlockItem(BORAX_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> MAGNESITE_ORE_ITEM = ITEMS.register("magnesite_ore", () -> new BlockItem(MAGNESITE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> SPODUMENE_ORE_ITEM = ITEMS.register("spodumene_ore", () -> new BlockItem(SPODUMENE_ORE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));     
    public static final RegistryObject<Item> AQUAMARINE_CRYSTAL_ITEM = ITEMS.register("aquamarine_crystal", () -> new BlockItem(AQUAMARINE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> DOLOMITE_CRYSTAL_ITEM = ITEMS.register("dolomite_crystal", () -> new BlockItem(DOLOMITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> FLUORITE_CRYSTAL_ITEM = ITEMS.register("fluorite_crystal", () -> new BlockItem(FLUORITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
    public static final RegistryObject<Item> ULEXITE_CRYSTAL_ITEM = ITEMS.register("ulexite_crystal", () -> new BlockItem(ULEXITE_CRYSTAL.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL))); 
      
    public static final RegistryObject<Item> DISPLAY_CASE_ITEM = ITEMS.register("display_case", () -> new BlockItem(DISPLAY_CASE.get(), new Item.Properties().group(ModItemGroup.TECHNOLOGICA_DECORATIVE)));
    
//ITEMS
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
    public static final RegistryObject<Item> SHARK_SPAWN_EGG = ITEMS.register("shark_spawn_egg", () -> new ModSpawnEggItem(3));
    public static final RegistryObject<Item> ZEBRA_SPAWN_EGG = ITEMS.register("zebra_spawn_egg", () -> new ModSpawnEggItem(4));
    
    public static final RegistryObject<Item> BRINE_BUCKET = ITEMS.register("brine_bucket", () -> new BucketItem(FluidRegistration.BRINE_SOURCE, new Properties().group(ModItemGroup.TECHNOLOGICA_MINERAL).maxStackSize(1)));

//ENTITIES
    public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<DuckEntity>create(DuckEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).build("duck"));
    public static final RegistryObject<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBearEntity>create(GrizzlyBearEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F).trackingRange(10).build("grizzly_bear"));
    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<SharkEntity>create(SharkEntity::new, EntityClassification.CREATURE).size(0.9F, 0.6F).trackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<ZebraEntity>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<ZebraEntity>create(ZebraEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("zebra"));
    
//FEATURES
    public static final RegistryObject<Feature<BlockStateFeatureConfig>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateFeatureConfig.field_236455_a_));
    
//FOLIAGE PLACERS
    public static final RegistryObject<FoliagePlacerType<?>> CONICAL = FOLIAGES.register("conical_foliage_placer", () -> new FoliagePlacerType<>(ConicalFoliagePlacer.conicalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> CYLINDRICAL = FOLIAGES.register("cylindrical_foliage_placer", () -> new FoliagePlacerType<>(CylindricalFoliagePlacer.cylindricalCodec));
    public static final RegistryObject<FoliagePlacerType<?>> DISH = FOLIAGES.register("dish_foliage_placer", () -> new FoliagePlacerType<>(DishFoliagePlacer.dishCodec));
    public static final RegistryObject<FoliagePlacerType<?>> PALM = FOLIAGES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.palmCodec));
    public static final RegistryObject<FoliagePlacerType<?>> TEARDROP = FOLIAGES.register("teardrop_foliage_placer", () -> new FoliagePlacerType<>(TeardropFoliagePlacer.teardropCodec));    
    
//TILE ENTITIES
    public static final RegistryObject<TileEntityType<FruitTileEntity>> FRUIT_CROP = TILES.register("fruit_crop", () -> TileEntityType.Builder.create(FruitTileEntity::new, BANANA_LEAVES.get(), CHERRY_LEAVES.get(), COCONUT_LEAVES.get(), KIWI_LEAVES.get(), LEMON_LEAVES.get(), LIME_LEAVES.get(), ORANGE_LEAVES.get(), PEACH_LEAVES.get(), PEAR_LEAVES.get(), FRUITFUL_LEAVES.get(), ALCHEMICAL_LEAVES.get()).build(null));
    public static final RegistryObject<TileEntityType<PotionTileEntity>> POTION_CROP = TILES.register("potion_crop", () -> TileEntityType.Builder.create(PotionTileEntity::new, BENEVOLENT_LEAVES.get(), MALEVOLENT_LEAVES.get()).build(null));
    public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_TILE = TILES.register("display_tile", () -> TileEntityType.Builder.create(DisplayCaseTileEntity::new, DISPLAY_CASE.get()).build(null));
}