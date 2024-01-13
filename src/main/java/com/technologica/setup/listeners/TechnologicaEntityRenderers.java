package com.technologica.setup.listeners;

import com.technologica.Technologica;
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

import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;

/**
 * <p>
 * This class listens for RegisterRenderersEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Entity Renderers and Block Entity Renderers are registered.
 * </p>
 * 
 * @tl.status YELLOW
 */
public final class TechnologicaEntityRenderers {

	public static void onRegisterRenderers(final RegisterRenderers event) {
		event.registerEntityRenderer(TechnologicaEntityTypes.TECHNOLOGICA_BOAT.get(), context -> new TechnologicaBoatRenderer(context, false));
		event.registerEntityRenderer(TechnologicaEntityTypes.INVISIBLE_SEAT.get(), InvisibleRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityTypes.COCONUT.get(), (renderManager) -> {
			return new ThrownItemRenderer<>(renderManager, 1.0F, true);
		});
		event.registerEntityRenderer(TechnologicaEntityTypes.DODGEBALL.get(), (renderManager) -> {
			return new ThrownItemRenderer<>(renderManager, 1.0F, true);
		});
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
		event.registerEntityRenderer(TechnologicaEntityTypes.METEOR.get(), (context) -> {
			return new ThrownItemRenderer<>(context, 4.0F, true);
		});
		// event.registerEntityRenderer(TechnologicaEntityTypes.ROCKET.get(), RocketRenderer::new);
		/**
		 * TODO: Determine how to count how many Technologica Entity Renderers actually got registered and replace the hard-coded value in the logger message. Trying to avoid Access Transformers, but could open up private final Map {@link EntityRenderers} PROVIDERS.
		 */
		Technologica.LOGGER.info("SETUP - ENTITY RENDERERS - 49 OF 49");
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
		event.registerBlockEntityRenderer(TechnologicaBlockEntityTypes.LAND_MINE_TILE.get(), LandMineRenderer::new);
		/**
		 * TODO: Determine how to count how many Technologica Block Entity Renderers actually got registered and replace the hard-coded value in the logger message. Trying to avoid Access Transformers, but could open up private final Map {@link BlockEntityRenderers} PROVIDERS.
		 */
		Technologica.LOGGER.info("SETUP - BLOCK ENTITY RENDERERS - 11 OF 11");
	}
}