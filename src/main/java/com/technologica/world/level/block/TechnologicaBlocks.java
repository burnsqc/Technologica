package com.technologica.world.level.block;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.entity.TechnologicaSignBlockEntity;
import com.technologica.world.level.block.entity.VanillaSignBlockEntity;
import com.technologica.world.level.block.grower.AncientAmbrosiaTreeGrower;
import com.technologica.world.level.block.grower.ApricotTreeGrower;
import com.technologica.world.level.block.grower.AspenTreeGrower;
import com.technologica.world.level.block.grower.AvocadoTreeGrower;
import com.technologica.world.level.block.grower.BananaTreeGrower;
import com.technologica.world.level.block.grower.BenevolentApothecaryTreeGrower;
import com.technologica.world.level.block.grower.CherryTreeGrower;
import com.technologica.world.level.block.grower.ChestnutTreeGrower;
import com.technologica.world.level.block.grower.CinnamonTreeGrower;
import com.technologica.world.level.block.grower.CoconutTreeGrower;
import com.technologica.world.level.block.grower.CryogenicSpireTreeGrower;
import com.technologica.world.level.block.grower.EbonyTreeGrower;
import com.technologica.world.level.block.grower.KiwiTreeGrower;
import com.technologica.world.level.block.grower.LemonTreeGrower;
import com.technologica.world.level.block.grower.LimeTreeGrower;
import com.technologica.world.level.block.grower.MahoganyTreeGrower;
import com.technologica.world.level.block.grower.MalevolentApothecaryTreeGrower;
import com.technologica.world.level.block.grower.MapleTreeGrower;
import com.technologica.world.level.block.grower.NecroticTreeGrower;
import com.technologica.world.level.block.grower.OliveTreeGrower;
import com.technologica.world.level.block.grower.OrangeTreeGrower;
import com.technologica.world.level.block.grower.PeachTreeGrower;
import com.technologica.world.level.block.grower.PearTreeGrower;
import com.technologica.world.level.block.grower.PlumTreeGrower;
import com.technologica.world.level.block.grower.RedwoodTreeGrower;
import com.technologica.world.level.block.grower.RosewoodTreeGrower;
import com.technologica.world.level.block.grower.RubberTreeGrower;
import com.technologica.world.level.block.grower.SerendipitousApothecaryTreeGrower;
import com.technologica.world.level.block.grower.TeakTreeGrower;
import com.technologica.world.level.block.grower.ThunderousConductorTreeGrower;
import com.technologica.world.level.block.grower.ToweringInfernoTreeGrower;
import com.technologica.world.level.block.grower.WalnutTreeGrower;
import com.technologica.world.level.block.grower.ZebrawoodTreeGrower;
import com.technologica.world.level.block.state.properties.TechnologicaWoodType;
import com.technologica.world.level.material.TechnologicaFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.Keys.BLOCKS, MODID);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("BLOCKS INITIALIZED: " + BLOCKS.getEntries().size() + " OF 827");
	}

	/*
	 * FLORA
	 */

	public static final RegistryObject<Block> BARLEY = BLOCKS.register("barley", () -> grainCropBlock(TechnologicaItems.BARLEY_SEEDS));
	public static final RegistryObject<Block> OATS = BLOCKS.register("oats", () -> grainCropBlock(TechnologicaItems.OATS_SEEDS));
	public static final RegistryObject<Block> RYE = BLOCKS.register("rye", () -> grainCropBlock(TechnologicaItems.RYE_SEEDS));
	public static final RegistryObject<Block> CORN = BLOCKS.register("corn", () -> new TallCropBlock(TechnologicaItems.CORN_SEEDS));
	public static final RegistryObject<Block> ASPARAGUS = BLOCKS.register("asparagus", () -> replantableCropBlock(TechnologicaItems.ASPARAGUS));
	public static final RegistryObject<Block> CHILI_PEPPERS = BLOCKS.register("chili_peppers", () -> replantableCropBlock(TechnologicaItems.CHILI_PEPPER));
	public static final RegistryObject<Block> COFFEE = BLOCKS.register("coffee", () -> replantableCropBlock(TechnologicaItems.COFFEE_BEANS));
	public static final RegistryObject<Block> GARLIC = BLOCKS.register("garlic", () -> replantableCropBlock(TechnologicaItems.GARLIC));
	public static final RegistryObject<Block> GINGER = BLOCKS.register("ginger", () -> replantableCropBlock(TechnologicaItems.GINGER));
	public static final RegistryObject<Block> PEAS = BLOCKS.register("peas", () -> replantableCropBlock(TechnologicaItems.PEAS));
	public static final RegistryObject<Block> PEANUTS = BLOCKS.register("peanuts", () -> replantableCropBlock(TechnologicaItems.PEANUT));
	public static final RegistryObject<Block> RED_BEANS = BLOCKS.register("red_beans", () -> replantableCropBlock(TechnologicaItems.RED_BEANS));
	public static final RegistryObject<Block> SOY_BEANS = BLOCKS.register("soy_beans", () -> replantableCropBlock(TechnologicaItems.SOY_BEANS));
	public static final RegistryObject<Block> SWEET_POTATOES = BLOCKS.register("sweet_potatoes", () -> replantableCropBlock(TechnologicaItems.SWEET_POTATO));
	public static final RegistryObject<Block> BROCCOLI = BLOCKS.register("broccoli", () -> seededCropBlock(TechnologicaItems.BROCCOLI_SEEDS));
	public static final RegistryObject<Block> CELERY = BLOCKS.register("celery", () -> seededCropBlock(TechnologicaItems.CELERY_SEEDS));
	public static final RegistryObject<Block> LETTUCE = BLOCKS.register("lettuce", () -> seededCropBlock(TechnologicaItems.LETTUCE_SEEDS));
	public static final RegistryObject<Block> MUSTARD_GREENS = BLOCKS.register("mustard_greens", () -> seededCropBlock(TechnologicaItems.MUSTARD_SEEDS));
	public static final RegistryObject<Block> ONIONS = BLOCKS.register("onions", () -> seededCropBlock(TechnologicaItems.ONION_SEEDS));
	public static final RegistryObject<Block> PINEAPPLES = BLOCKS.register("pineapples", () -> seededCropBlock(TechnologicaItems.PINEAPPLE_SEEDS));
	public static final RegistryObject<Block> PURPLE_CABBAGE = BLOCKS.register("purple_cabbage", () -> seededCropBlock(TechnologicaItems.PURPLE_CABBAGE_SEEDS));
	public static final RegistryObject<Block> RADISHES = BLOCKS.register("radishes", () -> seededCropBlock(TechnologicaItems.RADISH_SEEDS));
	public static final RegistryObject<Block> TEA = BLOCKS.register("tea", () -> seededCropBlock(TechnologicaItems.TEA_SEEDS));
	public static final RegistryObject<Block> TURNIPS = BLOCKS.register("turnips", () -> seededCropBlock(TechnologicaItems.TURNIP_SEEDS));
	public static final RegistryObject<Block> CUCUMBERS = BLOCKS.register("cucumbers", () -> new GourdCropBlock(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.WARPED_WART_BLOCK).strength(1.0F).sound(SoundType.WOOD).noOcclusion(), 0));
	public static final RegistryObject<Block> ATTACHED_CUCUMBER_STEM = BLOCKS.register("attached_cucumber_stem", () -> new AttachedStemBlock((StemGrownBlock) CUCUMBERS.get(), () -> {
		return TechnologicaItems.CUCUMBER_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> CUCUMBER_STEM = BLOCKS.register("cucumber_stem", () -> new GourdStemBlock((StemGrownBlock) CUCUMBERS.get(), () -> {
		return TechnologicaItems.CUCUMBER_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP)));
	public static final RegistryObject<Block> SQUASH = BLOCKS.register("squash", () -> new GourdCropBlock(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion(), 1));
	public static final RegistryObject<Block> ATTACHED_SQUASH_STEM = BLOCKS.register("attached_squash_stem", () -> new AttachedStemBlock((StemGrownBlock) SQUASH.get(), () -> {
		return TechnologicaItems.SQUASH_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SQUASH_STEM = BLOCKS.register("squash_stem", () -> new GourdStemBlock((StemGrownBlock) SQUASH.get(), () -> {
		return TechnologicaItems.SQUASH_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP)));
	public static final RegistryObject<Block> ZUCCHINI = BLOCKS.register("zucchini", () -> new GourdCropBlock(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_GREEN).strength(1.0F).sound(SoundType.WOOD).noOcclusion(), 2));
	public static final RegistryObject<Block> ATTACHED_ZUCCHINI_STEM = BLOCKS.register("attached_zucchini_stem", () -> new AttachedStemBlock((StemGrownBlock) ZUCCHINI.get(), () -> {
		return TechnologicaItems.ZUCCHINI_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ZUCCHINI_STEM = BLOCKS.register("zucchini_stem", () -> new GourdStemBlock((StemGrownBlock) ZUCCHINI.get(), () -> {
		return TechnologicaItems.ZUCCHINI_SEEDS.get();
	}, BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP)));
	public static final RegistryObject<Block> BLACKBERRY_BUSH = BLOCKS.register("blackberry_bush", () -> bushCropBlock(TechnologicaItems.BLACKBERRY));
	public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush", () -> bushCropBlock(TechnologicaItems.BLUEBERRY));
	public static final RegistryObject<Block> RASPBERRY_BUSH = BLOCKS.register("raspberry_bush", () -> bushCropBlock(TechnologicaItems.RASPBERRY));
	public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush", () -> bushCropBlock(TechnologicaItems.STRAWBERRY));
	public static final RegistryObject<Block> COTTON_BUSH = BLOCKS.register("cotton_bush", () -> bushCropBlock(TechnologicaItems.COTTON));
	public static final RegistryObject<Block> PEPPERCORNS = BLOCKS.register("peppercorns", () -> new TallBushCropBlock(TechnologicaItems.PEPPERCORNS));
	public static final RegistryObject<Block> GRAPES = BLOCKS.register("grapes", () -> new VineCropBlock(TechnologicaItems.GRAPE_SEEDS, TechnologicaItems.GRAPE));
	public static final RegistryObject<Block> TOMATOES = BLOCKS.register("tomatoes", () -> new VineCropBlock(TechnologicaItems.TOMATO_SEEDS, TechnologicaItems.TOMATO));
	public static final RegistryObject<Block> CRANBERRY_CROP = BLOCKS.register("cranberry", () -> new WaterCropBlock(TechnologicaItems.CRANBERRY_SEEDS));
	public static final RegistryObject<Block> RICE = BLOCKS.register("rice", () -> new WaterCropBlock(TechnologicaItems.RICE_SEEDS));

	public static final RegistryObject<Block> APRICOT_SAPLING = BLOCKS.register("apricot_sapling", () -> new SaplingBlock(new ApricotTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ASPEN_SAPLING = BLOCKS.register("aspen_sapling", () -> new SaplingBlock(new AspenTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> AVOCADO_SAPLING = BLOCKS.register("avocado_sapling", () -> new SaplingBlock(new AvocadoTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new SaplingBlock(new BananaTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CHESTNUT_SAPLING = BLOCKS.register("chestnut_sapling", () -> new SaplingBlock(new ChestnutTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CINNAMON_SAPLING = BLOCKS.register("cinnamon_sapling", () -> new SaplingBlock(new CinnamonTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> COCONUT_SAPLING = BLOCKS.register("coconut_sapling", () -> new SaplingBlock(new CoconutTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> EBONY_SAPLING = BLOCKS.register("ebony_sapling", () -> new SaplingBlock(new EbonyTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> KIWI_SAPLING = BLOCKS.register("kiwi_sapling", () -> new SaplingBlock(new KiwiTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new SaplingBlock(new LemonTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LIME_SAPLING = BLOCKS.register("lime_sapling", () -> new SaplingBlock(new LimeTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MAHOGANY_SAPLING = BLOCKS.register("mahogany_sapling", () -> new SaplingBlock(new MahoganyTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MAPLE_SAPLING = BLOCKS.register("maple_sapling", () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling", () -> new SaplingBlock(new OliveTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", () -> new SaplingBlock(new PeachTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new SaplingBlock(new PearTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PLUM_SAPLING = BLOCKS.register("plum_sapling", () -> new SaplingBlock(new PlumTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> REDWOOD_SAPLING = BLOCKS.register("redwood_sapling", () -> new SaplingBlock(new RedwoodTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ROSEWOOD_SAPLING = BLOCKS.register("rosewood_sapling", () -> new SaplingBlock(new RosewoodTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> RUBBER_SAPLING = BLOCKS.register("rubber_sapling", () -> new SaplingBlock(new RubberTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> TEAK_SAPLING = BLOCKS.register("teak_sapling", () -> new SaplingBlock(new TeakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> WALNUT_SAPLING = BLOCKS.register("walnut_sapling", () -> new SaplingBlock(new WalnutTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ZEBRAWOOD_SAPLING = BLOCKS.register("zebrawood_sapling", () -> new SaplingBlock(new ZebrawoodTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ANCIENT_AMBROSIA_SAPLING = BLOCKS.register("ancient_ambrosia_sapling", () -> new SaplingBlock(new AncientAmbrosiaTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("serendipitous_apothecary_sapling", () -> new SaplingBlock(new SerendipitousApothecaryTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("benevolent_apothecary_sapling", () -> new SaplingBlock(new BenevolentApothecaryTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("malevolent_apothecary_sapling", () -> new SaplingBlock(new MalevolentApothecaryTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> NECROTIC_SAPLING = BLOCKS.register("necrotic_sapling", () -> new SaplingBlock(new NecroticTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> TOWERING_INFERNO_SAPLING = BLOCKS.register("towering_inferno_sapling", () -> new SaplingBlock(new ToweringInfernoTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("thunderous_conductor_sapling", () -> new SaplingBlock(new ThunderousConductorTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("cryogenic_spire_sapling", () -> new SaplingBlock(new CryogenicSpireTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

	public static final RegistryObject<Block> POTTED_APRICOT_SAPLING = BLOCKS.register("potted_apricot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, APRICOT_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ASPEN_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_AVOCADO_SAPLING = BLOCKS.register("potted_avocado_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, AVOCADO_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_BANANA_SAPLING = BLOCKS.register("potted_banana_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BANANA_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = BLOCKS.register("potted_cherry_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHERRY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_CHESTNUT_SAPLING = BLOCKS.register("potted_chestnut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CHESTNUT_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_CINNAMON_SAPLING = BLOCKS.register("potted_cinnamon_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CINNAMON_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_COCONUT_SAPLING = BLOCKS.register("potted_coconut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, COCONUT_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_EBONY_SAPLING = BLOCKS.register("potted_ebony_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EBONY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_KIWI_SAPLING = BLOCKS.register("potted_kiwi_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, KIWI_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_LEMON_SAPLING = BLOCKS.register("potted_lemon_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LEMON_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_LIME_SAPLING = BLOCKS.register("potted_lime_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, LIME_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_MAHOGANY_SAPLING = BLOCKS.register("potted_mahogany_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAHOGANY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = BLOCKS.register("potted_maple_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAPLE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = BLOCKS.register("potted_olive_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, OLIVE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_ORANGE_SAPLING = BLOCKS.register("potted_orange_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_PEACH_SAPLING = BLOCKS.register("potted_peach_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEACH_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_PEAR_SAPLING = BLOCKS.register("potted_pear_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEAR_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_PLUM_SAPLING = BLOCKS.register("potted_plum_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PLUM_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = BLOCKS.register("potted_redwood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, REDWOOD_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_ROSEWOOD_SAPLING = BLOCKS.register("potted_rosewood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ROSEWOOD_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_RUBBER_SAPLING = BLOCKS.register("potted_rubber_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RUBBER_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_TEAK_SAPLING = BLOCKS.register("potted_teak_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, TEAK_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_WALNUT_SAPLING = BLOCKS.register("potted_walnut_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WALNUT_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_ZEBRAWOOD_SAPLING = BLOCKS.register("potted_zebrawood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ZEBRAWOOD_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_ANCIENT_AMBROSIA_SAPLING = BLOCKS.register("potted_ancient_ambrosia_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ANCIENT_AMBROSIA_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_SERENDIPITOUS_APOTHECARY_SAPLING = BLOCKS.register("potted_serendipitous_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SERENDIPITOUS_APOTHECARY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_BENEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("potted_benevolent_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BENEVOLENT_APOTHECARY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_MALEVOLENT_APOTHECARY_SAPLING = BLOCKS.register("potted_malevolent_apothecary_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MALEVOLENT_APOTHECARY_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_NECROTIC_SAPLING = BLOCKS.register("potted_necrotic_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, NECROTIC_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_TOWERING_INFERNO_SAPLING = BLOCKS.register("potted_towering_inferno_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, TOWERING_INFERNO_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_THUNDEROUS_CONDUCTOR_SAPLING = BLOCKS.register("potted_thunderous_conductor_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, THUNDEROUS_CONDUCTOR_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
	public static final RegistryObject<Block> POTTED_CRYOGENIC_SPIRE_SAPLING = BLOCKS.register("potted_cryogenic_spire_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYOGENIC_SPIRE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

	public static final RegistryObject<Block> APRICOT_LEAVES = BLOCKS.register("apricot_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.APRICOT));
	public static final RegistryObject<Block> ASPEN_LEAVES = BLOCKS.register("aspen_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> AVOCADO_LEAVES = BLOCKS.register("avocado_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.AVOCADO));
	public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.BANANA));
	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.CHERRY));
	public static final RegistryObject<Block> CHESTNUT_LEAVES = BLOCKS.register("chestnut_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.CHESTNUT));
	public static final RegistryObject<Block> CINNAMON_LEAVES = BLOCKS.register("cinnamon_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> COCONUT_LEAVES = BLOCKS.register("coconut_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.COCONUT));
	public static final RegistryObject<Block> EBONY_LEAVES = BLOCKS.register("ebony_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> KIWI_LEAVES = BLOCKS.register("kiwi_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.KIWI));
	public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.LEMON));
	public static final RegistryObject<Block> LIME_LEAVES = BLOCKS.register("lime_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.LIME));
	public static final RegistryObject<Block> MAHOGANY_LEAVES = BLOCKS.register("mahogany_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> MAPLE_LEAVES = BLOCKS.register("maple_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.OLIVE));
	public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.ORANGE));
	public static final RegistryObject<Block> PEACH_LEAVES = BLOCKS.register("peach_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.PEACH));
	public static final RegistryObject<Block> PEAR_LEAVES = BLOCKS.register("pear_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.PEAR));
	public static final RegistryObject<Block> PLUM_LEAVES = BLOCKS.register("plum_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.PLUM));
	public static final RegistryObject<Block> REDWOOD_LEAVES = BLOCKS.register("redwood_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> ROSEWOOD_LEAVES = BLOCKS.register("rosewood_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> RUBBER_LEAVES = BLOCKS.register("rubber_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> TEAK_LEAVES = BLOCKS.register("teak_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> WALNUT_LEAVES = BLOCKS.register("walnut_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.WALNUT));
	public static final RegistryObject<Block> ZEBRAWOOD_LEAVES = BLOCKS.register("zebrawood_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> FRUITFUL_LEAVES = BLOCKS.register("fruitful_leaves", () -> new FruitingLeavesBlock(TechnologicaItems.BANANA, TechnologicaItems.CHERRY, TechnologicaItems.COCONUT, TechnologicaItems.KIWI, TechnologicaItems.LEMON, TechnologicaItems.LIME, TechnologicaItems.ORANGE, TechnologicaItems.PEACH, TechnologicaItems.PEAR));
	public static final RegistryObject<Block> ALCHEMICAL_LEAVES = BLOCKS.register("alchemical_leaves", () -> new FruitingLeavesBlock(() -> Items.POTION));
	public static final RegistryObject<Block> BENEVOLENT_LEAVES = BLOCKS.register("benevolent_leaves", () -> new PotionLeavesBlock(1));
	public static final RegistryObject<Block> CURSED_LEAVES = BLOCKS.register("cursed_leaves", () -> leavesBlock());
	public static final RegistryObject<Block> MALEVOLENT_LEAVES = BLOCKS.register("malevolent_leaves", () -> new PotionLeavesBlock(2));
	public static final RegistryObject<Block> CONDUCTIVE_LEAVES = BLOCKS.register("conductive_leaves", () -> new MagicLeavesBlock(1));
	public static final RegistryObject<Block> FROSTBITTEN_LEAVES = BLOCKS.register("frostbitten_leaves", () -> new MagicLeavesBlock(2));

	public static final RegistryObject<Block> MULCH = BLOCKS.register("mulch", MulchBlock::new);
	public static final RegistryObject<Block> TRELLIS = BLOCKS.register("trellis", TrellisBlock::new);

	/*
	 * MINERAL
	 */

	public static final RegistryObject<Block> SALT = BLOCKS.register("salt", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	public static final RegistryObject<Block> LITHIUM_CLAY = BLOCKS.register("lithium_clay", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(0.6F).sound(SoundType.GRAVEL)));
	public static final RegistryObject<Block> MOON_ROCK = BLOCKS.register("moon_rock", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
	public static final RegistryObject<Block> MOON_DUST = BLOCKS.register("moon_dust", () -> new SandBlock(14406560, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F).sound(SoundType.SAND)));

	public static final RegistryObject<Block> APATITE_ORE = BLOCKS.register("apatite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_APATITE_ORE = BLOCKS.register("deepslate_apatite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ARGENTITE_ORE = BLOCKS.register("argentite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_ARGENTITE_ORE = BLOCKS.register("deepslate_argentite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> NETHER_ARGENTITE_ORE = BLOCKS.register("nether_argentite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ARSENOPYRITE_ORE = BLOCKS.register("arsenopyrite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_ARSENOPYRITE_ORE = BLOCKS.register("deepslate_arsenopyrite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BASTNAESITE_ORE = BLOCKS.register("bastnaesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_BASTNAESITE_ORE = BLOCKS.register("deepslate_bastnaesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_BAUXITE_ORE = BLOCKS.register("deepslate_bauxite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> BORAX_ORE = BLOCKS.register("borax_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_BORAX_ORE = BLOCKS.register("deepslate_borax_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CASSITERITE_ORE = BLOCKS.register("cassiterite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_CASSITERITE_ORE = BLOCKS.register("deepslate_cassiterite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CHROMITE_ORE = BLOCKS.register("chromite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_CHROMITE_ORE = BLOCKS.register("deepslate_chromite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CINNABAR_ORE = BLOCKS.register("cinnabar_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_CINNABAR_ORE = BLOCKS.register("deepslate_cinnabar_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> COBALTITE_ORE = BLOCKS.register("cobaltite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_COBALTITE_ORE = BLOCKS.register("deepslate_cobaltite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> CROOKESITE_ORE = BLOCKS.register("crookesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_CROOKESITE_ORE = BLOCKS.register("deepslate_crookesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GADOLINITE_ORE = BLOCKS.register("gadolinite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_GADOLINITE_ORE = BLOCKS.register("deepslate_gadolinite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GALENA_ORE = BLOCKS.register("galena_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_GALENA_ORE = BLOCKS.register("deepslate_galena_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> GARNIERITE_ORE = BLOCKS.register("garnierite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_GARNIERITE_ORE = BLOCKS.register("deepslate_garnierite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ILMENITE_ORE = BLOCKS.register("ilmenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_ILMENITE_ORE = BLOCKS.register("deepslate_ilmenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> LEPIDOLITE_ORE = BLOCKS.register("lepidolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_LEPIDOLITE_ORE = BLOCKS.register("deepslate_lepidolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MAGNESITE_ORE = BLOCKS.register("magnesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_MAGNESITE_ORE = BLOCKS.register("deepslate_magnesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> MOLYBDENITE_ORE = BLOCKS.register("molybdenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_MOLYBDENITE_ORE = BLOCKS.register("deepslate_molybdenite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> OSMIRIDIUM_ORE = BLOCKS.register("osmiridium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_OSMIRIDIUM_ORE = BLOCKS.register("deepslate_osmiridium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> NETHER_OSMIRIDIUM_ORE = BLOCKS.register("nether_osmiridium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PATRONITE_ORE = BLOCKS.register("patronite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_PATRONITE_ORE = BLOCKS.register("deepslate_patronite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PENTLANDITE_ORE = BLOCKS.register("pentlandite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_PENTLANDITE_ORE = BLOCKS.register("deepslate_pentlandite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PHOSPHORITE_ORE = BLOCKS.register("phosphorite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_PHOSPHORITE_ORE = BLOCKS.register("deepslate_phosphorite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = BLOCKS.register("deepslate_platinum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> NETHER_PLATINUM_ORE = BLOCKS.register("nether_platinum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PYROLUSITE_ORE = BLOCKS.register("pyrolusite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_PYROLUSITE_ORE = BLOCKS.register("deepslate_pyrolusite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = BLOCKS.register("deepslate_ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(RUBY_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = BLOCKS.register("deepslate_sapphire_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SAPPHIRE_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> SPODUMENE_ORE = BLOCKS.register("spodumene_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_SPODUMENE_ORE = BLOCKS.register("deepslate_spodumene_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> SYLVANITE_ORE = BLOCKS.register("sylvanite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_SYLVANITE_ORE = BLOCKS.register("deepslate_sylvanite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> NETHER_SYLVANITE_ORE = BLOCKS.register("nether_sylvanite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TANTALITE_ORE = BLOCKS.register("tantalite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_TANTALITE_ORE = BLOCKS.register("deepslate_tantalite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> THORIANITE_ORE = BLOCKS.register("thorianite_ore", () -> new RadioactiveOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_THORIANITE_ORE = BLOCKS.register("deepslate_thorianite_ore", () -> new RadioactiveOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = BLOCKS.register("deepslate_topaz_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(TOPAZ_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> URANINITE_ORE = BLOCKS.register("uraninite_ore", () -> new RadioactiveOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_URANINITE_ORE = BLOCKS.register("deepslate_uraninite_ore", () -> new RadioactiveOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> WOLFRAMITE_ORE = BLOCKS.register("wolframite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_WOLFRAMITE_ORE = BLOCKS.register("deepslate_wolframite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> AUTUNITE_CRYSTAL = BLOCKS.register("autunite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> AQUAMARINE_CRYSTAL = BLOCKS.register("aquamarine_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> BARYTE_CRYSTAL = BLOCKS.register("baryte_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> BISMITHUNITE_CRYSTAL = BLOCKS.register("bismithunite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> CELESTINE_CRYSTAL = BLOCKS.register("celestine_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> COLUMBITE_CRYSTAL = BLOCKS.register("columbite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> DOLOMITE_CRYSTAL = BLOCKS.register("dolomite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> FLUORITE_CRYSTAL = BLOCKS.register("fluorite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> HUTCHINSONITE_CRYSTAL = BLOCKS.register("hutchinsonite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> MONAZITE_CRYSTAL = BLOCKS.register("monazite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> POLLUCITE_CRYSTAL = BLOCKS.register("pollucite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> RUTILE_CRYSTAL = BLOCKS.register("rutile_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> SCHEELITE_CRYSTAL = BLOCKS.register("scheelite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> SPHALERITE_CRYSTAL = BLOCKS.register("sphalerite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> STIBNITE_CRYSTAL = BLOCKS.register("stibnite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> STRONTIANITE_CRYSTAL = BLOCKS.register("strontianite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> TELLURITE_CRYSTAL = BLOCKS.register("tellurite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> ULEXITE_CRYSTAL = BLOCKS.register("ulexite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> VANADINITE_CRYSTAL = BLOCKS.register("vanadinite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> WULFENITE_CRYSTAL = BLOCKS.register("wulfenite_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> XENOTIME_CRYSTAL = BLOCKS.register("xenotime_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));
	public static final RegistryObject<Block> ZIRCON_CRYSTAL = BLOCKS.register("zircon_crystal", () -> new TwentyFourDirectionBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(6.0F).sound(SoundType.GLASS).noOcclusion().lightLevel((p_152632_) -> {
		return 5;
	})));

	public static final RegistryObject<Block> BLOCK_OF_RUBY = BLOCKS.register("block_of_ruby", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> BLOCK_OF_SAPPHIRE = BLOCKS.register("block_of_sapphire", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> BLOCK_OF_TOPAZ = BLOCKS.register("block_of_topaz", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<LiquidBlock> HYDROGEN = BLOCKS.register("hydrogen", () -> new LiquidBlock(TechnologicaFluids.HYDROGEN, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> HELIUM = BLOCKS.register("helium", () -> new LiquidBlock(TechnologicaFluids.HELIUM, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> NITROGEN = BLOCKS.register("nitrogen", () -> new LiquidBlock(TechnologicaFluids.NITROGEN, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> OXYGEN = BLOCKS.register("oxygen", () -> new LiquidBlock(TechnologicaFluids.OXYGEN, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> FLUORINE = BLOCKS.register("fluorine", () -> new LiquidBlock(TechnologicaFluids.FLUORINE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> NEON = BLOCKS.register("neon", () -> new LiquidBlock(TechnologicaFluids.NEON, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> CHLORINE = BLOCKS.register("chlorine", () -> new LiquidBlock(TechnologicaFluids.CHLORINE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> ARGON = BLOCKS.register("argon", () -> new LiquidBlock(TechnologicaFluids.ARGON, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> KRYPTON = BLOCKS.register("krypton", () -> new LiquidBlock(TechnologicaFluids.KRYPTON, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> XENON = BLOCKS.register("xenon", () -> new LiquidBlock(TechnologicaFluids.XENON, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> RADON = BLOCKS.register("radon", () -> new LiquidBlock(TechnologicaFluids.RADON, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final RegistryObject<LiquidBlock> BROMINE = BLOCKS.register("bromine", () -> new LiquidBlock(TechnologicaFluids.BROMINE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> MERCURY = BLOCKS.register("mercury", () -> new LiquidBlock(TechnologicaFluids.MERCURY, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final RegistryObject<LiquidBlock> BRINE = BLOCKS.register("brine", () -> new LiquidBlock(TechnologicaFluids.BRINE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> OIL = BLOCKS.register("oil", () -> new LiquidBlock(TechnologicaFluids.OIL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> NATURAL_GAS = BLOCKS.register("natural_gas", () -> new LiquidBlock(TechnologicaFluids.NATURAL_GAS, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final RegistryObject<LiquidBlock> MAPLE_SYRUP = BLOCKS.register("maple_syrup", () -> new LiquidBlock(TechnologicaFluids.MAPLE_SYRUP, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> RUBBER_RESIN = BLOCKS.register("rubber_resin", () -> new LiquidBlock(TechnologicaFluids.RUBBER_RESIN, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	public static final RegistryObject<LiquidBlock> GASOLINE = BLOCKS.register("gasoline", () -> new LiquidBlock(TechnologicaFluids.GASOLINE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> MACHINE_OIL = BLOCKS.register("machine_oil", () -> new LiquidBlock(TechnologicaFluids.MACHINE_OIL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
	public static final RegistryObject<LiquidBlock> COOLANT = BLOCKS.register("coolant", () -> new LiquidBlock(TechnologicaFluids.COOLANT, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

	/*
	 * CONSTRUCTION
	 */

	public static final RegistryObject<Block> APRICOT_LOG = BLOCKS.register("apricot_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> ASPEN_LOG = BLOCKS.register("aspen_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> AVOCADO_LOG = BLOCKS.register("avocado_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> CHESTNUT_LOG = BLOCKS.register("chestnut_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> CINNAMON_LOG = BLOCKS.register("cinnamon_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> COCONUT_LOG = BLOCKS.register("coconut_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> EBONY_LOG = BLOCKS.register("ebony_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> KIWI_LOG = BLOCKS.register("kiwi_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> LIME_LOG = BLOCKS.register("lime_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> MAHOGANY_LOG = BLOCKS.register("mahogany_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> MAPLE_LOG = BLOCKS.register("maple_log", SapLogBlock::new);
	public static final RegistryObject<Block> OLIVE_LOG = BLOCKS.register("olive_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> PEACH_LOG = BLOCKS.register("peach_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> PEAR_LOG = BLOCKS.register("pear_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> PLUM_LOG = BLOCKS.register("plum_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> REDWOOD_LOG = BLOCKS.register("redwood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ROSEWOOD_LOG = BLOCKS.register("rosewood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> RUBBER_LOG = BLOCKS.register("rubber_log", SapLogBlock::new);
	public static final RegistryObject<Block> TEAK_LOG = BLOCKS.register("teak_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> WALNUT_LOG = BLOCKS.register("walnut_log", FruitingLogBlock::new);
	public static final RegistryObject<Block> ZEBRAWOOD_LOG = BLOCKS.register("zebrawood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ALCHEMICAL_LOG = BLOCKS.register("alchemical_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> BENEVOLENT_LOG = BLOCKS.register("benevolent_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> CONDUCTIVE_LOG = BLOCKS.register("conductive_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> FROSTBITTEN_LOG = BLOCKS.register("frostbitten_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.ICE).strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FRUITFUL_LOG = BLOCKS.register("fruitful_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> INFERNAL_LOG = BLOCKS.register("infernal_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> MALEVOLENT_LOG = BLOCKS.register("malevolent_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> NECROTIC_LOG = BLOCKS.register("necrotic_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));

	public static final RegistryObject<Block> STRIPPED_APRICOT_LOG = BLOCKS.register("stripped_apricot_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = BLOCKS.register("stripped_aspen_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_AVOCADO_LOG = BLOCKS.register("stripped_avocado_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_BANANA_LOG = BLOCKS.register("stripped_banana_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CHESTNUT_LOG = BLOCKS.register("stripped_chestnut_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CINNAMON_LOG = BLOCKS.register("stripped_cinnamon_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_COCONUT_LOG = BLOCKS.register("stripped_coconut_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_EBONY_LOG = BLOCKS.register("stripped_ebony_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_KIWI_LOG = BLOCKS.register("stripped_kiwi_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_LEMON_LOG = BLOCKS.register("stripped_lemon_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_LIME_LOG = BLOCKS.register("stripped_lime_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = BLOCKS.register("stripped_mahogany_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = BLOCKS.register("stripped_maple_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ORANGE_LOG = BLOCKS.register("stripped_orange_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PEACH_LOG = BLOCKS.register("stripped_peach_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PEAR_LOG = BLOCKS.register("stripped_pear_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PLUM_LOG = BLOCKS.register("stripped_plum_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = BLOCKS.register("stripped_redwood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ROSEWOOD_LOG = BLOCKS.register("stripped_rosewood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = BLOCKS.register("stripped_rubber_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_TEAK_LOG = BLOCKS.register("stripped_teak_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_WALNUT_LOG = BLOCKS.register("stripped_walnut_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ZEBRAWOOD_LOG = BLOCKS.register("stripped_zebrawood_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ALCHEMICAL_LOG = BLOCKS.register("stripped_alchemical_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_BENEVOLENT_LOG = BLOCKS.register("stripped_benevolent_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CONDUCTIVE_LOG = BLOCKS.register("stripped_conductive_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_FROSTBITTEN_LOG = BLOCKS.register("stripped_frostbitten_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).strength(0.5F).sound(SoundType.GLASS).noOcclusion()));;
	public static final RegistryObject<Block> STRIPPED_FRUITFUL_LOG = BLOCKS.register("stripped_fruitful_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_INFERNAL_LOG = BLOCKS.register("stripped_infernal_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MALEVOLENT_LOG = BLOCKS.register("stripped_malevolent_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_NECROTIC_LOG = BLOCKS.register("stripped_necrotic_log", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));

	public static final RegistryObject<Block> APRICOT_WOOD = BLOCKS.register("apricot_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ASPEN_WOOD = BLOCKS.register("aspen_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> AVOCADO_WOOD = BLOCKS.register("avocado_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> BANANA_WOOD = BLOCKS.register("banana_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> CHESTNUT_WOOD = BLOCKS.register("chestnut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> CINNAMON_WOOD = BLOCKS.register("cinnamon_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> COCONUT_WOOD = BLOCKS.register("coconut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> EBONY_WOOD = BLOCKS.register("ebony_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> KIWI_WOOD = BLOCKS.register("kiwi_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> LEMON_WOOD = BLOCKS.register("lemon_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> LIME_WOOD = BLOCKS.register("lime_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> MAHOGANY_WOOD = BLOCKS.register("mahogany_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> MAPLE_WOOD = BLOCKS.register("maple_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> OLIVE_WOOD = BLOCKS.register("olive_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ORANGE_WOOD = BLOCKS.register("orange_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> PEACH_WOOD = BLOCKS.register("peach_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> PEAR_WOOD = BLOCKS.register("pear_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> PLUM_WOOD = BLOCKS.register("plum_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> REDWOOD_WOOD = BLOCKS.register("redwood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ROSEWOOD_WOOD = BLOCKS.register("rosewood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> RUBBER_WOOD = BLOCKS.register("rubber_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> TEAK_WOOD = BLOCKS.register("teak_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> WALNUT_WOOD = BLOCKS.register("walnut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ZEBRAWOOD_WOOD = BLOCKS.register("zebrawood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> FRUITFUL_WOOD = BLOCKS.register("fruitful_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> ALCHEMICAL_WOOD = BLOCKS.register("alchemical_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> BENEVOLENT_WOOD = BLOCKS.register("benevolent_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> MALEVOLENT_WOOD = BLOCKS.register("malevolent_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> NECROTIC_WOOD = BLOCKS.register("necrotic_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> CONDUCTIVE_WOOD = BLOCKS.register("conductive_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> FROSTBITTEN_WOOD = BLOCKS.register("frostbitten_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> INFERNAL_WOOD = BLOCKS.register("infernal_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));

	public static final RegistryObject<Block> STRIPPED_APRICOT_WOOD = BLOCKS.register("stripped_apricot_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = BLOCKS.register("stripped_aspen_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_AVOCADO_WOOD = BLOCKS.register("stripped_avocado_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_BANANA_WOOD = BLOCKS.register("stripped_banana_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CHESTNUT_WOOD = BLOCKS.register("stripped_chestnut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CINNAMON_WOOD = BLOCKS.register("stripped_cinnamon_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_COCONUT_WOOD = BLOCKS.register("stripped_coconut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = BLOCKS.register("stripped_ebony_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_KIWI_WOOD = BLOCKS.register("stripped_kiwi_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_LEMON_WOOD = BLOCKS.register("stripped_lemon_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_LIME_WOOD = BLOCKS.register("stripped_lime_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = BLOCKS.register("stripped_mahogany_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = BLOCKS.register("stripped_maple_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = BLOCKS.register("stripped_olive_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ORANGE_WOOD = BLOCKS.register("stripped_orange_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PEACH_WOOD = BLOCKS.register("stripped_peach_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PEAR_WOOD = BLOCKS.register("stripped_pear_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_PLUM_WOOD = BLOCKS.register("stripped_plum_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = BLOCKS.register("stripped_redwood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ROSEWOOD_WOOD = BLOCKS.register("stripped_rosewood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = BLOCKS.register("stripped_rubber_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_TEAK_WOOD = BLOCKS.register("stripped_teak_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_WALNUT_WOOD = BLOCKS.register("stripped_walnut_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ZEBRAWOOD_WOOD = BLOCKS.register("stripped_zebrawood_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_FRUITFUL_WOOD = BLOCKS.register("stripped_fruitful_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_ALCHEMICAL_WOOD = BLOCKS.register("stripped_alchemical_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_BENEVOLENT_WOOD = BLOCKS.register("stripped_benevolent_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_MALEVOLENT_WOOD = BLOCKS.register("stripped_malevolent_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_NECROTIC_WOOD = BLOCKS.register("stripped_necrotic_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_CONDUCTIVE_WOOD = BLOCKS.register("stripped_conductive_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
	public static final RegistryObject<Block> STRIPPED_FROSTBITTEN_WOOD = BLOCKS.register("stripped_frostbitten_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> STRIPPED_INFERNAL_WOOD = BLOCKS.register("stripped_infernal_wood", () -> logBlock(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));

	public static final RegistryObject<Block> APRICOT_PLANKS = BLOCKS.register("apricot_planks", () -> planksBlock());
	public static final RegistryObject<Block> ASPEN_PLANKS = BLOCKS.register("aspen_planks", () -> planksBlock());
	public static final RegistryObject<Block> AVOCADO_PLANKS = BLOCKS.register("avocado_planks", () -> planksBlock());
	public static final RegistryObject<Block> BANANA_PLANKS = BLOCKS.register("banana_planks", () -> planksBlock());
	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> planksBlock());
	public static final RegistryObject<Block> CHESTNUT_PLANKS = BLOCKS.register("chestnut_planks", () -> planksBlock());
	public static final RegistryObject<Block> CINNAMON_PLANKS = BLOCKS.register("cinnamon_planks", () -> planksBlock());
	public static final RegistryObject<Block> COCONUT_PLANKS = BLOCKS.register("coconut_planks", () -> planksBlock());
	public static final RegistryObject<Block> EBONY_PLANKS = BLOCKS.register("ebony_planks", () -> planksBlock());
	public static final RegistryObject<Block> KIWI_PLANKS = BLOCKS.register("kiwi_planks", () -> planksBlock());
	public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> planksBlock());
	public static final RegistryObject<Block> LIME_PLANKS = BLOCKS.register("lime_planks", () -> planksBlock());
	public static final RegistryObject<Block> MAHOGANY_PLANKS = BLOCKS.register("mahogany_planks", () -> planksBlock());
	public static final RegistryObject<Block> MAPLE_PLANKS = BLOCKS.register("maple_planks", () -> planksBlock());
	public static final RegistryObject<Block> OLIVE_PLANKS = BLOCKS.register("olive_planks", () -> planksBlock());
	public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> planksBlock());
	public static final RegistryObject<Block> PEACH_PLANKS = BLOCKS.register("peach_planks", () -> planksBlock());
	public static final RegistryObject<Block> PEAR_PLANKS = BLOCKS.register("pear_planks", () -> planksBlock());
	public static final RegistryObject<Block> PLUM_PLANKS = BLOCKS.register("plum_planks", () -> planksBlock());
	public static final RegistryObject<Block> REDWOOD_PLANKS = BLOCKS.register("redwood_planks", () -> planksBlock());
	public static final RegistryObject<Block> ROSEWOOD_PLANKS = BLOCKS.register("rosewood_planks", () -> planksBlock());
	public static final RegistryObject<Block> RUBBER_PLANKS = BLOCKS.register("rubber_planks", () -> planksBlock());
	public static final RegistryObject<Block> TEAK_PLANKS = BLOCKS.register("teak_planks", () -> planksBlock());
	public static final RegistryObject<Block> WALNUT_PLANKS = BLOCKS.register("walnut_planks", () -> planksBlock());
	public static final RegistryObject<Block> ZEBRAWOOD_PLANKS = BLOCKS.register("zebrawood_planks", () -> planksBlock());
	public static final RegistryObject<Block> ALCHEMICAL_PLANKS = BLOCKS.register("alchemical_planks", () -> planksBlock());
	public static final RegistryObject<Block> BENEVOLENT_PLANKS = BLOCKS.register("benevolent_planks", () -> planksBlock());
	public static final RegistryObject<Block> CONDUCTIVE_PLANKS = BLOCKS.register("conductive_planks", () -> planksBlock());
	public static final RegistryObject<Block> FROSTBITTEN_PLANKS = BLOCKS.register("frostbitten_planks", () -> new Block(BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FRUITFUL_PLANKS = BLOCKS.register("fruitful_planks", () -> planksBlock());
	public static final RegistryObject<Block> INFERNAL_PLANKS = BLOCKS.register("infernal_planks", () -> planksBlock());
	public static final RegistryObject<Block> MALEVOLENT_PLANKS = BLOCKS.register("malevolent_planks", () -> planksBlock());
	public static final RegistryObject<Block> NECROTIC_PLANKS = BLOCKS.register("necrotic_planks", () -> planksBlock());

	public static final RegistryObject<Block> APRICOT_SLAB = BLOCKS.register("apricot_slab", () -> slabBlock());
	public static final RegistryObject<Block> ASPEN_SLAB = BLOCKS.register("aspen_slab", () -> slabBlock());
	public static final RegistryObject<Block> AVOCADO_SLAB = BLOCKS.register("avocado_slab", () -> slabBlock());
	public static final RegistryObject<Block> BANANA_SLAB = BLOCKS.register("banana_slab", () -> slabBlock());
	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", () -> slabBlock());
	public static final RegistryObject<Block> CHESTNUT_SLAB = BLOCKS.register("chestnut_slab", () -> slabBlock());
	public static final RegistryObject<Block> CINNAMON_SLAB = BLOCKS.register("cinnamon_slab", () -> slabBlock());
	public static final RegistryObject<Block> COCONUT_SLAB = BLOCKS.register("coconut_slab", () -> slabBlock());
	public static final RegistryObject<Block> EBONY_SLAB = BLOCKS.register("ebony_slab", () -> slabBlock());
	public static final RegistryObject<Block> KIWI_SLAB = BLOCKS.register("kiwi_slab", () -> slabBlock());
	public static final RegistryObject<Block> LEMON_SLAB = BLOCKS.register("lemon_slab", () -> slabBlock());
	public static final RegistryObject<Block> LIME_SLAB = BLOCKS.register("lime_slab", () -> slabBlock());
	public static final RegistryObject<Block> MAHOGANY_SLAB = BLOCKS.register("mahogany_slab", () -> slabBlock());
	public static final RegistryObject<Block> MAPLE_SLAB = BLOCKS.register("maple_slab", () -> slabBlock());
	public static final RegistryObject<Block> OLIVE_SLAB = BLOCKS.register("olive_slab", () -> slabBlock());
	public static final RegistryObject<Block> ORANGE_SLAB = BLOCKS.register("orange_slab", () -> slabBlock());
	public static final RegistryObject<Block> PEACH_SLAB = BLOCKS.register("peach_slab", () -> slabBlock());
	public static final RegistryObject<Block> PEAR_SLAB = BLOCKS.register("pear_slab", () -> slabBlock());
	public static final RegistryObject<Block> PLUM_SLAB = BLOCKS.register("plum_slab", () -> slabBlock());
	public static final RegistryObject<Block> REDWOOD_SLAB = BLOCKS.register("redwood_slab", () -> slabBlock());
	public static final RegistryObject<Block> ROSEWOOD_SLAB = BLOCKS.register("rosewood_slab", () -> slabBlock());
	public static final RegistryObject<Block> RUBBER_SLAB = BLOCKS.register("rubber_slab", () -> slabBlock());
	public static final RegistryObject<Block> TEAK_SLAB = BLOCKS.register("teak_slab", () -> slabBlock());
	public static final RegistryObject<Block> WALNUT_SLAB = BLOCKS.register("walnut_slab", () -> slabBlock());
	public static final RegistryObject<Block> ZEBRAWOOD_SLAB = BLOCKS.register("zebrawood_slab", () -> slabBlock());
	public static final RegistryObject<Block> ALCHEMICAL_SLAB = BLOCKS.register("alchemical_slab", () -> slabBlock());
	public static final RegistryObject<Block> BENEVOLENT_SLAB = BLOCKS.register("benevolent_slab", () -> slabBlock());
	public static final RegistryObject<Block> CONDUCTIVE_SLAB = BLOCKS.register("conductive_slab", () -> slabBlock());
	public static final RegistryObject<Block> FROSTBITTEN_SLAB = BLOCKS.register("frostbitten_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FRUITFUL_SLAB = BLOCKS.register("fruitful_slab", () -> slabBlock());
	public static final RegistryObject<Block> INFERNAL_SLAB = BLOCKS.register("infernal_slab", () -> slabBlock());
	public static final RegistryObject<Block> MALEVOLENT_SLAB = BLOCKS.register("malevolent_slab", () -> slabBlock());
	public static final RegistryObject<Block> NECROTIC_SLAB = BLOCKS.register("necrotic_slab", () -> slabBlock());

	public static final RegistryObject<Block> APRICOT_STAIRS = BLOCKS.register("apricot_stairs", () -> stairBlock(() -> APRICOT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> ASPEN_STAIRS = BLOCKS.register("aspen_stairs", () -> stairBlock(() -> ASPEN_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> AVOCADO_STAIRS = BLOCKS.register("avocado_stairs", () -> stairBlock(() -> AVOCADO_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> BANANA_STAIRS = BLOCKS.register("banana_stairs", () -> stairBlock(() -> BANANA_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> stairBlock(() -> CHERRY_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> CHESTNUT_STAIRS = BLOCKS.register("chestnut_stairs", () -> stairBlock(() -> CHESTNUT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> CINNAMON_STAIRS = BLOCKS.register("cinnamon_stairs", () -> stairBlock(() -> CINNAMON_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> COCONUT_STAIRS = BLOCKS.register("coconut_stairs", () -> stairBlock(() -> COCONUT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> EBONY_STAIRS = BLOCKS.register("ebony_stairs", () -> stairBlock(() -> EBONY_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> KIWI_STAIRS = BLOCKS.register("kiwi_stairs", () -> stairBlock(() -> KIWI_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> LEMON_STAIRS = BLOCKS.register("lemon_stairs", () -> stairBlock(() -> LEMON_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> LIME_STAIRS = BLOCKS.register("lime_stairs", () -> stairBlock(() -> LIME_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> MAHOGANY_STAIRS = BLOCKS.register("mahogany_stairs", () -> stairBlock(() -> MAHOGANY_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> MAPLE_STAIRS = BLOCKS.register("maple_stairs", () -> stairBlock(() -> MAPLE_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> OLIVE_STAIRS = BLOCKS.register("olive_stairs", () -> stairBlock(() -> OLIVE_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> ORANGE_STAIRS = BLOCKS.register("orange_stairs", () -> stairBlock(() -> ORANGE_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> PEACH_STAIRS = BLOCKS.register("peach_stairs", () -> stairBlock(() -> PEACH_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> PEAR_STAIRS = BLOCKS.register("pear_stairs", () -> stairBlock(() -> PEAR_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> PLUM_STAIRS = BLOCKS.register("plum_stairs", () -> stairBlock(() -> PLUM_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> REDWOOD_STAIRS = BLOCKS.register("redwood_stairs", () -> stairBlock(() -> REDWOOD_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> ROSEWOOD_STAIRS = BLOCKS.register("rosewood_stairs", () -> stairBlock(() -> ROSEWOOD_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> RUBBER_STAIRS = BLOCKS.register("rubber_stairs", () -> stairBlock(() -> RUBBER_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> TEAK_STAIRS = BLOCKS.register("teak_stairs", () -> stairBlock(() -> TEAK_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> WALNUT_STAIRS = BLOCKS.register("walnut_stairs", () -> stairBlock(() -> WALNUT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> ZEBRAWOOD_STAIRS = BLOCKS.register("zebrawood_stairs", () -> stairBlock(() -> ZEBRAWOOD_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> ALCHEMICAL_STAIRS = BLOCKS.register("alchemical_stairs", () -> stairBlock(() -> ALCHEMICAL_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> BENEVOLENT_STAIRS = BLOCKS.register("benevolent_stairs", () -> stairBlock(() -> BENEVOLENT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> CONDUCTIVE_STAIRS = BLOCKS.register("conductive_stairs", () -> stairBlock(() -> CONDUCTIVE_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> FROSTBITTEN_STAIRS = BLOCKS.register("frostbitten_stairs", () -> new StairBlock(() -> FROSTBITTEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FRUITFUL_STAIRS = BLOCKS.register("fruitful_stairs", () -> stairBlock(() -> FRUITFUL_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> INFERNAL_STAIRS = BLOCKS.register("infernal_stairs", () -> stairBlock(() -> INFERNAL_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> MALEVOLENT_STAIRS = BLOCKS.register("malevolent_stairs", () -> stairBlock(() -> MALEVOLENT_PLANKS.get().defaultBlockState()));
	public static final RegistryObject<Block> NECROTIC_STAIRS = BLOCKS.register("necrotic_stairs", () -> stairBlock(() -> NECROTIC_PLANKS.get().defaultBlockState()));

	public static final RegistryObject<Block> SPRUCE_BOOKSHELF = BLOCKS.register("spruce_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> BIRCH_BOOKSHELF = BLOCKS.register("birch_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> JUNGLE_BOOKSHELF = BLOCKS.register("jungle_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ACACIA_BOOKSHELF = BLOCKS.register("acacia_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = BLOCKS.register("dark_oak_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> CRIMSON_BOOKSHELF = BLOCKS.register("crimson_bookshelf", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WARPED_BOOKSHELF = BLOCKS.register("warped_bookshelf", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> APRICOT_BOOKSHELF = BLOCKS.register("apricot_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ASPEN_BOOKSHELF = BLOCKS.register("aspen_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> AVOCADO_BOOKSHELF = BLOCKS.register("avocado_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> BANANA_BOOKSHELF = BLOCKS.register("banana_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> CHERRY_BOOKSHELF = BLOCKS.register("cherry_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> CHESTNUT_BOOKSHELF = BLOCKS.register("chestnut_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> CINNAMON_BOOKSHELF = BLOCKS.register("cinnamon_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> COCONUT_BOOKSHELF = BLOCKS.register("coconut_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> EBONY_BOOKSHELF = BLOCKS.register("ebony_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> KIWI_BOOKSHELF = BLOCKS.register("kiwi_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> LEMON_BOOKSHELF = BLOCKS.register("lemon_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> LIME_BOOKSHELF = BLOCKS.register("lime_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> MAHOGANY_BOOKSHELF = BLOCKS.register("mahogany_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> MAPLE_BOOKSHELF = BLOCKS.register("maple_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> OLIVE_BOOKSHELF = BLOCKS.register("olive_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ORANGE_BOOKSHELF = BLOCKS.register("orange_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> PEACH_BOOKSHELF = BLOCKS.register("peach_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> PEAR_BOOKSHELF = BLOCKS.register("pear_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> PLUM_BOOKSHELF = BLOCKS.register("plum_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> REDWOOD_BOOKSHELF = BLOCKS.register("redwood_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ROSEWOOD_BOOKSHELF = BLOCKS.register("rosewood_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> RUBBER_BOOKSHELF = BLOCKS.register("rubber_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> TEAK_BOOKSHELF = BLOCKS.register("teak_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> WALNUT_BOOKSHELF = BLOCKS.register("walnut_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ZEBRAWOOD_BOOKSHELF = BLOCKS.register("zebrawood_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> ALCHEMICAL_BOOKSHELF = BLOCKS.register("alchemical_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> BENEVOLENT_BOOKSHELF = BLOCKS.register("benevolent_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> CONDUCTIVE_BOOKSHELF = BLOCKS.register("conductive_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> FROSTBITTEN_BOOKSHELF = BLOCKS.register("frostbitten_bookshelf", () -> new Block(BlockBehaviour.Properties.of(Material.ICE).friction(0.98F).randomTicks().strength(0.5F).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> FRUITFUL_BOOKSHELF = BLOCKS.register("fruitful_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> INFERNAL_BOOKSHELF = BLOCKS.register("infernal_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> MALEVOLENT_BOOKSHELF = BLOCKS.register("malevolent_bookshelf", () -> bookshelfBlock());
	public static final RegistryObject<Block> NECROTIC_BOOKSHELF = BLOCKS.register("necrotic_bookshelf", () -> bookshelfBlock());

	public static final RegistryObject<Block> APRICOT_FENCE = BLOCKS.register("apricot_fence", () -> fenceBlock());
	public static final RegistryObject<Block> ASPEN_FENCE = BLOCKS.register("aspen_fence", () -> fenceBlock());
	public static final RegistryObject<Block> AVOCADO_FENCE = BLOCKS.register("avocado_fence", () -> fenceBlock());
	public static final RegistryObject<Block> BANANA_FENCE = BLOCKS.register("banana_fence", () -> fenceBlock());
	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> fenceBlock());
	public static final RegistryObject<Block> CHESTNUT_FENCE = BLOCKS.register("chestnut_fence", () -> fenceBlock());
	public static final RegistryObject<Block> CINNAMON_FENCE = BLOCKS.register("cinnamon_fence", () -> fenceBlock());
	public static final RegistryObject<Block> COCONUT_FENCE = BLOCKS.register("coconut_fence", () -> fenceBlock());
	public static final RegistryObject<Block> EBONY_FENCE = BLOCKS.register("ebony_fence", () -> fenceBlock());
	public static final RegistryObject<Block> KIWI_FENCE = BLOCKS.register("kiwi_fence", () -> fenceBlock());
	public static final RegistryObject<Block> LEMON_FENCE = BLOCKS.register("lemon_fence", () -> fenceBlock());
	public static final RegistryObject<Block> LIME_FENCE = BLOCKS.register("lime_fence", () -> fenceBlock());
	public static final RegistryObject<Block> MAHOGANY_FENCE = BLOCKS.register("mahogany_fence", () -> fenceBlock());
	public static final RegistryObject<Block> MAPLE_FENCE = BLOCKS.register("maple_fence", () -> fenceBlock());
	public static final RegistryObject<Block> OLIVE_FENCE = BLOCKS.register("olive_fence", () -> fenceBlock());
	public static final RegistryObject<Block> ORANGE_FENCE = BLOCKS.register("orange_fence", () -> fenceBlock());;
	public static final RegistryObject<Block> PEACH_FENCE = BLOCKS.register("peach_fence", () -> fenceBlock());
	public static final RegistryObject<Block> PEAR_FENCE = BLOCKS.register("pear_fence", () -> fenceBlock());
	public static final RegistryObject<Block> PLUM_FENCE = BLOCKS.register("plum_fence", () -> fenceBlock());
	public static final RegistryObject<Block> REDWOOD_FENCE = BLOCKS.register("redwood_fence", () -> fenceBlock());
	public static final RegistryObject<Block> ROSEWOOD_FENCE = BLOCKS.register("rosewood_fence", () -> fenceBlock());
	public static final RegistryObject<Block> RUBBER_FENCE = BLOCKS.register("rubber_fence", () -> fenceBlock());
	public static final RegistryObject<Block> TEAK_FENCE = BLOCKS.register("teak_fence", () -> fenceBlock());
	public static final RegistryObject<Block> WALNUT_FENCE = BLOCKS.register("walnut_fence", () -> fenceBlock());
	public static final RegistryObject<Block> ZEBRAWOOD_FENCE = BLOCKS.register("zebrawood_fence", () -> fenceBlock());
	public static final RegistryObject<Block> ALCHEMICAL_FENCE = BLOCKS.register("alchemical_fence", () -> fenceBlock());
	public static final RegistryObject<Block> BENEVOLENT_FENCE = BLOCKS.register("benevolent_fence", () -> fenceBlock());
	public static final RegistryObject<Block> CONDUCTIVE_FENCE = BLOCKS.register("conductive_fence", () -> fenceBlock());
	public static final RegistryObject<Block> FROSTBITTEN_FENCE = BLOCKS.register("frostbitten_fence", () -> fenceBlock());
	public static final RegistryObject<Block> FRUITFUL_FENCE = BLOCKS.register("fruitful_fence", () -> fenceBlock());
	public static final RegistryObject<Block> INFERNAL_FENCE = BLOCKS.register("infernal_fence", () -> fenceBlock());
	public static final RegistryObject<Block> MALEVOLENT_FENCE = BLOCKS.register("malevolent_fence", () -> fenceBlock());
	public static final RegistryObject<Block> NECROTIC_FENCE = BLOCKS.register("necrotic_fence", () -> fenceBlock());

	public static final RegistryObject<Block> APRICOT_FENCE_GATE = BLOCKS.register("apricot_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> ASPEN_FENCE_GATE = BLOCKS.register("aspen_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> AVOCADO_FENCE_GATE = BLOCKS.register("avocado_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> BANANA_FENCE_GATE = BLOCKS.register("banana_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> CHESTNUT_FENCE_GATE = BLOCKS.register("chestnut_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> CINNAMON_FENCE_GATE = BLOCKS.register("cinnamon_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> COCONUT_FENCE_GATE = BLOCKS.register("coconut_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> EBONY_FENCE_GATE = BLOCKS.register("ebony_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> KIWI_FENCE_GATE = BLOCKS.register("kiwi_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> LEMON_FENCE_GATE = BLOCKS.register("lemon_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> LIME_FENCE_GATE = BLOCKS.register("lime_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> MAHOGANY_FENCE_GATE = BLOCKS.register("mahogany_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> MAPLE_FENCE_GATE = BLOCKS.register("maple_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> OLIVE_FENCE_GATE = BLOCKS.register("olive_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> ORANGE_FENCE_GATE = BLOCKS.register("orange_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> PEACH_FENCE_GATE = BLOCKS.register("peach_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> PEAR_FENCE_GATE = BLOCKS.register("pear_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> PLUM_FENCE_GATE = BLOCKS.register("plum_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> REDWOOD_FENCE_GATE = BLOCKS.register("redwood_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> ROSEWOOD_FENCE_GATE = BLOCKS.register("rosewood_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> RUBBER_FENCE_GATE = BLOCKS.register("rubber_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> TEAK_FENCE_GATE = BLOCKS.register("teak_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> WALNUT_FENCE_GATE = BLOCKS.register("walnut_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> ZEBRAWOOD_FENCE_GATE = BLOCKS.register("zebrawood_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> ALCHEMICAL_FENCE_GATE = BLOCKS.register("alchemical_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> BENEVOLENT_FENCE_GATE = BLOCKS.register("benevolent_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> CONDUCTIVE_FENCE_GATE = BLOCKS.register("conductive_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> FROSTBITTEN_FENCE_GATE = BLOCKS.register("frostbitten_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> FRUITFUL_FENCE_GATE = BLOCKS.register("fruitful_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> INFERNAL_FENCE_GATE = BLOCKS.register("infernal_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> MALEVOLENT_FENCE_GATE = BLOCKS.register("malevolent_fence_gate", () -> fenceGateBlock());
	public static final RegistryObject<Block> NECROTIC_FENCE_GATE = BLOCKS.register("necrotic_fence_gate", () -> fenceGateBlock());

	public static final RegistryObject<Block> APRICOT_DOOR = BLOCKS.register("apricot_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> ASPEN_DOOR = BLOCKS.register("aspen_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> AVOCADO_DOOR = BLOCKS.register("avocado_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> BANANA_DOOR = BLOCKS.register("banana_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> CHESTNUT_DOOR = BLOCKS.register("chestnut_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> CINNAMON_DOOR = BLOCKS.register("cinnamon_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> COCONUT_DOOR = BLOCKS.register("coconut_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> EBONY_DOOR = BLOCKS.register("ebony_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> KIWI_DOOR = BLOCKS.register("kiwi_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> LEMON_DOOR = BLOCKS.register("lemon_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> LIME_DOOR = BLOCKS.register("lime_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> MAHOGANY_DOOR = BLOCKS.register("mahogany_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> MAPLE_DOOR = BLOCKS.register("maple_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> OLIVE_DOOR = BLOCKS.register("olive_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> ORANGE_DOOR = BLOCKS.register("orange_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> PEACH_DOOR = BLOCKS.register("peach_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> PEAR_DOOR = BLOCKS.register("pear_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> PLUM_DOOR = BLOCKS.register("plum_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> REDWOOD_DOOR = BLOCKS.register("redwood_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> ROSEWOOD_DOOR = BLOCKS.register("rosewood_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> RUBBER_DOOR = BLOCKS.register("rubber_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> TEAK_DOOR = BLOCKS.register("teak_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> WALNUT_DOOR = BLOCKS.register("walnut_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> ZEBRAWOOD_DOOR = BLOCKS.register("zebrawood_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> ALCHEMICAL_DOOR = BLOCKS.register("alchemical_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> BENEVOLENT_DOOR = BLOCKS.register("benevolent_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> CONDUCTIVE_DOOR = BLOCKS.register("conductive_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> FROSTBITTEN_DOOR = BLOCKS.register("frostbitten_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> FRUITFUL_DOOR = BLOCKS.register("fruitful_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> INFERNAL_DOOR = BLOCKS.register("infernal_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> MALEVOLENT_DOOR = BLOCKS.register("malevolent_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
	public static final RegistryObject<Block> NECROTIC_DOOR = BLOCKS.register("necrotic_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));

	public static final RegistryObject<Block> APRICOT_TRAPDOOR = BLOCKS.register("apricot_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> ASPEN_TRAPDOOR = BLOCKS.register("aspen_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> AVOCADO_TRAPDOOR = BLOCKS.register("avocado_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> BANANA_TRAPDOOR = BLOCKS.register("banana_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> CHESTNUT_TRAPDOOR = BLOCKS.register("chestnut_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> CINNAMON_TRAPDOOR = BLOCKS.register("cinnamon_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> COCONUT_TRAPDOOR = BLOCKS.register("coconut_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> EBONY_TRAPDOOR = BLOCKS.register("ebony_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> KIWI_TRAPDOOR = BLOCKS.register("kiwi_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> LEMON_TRAPDOOR = BLOCKS.register("lemon_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> LIME_TRAPDOOR = BLOCKS.register("lime_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> MAHOGANY_TRAPDOOR = BLOCKS.register("mahogany_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> MAPLE_TRAPDOOR = BLOCKS.register("maple_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> OLIVE_TRAPDOOR = BLOCKS.register("olive_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> ORANGE_TRAPDOOR = BLOCKS.register("orange_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> PEACH_TRAPDOOR = BLOCKS.register("peach_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> PEAR_TRAPDOOR = BLOCKS.register("pear_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> PLUM_TRAPDOOR = BLOCKS.register("plum_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> REDWOOD_TRAPDOOR = BLOCKS.register("redwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> ROSEWOOD_TRAPDOOR = BLOCKS.register("rosewood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> RUBBER_TRAPDOOR = BLOCKS.register("rubber_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> TEAK_TRAPDOOR = BLOCKS.register("teak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> WALNUT_TRAPDOOR = BLOCKS.register("walnut_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> ZEBRAWOOD_TRAPDOOR = BLOCKS.register("zebrawood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> ALCHEMICAL_TRAPDOOR = BLOCKS.register("alchemical_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> BENEVOLENT_TRAPDOOR = BLOCKS.register("benevolent_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> CONDUCTIVE_TRAPDOOR = BLOCKS.register("conductive_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> FROSTBITTEN_TRAPDOOR = BLOCKS.register("frostbitten_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> FRUITFUL_TRAPDOOR = BLOCKS.register("fruitful_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> INFERNAL_TRAPDOOR = BLOCKS.register("infernal_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> MALEVOLENT_TRAPDOOR = BLOCKS.register("malevolent_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
	public static final RegistryObject<Block> NECROTIC_TRAPDOOR = BLOCKS.register("necrotic_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(TechnologicaBlocks::never), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));

	public static final RegistryObject<Block> APRICOT_PRESSURE_PLATE = BLOCKS.register("apricot_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> ASPEN_PRESSURE_PLATE = BLOCKS.register("aspen_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> AVOCADO_PRESSURE_PLATE = BLOCKS.register("avocado_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> BANANA_PRESSURE_PLATE = BLOCKS.register("banana_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = BLOCKS.register("cherry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> CHESTNUT_PRESSURE_PLATE = BLOCKS.register("chestnut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> CINNAMON_PRESSURE_PLATE = BLOCKS.register("cinnamon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> COCONUT_PRESSURE_PLATE = BLOCKS.register("coconut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> EBONY_PRESSURE_PLATE = BLOCKS.register("ebony_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> KIWI_PRESSURE_PLATE = BLOCKS.register("kiwi_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> LEMON_PRESSURE_PLATE = BLOCKS.register("lemon_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> LIME_PRESSURE_PLATE = BLOCKS.register("lime_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> MAHOGANY_PRESSURE_PLATE = BLOCKS.register("mahogany_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = BLOCKS.register("maple_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = BLOCKS.register("olive_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = BLOCKS.register("orange_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> PEACH_PRESSURE_PLATE = BLOCKS.register("peach_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> PEAR_PRESSURE_PLATE = BLOCKS.register("pear_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> PLUM_PRESSURE_PLATE = BLOCKS.register("plum_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = BLOCKS.register("redwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> ROSEWOOD_PRESSURE_PLATE = BLOCKS.register("rosewood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> RUBBER_PRESSURE_PLATE = BLOCKS.register("rubber_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> TEAK_PRESSURE_PLATE = BLOCKS.register("teak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> WALNUT_PRESSURE_PLATE = BLOCKS.register("walnut_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> ZEBRAWOOD_PRESSURE_PLATE = BLOCKS.register("zebrawood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> ALCHEMICAL_PRESSURE_PLATE = BLOCKS.register("alchemical_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> BENEVOLENT_PRESSURE_PLATE = BLOCKS.register("benevolent_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> CONDUCTIVE_PRESSURE_PLATE = BLOCKS.register("conductive_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> FROSTBITTEN_PRESSURE_PLATE = BLOCKS.register("frostbitten_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> FRUITFUL_PRESSURE_PLATE = BLOCKS.register("fruitful_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> INFERNAL_PRESSURE_PLATE = BLOCKS.register("infernal_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> MALEVOLENT_PRESSURE_PLATE = BLOCKS.register("malevolent_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
	public static final RegistryObject<Block> NECROTIC_PRESSURE_PLATE = BLOCKS.register("necrotic_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));

	public static final RegistryObject<Block> APRICOT_BUTTON = BLOCKS.register("apricot_button", () -> woodenButton());
	public static final RegistryObject<Block> ASPEN_BUTTON = BLOCKS.register("aspen_button", () -> woodenButton());
	public static final RegistryObject<Block> AVOCADO_BUTTON = BLOCKS.register("avocado_button", () -> woodenButton());
	public static final RegistryObject<Block> BANANA_BUTTON = BLOCKS.register("banana_button", () -> woodenButton());
	public static final RegistryObject<Block> CHERRY_BUTTON = BLOCKS.register("cherry_button", () -> woodenButton());
	public static final RegistryObject<Block> CHESTNUT_BUTTON = BLOCKS.register("chestnut_button", () -> woodenButton());
	public static final RegistryObject<Block> CINNAMON_BUTTON = BLOCKS.register("cinnamon_button", () -> woodenButton());
	public static final RegistryObject<Block> COCONUT_BUTTON = BLOCKS.register("coconut_button", () -> woodenButton());
	public static final RegistryObject<Block> EBONY_BUTTON = BLOCKS.register("ebony_button", () -> woodenButton());
	public static final RegistryObject<Block> KIWI_BUTTON = BLOCKS.register("kiwi_button", () -> woodenButton());
	public static final RegistryObject<Block> LEMON_BUTTON = BLOCKS.register("lemon_button", () -> woodenButton());
	public static final RegistryObject<Block> LIME_BUTTON = BLOCKS.register("lime_button", () -> woodenButton());
	public static final RegistryObject<Block> MAHOGANY_BUTTON = BLOCKS.register("mahogany_button", () -> woodenButton());
	public static final RegistryObject<Block> MAPLE_BUTTON = BLOCKS.register("maple_button", () -> woodenButton());
	public static final RegistryObject<Block> OLIVE_BUTTON = BLOCKS.register("olive_button", () -> woodenButton());
	public static final RegistryObject<Block> ORANGE_BUTTON = BLOCKS.register("orange_button", () -> woodenButton());
	public static final RegistryObject<Block> PEACH_BUTTON = BLOCKS.register("peach_button", () -> woodenButton());
	public static final RegistryObject<Block> PEAR_BUTTON = BLOCKS.register("pear_button", () -> woodenButton());
	public static final RegistryObject<Block> PLUM_BUTTON = BLOCKS.register("plum_button", () -> woodenButton());
	public static final RegistryObject<Block> REDWOOD_BUTTON = BLOCKS.register("redwood_button", () -> woodenButton());
	public static final RegistryObject<Block> ROSEWOOD_BUTTON = BLOCKS.register("rosewood_button", () -> woodenButton());
	public static final RegistryObject<Block> RUBBER_BUTTON = BLOCKS.register("rubber_button", () -> woodenButton());
	public static final RegistryObject<Block> TEAK_BUTTON = BLOCKS.register("teak_button", () -> woodenButton());
	public static final RegistryObject<Block> WALNUT_BUTTON = BLOCKS.register("walnut_button", () -> woodenButton());
	public static final RegistryObject<Block> ZEBRAWOOD_BUTTON = BLOCKS.register("zebrawood_button", () -> woodenButton());
	public static final RegistryObject<Block> ALCHEMICAL_BUTTON = BLOCKS.register("alchemical_button", () -> woodenButton());
	public static final RegistryObject<Block> BENEVOLENT_BUTTON = BLOCKS.register("benevolent_button", () -> woodenButton());
	public static final RegistryObject<Block> CONDUCTIVE_BUTTON = BLOCKS.register("conductive_button", () -> woodenButton());
	public static final RegistryObject<Block> FROSTBITTEN_BUTTON = BLOCKS.register("frostbitten_button", () -> woodenButton());
	public static final RegistryObject<Block> FRUITFUL_BUTTON = BLOCKS.register("fruitful_button", () -> woodenButton());
	public static final RegistryObject<Block> INFERNAL_BUTTON = BLOCKS.register("infernal_button", () -> woodenButton());
	public static final RegistryObject<Block> MALEVOLENT_BUTTON = BLOCKS.register("malevolent_button", () -> woodenButton());
	public static final RegistryObject<Block> NECROTIC_BUTTON = BLOCKS.register("necrotic_button", () -> woodenButton());

	public static final RegistryObject<Block> APRICOT_SIGN = BLOCKS.register("apricot_sign", () -> standingSignBlock(TechnologicaWoodType.APRICOT));
	public static final RegistryObject<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> standingSignBlock(TechnologicaWoodType.ASPEN));
	public static final RegistryObject<Block> AVOCADO_SIGN = BLOCKS.register("avocado_sign", () -> standingSignBlock(TechnologicaWoodType.AVOCADO));
	public static final RegistryObject<Block> BANANA_SIGN = BLOCKS.register("banana_sign", () -> standingSignBlock(TechnologicaWoodType.BANANA));
	public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign", () -> standingSignBlock(TechnologicaWoodType.CHERRY));
	public static final RegistryObject<Block> CHESTNUT_SIGN = BLOCKS.register("chestnut_sign", () -> standingSignBlock(TechnologicaWoodType.CHESTNUT));
	public static final RegistryObject<Block> CINNAMON_SIGN = BLOCKS.register("cinnamon_sign", () -> standingSignBlock(TechnologicaWoodType.CINNAMON));
	public static final RegistryObject<Block> COCONUT_SIGN = BLOCKS.register("coconut_sign", () -> standingSignBlock(TechnologicaWoodType.COCONUT));
	public static final RegistryObject<Block> EBONY_SIGN = BLOCKS.register("ebony_sign", () -> standingSignBlock(TechnologicaWoodType.EBONY));
	public static final RegistryObject<Block> KIWI_SIGN = BLOCKS.register("kiwi_sign", () -> standingSignBlock(TechnologicaWoodType.KIWI));
	public static final RegistryObject<Block> LEMON_SIGN = BLOCKS.register("lemon_sign", () -> standingSignBlock(TechnologicaWoodType.LEMON));
	public static final RegistryObject<Block> LIME_SIGN = BLOCKS.register("lime_sign", () -> standingSignBlock(TechnologicaWoodType.LIME));
	public static final RegistryObject<Block> MAHOGANY_SIGN = BLOCKS.register("mahogany_sign", () -> standingSignBlock(TechnologicaWoodType.MAHOGANY));
	public static final RegistryObject<Block> MAPLE_SIGN = BLOCKS.register("maple_sign", () -> standingSignBlock(TechnologicaWoodType.MAPLE));
	public static final RegistryObject<Block> OLIVE_SIGN = BLOCKS.register("olive_sign", () -> standingSignBlock(TechnologicaWoodType.OLIVE));
	public static final RegistryObject<Block> ORANGE_SIGN = BLOCKS.register("orange_sign", () -> standingSignBlock(TechnologicaWoodType.ORANGE));
	public static final RegistryObject<Block> PEACH_SIGN = BLOCKS.register("peach_sign", () -> standingSignBlock(TechnologicaWoodType.PEACH));
	public static final RegistryObject<Block> PEAR_SIGN = BLOCKS.register("pear_sign", () -> standingSignBlock(TechnologicaWoodType.PEAR));
	public static final RegistryObject<Block> PLUM_SIGN = BLOCKS.register("plum_sign", () -> standingSignBlock(TechnologicaWoodType.PLUM));
	public static final RegistryObject<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign", () -> standingSignBlock(TechnologicaWoodType.REDWOOD));
	public static final RegistryObject<Block> ROSEWOOD_SIGN = BLOCKS.register("rosewood_sign", () -> standingSignBlock(TechnologicaWoodType.ROSEWOOD));
	public static final RegistryObject<Block> RUBBER_SIGN = BLOCKS.register("rubber_sign", () -> standingSignBlock(TechnologicaWoodType.RUBBER));
	public static final RegistryObject<Block> TEAK_SIGN = BLOCKS.register("teak_sign", () -> standingSignBlock(TechnologicaWoodType.TEAK));
	public static final RegistryObject<Block> WALNUT_SIGN = BLOCKS.register("walnut_sign", () -> standingSignBlock(TechnologicaWoodType.WALNUT));
	public static final RegistryObject<Block> ZEBRAWOOD_SIGN = BLOCKS.register("zebrawood_sign", () -> standingSignBlock(TechnologicaWoodType.ZEBRAWOOD));
	public static final RegistryObject<Block> ALCHEMICAL_SIGN = BLOCKS.register("alchemical_sign", () -> standingSignBlock(TechnologicaWoodType.ALCHEMICAL));
	public static final RegistryObject<Block> BENEVOLENT_SIGN = BLOCKS.register("benevolent_sign", () -> standingSignBlock(TechnologicaWoodType.BENEVOLENT));
	public static final RegistryObject<Block> CONDUCTIVE_SIGN = BLOCKS.register("conductive_sign", () -> standingSignBlock(TechnologicaWoodType.CONDUCTIVE));
	public static final RegistryObject<Block> FROSTBITTEN_SIGN = BLOCKS.register("frostbitten_sign", () -> technologicaStandingSignBlock(TechnologicaWoodType.FROSTBITTEN));
	public static final RegistryObject<Block> FRUITFUL_SIGN = BLOCKS.register("fruitful_sign", () -> standingSignBlock(TechnologicaWoodType.FRUITFUL));
	public static final RegistryObject<Block> INFERNAL_SIGN = BLOCKS.register("infernal_sign", () -> standingSignBlock(TechnologicaWoodType.INFERNAL));
	public static final RegistryObject<Block> MALEVOLENT_SIGN = BLOCKS.register("malevolent_sign", () -> standingSignBlock(TechnologicaWoodType.MALEVOLENT));
	public static final RegistryObject<Block> NECROTIC_SIGN = BLOCKS.register("necrotic_sign", () -> standingSignBlock(TechnologicaWoodType.NECROTIC));

	public static final RegistryObject<Block> APRICOT_WALL_SIGN = BLOCKS.register("apricot_wall_sign", () -> wallSignBlock(TechnologicaWoodType.APRICOT));
	public static final RegistryObject<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> wallSignBlock(TechnologicaWoodType.ASPEN));
	public static final RegistryObject<Block> AVOCADO_WALL_SIGN = BLOCKS.register("avocado_wall_sign", () -> wallSignBlock(TechnologicaWoodType.AVOCADO));
	public static final RegistryObject<Block> BANANA_WALL_SIGN = BLOCKS.register("banana_wall_sign", () -> wallSignBlock(TechnologicaWoodType.BANANA));
	public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign", () -> wallSignBlock(TechnologicaWoodType.CHERRY));
	public static final RegistryObject<Block> CHESTNUT_WALL_SIGN = BLOCKS.register("chestnut_wall_sign", () -> wallSignBlock(TechnologicaWoodType.CHESTNUT));
	public static final RegistryObject<Block> CINNAMON_WALL_SIGN = BLOCKS.register("cinnamon_wall_sign", () -> wallSignBlock(TechnologicaWoodType.CINNAMON));
	public static final RegistryObject<Block> COCONUT_WALL_SIGN = BLOCKS.register("coconut_wall_sign", () -> wallSignBlock(TechnologicaWoodType.COCONUT));
	public static final RegistryObject<Block> EBONY_WALL_SIGN = BLOCKS.register("ebony_wall_sign", () -> wallSignBlock(TechnologicaWoodType.EBONY));
	public static final RegistryObject<Block> KIWI_WALL_SIGN = BLOCKS.register("kiwi_wall_sign", () -> wallSignBlock(TechnologicaWoodType.KIWI));
	public static final RegistryObject<Block> LEMON_WALL_SIGN = BLOCKS.register("lemon_wall_sign", () -> wallSignBlock(TechnologicaWoodType.LEMON));
	public static final RegistryObject<Block> LIME_WALL_SIGN = BLOCKS.register("lime_wall_sign", () -> wallSignBlock(TechnologicaWoodType.LIME));
	public static final RegistryObject<Block> MAHOGANY_WALL_SIGN = BLOCKS.register("mahogany_wall_sign", () -> wallSignBlock(TechnologicaWoodType.MAHOGANY));
	public static final RegistryObject<Block> MAPLE_WALL_SIGN = BLOCKS.register("maple_wall_sign", () -> wallSignBlock(TechnologicaWoodType.MAPLE));
	public static final RegistryObject<Block> OLIVE_WALL_SIGN = BLOCKS.register("olive_wall_sign", () -> wallSignBlock(TechnologicaWoodType.OLIVE));
	public static final RegistryObject<Block> ORANGE_WALL_SIGN = BLOCKS.register("orange_wall_sign", () -> wallSignBlock(TechnologicaWoodType.ORANGE));
	public static final RegistryObject<Block> PEACH_WALL_SIGN = BLOCKS.register("peach_wall_sign", () -> wallSignBlock(TechnologicaWoodType.PEACH));
	public static final RegistryObject<Block> PEAR_WALL_SIGN = BLOCKS.register("pear_wall_sign", () -> wallSignBlock(TechnologicaWoodType.PEAR));
	public static final RegistryObject<Block> PLUM_WALL_SIGN = BLOCKS.register("plum_wall_sign", () -> wallSignBlock(TechnologicaWoodType.PLUM));
	public static final RegistryObject<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign", () -> wallSignBlock(TechnologicaWoodType.REDWOOD));
	public static final RegistryObject<Block> ROSEWOOD_WALL_SIGN = BLOCKS.register("rosewood_wall_sign", () -> wallSignBlock(TechnologicaWoodType.ROSEWOOD));
	public static final RegistryObject<Block> RUBBER_WALL_SIGN = BLOCKS.register("rubber_wall_sign", () -> wallSignBlock(TechnologicaWoodType.RUBBER));
	public static final RegistryObject<Block> TEAK_WALL_SIGN = BLOCKS.register("teak_wall_sign", () -> wallSignBlock(TechnologicaWoodType.TEAK));
	public static final RegistryObject<Block> WALNUT_WALL_SIGN = BLOCKS.register("walnut_wall_sign", () -> wallSignBlock(TechnologicaWoodType.WALNUT));
	public static final RegistryObject<Block> ZEBRAWOOD_WALL_SIGN = BLOCKS.register("zebrawood_wall_sign", () -> wallSignBlock(TechnologicaWoodType.ZEBRAWOOD));
	public static final RegistryObject<Block> ALCHEMICAL_WALL_SIGN = BLOCKS.register("alchemical_wall_sign", () -> wallSignBlock(TechnologicaWoodType.ALCHEMICAL));
	public static final RegistryObject<Block> BENEVOLENT_WALL_SIGN = BLOCKS.register("benevolent_wall_sign", () -> wallSignBlock(TechnologicaWoodType.BENEVOLENT));
	public static final RegistryObject<Block> CONDUCTIVE_WALL_SIGN = BLOCKS.register("conductive_wall_sign", () -> wallSignBlock(TechnologicaWoodType.CONDUCTIVE));
	public static final RegistryObject<Block> FROSTBITTEN_WALL_SIGN = BLOCKS.register("frostbitten_wall_sign", () -> technologicaWallSignBlock(TechnologicaWoodType.FROSTBITTEN));
	public static final RegistryObject<Block> FRUITFUL_WALL_SIGN = BLOCKS.register("fruitful_wall_sign", () -> wallSignBlock(TechnologicaWoodType.FRUITFUL));
	public static final RegistryObject<Block> INFERNAL_WALL_SIGN = BLOCKS.register("infernal_wall_sign", () -> wallSignBlock(TechnologicaWoodType.INFERNAL));
	public static final RegistryObject<Block> MALEVOLENT_WALL_SIGN = BLOCKS.register("malevolent_wall_sign", () -> wallSignBlock(TechnologicaWoodType.MALEVOLENT));
	public static final RegistryObject<Block> NECROTIC_WALL_SIGN = BLOCKS.register("necrotic_wall_sign", () -> wallSignBlock(TechnologicaWoodType.MALEVOLENT));

	/*
	 * MACHINERY
	 */

	public static final RegistryObject<Block> LINE_SHAFT_HANGER = BLOCKS.register("line_shaft_hanger", LineShaftHangerBlock::new);
	public static final RegistryObject<Block> LINE_SHAFT = BLOCKS.register("line_shaft", LineShaftBlock::new);
	public static final RegistryObject<Block> SMALL_PULLEY = BLOCKS.register("small_pulley", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1.0F).sound(SoundType.ANVIL).noOcclusion()));
	public static final RegistryObject<Block> MEDIUM_PULLEY = BLOCKS.register("medium_pulley", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1.0F).sound(SoundType.ANVIL).noOcclusion()));
	public static final RegistryObject<Block> LARGE_PULLEY = BLOCKS.register("large_pulley", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(1.0F).sound(SoundType.ANVIL).noOcclusion()));
	public static final RegistryObject<Block> MOTOR_1HP = BLOCKS.register("motor_1hp", () -> new MotorBlock(100.0F, 60.0F));
	public static final RegistryObject<Block> MOTOR_5HP = BLOCKS.register("motor_5hp", () -> new MotorBlock(200.0F, 120.0F));
	public static final RegistryObject<Block> MOTOR_20HP = BLOCKS.register("motor_20hp", () -> new MotorBlock(400.0F, 240.0F));
	public static final RegistryObject<Block> TREE_TAP = BLOCKS.register("tree_tap", TreeTapBlock::new);
	public static final RegistryObject<Block> SAWMILL_CORE = BLOCKS.register("sawmill_core", SawmillCoreBlock::new);
	public static final RegistryObject<Block> SAWMILL = BLOCKS.register("sawmill", SawmillBlock::new);
	public static final RegistryObject<Block> GLUE = BLOCKS.register("glue", () -> new GlueBlock(BlockBehaviour.Properties.of(Material.WEB).noCollission().randomTicks().strength(0.2F).sound(SoundType.SLIME_BLOCK)));
	public static final RegistryObject<Block> FAST_HOPPER = BLOCKS.register("fast_hopper", () -> new FastHopper(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 4.8F).sound(SoundType.METAL).noOcclusion()));

	/*
	 * DECORATIVE
	 */

	public static final RegistryObject<Block> ACACIA_CHAIR = BLOCKS.register("acacia_chair", ChairBlock::new);
	public static final RegistryObject<Block> APRICOT_CHAIR = BLOCKS.register("apricot_chair", ChairBlock::new);
	public static final RegistryObject<Block> ASPEN_CHAIR = BLOCKS.register("aspen_chair", ChairBlock::new);
	public static final RegistryObject<Block> AVOCADO_CHAIR = BLOCKS.register("avocado_chair", ChairBlock::new);
	public static final RegistryObject<Block> BANANA_CHAIR = BLOCKS.register("banana_chair", ChairBlock::new);
	public static final RegistryObject<Block> BIRCH_CHAIR = BLOCKS.register("birch_chair", ChairBlock::new);
	public static final RegistryObject<Block> CHERRY_CHAIR = BLOCKS.register("cherry_chair", ChairBlock::new);
	public static final RegistryObject<Block> CHESTNUT_CHAIR = BLOCKS.register("chestnut_chair", ChairBlock::new);
	public static final RegistryObject<Block> CINNAMON_CHAIR = BLOCKS.register("cinnamon_chair", ChairBlock::new);
	public static final RegistryObject<Block> COCONUT_CHAIR = BLOCKS.register("coconut_chair", ChairBlock::new);
	public static final RegistryObject<Block> CRIMSON_CHAIR = BLOCKS.register("crimson_chair", ChairBlock::new);
	public static final RegistryObject<Block> DARK_OAK_CHAIR = BLOCKS.register("dark_oak_chair", ChairBlock::new);
	public static final RegistryObject<Block> EBONY_CHAIR = BLOCKS.register("ebony_chair", ChairBlock::new);
	public static final RegistryObject<Block> JUNGLE_CHAIR = BLOCKS.register("jungle_chair", ChairBlock::new);
	public static final RegistryObject<Block> KIWI_CHAIR = BLOCKS.register("kiwi_chair", ChairBlock::new);
	public static final RegistryObject<Block> LEMON_CHAIR = BLOCKS.register("lemon_chair", ChairBlock::new);
	public static final RegistryObject<Block> LIME_CHAIR = BLOCKS.register("lime_chair", ChairBlock::new);
	public static final RegistryObject<Block> MAHOGANY_CHAIR = BLOCKS.register("mahogany_chair", ChairBlock::new);
	public static final RegistryObject<Block> MAPLE_CHAIR = BLOCKS.register("maple_chair", ChairBlock::new);
	public static final RegistryObject<Block> OAK_CHAIR = BLOCKS.register("oak_chair", ChairBlock::new);
	public static final RegistryObject<Block> OLIVE_CHAIR = BLOCKS.register("olive_chair", ChairBlock::new);
	public static final RegistryObject<Block> ORANGE_CHAIR = BLOCKS.register("orange_chair", ChairBlock::new);
	public static final RegistryObject<Block> PEACH_CHAIR = BLOCKS.register("peach_chair", ChairBlock::new);
	public static final RegistryObject<Block> PEAR_CHAIR = BLOCKS.register("pear_chair", ChairBlock::new);
	public static final RegistryObject<Block> PLUM_CHAIR = BLOCKS.register("plum_chair", ChairBlock::new);
	public static final RegistryObject<Block> REDWOOD_CHAIR = BLOCKS.register("redwood_chair", ChairBlock::new);
	public static final RegistryObject<Block> ROSEWOOD_CHAIR = BLOCKS.register("rosewood_chair", ChairBlock::new);
	public static final RegistryObject<Block> RUBBER_CHAIR = BLOCKS.register("rubber_chair", ChairBlock::new);
	public static final RegistryObject<Block> SPRUCE_CHAIR = BLOCKS.register("spruce_chair", ChairBlock::new);
	public static final RegistryObject<Block> TEAK_CHAIR = BLOCKS.register("teak_chair", ChairBlock::new);
	public static final RegistryObject<Block> WALNUT_CHAIR = BLOCKS.register("walnut_chair", ChairBlock::new);
	public static final RegistryObject<Block> WARPED_CHAIR = BLOCKS.register("warped_chair", ChairBlock::new);
	public static final RegistryObject<Block> ZEBRAWOOD_CHAIR = BLOCKS.register("zebrawood_chair", ChairBlock::new);
	public static final RegistryObject<Block> ALCHEMICAL_CHAIR = BLOCKS.register("alchemical_chair", ChairBlock::new);
	public static final RegistryObject<Block> BENEVOLENT_CHAIR = BLOCKS.register("benevolent_chair", ChairBlock::new);
	public static final RegistryObject<Block> CONDUCTIVE_CHAIR = BLOCKS.register("conductive_chair", ChairBlock::new);
	public static final RegistryObject<Block> FROSTBITTEN_CHAIR = BLOCKS.register("frostbitten_chair", ChairBlock::new);
	public static final RegistryObject<Block> FRUITFUL_CHAIR = BLOCKS.register("fruitful_chair", ChairBlock::new);
	public static final RegistryObject<Block> INFERNAL_CHAIR = BLOCKS.register("infernal_chair", ChairBlock::new);
	public static final RegistryObject<Block> MALEVOLENT_CHAIR = BLOCKS.register("malevolent_chair", ChairBlock::new);
	public static final RegistryObject<Block> NECROTIC_CHAIR = BLOCKS.register("necrotic_chair", ChairBlock::new);

	public static final RegistryObject<Block> ACACIA_TABLE = BLOCKS.register("acacia_table", TableBlock::new);
	public static final RegistryObject<Block> APRICOT_TABLE = BLOCKS.register("apricot_table", TableBlock::new);
	public static final RegistryObject<Block> ASPEN_TABLE = BLOCKS.register("aspen_table", TableBlock::new);
	public static final RegistryObject<Block> AVOCADO_TABLE = BLOCKS.register("avocado_table", TableBlock::new);
	public static final RegistryObject<Block> BANANA_TABLE = BLOCKS.register("banana_table", TableBlock::new);
	public static final RegistryObject<Block> BIRCH_TABLE = BLOCKS.register("birch_table", TableBlock::new);
	public static final RegistryObject<Block> CHERRY_TABLE = BLOCKS.register("cherry_table", TableBlock::new);
	public static final RegistryObject<Block> CHESTNUT_TABLE = BLOCKS.register("chestnut_table", TableBlock::new);
	public static final RegistryObject<Block> CINNAMON_TABLE = BLOCKS.register("cinnamon_table", TableBlock::new);
	public static final RegistryObject<Block> COCONUT_TABLE = BLOCKS.register("coconut_table", TableBlock::new);
	public static final RegistryObject<Block> CRIMSON_TABLE = BLOCKS.register("crimson_table", TableBlock::new);
	public static final RegistryObject<Block> DARK_OAK_TABLE = BLOCKS.register("dark_oak_table", TableBlock::new);
	public static final RegistryObject<Block> EBONY_TABLE = BLOCKS.register("ebony_table", TableBlock::new);
	public static final RegistryObject<Block> JUNGLE_TABLE = BLOCKS.register("jungle_table", TableBlock::new);
	public static final RegistryObject<Block> KIWI_TABLE = BLOCKS.register("kiwi_table", TableBlock::new);
	public static final RegistryObject<Block> LEMON_TABLE = BLOCKS.register("lemon_table", TableBlock::new);
	public static final RegistryObject<Block> LIME_TABLE = BLOCKS.register("lime_table", TableBlock::new);
	public static final RegistryObject<Block> MAHOGANY_TABLE = BLOCKS.register("mahogany_table", TableBlock::new);
	public static final RegistryObject<Block> MAPLE_TABLE = BLOCKS.register("maple_table", TableBlock::new);
	public static final RegistryObject<Block> OAK_TABLE = BLOCKS.register("oak_table", TableBlock::new);
	public static final RegistryObject<Block> OLIVE_TABLE = BLOCKS.register("olive_table", TableBlock::new);
	public static final RegistryObject<Block> ORANGE_TABLE = BLOCKS.register("orange_table", TableBlock::new);
	public static final RegistryObject<Block> PEACH_TABLE = BLOCKS.register("peach_table", TableBlock::new);
	public static final RegistryObject<Block> PEAR_TABLE = BLOCKS.register("pear_table", TableBlock::new);
	public static final RegistryObject<Block> PLUM_TABLE = BLOCKS.register("plum_table", TableBlock::new);
	public static final RegistryObject<Block> REDWOOD_TABLE = BLOCKS.register("redwood_table", TableBlock::new);
	public static final RegistryObject<Block> ROSEWOOD_TABLE = BLOCKS.register("rosewood_table", TableBlock::new);
	public static final RegistryObject<Block> RUBBER_TABLE = BLOCKS.register("rubber_table", TableBlock::new);
	public static final RegistryObject<Block> SPRUCE_TABLE = BLOCKS.register("spruce_table", TableBlock::new);
	public static final RegistryObject<Block> TEAK_TABLE = BLOCKS.register("teak_table", TableBlock::new);
	public static final RegistryObject<Block> WALNUT_TABLE = BLOCKS.register("walnut_table", TableBlock::new);
	public static final RegistryObject<Block> WARPED_TABLE = BLOCKS.register("warped_table", TableBlock::new);
	public static final RegistryObject<Block> ZEBRAWOOD_TABLE = BLOCKS.register("zebrawood_table", TableBlock::new);
	public static final RegistryObject<Block> ALCHEMICAL_TABLE = BLOCKS.register("alchemical_table", TableBlock::new);
	public static final RegistryObject<Block> BENEVOLENT_TABLE = BLOCKS.register("benevolent_table", TableBlock::new);
	public static final RegistryObject<Block> CONDUCTIVE_TABLE = BLOCKS.register("conductive_table", TableBlock::new);
	public static final RegistryObject<Block> FROSTBITTEN_TABLE = BLOCKS.register("frostbitten_table", TableBlock::new);
	public static final RegistryObject<Block> FRUITFUL_TABLE = BLOCKS.register("fruitful_table", TableBlock::new);
	public static final RegistryObject<Block> INFERNAL_TABLE = BLOCKS.register("infernal_table", TableBlock::new);
	public static final RegistryObject<Block> MALEVOLENT_TABLE = BLOCKS.register("malevolent_table", TableBlock::new);
	public static final RegistryObject<Block> NECROTIC_TABLE = BLOCKS.register("necrotic_table", TableBlock::new);

	public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", DisplayCaseBlock::new);
	public static final RegistryObject<Block> ANNUNCIATOR = BLOCKS.register("annunciator", AnnunciatorBlock::new);

	/*
	 * ARMORY
	 */

	public static final RegistryObject<Block> LAND_MINE = BLOCKS.register("land_mine", LandMineBlock::new);
	public static final RegistryObject<Block> NITROGLYCERIN = BLOCKS.register("nitroglycerin", () -> new NitroBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE).noCollission().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> NAVAL_MINE_CHAIN = BLOCKS.register("naval_mine_chain", NavalMineChainBlock::new);

	public static final RegistryObject<Block> LIGHT = BLOCKS.register("light", () -> new LightBlock(BlockBehaviour.Properties.of(Material.AIR).noCollission().noLootTable().air().lightLevel((p_50874_) -> {
		return 15;
	})));

	public static final RegistryObject<Block> SLEEPING_BAG = BLOCKS.register("sleeping_bag", () -> new SleepingBagBlock(DyeColor.RED, BlockBehaviour.Properties.of(Material.WOOL, (p_152613_) -> {
		return p_152613_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.RED.getMaterialColor() : MaterialColor.WOOL;
	}).sound(SoundType.WOOD).strength(0.2F).noOcclusion()));

	/*
	 * VANILLA REPLICATORS
	 */

	private static CropBlock grainCropBlock(Supplier<Item> seeds) {
		return new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	private static PotatoBlock replantableCropBlock(Supplier<Item> seeds) {
		return new PotatoBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	private static BeetrootBlock seededCropBlock(Supplier<Item> seeds) {
		return new BeetrootBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)) {
			@Override
			protected ItemLike getBaseSeedId() {
				return seeds.get();
			}
		};
	}

	private static SweetBerryBushBlock bushCropBlock(Supplier<Item> clone) {
		return new SweetBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)) {
			@Override
			public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
				return new ItemStack(clone.get());
			}

			@Override
			public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
				int i = p_57275_.getValue(AGE);
				boolean flag = i == 3;
				if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
					return InteractionResult.PASS;
				} else if (i > 1) {
					int j = 1 + p_57276_.random.nextInt(2);
					popResource(p_57276_, p_57277_, new ItemStack(clone.get(), j + (flag ? 1 : 0)));
					p_57276_.playSound((Player) null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
					p_57276_.setBlock(p_57277_, p_57275_.setValue(AGE, Integer.valueOf(1)), 2);
					return InteractionResult.sidedSuccess(p_57276_.isClientSide);
				} else {
					return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
				}
			}

			@Override
			public BlockPathTypes getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob) {
				return BlockPathTypes.DAMAGE_OTHER;
			}

			@Override
			public BlockPathTypes getAdjacentBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob, BlockPathTypes originalType) {
				return BlockPathTypes.DANGER_OTHER;
			}

			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 60;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 100;
			}
		};
	}

	private static LeavesBlock leavesBlock() {
		return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 30;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 60;
			}
		};
	}

	private static RotatedPillarBlock logBlock(MaterialColor p_50789_, MaterialColor p_50790_) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
			return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
		}).strength(2.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}
		};
	}

	private static Block planksBlock() {
		return new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static SlabBlock slabBlock() {
		return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static StairBlock stairBlock(Supplier<BlockState> state) {
		return new StairBlock(state, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static Block bookshelfBlock() {
		return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 30;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static FenceBlock fenceBlock() {
		return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static FenceGateBlock fenceGateBlock() {
		return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN) {
			@Override
			public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 5;
			}

			@Override
			public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
				return 20;
			}
		};
	}

	private static StandingSignBlock standingSignBlock(WoodType typeIn) {
		return new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new VanillaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	private static WallSignBlock wallSignBlock(WoodType typeIn) {
		return new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new VanillaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	private static StandingSignBlock technologicaStandingSignBlock(WoodType typeIn) {
		return new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new TechnologicaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	private static WallSignBlock technologicaWallSignBlock(WoodType typeIn) {
		return new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), typeIn) {
			@Override
			public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
				return new TechnologicaSignBlockEntity(p_154556_, p_154557_);
			}
		};
	}

	private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
		return (boolean) false;
	}

	private static ButtonBlock woodenButton() {
		return woodenButton(SoundType.WOOD, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
	}

	private static ButtonBlock woodenButton(SoundType p_249282_, SoundEvent p_251988_, SoundEvent p_251887_) {
		return new ButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(p_249282_), 30, true, p_251988_, p_251887_);
	}
}