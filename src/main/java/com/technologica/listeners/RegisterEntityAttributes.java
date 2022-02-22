package com.technologica.listeners;

import static com.technologica.Technologica.LOGGER;
import static net.minecraft.entity.passive.horse.AbstractHorseEntity.createBaseHorseAttributes;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.entity.passive.AlligatorEntity;
import com.technologica.entity.passive.BeaverEntity;
import com.technologica.entity.passive.BuffaloEntity;
import com.technologica.entity.passive.CamelEntity;
import com.technologica.entity.passive.CobraEntity;
import com.technologica.entity.passive.CottonmouthEntity;
import com.technologica.entity.passive.CoyoteEntity;
import com.technologica.entity.passive.CrabEntity;
import com.technologica.entity.passive.DeerEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.ElephantEntity;
import com.technologica.entity.passive.FlamingoEntity;
import com.technologica.entity.passive.FrogEntity;
import com.technologica.entity.passive.GorillaEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.JaguarEntity;
import com.technologica.entity.passive.KingCrabEntity;
import com.technologica.entity.passive.LeopardSealEntity;
import com.technologica.entity.passive.LionEntity;
import com.technologica.entity.passive.LizardEntity;
import com.technologica.entity.passive.MooseEntity;
import com.technologica.entity.passive.NarwhalEntity;
import com.technologica.entity.passive.OctopusEntity;
import com.technologica.entity.passive.OwlEntity;
import com.technologica.entity.passive.PenguinEntity;
import com.technologica.entity.passive.PoisonDartFrogEntity;
import com.technologica.entity.passive.RaccoonEntity;
import com.technologica.entity.passive.ScorpionEntity;
import com.technologica.entity.passive.SharkEntity;
import com.technologica.entity.passive.SlothEntity;
import com.technologica.entity.passive.StingrayEntity;
import com.technologica.entity.passive.TurkeyEntity;
import com.technologica.entity.passive.VultureEntity;
import com.technologica.entity.passive.WalrusEntity;
import com.technologica.entity.passive.fish.PiranhaEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterEntityAttributes {

	@SubscribeEvent
	public static void onEntityAttributeCreationEvent(final EntityAttributeCreationEvent event) {
		LOGGER.info("REGISTERING ENTITY ATTRIBUTES");
		event.put(TechnologicaEntityType.ALLIGATOR.get(), AlligatorEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.BEAVER.get(), BeaverEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.BUFFALO.get(), BuffaloEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.CAMEL.get(), CamelEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.COBRA.get(), CobraEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.COTTONMOUTH.get(), CottonmouthEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.COYOTE.get(), CoyoteEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.CRAB.get(), CrabEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.DEER.get(), DeerEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.DUCK.get(), DuckEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.ELEPHANT.get(), ElephantEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.FLAMINGO.get(), FlamingoEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.FROG.get(), FrogEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.GIRAFFE.get(), createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.GORILLA.get(), GorillaEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.JAGUAR.get(), JaguarEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.KING_CRAB.get(), KingCrabEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSealEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.LION.get(), LionEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.LIZARD.get(), LizardEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.MOOSE.get(), MooseEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.NARWHAL.get(), NarwhalEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.OCTOPUS.get(), OctopusEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.OSTRICH.get(), createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.OWL.get(), OwlEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.PENGUIN.get(), PenguinEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.PIRANHA.get(), PiranhaEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrogEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.RACCOON.get(), RaccoonEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.SCORPION.get(), ScorpionEntity.createAttributes().build());
		event.put(TechnologicaEntityType.SHARK.get(), SharkEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.SLOTH.get(), SlothEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.STINGRAY.get(), StingrayEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.TURKEY.get(), TurkeyEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.VULTURE.get(), VultureEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.WALRUS.get(), WalrusEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.ZEBRA.get(), createBaseHorseAttributes().build());
		
		event.put(TechnologicaEntityType.PEEPER.get(), createBaseHorseAttributes().build());
		event.put(TechnologicaEntityType.SWEEPER.get(), createBaseHorseAttributes().build());
	}
}
