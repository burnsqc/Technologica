package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.client.model.AlligatorModel;
import com.technologica.client.model.BeaverModel;
import com.technologica.client.model.BuffaloModel;
import com.technologica.client.model.CobraModel;
import com.technologica.client.model.CoconutBazookaModel;
import com.technologica.client.model.CottonmouthModel;
import com.technologica.client.model.CoyoteModel;
import com.technologica.client.model.CrabModel;
import com.technologica.client.model.DeerModel;
import com.technologica.client.model.DustDevilModel;
import com.technologica.client.model.ElephantModel;
import com.technologica.client.model.FigureEightPufferfishBigModel;
import com.technologica.client.model.FigureEightPufferfishMidModel;
import com.technologica.client.model.FigureEightPufferfishSmallModel;
import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.GiraffeModel;
import com.technologica.client.model.GorillaModel;
import com.technologica.client.model.JaguarModel;
import com.technologica.client.model.KingCrabModel;
import com.technologica.client.model.LeopardSealModel;
import com.technologica.client.model.LionModel;
import com.technologica.client.model.LizardModel;
import com.technologica.client.model.MooseModel;
import com.technologica.client.model.NarwhalModel;
import com.technologica.client.model.NavalMineModel;
import com.technologica.client.model.OctopusModel;
import com.technologica.client.model.OstrichModel;
import com.technologica.client.model.OwlModel;
import com.technologica.client.model.PenguinModel;
import com.technologica.client.model.PiranhaModel;
import com.technologica.client.model.PoisonDartFrogModel;
import com.technologica.client.model.RaccoonModel;
import com.technologica.client.model.ScorpionModel;
import com.technologica.client.model.SharkModel;
import com.technologica.client.model.SlothModel;
import com.technologica.client.model.SpearGunModel;
import com.technologica.client.model.StingrayModel;
import com.technologica.client.model.TurkeyModel;
import com.technologica.client.model.VultureModel;
import com.technologica.client.model.WalrusModel;
import com.technologica.client.model.WindmillModel;
import com.technologica.client.model.armor.DivingHelmetModel;
import com.technologica.client.model.armor.MiningHelmetModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.client.renderer.blockentity.AnnunciatorRenderer;
import com.technologica.client.renderer.blockentity.DisplayCaseRenderer;
import com.technologica.client.renderer.blockentity.FruitRenderer;
import com.technologica.client.renderer.blockentity.LandMineRenderer;
import com.technologica.client.renderer.blockentity.LineShaftHangerRenderer;
import com.technologica.client.renderer.blockentity.LineShaftRenderer;
import com.technologica.client.renderer.blockentity.MonitorRenderer;
import com.technologica.client.renderer.blockentity.PotionRenderer;
import com.technologica.client.renderer.blockentity.SawmillRenderer;
import com.technologica.client.renderer.blockentity.TechnologicaSignRenderer;
import com.technologica.client.renderer.blockentity.WindmillRenderer;
import com.technologica.client.renderer.entity.AlligatorRenderer;
import com.technologica.client.renderer.entity.AtomicCreeperRenderer;
import com.technologica.client.renderer.entity.BeaverRenderer;
import com.technologica.client.renderer.entity.BeeperRenderer;
import com.technologica.client.renderer.entity.BuffaloRenderer;
import com.technologica.client.renderer.entity.CobraRenderer;
import com.technologica.client.renderer.entity.CottonmouthRenderer;
import com.technologica.client.renderer.entity.CoyoteRenderer;
import com.technologica.client.renderer.entity.CrabRenderer;
import com.technologica.client.renderer.entity.DeerRenderer;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.DustDevilRenderer;
import com.technologica.client.renderer.entity.ElephantRenderer;
import com.technologica.client.renderer.entity.FigureEightPufferfishRenderer;
import com.technologica.client.renderer.entity.FlamingoRenderer;
import com.technologica.client.renderer.entity.GiraffeRenderer;
import com.technologica.client.renderer.entity.GorillaRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.HarpoonRenderer;
import com.technologica.client.renderer.entity.InvisibleRenderer;
import com.technologica.client.renderer.entity.JaguarRenderer;
import com.technologica.client.renderer.entity.KingCrabRenderer;
import com.technologica.client.renderer.entity.LeopardSealRenderer;
import com.technologica.client.renderer.entity.LionRenderer;
import com.technologica.client.renderer.entity.LizardRenderer;
import com.technologica.client.renderer.entity.MooseRenderer;
import com.technologica.client.renderer.entity.MummyRenderer;
import com.technologica.client.renderer.entity.NarwhalRenderer;
import com.technologica.client.renderer.entity.NavalMineRenderer;
import com.technologica.client.renderer.entity.OctopusRenderer;
import com.technologica.client.renderer.entity.OstrichRenderer;
import com.technologica.client.renderer.entity.OwlRenderer;
import com.technologica.client.renderer.entity.PeeperRenderer;
import com.technologica.client.renderer.entity.PenguinRenderer;
import com.technologica.client.renderer.entity.PiranhaRenderer;
import com.technologica.client.renderer.entity.PoisonDartFrogRenderer;
import com.technologica.client.renderer.entity.RaccoonRenderer;
import com.technologica.client.renderer.entity.ScorpionRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.SleeperRenderer;
import com.technologica.client.renderer.entity.SlothRenderer;
import com.technologica.client.renderer.entity.StingrayRenderer;
import com.technologica.client.renderer.entity.SweeperRenderer;
import com.technologica.client.renderer.entity.TechnologicaBoatRenderer;
import com.technologica.client.renderer.entity.TurkeyRenderer;
import com.technologica.client.renderer.entity.VultureRenderer;
import com.technologica.client.renderer.entity.WalrusRenderer;
import com.technologica.client.renderer.entity.WeeperRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.world.entity.vehicle.TechnologicaBoat;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;

