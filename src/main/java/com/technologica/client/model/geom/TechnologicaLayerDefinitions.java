package com.technologica.client.model.geom;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;
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
import com.technologica.listeners.mod.client.EntityRenderersEventListener;
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

/**
 * Effectively a copy of {@link LayerDefinitions}. {@link #createRoots} gets
 * called by
 * {@link EntityRenderersEventListener#onEntityRenderersEvent$RegisterLayerDefinitions}
 * with the intent of keeping the listener method itself concise and providing a
 * higher fidelity mirror of vanilla code.
 */
public class TechnologicaLayerDefinitions {

	public static Map<ModelLayerLocation, LayerDefinition> createRoots() {
		ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();
		builder.put(TechnologicaModelLayers.ALLIGATOR, AlligatorModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.BEAVER, BeaverModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.BUFFALO, BuffaloModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.COBRA, CobraModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.COTTONMOUTH, CottonmouthModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.COYOTE, CoyoteModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.CRAB, CrabModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.DEER, DeerModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.DUCK, ChickenModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.ELEPHANT, ElephantModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_BIG, FigureEightPufferfishBigModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_MEDIUM, FigureEightPufferfishMidModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.FIGURE_EIGHT_PUFFERFISH_SMALL, FigureEightPufferfishSmallModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.FLAMINGO, FlamingoModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.GIRAFFE, GiraffeModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.GORILLA, GorillaModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.GRIZZLY_BEAR, PolarBearModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.JAGUAR, JaguarModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.KING_CRAB, KingCrabModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.LEOPARD_SEAL, LeopardSealModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.LION, LionModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.LIZARD, LizardModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.MOOSE, MooseModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.NARWHAL, NarwhalModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.OCTOPUS, OctopusModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.OSTRICH, OstrichModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.OWL, OwlModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.PENGUIN, PenguinModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.PIRANHA, PiranhaModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.POISON_DART_FROG, PoisonDartFrogModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.RACCOON, RaccoonModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.SCORPION, ScorpionModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.SHARK, SharkModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.SLOTH, SlothModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.STINGRAY, StingrayModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.TURKEY, TurkeyModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.VULTURE, VultureModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.WALRUS, WalrusModel.createBodyLayer());
		builder.put(TechnologicaModelLayers.ZEBRA, LayerDefinition.create(HorseModel.createBodyMesh(CubeDeformation.NONE), 64, 64));
		builder.put(TechnologicaModelLayers.ATOMIC_CREEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.MUMMY, LayerDefinition.create(ZombieModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64));
		builder.put(TechnologicaModelLayers.BEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.BEEPER_HEAD, SkullModel.createMobHeadLayer());
		builder.put(TechnologicaModelLayers.PEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.PEEPER_HEAD, SkullModel.createMobHeadLayer());
		builder.put(TechnologicaModelLayers.SLEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.SLEEPER_HEAD, SkullModel.createMobHeadLayer());
		builder.put(TechnologicaModelLayers.SWEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.SWEEPER_HEAD, SkullModel.createMobHeadLayer());
		builder.put(TechnologicaModelLayers.WEEPER, CreeperModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.WEEPER_HEAD, SkullModel.createMobHeadLayer());
		builder.put(TechnologicaModelLayers.DUST_DEVIL, DustDevilModel.createBodyLayer(CubeDeformation.NONE));
		builder.put(TechnologicaModelLayers.NAVAL_MINE, NavalMineModel.createBodyModel());
		builder.put(TechnologicaModelLayers.WINDMILL, WindmillModel.createBodyModel());
		builder.put(TechnologicaModelLayers.ROCKET, BoatModel.createBodyModel());
		builder.put(TechnologicaModelLayers.SUBMERSIBLE, BiPlaneModel.createBodyModel());
		builder.put(TechnologicaModelLayers.COCONUT_BAZOOKA, CoconutBazookaModel.createLayer());
		builder.put(TechnologicaModelLayers.SPEAR_GUN, SpearGunModel.createLayer());
		builder.put(TechnologicaModelLayers.MINING_HELMET, LayerDefinition.create(MiningHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));
		builder.put(TechnologicaModelLayers.DIVING_HELMET, LayerDefinition.create(DivingHelmetModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F), 64, 32));

		for (TechnologicaBoat.Type boat$type : TechnologicaBoat.Type.values()) {
			builder.put(TechnologicaModelLayers.createBoatModelName(boat$type), BoatModel.createBodyModel());
		}

		ImmutableMap<ModelLayerLocation, LayerDefinition> immutablemap = builder.build();
		List<ModelLayerLocation> list = TechnologicaModelLayers.getKnownLocations().filter((p_171117_) -> {
			return !immutablemap.containsKey(p_171117_);
		}).collect(Collectors.toList());
		if (!list.isEmpty()) {
			throw new IllegalStateException("Missing layer definitions: " + list);
		} else {
			return immutablemap;
		}
	}
}
