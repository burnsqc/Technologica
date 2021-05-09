package com.technologica.block;

import static com.technologica.Technologica.MODID;

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
import com.technologica.fluid.ModFluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	
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
         
    public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new SaplingBlock(new BananaTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new SaplingBlock(new CherryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> COCONUT_SAPLING = BLOCKS.register("coconut_sapling", () -> new SaplingBlock(new CoconutTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> KIWI_SAPLING = BLOCKS.register("kiwi_sapling", () -> new SaplingBlock(new KiwiTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new SaplingBlock(new LemonTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> LIME_SAPLING = BLOCKS.register("lime_sapling", () -> new SaplingBlock(new LimeTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new SaplingBlock(new OrangeTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> new SaplingBlock(new PeachTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new SaplingBlock(new PearTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> ANCIENT_AMBROSIA_SAPLING = BLOCKS.register("ancient_ambrosia_sapling", () -> new SaplingBlock(new AncientAmbrosiaTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("serendipitous_apothecary_sapling", () -> new SaplingBlock(new SerendipitousApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("benevolent_apothecary_sapling", () -> new SaplingBlock(new BenevolentApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("malevolent_apothecary_sapling", () -> new SaplingBlock(new MalevolentApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> TOWERING_INFERNO_SAPLING = BLOCKS.register("towering_inferno_sapling", () -> new SaplingBlock(new ToweringInfernoTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("thunderous_conductor_sapling", () -> new SaplingBlock(new ThunderousConductorTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("cryogenic_spire_sapling", () -> new SaplingBlock(new CryogenicSpireTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    	
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
    
    public static final RegistryObject<FlowingFluidBlock> BRINE = BLOCKS.register("brine", () -> new FlowingFluidBlock(ModFluids.BRINE_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    
    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", DisplayCaseBlock::new);   
	
	public static void register() 
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