/**
 * <p>
 * This class listens for EntityRenderersEvent.RegisterLayerDefinitions and EntityRenderersEvent.RegisterRenderers which are fired on the mod-specific event bus on the client side.
 * <p>
 * When RegisterLayerDefinitions is intercepted, ModelLayerLocations are mapped to LayerDefinition suppliers.
 * <p>
 * When RegisterRenderers is intercepted, EntityTypes are mapped to EntityRendererProviders and BlockEntityTypes are mapped to BlockEntityRendererProviders.
 * </p>
 * 
 * @tl.status BLUE
 */
public final class EntityRenderersEventListener {
	private static long modelLayersRequired;
	private static long modelLayersCompleted;
	private static long entitiesRequired;
	private static long entitiesCompleted;
	private static long blockEntitiesRequired;
	private static long blockEntitiesCompleted;

	/**
	 * <p>
	 * Map ModelLayerLocations to LayerDefinition suppliers in 3 steps:
	 * <p>
	 * 1. Count how many Technologica ModelLayerLocations do not yet have LayerDefinition suppliers and log.
	 * <p>
	 * 2. Map ModelLayerLocations to LayerDefinition suppliers.
	 * <p>
	 * 3. Count how many Technologica EntityTypes now have LayerDefinition suppliers and log.
	 * </p>
	 * 
	 * @param event EntityRenderersEvent.RegisterLayerDefinitions
	 */
	public static void onRegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
		modelLayersRequired = TechnologicaModelLayers.ALL_MODELS.stream().filter(entity -> !ForgeHooksClient.layerDefinitions.containsKey(entity)).count();

