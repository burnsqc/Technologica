package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.client.model.AlligatorModel;
import com.technologica.client.model.BeaverModel;
import com.technologica.client.model.BuffaloModel;
import com.technologica.client.model.CamelModel;
import com.technologica.client.model.CobraModel;
import com.technologica.client.model.CottonmouthModel;
import com.technologica.client.model.CoyoteModel;
import com.technologica.client.model.CrabModel;
import com.technologica.client.model.DeerModel;
import com.technologica.client.model.ElephantModel;
import com.technologica.client.model.FlamingoModel;
import com.technologica.client.model.FrogModel;
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
import com.technologica.client.model.StingrayModel;
import com.technologica.client.model.TurkeyModel;
import com.technologica.client.model.VultureModel;
import com.technologica.client.model.WalrusModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;

public class RegisterLayerDefinitons {

	public static void onRegisterLayerDefinitions(RegisterLayerDefinitions event) {
		event.registerLayerDefinition(TechnologicaModelLayers.ALLIGATOR, AlligatorModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.BEAVER, BeaverModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.BUFFALO, BuffaloModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.CAMEL, CamelModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COBRA, CobraModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COTTONMOUTH, CottonmouthModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.COYOTE, CoyoteModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.CRAB, CrabModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.DEER, DeerModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.DUCK, ChickenModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.ELEPHANT, ElephantModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FLAMINGO, FlamingoModel::createBodyLayer);
		event.registerLayerDefinition(TechnologicaModelLayers.FROG, FrogModel::createBodyLayer);
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

		event.registerLayerDefinition(TechnologicaModelLayers.PEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));
		event.registerLayerDefinition(TechnologicaModelLayers.SWEEPER, () -> CreeperModel.createBodyLayer(CubeDeformation.NONE));

		event.registerLayerDefinition(TechnologicaModelLayers.NAVAL_MINE, NavalMineModel::createBodyModel);
		event.registerLayerDefinition(TechnologicaModelLayers.ROCKET, () -> BoatModel.createBodyModel(false));

		for (VanillaBoat.Type boat$type : VanillaBoat.Type.values()) {
			event.registerLayerDefinition(TechnologicaModelLayers.createBoatModelName(boat$type), () -> BoatModel.createBodyModel(false));
		}
		LOGGER.info("LAYER DEFINITIONS REGISTERED: 43 OF 43");
	}
}