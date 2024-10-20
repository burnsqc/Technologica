package com.technologica.client.renderer.entity;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class TechnologicaEntityRenderers {
	public static final Map<EntityType<? extends Entity>, EntityRendererProvider<Entity>> PROVIDERS = Maps.newHashMap();

	@SuppressWarnings("unchecked")
	public static <T extends Entity> void register(EntityType<? extends T> entity, EntityRendererProvider<T> renderer) {
		PROVIDERS.put((EntityType<? extends T>) entity, (EntityRendererProvider<Entity>) renderer);
	}

	static {
		register(TechnologicaEntityTypes.TECHNOLOGICA_BOAT.get(), context -> new TechnologicaBoatRenderer(context, false));
		register(TechnologicaEntityTypes.INVISIBLE_SEAT.get(), InvisibleRenderer::new);
		register(TechnologicaEntityTypes.COCONUT.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 1.0F, true));
		register(TechnologicaEntityTypes.DODGEBALL.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 1.0F, true));
		register(TechnologicaEntityTypes.HARPOON.get(), HarpoonRenderer::new);
		register(TechnologicaEntityTypes.ALLIGATOR.get(), AlligatorRenderer::new);
		register(TechnologicaEntityTypes.BEAVER.get(), BeaverRenderer::new);
		register(TechnologicaEntityTypes.BUFFALO.get(), BuffaloRenderer::new);
		register(TechnologicaEntityTypes.COBRA.get(), CobraRenderer::new);
		register(TechnologicaEntityTypes.COTTONMOUTH.get(), CottonmouthRenderer::new);
		register(TechnologicaEntityTypes.COYOTE.get(), CoyoteRenderer::new);
		register(TechnologicaEntityTypes.CRAB.get(), CrabRenderer::new);
		register(TechnologicaEntityTypes.DEER.get(), DeerRenderer::new);
		register(TechnologicaEntityTypes.DUCK.get(), DuckRenderer::new);
		register(TechnologicaEntityTypes.ELEPHANT.get(), ElephantRenderer::new);
		register(TechnologicaEntityTypes.FLAMINGO.get(), FlamingoRenderer::new);
		register(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), FigureEightPufferfishRenderer::new);
		register(TechnologicaEntityTypes.GIRAFFE.get(), GiraffeRenderer::new);
		register(TechnologicaEntityTypes.GORILLA.get(), GorillaRenderer::new);
		register(TechnologicaEntityTypes.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		register(TechnologicaEntityTypes.JAGUAR.get(), JaguarRenderer::new);
		register(TechnologicaEntityTypes.KING_CRAB.get(), KingCrabRenderer::new);
		register(TechnologicaEntityTypes.LEOPARD_SEAL.get(), LeopardSealRenderer::new);
		register(TechnologicaEntityTypes.LION.get(), LionRenderer::new);
		register(TechnologicaEntityTypes.LIZARD.get(), LizardRenderer::new);
		register(TechnologicaEntityTypes.MOOSE.get(), MooseRenderer::new);
		register(TechnologicaEntityTypes.NARWHAL.get(), NarwhalRenderer::new);
		register(TechnologicaEntityTypes.OCTOPUS.get(), OctopusRenderer::new);
		register(TechnologicaEntityTypes.OSTRICH.get(), OstrichRenderer::new);
		register(TechnologicaEntityTypes.OWL.get(), OwlRenderer::new);
		register(TechnologicaEntityTypes.PENGUIN.get(), PenguinRenderer::new);
		register(TechnologicaEntityTypes.PIRANHA.get(), PiranhaRenderer::new);
		register(TechnologicaEntityTypes.POISON_DART_FROG.get(), PoisonDartFrogRenderer::new);
		register(TechnologicaEntityTypes.RACCOON.get(), RaccoonRenderer::new);
		register(TechnologicaEntityTypes.SCORPION.get(), ScorpionRenderer::new);
		register(TechnologicaEntityTypes.SHARK.get(), SharkRenderer::new);
		register(TechnologicaEntityTypes.SLOTH.get(), SlothRenderer::new);
		register(TechnologicaEntityTypes.STINGRAY.get(), StingrayRenderer::new);
		register(TechnologicaEntityTypes.TURKEY.get(), TurkeyRenderer::new);
		register(TechnologicaEntityTypes.VULTURE.get(), VultureRenderer::new);
		register(TechnologicaEntityTypes.WALRUS.get(), WalrusRenderer::new);
		register(TechnologicaEntityTypes.ZEBRA.get(), ZebraRenderer::new);
		register(TechnologicaEntityTypes.ATOMIC_CREEPER.get(), AtomicCreeperRenderer::new);
		register(TechnologicaEntityTypes.MUMMY.get(), MummyRenderer::new);
		register(TechnologicaEntityTypes.PEEPER.get(), PeeperRenderer::new);
		register(TechnologicaEntityTypes.BEEPER.get(), BeeperRenderer::new);
		register(TechnologicaEntityTypes.SLEEPER.get(), SleeperRenderer::new);
		register(TechnologicaEntityTypes.WEEPER.get(), WeeperRenderer::new);
		register(TechnologicaEntityTypes.SWEEPER.get(), SweeperRenderer::new);
		register(TechnologicaEntityTypes.DUST_DEVIL.get(), DustDevilRenderer::new);
		register(TechnologicaEntityTypes.NAVAL_MINE.get(), NavalMineRenderer::new);
		register(TechnologicaEntityTypes.METEOR.get(), renderManager -> new ThrownItemRenderer<>(renderManager, 4.0F, true));
		register(TechnologicaEntityTypes.MAGIC_LIGHTNING.get(), MagicLightningBoltRenderer::new);
		register(TechnologicaEntityTypes.SUBMERSIBLE.get(), context -> new SubmersibleRenderer(context));
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.ANNUNCIATOR_TILE.get(),
		// AnnunciatorRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.MONITOR_TILE.get(),
		// MonitorRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.VANILLA_SIGN.get(),
		// SignRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.TECHNOLOGICA_SIGN.get(),
		// TechnologicaSignRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.FRUIT_CROP.get(),
		// FruitRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.POTION_CROP.get(),
		// PotionRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.DISPLAY_TILE.get(),
		// DisplayCaseRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LINE_SHAFT_TILE.get(),
		// LineShaftRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LINE_SHAFT_HANGER_TILE.get(),
		// LineShaftHangerRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.SAWMILL_TILE.get(),
		// SawmillRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.WINDMILL.get(),
		// WindmillRenderer::new);
		// event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LAND_MINE_TILE.get(),
		// LandMineRenderer::new);
	}
}