		event.registerLayerDefinition(TechnologicaModelLayers.ALLIGATOR, AlligatorModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.BEAVER, BeaverModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.BUFFALO, BuffaloModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COBRA, CobraModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COTTONMOUTH, CottonmouthModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COYOTE, CoyoteModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.CRAB, CrabModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.DEER, DeerModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.DUCK, ChickenModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.ELEPHANT, ElephantModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG, FigureEightPufferfishBigModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM, FigureEightPufferfishMidModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL, FigureEightPufferfishSmallModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FLAMINGO, FlamingoModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.GIRAFFE, GiraffeModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.GORILLA, GorillaModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.GRIZZLY_BEAR, PolarBearModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.JAGUAR, JaguarModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.KING_CRAB, KingCrabModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.LEOPARD_SEAL, LeopardSealModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.LION, LionModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.LIZARD, LizardModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.MOOSE, MooseModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.NARWHAL, NarwhalModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.OCTOPUS, OctopusModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.OSTRICH, OstrichModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.OWL, OwlModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.PENGUIN, PenguinModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.PIRANHA, PiranhaModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.POISON_DART_FROG, PoisonDartFrogModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.RACCOON, RaccoonModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.SCORPION, ScorpionModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.SHARK, SharkModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.SLOTH, SlothModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.STINGRAY, StingrayModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.TURKEY, TurkeyModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.VULTURE, VultureModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.WALRUS, WalrusModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.ZEBRA, () -> LayerDefinition.create(HorseModel.createBodyMesh(CubeDeformation.NONE), 64, 64));
		event.registerLayerDefinition(TechnologicaModelLayers.ATOMIC_CREEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.MUMMY, () -> LayerDefinition.create(ZombieModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64));
		event.registerLayerDefinition(TechnologicaModelLayers.PEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.BEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.SLEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.WEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.SWEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.DUST_DEVIL, () -> DustDevilModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.NAVAL_MINE, NavalMineModel::createBodyModel);
		event.registerLayerDefinition(TechnologicaModelLayers.WINDMILL, WindmillModel::createBodyModel);
		event.registerLayerDefinition(TechnologicaModelLayers.ROCKET, () -> BoatModel.createBodyModel());
		event.registerLayerDefinition(TechnologicaModelLayers.COCONUT_BAZOOKA, CoconutBazookaModel::createLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.SPEAR_GUN, SpearGunModel::createLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.MINING_HELMET, () -> LayerDefinition.create(MiningHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		event.registerLayerDefinition(TechnologicaModelLayers.DIVING_HELMET, () -> LayerDefinition.create(DivingHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		for (TechnologicaBoat.Type boat$type : TechnologicaBoat.Type.values()) {
			event.registerLayerDefinition(TechnologicaModelLayers.createBoatModelName(boat$type), () -> BoatModel.createBodyModel());
		}

		modelLayersCompleted = TechnologicaModelLayers.ALL_MODELS.stream().filter(entity -> ForgeHooksClient.layerDefinitions.containsKey(entity)).count();
		Technologica.LOGGER.info("SETUP - LAYER DEFINITIONS - " + modelLayersCompleted + " OF " + modelLayersRequired);
		if (modelLayersCompleted != modelLayersRequired) {
			Technologica.LOGGER.error("LAYER DEFINITION MAPPING FAILED: " + (modelLayersRequired - modelLayersCompleted) + " MISSING");
		}
	}

	/**
	 * <p>
	 * Map EntityTypes to EntityRendererProviders and map BlockEntityTypes to BlockEntityRendererProviders in 6 steps:
	 * <p>
	 * 1. Count how many Technologica EntityTypes do not yet have EntityRendererProviders and log.
	 * <p>
	 * 2. Map EntityTypes to EntityRendererProviders.
	 * <p>
	 * 3. Count how many Technologica EntityTypes now have EntityRendererProviders and log.
	 * </p>
	 * 4. Count how many Technologica BlockEntityTypes do not yet have BlockEntityRendererProviders and log.
	 * <p>
	 * 5. Map BlockEntityTypes to BlockEntityRendererProviders.
	 * <p>
	 * 6. Count how many Technologica BlockEntityTypes now have BlockEntityRendererProviders and log.
	 * </p>
	 * 
	 * @param event EntityRenderersEvent.RegisterRenderers
	 */
	public static void onRegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		entitiesRequired = TechnologicaEntityTypes.ENTITY_TYPES.getEntries().stream().filter(entity -> !EntityRenderers.PROVIDERS.containsKey(entity.get())).count();

		event.registerEntityRenderer(TechnologicaEntityTypes.TECHNOLOGICA_BOAT.get(), context -> new TechnologicaBoatRenderer(context, false));
		event.registerEntityRenderer(TechnologicaEntityTypes.INVISIBLE_SEAT.get(), InvisibleRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.COCONUT.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 1.0F, true));
		event.registerEntityRenderer(TechnologicaEntityTypes.DODGEBALL.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 1.0F, true));
		event.registerEntityRenderer(TechnologicaEntityTypes.HARPOON.get(), HarpoonRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.ALLIGATOR.get(), AlligatorRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.BEAVER.get(), BeaverRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.BUFFALO.get(), BuffaloRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.COBRA.get(), CobraRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.COTTONMOUTH.get(), CottonmouthRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.COYOTE.get(), CoyoteRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.CRAB.get(), CrabRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.DEER.get(), DeerRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.DUCK.get(), DuckRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.ELEPHANT.get(), ElephantRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.FLAMINGO.get(), FlamingoRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), FigureEightPufferfishRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.GIRAFFE.get(), GiraffeRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.GORILLA.get(), GorillaRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.JAGUAR.get(), JaguarRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.KING_CRAB.get(), KingCrabRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.LEOPARD_SEAL.get(), LeopardSealRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.LION.get(), LionRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.LIZARD.get(), LizardRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.MOOSE.get(), MooseRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.NARWHAL.get(), NarwhalRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.OCTOPUS.get(), OctopusRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.OSTRICH.get(), OstrichRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.OWL.get(), OwlRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.PENGUIN.get(), PenguinRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.PIRANHA.get(), PiranhaRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.POISON_DART_FROG.get(), PoisonDartFrogRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.RACCOON.get(), RaccoonRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.SCORPION.get(), ScorpionRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.SHARK.get(), SharkRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.SLOTH.get(), SlothRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.STINGRAY.get(), StingrayRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.TURKEY.get(), TurkeyRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.VULTURE.get(), VultureRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.WALRUS.get(), WalrusRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.ZEBRA.get(), ZebraRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.ATOMIC_CREEPER.get(), AtomicCreeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.MUMMY.get(), MummyRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.PEEPER.get(), PeeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.BEEPER.get(), BeeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.SLEEPER.get(), SleeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.WEEPER.get(), WeeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.SWEEPER.get(), SweeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.DUST_DEVIL.get(), DustDevilRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.NAVAL_MINE.get(), NavalMineRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.METEOR.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 4.0F, true));

		entitiesCompleted = TechnologicaEntityTypes.ENTITY_TYPES.getEntries().stream().filter(entity -> EntityRenderers.PROVIDERS.containsKey(entity.get())).count();
		Technologica.LOGGER.info("SETUP - ENTITY RENDERERS - " + entitiesCompleted + " OF " + entitiesRequired);
		if (entitiesCompleted != entitiesRequired) {
			Technologica.LOGGER.error("ENTITY RENDERER MAPPING FAILED: " + (entitiesRequired - entitiesCompleted) + " MISSING");
		}

		blockEntitiesRequired = TechnologicaBlockEntityTypes.BLOCK_ENTITY_TYPES.getEntries().stream().filter(blockEntity -> !BlockEntityRenderers.PROVIDERS.containsKey(blockEntity.get())).count();

		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.ANNUNCIATOR_TILE.get(), AnnunciatorRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.MONITOR_TILE.get(), MonitorRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.VANILLA_SIGN.get(), SignRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.TECHNOLOGICA_SIGN.get(), TechnologicaSignRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.FRUIT_CROP.get(), FruitRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.POTION_CROP.get(), PotionRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.DISPLAY_TILE.get(), DisplayCaseRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LINE_SHAFT_TILE.get(), LineShaftRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.SAWMILL_TILE.get(), SawmillRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.WINDMILL.get(), WindmillRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LAND_MINE_TILE.get(), LandMineRenderer::new);

		blockEntitiesCompleted = TechnologicaBlockEntityTypes.BLOCK_ENTITY_TYPES.getEntries().stream().filter(blockEntity -> BlockEntityRenderers.PROVIDERS.containsKey(blockEntity.get())).count();
		Technologica.LOGGER.info("SETUP - BLOCK ENTITY RENDERERS - " + blockEntitiesCompleted + " OF " + blockEntitiesRequired);
		if (blockEntitiesCompleted != blockEntitiesRequired) {
			Technologica.LOGGER.error("BLOCK ENTITY RENDERER MAPPING FAILED: " + (blockEntitiesRequired - blockEntitiesCompleted) + " MISSING");
		}
	}
}