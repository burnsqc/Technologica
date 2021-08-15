package com.technologica.block;

import static com.technologica.Technologica.MODID;

import com.technologica.block.trees.AncientAmbrosiaTree;
import com.technologica.block.trees.AspenTree;
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
import com.technologica.item.ModItems;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	
	/**
	 * FLORA
	 */
	
    public static final RegistryObject<Block> ASPARAGUS_CROP = BLOCKS.register("asparagus_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BARLEY_CROP = BLOCKS.register("barley_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BLACKBERRY_CROP = BLOCKS.register("blackberry_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> BROCCOLI_CROP = BLOCKS.register("broccoli_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> CELERY_CROP = BLOCKS.register("celery_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COFFEE_BEAN_CROP = BLOCKS.register("coffee_bean_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));    
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", () -> new TallCropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COTTON_CROP = BLOCKS.register("cotton_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> CUCUMBER_CROP = BLOCKS.register("cucumber_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> GINGER_CROP = BLOCKS.register("ginger_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> LETTUCE_CROP = BLOCKS.register("lettuce_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> MUSTARD_GREENS_CROP = BLOCKS.register("mustard_greens_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> OATS_CROP = BLOCKS.register("oats_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> PEA_CROP = BLOCKS.register("pea_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> PEANUT_CROP = BLOCKS.register("peanut_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> PEPPERCORN_CROP = BLOCKS.register("peppercorn_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> PURPLE_CABBAGE_CROP = BLOCKS.register("purple_cabbage_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RADISH_CROP = BLOCKS.register("radish_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RASPBERRY_CROP = BLOCKS.register("raspberry_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RED_BEAN_CROP = BLOCKS.register("red_bean_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop", () -> new WaterCropsBlockBottom(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RYE_CROP = BLOCKS.register("rye_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SOYBEAN_CROP = BLOCKS.register("soybean_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SQUASH_CROP = BLOCKS.register("squash_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SWEET_POTATO_CROP = BLOCKS.register("sweet_potato_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
//    public static final RegistryObject<Block> TEA_CROP = BLOCKS.register("tea_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> TURNIP_CROP = BLOCKS.register("turnip_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<Block> ZUCCHINI_CROP = BLOCKS.register("zucchini_crop", () -> new CropsBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP)));
	
//    public static final RegistryObject<Block> APRICOT_SAPLING = BLOCKS.register("apricot_sapling", () -> new SaplingBlock(new ApricotTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
    public static final RegistryObject<Block> ASPEN_SAPLING = BLOCKS.register("aspen_sapling", () -> new SaplingBlock(new AspenTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
//    public static final RegistryObject<Block> AVACADO_SAPLING = BLOCKS.register("avacado_sapling", () -> new SaplingBlock(new AvacadoTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
    public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new SaplingBlock(new BananaTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new SaplingBlock(new CherryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
//    public static final RegistryObject<Block> CHESTNUT_SAPLING = BLOCKS.register("chestnut_sapling", () -> new SaplingBlock(new ChestnutTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
	public static final RegistryObject<Block> COCONUT_SAPLING = BLOCKS.register("coconut_sapling", () -> new SaplingBlock(new CoconutTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
//    public static final RegistryObject<Block> EBONY_SAPLING = BLOCKS.register("ebony_sapling", () -> new SaplingBlock(new EbonyTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
	public static final RegistryObject<Block> KIWI_SAPLING = BLOCKS.register("kiwi_sapling", () -> new SaplingBlock(new KiwiTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new SaplingBlock(new LemonTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> LIME_SAPLING = BLOCKS.register("lime_sapling", () -> new SaplingBlock(new LimeTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
//    public static final RegistryObject<Block> MAHOGANY_SAPLING = BLOCKS.register("mahogany_sapling", () -> new SaplingBlock(new MahoganyTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
//    public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> new SaplingBlock(new MapleTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
	public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new SaplingBlock(new OrangeTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));	
	public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> new SaplingBlock(new PeachTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new SaplingBlock(new PearTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
//    public static final RegistryObject<Block> PLUM_SAPLING = BLOCKS.register("plum_sapling", () -> new SaplingBlock(new PlumTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
//    public static final RegistryObject<Block> REDWOOD_SAPLING = BLOCKS.register("redwood_sapling", () -> new SaplingBlock(new RedwoodTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
//    public static final RegistryObject<Block> RUBBER_SAPLING = BLOCKS.register("rubber_sapling", () -> new SaplingBlock(new RubberTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  
//    public static final RegistryObject<Block> TEAK_SAPLING = BLOCKS.register("teak_sapling", () -> new SaplingBlock(new TeakTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
//    public static final RegistryObject<Block> WALNUT_SAPLING = BLOCKS.register("walnut_sapling", () -> new SaplingBlock(new WalnutTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
//    public static final RegistryObject<Block> ZEBRAWOOD_SAPLING = BLOCKS.register("zebrawood_sapling", () -> new SaplingBlock(new ZebrawoodTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));  	
	public static final RegistryObject<Block> ANCIENT_AMBROSIA_SAPLING = BLOCKS.register("ancient_ambrosia_sapling", () -> new SaplingBlock(new AncientAmbrosiaTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("serendipitous_apothecary_sapling", () -> new SaplingBlock(new SerendipitousApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("benevolent_apothecary_sapling", () -> new SaplingBlock(new BenevolentApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("malevolent_apothecary_sapling", () -> new SaplingBlock(new MalevolentApothecaryTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> TOWERING_INFERNO_SAPLING = BLOCKS.register("towering_inferno_sapling", () -> new SaplingBlock(new ToweringInfernoTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("thunderous_conductor_sapling", () -> new SaplingBlock(new ThunderousConductorTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("cryogenic_spire_sapling", () -> new SaplingBlock(new CryogenicSpireTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	
//	public static final RegistryObject<Block> POTTED_APRICOT_SAPLING = BLOCKS.register("potted_apricot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, APRICOT_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
	public static final RegistryObject<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ASPEN_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));	
//	public static final RegistryObject<Block> POTTED_AVACADO_SAPLING = BLOCKS.register("potted_avacado_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, AVACADO_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));	
	public static final RegistryObject<Block> POTTED_BANANA_SAPLING = BLOCKS.register("potted_banana_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BANANA_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = BLOCKS.register("potted_cherry_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHERRY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_CHESTNUT_SAPLING = BLOCKS.register("potted_chestnut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHESTNUT_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_COCONUT_SAPLING = BLOCKS.register("potted_coconut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, COCONUT_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_EBONY_SAPLING = BLOCKS.register("potted_ebony_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EBONY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_KIWI_SAPLING = BLOCKS.register("potted_kiwi_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, KIWI_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_LEMON_SAPLING = BLOCKS.register("potted_lemon_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LEMON_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_LIME_SAPLING = BLOCKS.register("potted_lime_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LIME_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_MAHOGANY_SAPLING = BLOCKS.register("potted_mahogany_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAHOGANY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid())); 
//	public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAPLE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_ORANGE_SAPLING = BLOCKS.register("potted_orange_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_PEACH_SAPLING = BLOCKS.register("potted_peach_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEACH_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_PEAR_SAPLING = BLOCKS.register("potted_pear_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEAR_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_PLUM_SAPLING = BLOCKS.register("potted_plum_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PLUM_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));	
//	public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = BLOCKS.register("potted_redwood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, REDWOOD_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_RUBBER_SAPLING = BLOCKS.register("potted_rubber_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RUBBER_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_TEAK_SAPLING = BLOCKS.register("potted_teak_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, TEAK_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WALNUT_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
//	public static final RegistryObject<Block> POTTED_ZEBRAWOOD_SAPLING = BLOCKS.register("potted_zebrawood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ZEBRAWOOD_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_ANCIENT_AMBORISA_SAPLING = BLOCKS.register("potted_ancient_ambrosia_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ANCIENT_AMBROSIA_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("potted_serendipitous_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SERENDIPITOUS_APOTHECARY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("potted_benevolent_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BENEVOLENT_APOTHECARY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("potted_malevolent_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MALEVOLENT_APOTHECARY_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_TOWERING_INFERNO_SAPLING = BLOCKS.register("potted_towering_inferno_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, TOWERING_INFERNO_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("potted_thunderous_conductor_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, THUNDEROUS_CONDUCTOR_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> POTTED_CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("potted_cryogenic_spire_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYOGENIC_SPIRE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
    
//	  public static final RegistryObject<Block> APRICOT_LEAVES = BLOCKS.register("apricot_leaves", () -> new FruitingLeavesBlock(() -> ModItems.APRICOT.get()));
    public static final RegistryObject<Block> ASPEN_LEAVES = BLOCKS.register("aspen_leaves", ModLeavesBlock::new);
//    public static final RegistryObject<Block> AVACADO_LEAVES = BLOCKS.register("avacado_leaves", () -> new FruitingLeavesBlock(() -> ModItems.AVACADO.get()));
    public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves", () -> new FruitingLeavesBlock(() -> ModItems.BANANA.get()));
    public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new FruitingLeavesBlock(() -> ModItems.CHERRY.get()));
//    public static final RegistryObject<Block> CHESTNUT_LEAVES = BLOCKS.register("chestnut_leaves", () -> new FruitingLeavesBlock(() -> ModItems.CHESTNUT.get()));
    public static final RegistryObject<Block> COCONUT_LEAVES = BLOCKS.register("coconut_leaves", () -> new FruitingLeavesBlock(() -> ModItems.COCONUT.get()));   
//    public static final RegistryObject<Block> EBONY_LEAVES = BLOCKS.register("ebony_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> KIWI_LEAVES = BLOCKS.register("kiwi_leaves", () -> new FruitingLeavesBlock(() -> ModItems.KIWI.get()));
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new FruitingLeavesBlock(() -> ModItems.LEMON.get()));
    public static final RegistryObject<Block> LIME_LEAVES = BLOCKS.register("lime_leaves", () -> new FruitingLeavesBlock(() -> ModItems.LIME.get()));
//  public static final RegistryObject<Block> MAHOGANY_LEAVES = BLOCKS.register("mahogany_leaves", ModLeavesBlock::new);
//  public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new FruitingLeavesBlock(() -> ModItems.ORANGE.get()));
    public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", () -> new FruitingLeavesBlock(() -> ModItems.PEACH.get()));
    public static final RegistryObject<Block> PEAR_LEAVES = BLOCKS.register("pear_leaves", () -> new FruitingLeavesBlock(() -> ModItems.PEAR.get()));
//  public static final RegistryObject<Block> PLUM_LEAVES = BLOCKS.register("plum_leaves", () -> new FruitingLeavesBlock(() -> ModItems.PLUM.get()));
//  public static final RegistryObject<Block> REDWOOD_LEAVES = BLOCKS.register("redwood_leaves", ModLeavesBlock::new);
//  public static final RegistryObject<Block> RUBBER_LEAVES = BLOCKS.register("rubber_leaves", ModLeavesBlock::new);
//  public static final RegistryObject<Block> TEAK_LEAVES = BLOCKS.register("teak_leaves", ModLeavesBlock::new);
//	public static final RegistryObject<Block> WALNUT_LEAVES = BLOCKS.register("walnut_leaves", () -> new FruitingLeavesBlock(() -> ModItems.WALNUT.get()));    
//  public static final RegistryObject<Block> ZEBRAWOOD_LEAVES = BLOCKS.register("zebrawood_leaves", ModLeavesBlock::new);    
    public static final RegistryObject<Block> FRUITFUL_LEAVES = BLOCKS.register("fruitful_leaves", () -> new FruitingLeavesBlock(() -> ModItems.BANANA.get(), () -> ModItems.CHERRY.get(), () -> ModItems.COCONUT.get(), () -> ModItems.KIWI.get(), () -> ModItems.LEMON.get(), () -> ModItems.LIME.get(), () -> ModItems.ORANGE.get(), () -> ModItems.PEACH.get(), () -> ModItems.PEAR.get()));
    public static final RegistryObject<Block> ALCHEMICAL_LEAVES = BLOCKS.register("alchemical_leaves", () -> new FruitingLeavesBlock(() -> Items.POTION));
    public static final RegistryObject<Block> BENEVOLENT_LEAVES = BLOCKS.register("benevolent_leaves", () -> new PotionLeavesBlock(1));
    public static final RegistryObject<Block> MALEVOLENT_LEAVES = BLOCKS.register("malevolent_leaves", () -> new PotionLeavesBlock(2));
    public static final RegistryObject<Block> CONDUCTIVE_LEAVES = BLOCKS.register("conductive_leaves", () -> new MagicLeavesBlock(1));
    public static final RegistryObject<Block> FROSTBITTEN_LEAVES = BLOCKS.register("frostbitten_leaves", () -> new MagicLeavesBlock(2)); 
    
    /**
     * MINERAL
     */
    
    public static final RegistryObject<Block> SALT = BLOCKS.register("salt", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> LITHIUM_CLAY = BLOCKS.register("lithium_clay", () -> new Block(AbstractBlock.Properties.create(Material.CLAY).hardnessAndResistance(0.6F).sound(SoundType.GROUND)));
    
    public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHROMITE_ORE = BLOCKS.register("chromite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ILMENITE_ORE = BLOCKS.register("ilmenite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> PYROLUSITE_ORE = BLOCKS.register("pyrolusite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBALTITE_ORE = BLOCKS.register("cobaltite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GARNIERITE_ORE = BLOCKS.register("garnierite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BORAX_ORE = BLOCKS.register("borax_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MAGNESITE_ORE = BLOCKS.register("magnesite_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SPODUMENE_ORE = BLOCKS.register("spodumene_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(6.0F).sound(SoundType.STONE)));
    
    public static final RegistryObject<Block> AQUAMARINE_CRYSTAL = BLOCKS.register("aquamarine_crystal", CrystalBlock::new);
    public static final RegistryObject<Block> DOLOMITE_CRYSTAL = BLOCKS.register("dolomite_crystal", CrystalBlock::new);
    public static final RegistryObject<Block> FLUORITE_CRYSTAL = BLOCKS.register("fluorite_crystal", CrystalBlock::new);
    public static final RegistryObject<Block> ULEXITE_CRYSTAL = BLOCKS.register("ulexite_crystal", CrystalBlock::new);
    
    public static final RegistryObject<FlowingFluidBlock> BRINE = BLOCKS.register("brine", () -> new FlowingFluidBlock(ModFluids.BRINE_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> MERCURY = BLOCKS.register("mercury", () -> new FlowingFluidBlock(ModFluids.MERCURY_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    public static final RegistryObject<FlowingFluidBlock> HYDROGEN = BLOCKS.register("hydrogen", () -> new FlowingFluidBlock(ModFluids.HYDROGEN_SOURCE, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));
    
    /**
     * CONSTRUCTION
     */
    
//  public static final RegistryObject<Block> APRICOT_LOG = BLOCKS.register("apricot_log", ModLogBlock::new);  
    public static final RegistryObject<Block> ASPEN_LOG = BLOCKS.register("aspen_log", ModLogBlock::new);  
//  public static final RegistryObject<Block> AVACADO_LOG = BLOCKS.register("avacado_log", ModLogBlock::new);  
    public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", ModLogBlock::new);
    public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", ModLogBlock::new);
//  public static final RegistryObject<Block> CHESTNUT_LOG = BLOCKS.register("chestnut_log", ModLogBlock::new);  
    public static final RegistryObject<Block> COCONUT_LOG = BLOCKS.register("coconut_log", ModLogBlock::new);
//  public static final RegistryObject<Block> EBONY_LOG = BLOCKS.register("ebony_log", ModLogBlock::new);  
    public static final RegistryObject<Block> KIWI_LOG = BLOCKS.register("kiwi_log", ModLogBlock::new);
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", ModLogBlock::new);
    public static final RegistryObject<Block> LIME_LOG = BLOCKS.register("lime_log", ModLogBlock::new);
//  public static final RegistryObject<Block> MAHOGANY_LOG = BLOCKS.register("mahogany_log", ModLogBlock::new); 
//  public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", ModLogBlock::new);  
    public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEACH_LOG = BLOCKS.register("peach_log", ModLogBlock::new);
    public static final RegistryObject<Block> PEAR_LOG = BLOCKS.register("pear_log", ModLogBlock::new);
//  public static final RegistryObject<Block> PLUM_LOG = BLOCKS.register("plum_log", ModLogBlock::new); 
//  public static final RegistryObject<Block> REDWOOD_LOG = BLOCKS.register("redwood_log", ModLogBlock::new);  
//  public static final RegistryObject<Block> RUBBER_LOG = BLOCKS.register("rubber_log", ModLogBlock::new); 
//  public static final RegistryObject<Block> TEAK_LOG = BLOCKS.register("teak_log", ModLogBlock::new);  
//  public static final RegistryObject<Block> WALNUT_LOG = BLOCKS.register("walnut_log", ModLogBlock::new);  
//  public static final RegistryObject<Block> ZEBRAWOOD_LOG = BLOCKS.register("zebrawood_log", ModLogBlock::new);  
    public static final RegistryObject<Block> FRUITFUL_LOG = BLOCKS.register("fruitful_log", ModLogBlock::new);
    public static final RegistryObject<Block> ALCHEMICAL_LOG = BLOCKS.register("alchemical_log", ModLogBlock::new); 
    public static final RegistryObject<Block> BENEVOLENT_LOG = BLOCKS.register("benevolent_log", ModLogBlock::new);
    public static final RegistryObject<Block> MALEVOLENT_LOG = BLOCKS.register("malevolent_log", ModLogBlock::new);
    public static final RegistryObject<Block> CONDUCTIVE_LOG = BLOCKS.register("conductive_log", ModLogBlock::new);
    public static final RegistryObject<Block> FROSTBITTEN_LOG = BLOCKS.register("frostbitten_log", ModLogBlock::new);
    public static final RegistryObject<Block> INFERNAL_LOG = BLOCKS.register("infernal_log", ModLogBlock::new);
    
    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", ModLogBlock::new);
    
//  public static final RegistryObject<Block> APRICOT_WOOD = BLOCKS.register("apricot_wood", ModLogBlock::new);  
//  public static final RegistryObject<Block> ASPEN_WOOD = BLOCKS.register("aspen_wood", ModLogBlock::new);  
//  public static final RegistryObject<Block> AVACADO_WOOD = BLOCKS.register("avacado_wood", ModLogBlock::new);  
    public static final RegistryObject<Block> BANANA_WOOD = BLOCKS.register("banana_wood", ModLogBlock::new);
    public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", ModLogBlock::new);
//  public static final RegistryObject<Block> CHESTNUT_WOOD = BLOCKS.register("chestnut_wood", ModLogBlock::new);  
    public static final RegistryObject<Block> COCONUT_WOOD = BLOCKS.register("coconut_wood", ModLogBlock::new);
//  public static final RegistryObject<Block> EBONY_WOOD = BLOCKS.register("ebony_wood", ModLogBlock::new);  
    public static final RegistryObject<Block> KIWI_WOOD = BLOCKS.register("kiwi_wood", ModLogBlock::new);
    public static final RegistryObject<Block> LEMON_WOOD = BLOCKS.register("lemon_wood", ModLogBlock::new);
    public static final RegistryObject<Block> LIME_WOOD = BLOCKS.register("lime_wood", ModLogBlock::new);
//  public static final RegistryObject<Block> MAHOGANY_WOOD = BLOCKS.register("mahogany_wood", ModLogBlock::new); 
//  public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", ModLogBlock::new);  
    public static final RegistryObject<Block> ORANGE_WOOD = BLOCKS.register("orange_wood", ModLogBlock::new);
    public static final RegistryObject<Block> PEACH_WOOD = BLOCKS.register("peach_wood", ModLogBlock::new);
    public static final RegistryObject<Block> PEAR_WOOD = BLOCKS.register("pear_wood", ModLogBlock::new);
//  public static final RegistryObject<Block> PLUM_WOOD = BLOCKS.register("plum_wood", ModLogBlock::new); 
//  public static final RegistryObject<Block> REDWOOD_WOOD = BLOCKS.register("redwood_wood", ModLogBlock::new);  
//  public static final RegistryObject<Block> RUBBER_WOOD = BLOCKS.register("rubber_wood", ModLogBlock::new); 
//  public static final RegistryObject<Block> TEAK_WOOD = BLOCKS.register("teak_wood", ModLogBlock::new);  
//  public static final RegistryObject<Block> WALNUT_WOOD = BLOCKS.register("walnut_wood", ModLogBlock::new);  
//  public static final RegistryObject<Block> ZEBRAWOOD_WOOD = BLOCKS.register("zebrawood_wood", ModLogBlock::new);  
    public static final RegistryObject<Block> FRUITFUL_WOOD = BLOCKS.register("fruitful_wood", ModLogBlock::new);
    public static final RegistryObject<Block> ALCHEMICAL_WOOD = BLOCKS.register("alchemical_wood", ModLogBlock::new); 
    public static final RegistryObject<Block> BENEVOLENT_WOOD = BLOCKS.register("benevolent_wood", ModLogBlock::new);
    public static final RegistryObject<Block> MALEVOLENT_WOOD = BLOCKS.register("malevolent_wood", ModLogBlock::new);
    public static final RegistryObject<Block> CONDUCTIVE_WOOD = BLOCKS.register("conductive_wood", ModLogBlock::new);
    public static final RegistryObject<Block> FROSTBITTEN_WOOD = BLOCKS.register("frostbitten_wood", ModLogBlock::new);
    public static final RegistryObject<Block> INFERNAL_WOOD = BLOCKS.register("infernal_wood", ModLogBlock::new);
    
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", ModLogBlock::new);
   
//    public static final RegistryObject<Block> APRICOT_PLANKS = BLOCKS.register("apricot_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> ASPEN_PLANKS = BLOCKS.register("aspen_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> AVACADO_PLANKS = BLOCKS.register("avacado_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> CHESTNUT_PLANKS = BLOCKS.register("chestnut_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> COCONUT_PLANKS = BLOCKS.register("coconut_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> EBONY_PLANKS = BLOCKS.register("ebony_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> KIWI_PLANKS = BLOCKS.register("kiwi_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> LIME_PLANKS = BLOCKS.register("lime_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> MAHOGANY_PLANKS = BLOCKS.register("mahogany_planks", ModPlanksBlock::new);    
//    public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> PEACH_PLANKS = BLOCKS.register("peach_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> PEAR_PLANKS = BLOCKS.register("pear_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> PLUM_PLANKS = BLOCKS.register("plum_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> REDWOOD_PLANKS = BLOCKS.register("redwood_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> RUBBER_PLANKS = BLOCKS.register("rubber_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> TEAK_PLANKS = BLOCKS.register("teak_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> WALNUT_PLANKS = BLOCKS.register("walnut_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> ZEBRAWOOD_PLANKS = BLOCKS.register("zebrawood_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> FRUITFUL_PLANKS = BLOCKS.register("fruitful_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> ALCHEMICAL_PLANKS = BLOCKS.register("alchemical_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> BENEVOLENT_PLANKS = BLOCKS.register("benevolent_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> MALEVOLENT_PLANKS = BLOCKS.register("malevolent_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> CONDUCTIVE_PLANKS = BLOCKS.register("conductive_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> FROSTBITTEN_PLANKS = BLOCKS.register("frostbitten_planks", ModPlanksBlock::new);
//    public static final RegistryObject<Block> INFERNAL_PLANKS = BLOCKS.register("infernal_planks", ModPlanksBlock::new);

    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = BLOCKS.register("spruce_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = BLOCKS.register("birch_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = BLOCKS.register("jungle_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = BLOCKS.register("acacia_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = BLOCKS.register("dark_oak_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = BLOCKS.register("crimson_bookshelf", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = BLOCKS.register("warped_bookshelf", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
  
    public static final RegistryObject<Block> BANANA_BOOKSHELF = BLOCKS.register("banana_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> CHERRY_BOOKSHELF = BLOCKS.register("cherry_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> COCONUT_BOOKSHELF = BLOCKS.register("coconut_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> KIWI_BOOKSHELF = BLOCKS.register("kiwi_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> LEMON_BOOKSHELF = BLOCKS.register("lemon_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> LIME_BOOKSHELF = BLOCKS.register("lime_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> ORANGE_BOOKSHELF = BLOCKS.register("orange_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> PEACH_BOOKSHELF = BLOCKS.register("peach_bookshelf", ModBookshelfBlock::new);
    public static final RegistryObject<Block> PEAR_BOOKSHELF = BLOCKS.register("pear_bookshelf", ModBookshelfBlock::new);
    
    public static final RegistryObject<Block> BANANA_SLAB = BLOCKS.register("banana_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> COCONUT_SLAB = BLOCKS.register("coconut_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> KIWI_SLAB = BLOCKS.register("kiwi_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> LEMON_SLAB = BLOCKS.register("lemon_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> LIME_SLAB = BLOCKS.register("lime_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> ORANGE_SLAB = BLOCKS.register("orange_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> PEACH_SLAB = BLOCKS.register("peach_slab", ModSlabBlock::new);
    public static final RegistryObject<Block> PEAR_SLAB = BLOCKS.register("pear_slab", ModSlabBlock::new);
    
    public static final RegistryObject<Block> BANANA_STAIRS = BLOCKS.register("banana_stairs", () -> new ModStairsBlock(() -> BANANA_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> new ModStairsBlock(() -> CHERRY_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> COCONUT_STAIRS = BLOCKS.register("coconut_stairs", () -> new ModStairsBlock(() -> COCONUT_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> KIWI_STAIRS = BLOCKS.register("kiwi_stairs", () -> new ModStairsBlock(() -> KIWI_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> LEMON_STAIRS = BLOCKS.register("lemon_stairs", () -> new ModStairsBlock(() -> LEMON_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> LIME_STAIRS = BLOCKS.register("lime_stairs", () -> new ModStairsBlock(() -> LIME_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> ORANGE_STAIRS = BLOCKS.register("orange_stairs", () -> new ModStairsBlock(() -> ORANGE_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> PEACH_STAIRS = BLOCKS.register("peach_stairs", () -> new ModStairsBlock(() -> PEACH_PLANKS.get().getDefaultState()));
    public static final RegistryObject<Block> PEAR_STAIRS = BLOCKS.register("pear_stairs", () -> new ModStairsBlock(() -> PEAR_PLANKS.get().getDefaultState()));
    
    public static final RegistryObject<Block> BANANA_FENCE = BLOCKS.register("banana_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> COCONUT_FENCE = BLOCKS.register("coconut_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> KIWI_FENCE = BLOCKS.register("kiwi_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> LEMON_FENCE = BLOCKS.register("lemon_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> LIME_FENCE = BLOCKS.register("lime_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> ORANGE_FENCE = BLOCKS.register("orange_fence", ModFenceBlock::new);;
    public static final RegistryObject<Block> PEACH_FENCE = BLOCKS.register("peach_fence", ModFenceBlock::new);
    public static final RegistryObject<Block> PEAR_FENCE = BLOCKS.register("pear_fence", ModFenceBlock::new);
    
    public static final RegistryObject<Block> BANANA_FENCE_GATE = BLOCKS.register("banana_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> COCONUT_FENCE_GATE = BLOCKS.register("coconut_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> KIWI_FENCE_GATE = BLOCKS.register("kiwi_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> LEMON_FENCE_GATE = BLOCKS.register("lemon_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> LIME_FENCE_GATE = BLOCKS.register("lime_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> ORANGE_FENCE_GATE = BLOCKS.register("orange_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> PEACH_FENCE_GATE = BLOCKS.register("peach_fence_gate", ModFenceGateBlock::new);
    public static final RegistryObject<Block> PEAR_FENCE_GATE = BLOCKS.register("pear_fence_gate", ModFenceGateBlock::new);
    
    public static final RegistryObject<Block> BANANA_DOOR = BLOCKS.register("banana_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> COCONUT_DOOR = BLOCKS.register("coconut_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> KIWI_DOOR = BLOCKS.register("kiwi_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LEMON_DOOR = BLOCKS.register("lemon_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LIME_DOOR = BLOCKS.register("lime_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> ORANGE_DOOR = BLOCKS.register("orange_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEACH_DOOR = BLOCKS.register("peach_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEAR_DOOR = BLOCKS.register("pear_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD,  MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    
    public static final RegistryObject<Block> BANANA_TRAPDOOR = BLOCKS.register("banana_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> COCONUT_TRAPDOOR = BLOCKS.register("coconut_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> KIWI_TRAPDOOR = BLOCKS.register("kiwi_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LEMON_TRAPDOOR = BLOCKS.register("lemon_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LIME_TRAPDOOR = BLOCKS.register("lime_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> ORANGE_TRAPDOOR = BLOCKS.register("orange_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEACH_TRAPDOOR = BLOCKS.register("peach_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEAR_TRAPDOOR = BLOCKS.register("pear_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    
    public static final RegistryObject<Block> BANANA_PRESSURE_PLATE = BLOCKS.register("banana_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> COCONUT_PRESSURE_PLATE = BLOCKS.register("coconut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> KIWI_PRESSURE_PLATE = BLOCKS.register("kiwi_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LEMON_PRESSURE_PLATE = BLOCKS.register("lemon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> LIME_PRESSURE_PLATE = BLOCKS.register("lime_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = BLOCKS.register("orange_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEACH_PRESSURE_PLATE = BLOCKS.register("peach_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> PEAR_PRESSURE_PLATE = BLOCKS.register("pear_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    
    public static final RegistryObject<Block> BANANA_BUTTON = BLOCKS.register("banana_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> COCONUT_BUTTON = BLOCKS.register("coconut_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> KIWI_BUTTON = BLOCKS.register("kiwi_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEMON_BUTTON = BLOCKS.register("lemon_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIME_BUTTON = BLOCKS.register("lime_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ORANGE_BUTTON = BLOCKS.register("orange_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PEACH_BUTTON = BLOCKS.register("peach_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PEAR_BUTTON = BLOCKS.register("pear_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    
    public static final RegistryObject<Block> BANANA_SIGN = BLOCKS.register("banana_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.BANANA));
    public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.CHERRY));
    public static final RegistryObject<Block> COCONUT_SIGN = BLOCKS.register("coconut_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.COCONUT));
    public static final RegistryObject<Block> KIWI_SIGN = BLOCKS.register("kiwi_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.KIWI));
    public static final RegistryObject<Block> LEMON_SIGN = BLOCKS.register("lemon_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.LEMON));
    public static final RegistryObject<Block> LIME_SIGN = BLOCKS.register("lime_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.LIME));
    public static final RegistryObject<Block> ORANGE_SIGN = BLOCKS.register("orange_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.ORANGE));
    public static final RegistryObject<Block> PEACH_SIGN = BLOCKS.register("peach_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.PEACH));
    public static final RegistryObject<Block> PEAR_SIGN = BLOCKS.register("pear_sign", () -> new ModStandingSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.PEAR));
    
    public static final RegistryObject<Block> BANANA_WALL_SIGN = BLOCKS.register("banana_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.BANANA));
    public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.CHERRY));
    public static final RegistryObject<Block> COCONUT_WALL_SIGN = BLOCKS.register("coconut_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.COCONUT));
    public static final RegistryObject<Block> KIWI_WALL_SIGN = BLOCKS.register("kiwi_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.KIWI));
    public static final RegistryObject<Block> LEMON_WALL_SIGN = BLOCKS.register("lemon_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.LEMON));
    public static final RegistryObject<Block> LIME_WALL_SIGN = BLOCKS.register("lime_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.LIME));
    public static final RegistryObject<Block> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.ORANGE));
    public static final RegistryObject<Block> PEACH_WALL_SIGN = BLOCKS.register("peach_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.PEACH));
    public static final RegistryObject<Block> PEAR_WALL_SIGN = BLOCKS.register("pear_wall_sign", () -> new ModWallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), ModWoodType.PEAR));
    
    /**
     * MACHINERY
     */

    public static final RegistryObject<Block> LINE_SHAFT_HANGER = BLOCKS.register("line_shaft_hanger", TwelveDirectionBlock::new); 
    public static final RegistryObject<Block> LINE_SHAFT = BLOCKS.register("line_shaft", LineShaftBlock::new); 
    public static final RegistryObject<Block> SMALL_PULLEY = BLOCKS.register("small_pulley", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(1.0F).sound(SoundType.ANVIL).notSolid())); 
    public static final RegistryObject<Block> MEDIUM_PULLEY = BLOCKS.register("medium_pulley", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(1.0F).sound(SoundType.ANVIL).notSolid())); 
    public static final RegistryObject<Block> LARGE_PULLEY = BLOCKS.register("large_pulley", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(1.0F).sound(SoundType.ANVIL).notSolid())); 
    public static final RegistryObject<Block> MOTOR_1HP = BLOCKS.register("motor_1hp", () -> new MotorBlock(100, 60)); 
    public static final RegistryObject<Block> MOTOR_5HP = BLOCKS.register("motor_5hp", () -> new MotorBlock(200, 120));
    public static final RegistryObject<Block> MOTOR_20HP = BLOCKS.register("motor_20hp", () -> new MotorBlock(400, 240));
    
    /**
     * DECORATIVE
     */
    
    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", DisplayCaseBlock::new);  
    
    
    
	public static void register() 
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
