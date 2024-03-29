package com.technologica.setup.listeners;

import static com.technologica.Technologica.LOGGER;

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
import com.technologica.client.model.armor.DivingHelmetModel;
import com.technologica.client.model.armor.MiningHelmetModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
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
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;

public class TechnologicaLayerDefinitions {

	public static void onRegisterLayerDefinitions(RegisterLayerDefinitions event) {
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
		event.registerLayerDefinition(TechnologicaModelLayers.ROCKET, () -> BoatModel.createBodyModel());

		event.registerLayerDefinition(TechnologicaModelLayers.COCONUT_BAZOOKA, CoconutBazookaModel::createLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.SPEAR_GUN, SpearGunModel::createLayer);

		event.registerLayerDefinition(TechnologicaModelLayers.MINING_HELMET, () -> LayerDefinition.create(MiningHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		event.registerLayerDefinition(TechnologicaModelLayers.DIVING_HELMET, () -> LayerDefinition.create(DivingHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));

		for (TechnologicaBoat.Type boat$type : TechnologicaBoat.Type.values()) {
			event.registerLayerDefinition(TechnologicaModelLayers.createBoatModelName(boat$type), () -> BoatModel.createBodyModel());
		}
		LOGGER.info("SETUP - LAYER DEFINITIONS - 43 OF 43");
	}
}