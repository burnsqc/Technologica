package com.technologica.listeners;

import static net.minecraft.entity.passive.horse.AbstractHorseEntity.func_234237_fg_;

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
		event.put(TechnologicaEntityType.ALLIGATOR.get(), AlligatorEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.BEAVER.get(), BeaverEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.BUFFALO.get(), BuffaloEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.CAMEL.get(), CamelEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.COBRA.get(), CobraEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.COTTONMOUTH.get(), CottonmouthEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.COYOTE.get(), CoyoteEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.CRAB.get(), CrabEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.DEER.get(), DeerEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.DUCK.get(), DuckEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.ELEPHANT.get(), ElephantEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.FLAMINGO.get(), FlamingoEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.FROG.get(), FrogEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.GIRAFFE.get(), func_234237_fg_().create());
		event.put(TechnologicaEntityType.GORILLA.get(), GorillaEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.JAGUAR.get(), JaguarEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.KING_CRAB.get(), KingCrabEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSealEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.LION.get(), LionEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.LIZARD.get(), LizardEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.MOOSE.get(), MooseEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.NARWHAL.get(), NarwhalEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.OCTOPUS.get(), OctopusEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.OSTRICH.get(), func_234237_fg_().create());
		event.put(TechnologicaEntityType.OWL.get(), OwlEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.PENGUIN.get(), PenguinEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.PIRANHA.get(), PiranhaEntity.func_234176_m_().create());
		event.put(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrogEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.RACCOON.get(), RaccoonEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.SCORPION.get(), ScorpionEntity.func_234305_eI_().create());
		event.put(TechnologicaEntityType.SHARK.get(), SharkEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.SLOTH.get(), SlothEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.STINGRAY.get(), StingrayEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.TURKEY.get(), TurkeyEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.VULTURE.get(), VultureEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.WALRUS.get(), WalrusEntity.registerAttributes().create());
		event.put(TechnologicaEntityType.ZEBRA.get(), func_234237_fg_().create());
		
		event.put(TechnologicaEntityType.PEEPER.get(), func_234237_fg_().create());
		event.put(TechnologicaEntityType.SWEEPER.get(), func_234237_fg_().create());
	}
	
}
