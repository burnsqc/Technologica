package com.technologica.listeners;

import static com.technologica.Technologica.LOGGER;

import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.entity.animal.Alligator;
import com.technologica.world.entity.animal.Beaver;
import com.technologica.world.entity.animal.Buffalo;
import com.technologica.world.entity.animal.Camel;
import com.technologica.world.entity.animal.Cobra;
import com.technologica.world.entity.animal.Cottonmouth;
import com.technologica.world.entity.animal.Coyote;
import com.technologica.world.entity.animal.CrabEntity;
import com.technologica.world.entity.animal.DeerEntity;
import com.technologica.world.entity.animal.DuckEntity;
import com.technologica.world.entity.animal.ElephantEntity;
import com.technologica.world.entity.animal.FlamingoEntity;
import com.technologica.world.entity.animal.FrogEntity;
import com.technologica.world.entity.animal.GiraffeEntity;
import com.technologica.world.entity.animal.GorillaEntity;
import com.technologica.world.entity.animal.GrizzlyBearEntity;
import com.technologica.world.entity.animal.JaguarEntity;
import com.technologica.world.entity.animal.KingCrabEntity;
import com.technologica.world.entity.animal.LeopardSealEntity;
import com.technologica.world.entity.animal.LionEntity;
import com.technologica.world.entity.animal.LizardEntity;
import com.technologica.world.entity.animal.MooseEntity;
import com.technologica.world.entity.animal.NarwhalEntity;
import com.technologica.world.entity.animal.OctopusEntity;
import com.technologica.world.entity.animal.OstrichEntity;
import com.technologica.world.entity.animal.OwlEntity;
import com.technologica.world.entity.animal.PenguinEntity;
import com.technologica.world.entity.animal.PiranhaEntity;
import com.technologica.world.entity.animal.PoisonDartFrogEntity;
import com.technologica.world.entity.animal.RaccoonEntity;
import com.technologica.world.entity.animal.ScorpionEntity;
import com.technologica.world.entity.animal.SharkEntity;
import com.technologica.world.entity.animal.SlothEntity;
import com.technologica.world.entity.animal.StingrayEntity;
import com.technologica.world.entity.animal.TurkeyEntity;
import com.technologica.world.entity.animal.VultureEntity;
import com.technologica.world.entity.animal.WalrusEntity;
import com.technologica.world.entity.animal.ZebraEntity;
import com.technologica.world.entity.monster.PeeperEntity;
import com.technologica.world.entity.monster.SweeperEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterEntityAttributes {

	@SubscribeEvent
	public static void onEntityAttributeCreationEvent(final EntityAttributeCreationEvent event) {
		LOGGER.info("REGISTERING ENTITY ATTRIBUTES");
		event.put(TechnologicaEntityType.ALLIGATOR.get(), Alligator.registerAttributes().build());
		event.put(TechnologicaEntityType.BEAVER.get(), Beaver.registerAttributes().build());
		event.put(TechnologicaEntityType.BUFFALO.get(), Buffalo.registerAttributes().build());
		event.put(TechnologicaEntityType.CAMEL.get(), Camel.registerAttributes().build());
		event.put(TechnologicaEntityType.COBRA.get(), Cobra.registerAttributes().build());
		event.put(TechnologicaEntityType.COTTONMOUTH.get(), Cottonmouth.registerAttributes().build());
		event.put(TechnologicaEntityType.COYOTE.get(), Coyote.registerAttributes().build());
		event.put(TechnologicaEntityType.CRAB.get(), CrabEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.DEER.get(), DeerEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.DUCK.get(), DuckEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.ELEPHANT.get(), ElephantEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.FLAMINGO.get(), FlamingoEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.FROG.get(), FrogEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.GIRAFFE.get(), GiraffeEntity.createBaseHorseAttributes().build());
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
		event.put(TechnologicaEntityType.OSTRICH.get(), OstrichEntity.createBaseHorseAttributes().build());
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
		event.put(TechnologicaEntityType.ZEBRA.get(), ZebraEntity.createBaseHorseAttributes().build());
		
		event.put(TechnologicaEntityType.PEEPER.get(), PeeperEntity.registerAttributes().build());
		event.put(TechnologicaEntityType.SWEEPER.get(), SweeperEntity.registerAttributes().build());
	}
}
