package com.technologica.setup;

import static com.technologica.MainMod.MODID;

import com.technologica.block.ModCropsBlock;
import com.technologica.block.ModLeavesBlock;
import com.technologica.block.ModLogBlock;
import com.technologica.block.ModOreBlock;
import com.technologica.block.ModSaplingBlock;
import com.technologica.block.trees.BananaTree;
import com.technologica.block.trees.CherryTree;
import com.technologica.block.trees.CoconutTree;
import com.technologica.block.trees.LemonTree;
import com.technologica.block.trees.LimeTree;
import com.technologica.block.trees.OrangeTree;
import com.technologica.block.trees.PeachTree;
import com.technologica.block.trees.PearTree;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration 
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
       
    public static void init() 
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());                            
    }

    //------------
    // BLOCKS
    //------------
    public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", ModLogBlock::new);
    public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new ModSaplingBlock(new BananaTree()));
    
    public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", ModLogBlock::new);
    public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new ModSaplingBlock(new CherryTree()));
    
    public static final RegistryObject<Block> COCONUT_LEAVES = BLOCKS.register("coconut_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> COCONUT_LOG = BLOCKS.register("coconut_log", ModLogBlock::new);
    public static final RegistryObject<Block> COCONUT_SAPLING = BLOCKS.register("coconut_sapling", () -> new ModSaplingBlock(new CoconutTree()));
    
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", ModLogBlock::new);
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new ModSaplingBlock(new LemonTree()));
    
    public static final RegistryObject<Block> LIME_LEAVES = BLOCKS.register("lime_leaves", ModLeavesBlock::new);    
    public static final RegistryObject<Block> LIME_LOG = BLOCKS.register("lime_log", ModLogBlock::new);
    public static final RegistryObject<Block> LIME_SAPLING = BLOCKS.register("lime_sapling", () -> new ModSaplingBlock(new LimeTree()));
    
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", ModLeavesBlock::new); 
    public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", ModLogBlock::new);
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new ModSaplingBlock(new OrangeTree()));
    
    public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", ModLeavesBlock::new); 
    public static final RegistryObject<Block> PEACH_LOG = BLOCKS.register("peach_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> new ModSaplingBlock(new PeachTree()));
    
    public static final RegistryObject<Block> PEAR_LEAVES = BLOCKS.register("pear_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> PEAR_LOG = BLOCKS.register("pear_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new ModSaplingBlock(new PearTree()));
                                  
    public static final RegistryObject<Block> SPODUMENE_ORE = BLOCKS.register("spodumene_ore", ModOreBlock::new);    

    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop", ModCropsBlock::new);
    
    //------------
    // ITEMBLOCKS
    //------------
    public static final RegistryObject<Item> BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves", () -> new BlockItem(BANANA_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> BANANA_LOG_ITEM = ITEMS.register("banana_log", () -> new BlockItem(BANANA_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> BANANA_SAPLING_ITEM = ITEMS.register("banana_sapling", () -> new BlockItem(BANANA_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));  
    
    public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves", () -> new BlockItem(CHERRY_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_LOG_ITEM = ITEMS.register("cherry_log", () -> new BlockItem(CHERRY_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling", () -> new BlockItem(CHERRY_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));  
    
    public static final RegistryObject<Item> COCONUT_LEAVES_ITEM = ITEMS.register("coconut_leaves", () -> new BlockItem(COCONUT_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_LOG_ITEM = ITEMS.register("coconut_log", () -> new BlockItem(COCONUT_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> COCONUT_SAPLING_ITEM = ITEMS.register("coconut_sapling", () -> new BlockItem(COCONUT_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));   
    
    public static final RegistryObject<Item> LEMON_LEAVES_ITEM = ITEMS.register("lemon_leaves", () -> new BlockItem(LEMON_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_LOG_ITEM = ITEMS.register("lemon_log", () -> new BlockItem(LEMON_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LEMON_SAPLING_ITEM = ITEMS.register("lemon_sapling", () -> new BlockItem(LEMON_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));   
    
    public static final RegistryObject<Item> LIME_LEAVES_ITEM = ITEMS.register("lime_leaves", () -> new BlockItem(LIME_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_LOG_ITEM = ITEMS.register("lime_log", () -> new BlockItem(LIME_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> LIME_SAPLING_ITEM = ITEMS.register("lime_sapling", () -> new BlockItem(LIME_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> ORANGE_LEAVES_ITEM = ITEMS.register("orange_leaves", () -> new BlockItem(ORANGE_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_LOG_ITEM = ITEMS.register("orange_log", () -> new BlockItem(ORANGE_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = ITEMS.register("orange_sapling", () -> new BlockItem(ORANGE_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));  
    
    public static final RegistryObject<Item> PEACH_LEAVES_ITEM = ITEMS.register("peach_leaves", () -> new BlockItem(PEACH_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_LOG_ITEM = ITEMS.register("peach_log", () -> new BlockItem(PEACH_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    public static final RegistryObject<Item> PEACH_SAPLING_ITEM = ITEMS.register("peach_sapling", () -> new BlockItem(PEACH_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> PEAR_LEAVES_ITEM = ITEMS.register("pear_leaves", () -> new BlockItem(PEAR_LEAVES.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));    
    public static final RegistryObject<Item> PEAR_LOG_ITEM = ITEMS.register("pear_log", () -> new BlockItem(PEAR_LOG.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA))); 
    public static final RegistryObject<Item> PEAR_SAPLING_ITEM = ITEMS.register("pear_sapling", () -> new BlockItem(PEAR_SAPLING.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    
    public static final RegistryObject<Item> SPODUMENE_ORE_ITEM = ITEMS.register("spodumene_ore", () -> new BlockItem(SPODUMENE_ORE.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));    
    
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds", () -> new BlockNamedItem(BLUEBERRY_CROP.get(), new Item.Properties().group(ModSetup.TECHNOLOGICA_FLORA)));
    
    //------------
    // ITEMS
    //------------
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(4).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(3).saturation(0.1F).setAlwaysEdible().build())));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_FOOD).food(new Food.Builder().hunger(1).saturation(0.1F).setAlwaysEdible().fastToEat().build())));   
    
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CALCIUM_INGOT = ITEMS.register("calcium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));
    public static final RegistryObject<Item> CAESIUM_INGOT = ITEMS.register("caesium_ingot", () -> new Item(new Item.Properties().group(ModSetup.TECHNOLOGICA_MINERAL)));   
    
    
    
}