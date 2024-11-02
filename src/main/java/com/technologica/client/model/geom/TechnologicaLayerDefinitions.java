package com.technologica.client.model.geom;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.client.model.AlligatorModel;
import com.technologica.client.model.BeaverModel;
import com.technologica.client.model.BiPlaneModel;
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
import com.technologica.world.entity.vehicle.TechnologicaBoat;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.PolarBearModel;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class TechnologicaLayerDefinitions {
	public static final Map<ModelLayerLocation, LayerDefinition> ROOTS = Maps.newHashMap();

	static {
		register(TechnologicaModelLayers.ALLIGATOR, AlligatorModel.createBodyLayer());
		register(TechnologicaModelLayers.BEAVER, BeaverModel.createBodyLayer());
		register(TechnologicaModelLayers.BUFFALO, BuffaloModel.createBodyLayer());
		register(TechnologicaModelLayers.COBRA, CobraModel.createBodyLayer());
		register(TechnologicaModelLayers.COTTONMOUTH, CottonmouthModel.createBodyLayer());
		register(TechnologicaModelLayers.COYOTE, CoyoteModel.createBodyLayer());
		register(TechnologicaModelLayers.CRAB, CrabModel.createBodyLayer());
		register(TechnologicaModelLayers.DEER, DeerModel.createBodyLayer());
		register(TechnologicaModelLayers.DUCK, ChickenModel.createBodyLayer());
		register(TechnologicaModelLayers.ELEPHANT, ElephantModel.createBodyLayer());
		register(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG, FigureEightPufferfishBigModel.createBodyLayer());
		register(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM, FigureEightPufferfishMidModel.createBodyLayer());
		register(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL, FigureEightPufferfishSmallModel.createBodyLayer());
		register(TechnologicaModelLayers.FLAMINGO, FlamingoModel.createBodyLayer());
		register(TechnologicaModelLayers.GIRAFFE, GiraffeModel.createBodyLayer());
		register(TechnologicaModelLayers.GORILLA, GorillaModel.createBodyLayer());
		register(TechnologicaModelLayers.GRIZZLY_BEAR, PolarBearModel.createBodyLayer());
		register(TechnologicaModelLayers.JAGUAR, JaguarModel.createBodyLayer());
		register(TechnologicaModelLayers.KING_CRAB, KingCrabModel.createBodyLayer());
		register(TechnologicaModelLayers.LEOPARD_SEAL, LeopardSealModel.createBodyLayer());
		register(TechnologicaModelLayers.LION, LionModel.createBodyLayer());
		register(TechnologicaModelLayers.LIZARD, LizardModel.createBodyLayer());
		register(TechnologicaModelLayers.MOOSE, MooseModel.createBodyLayer());
		register(TechnologicaModelLayers.NARWHAL, NarwhalModel.createBodyLayer());
		register(TechnologicaModelLayers.OCTOPUS, OctopusModel.createBodyLayer());
		register(TechnologicaModelLayers.OSTRICH, OstrichModel.createBodyLayer());
		register(TechnologicaModelLayers.OWL, OwlModel.createBodyLayer());
		register(TechnologicaModelLayers.PENGUIN, PenguinModel.createBodyLayer());
		register(TechnologicaModelLayers.PIRANHA, PiranhaModel.createBodyLayer());
		register(TechnologicaModelLayers.POISON_DART_FROG, PoisonDartFrogModel.createBodyLayer());
		register(TechnologicaModelLayers.RACCOON, RaccoonModel.createBodyLayer());
		register(TechnologicaModelLayers.SCORPION, ScorpionModel.createBodyLayer());
		register(TechnologicaModelLayers.SHARK, SharkModel.createBodyLayer());
		register(TechnologicaModelLayers.SLOTH, SlothModel.createBodyLayer());
		register(TechnologicaModelLayers.STINGRAY, StingrayModel.createBodyLayer());
		register(TechnologicaModelLayers.TURKEY, TurkeyModel.createBodyLayer());
		register(TechnologicaModelLayers.VULTURE, VultureModel.createBodyLayer());
		register(TechnologicaModelLayers.WALRUS, WalrusModel.createBodyLayer());
		register(TechnologicaModelLayers.ZEBRA, LayerDefinition.create(HorseModel.createBodyMesh(CubeDeformation.NONE), 64, 64));
		register(TechnologicaModelLayers.ATOMIC_CREEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.MUMMY, LayerDefinition.create(ZombieModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64));
		register(TechnologicaModelLayers.BEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.BEEPER_HEAD, SkullModel.createMobHeadLayer());
		register(TechnologicaModelLayers.PEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.PEEPER_HEAD, SkullModel.createMobHeadLayer());
		register(TechnologicaModelLayers.SLEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.SLEEPER_HEAD, SkullModel.createMobHeadLayer());
		register(TechnologicaModelLayers.SWEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.SWEEPER_HEAD, SkullModel.createMobHeadLayer());
		register(TechnologicaModelLayers.WEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.WEEPER_HEAD, SkullModel.createMobHeadLayer());
		register(TechnologicaModelLayers.DUST_DEVIL, DustDevilModel.createBodyLayer(CubeDeformation.NONE));
		register(TechnologicaModelLayers.NAVAL_MINE, NavalMineModel.createBodyModel());
		register(TechnologicaModelLayers.WINDMILL, WindmillModel.createBodyModel());
		register(TechnologicaModelLayers.ROCKET, BoatModel.createBodyModel());
		register(TechnologicaModelLayers.SUBMERSIBLE, BiPlaneModel.createBodyModel());
		register(TechnologicaModelLayers.COCONUT_BAZOOKA, CoconutBazookaModel.createLayer());
		register(TechnologicaModelLayers.SPEAR_GUN, SpearGunModel.createLayer());
		register(TechnologicaModelLayers.MINING_HELMET, LayerDefinition.create(MiningHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		register(TechnologicaModelLayers.DIVING_HELMET, LayerDefinition.create(DivingHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		for (TechnologicaBoat.Type boat$type : TechnologicaBoat.Type.values()) {
			register(TechnologicaModelLayers.createBoatModelName(boat$type), BoatModel.createBodyModel());
		}
	}

	private static void register(ModelLayerLocation model, LayerDefinition layer) {
		ROOTS.put(model, layer);
	}
}
