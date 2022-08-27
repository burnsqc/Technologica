package com.technologica.listeners;

import com.technologica.client.renderer.blockentity.AnnunciatorRenderer;
import com.technologica.client.renderer.blockentity.DisplayCaseRenderer;
import com.technologica.client.renderer.blockentity.FruitRenderer;
import com.technologica.client.renderer.blockentity.LandMineRenderer;
import com.technologica.client.renderer.blockentity.LineShaftHangerRenderer;
import com.technologica.client.renderer.blockentity.LineShaftRenderer;
import com.technologica.client.renderer.blockentity.PotionRenderer;
import com.technologica.client.renderer.blockentity.SawmillRenderer;
import com.technologica.client.renderer.blockentity.TechnologicaSignRenderer;
import com.technologica.client.renderer.entity.AlligatorRenderer;
import com.technologica.client.renderer.entity.BeaverRenderer;
import com.technologica.client.renderer.entity.BuffaloRenderer;
import com.technologica.client.renderer.entity.CamelRenderer;
import com.technologica.client.renderer.entity.CobraRenderer;
import com.technologica.client.renderer.entity.CottonmouthRenderer;
import com.technologica.client.renderer.entity.CoyoteRenderer;
import com.technologica.client.renderer.entity.CrabRenderer;
import com.technologica.client.renderer.entity.DeerRenderer;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.ElephantRenderer;
import com.technologica.client.renderer.entity.FlamingoRenderer;
import com.technologica.client.renderer.entity.FrogRenderer;
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
import com.technologica.client.renderer.entity.SlothRenderer;
import com.technologica.client.renderer.entity.StingrayRenderer;
import com.technologica.client.renderer.entity.SweeperRenderer;
import com.technologica.client.renderer.entity.TurkeyRenderer;
import com.technologica.client.renderer.entity.VanillaBoatRenderer;
import com.technologica.client.renderer.entity.VultureRenderer;
import com.technologica.client.renderer.entity.WalrusRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.level.block.entity.TechnologicaBlockEntityType;

import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterEntityRenderers {
	@SubscribeEvent
	public static void onRegisterEntityRenderers(final RegisterRenderers event) {
		event.registerEntityRenderer(TechnologicaEntityType.MOD_BOAT.get(), VanillaBoatRenderer::new);

		event.registerEntityRenderer(TechnologicaEntityType.INVISIBLE_SEAT.get(), InvisibleRenderer::new);

		event.registerEntityRenderer(TechnologicaEntityType.COCONUT.get(), (renderManager) -> {
			return new ThrownItemRenderer<>(renderManager, 1.0F, true);
		});
		event.registerEntityRenderer(TechnologicaEntityType.DODGEBALL.get(), (renderManager) -> {
			return new ThrownItemRenderer<>(renderManager, 1.0F, true);
		});
		event.registerEntityRenderer(TechnologicaEntityType.HARPOON.get(), HarpoonRenderer::new);

		event.registerEntityRenderer(TechnologicaEntityType.ALLIGATOR.get(), AlligatorRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.BEAVER.get(), BeaverRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.BUFFALO.get(), BuffaloRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.CAMEL.get(), CamelRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.COBRA.get(), CobraRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.COTTONMOUTH.get(), CottonmouthRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.COYOTE.get(), CoyoteRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.CRAB.get(), CrabRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.DEER.get(), DeerRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.DUCK.get(), DuckRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.ELEPHANT.get(), ElephantRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.FLAMINGO.get(), FlamingoRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.FROG.get(), FrogRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.GIRAFFE.get(), GiraffeRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.GORILLA.get(), GorillaRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.JAGUAR.get(), JaguarRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.KING_CRAB.get(), KingCrabRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.LEOPARD_SEAL.get(), LeopardSealRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.LION.get(), LionRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.LIZARD.get(), LizardRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.MOOSE.get(), MooseRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.NARWHAL.get(), NarwhalRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.OCTOPUS.get(), OctopusRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.OSTRICH.get(), OstrichRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.OWL.get(), OwlRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.PENGUIN.get(), PenguinRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.PIRANHA.get(), PiranhaRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.POISON_DART_FROG.get(), PoisonDartFrogRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.RACCOON.get(), RaccoonRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.SCORPION.get(), ScorpionRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.SHARK.get(), SharkRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.SLOTH.get(), SlothRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.STINGRAY.get(), StingrayRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.TURKEY.get(), TurkeyRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.VULTURE.get(), VultureRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.WALRUS.get(), WalrusRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.ZEBRA.get(), ZebraRenderer::new);

		event.registerEntityRenderer(TechnologicaEntityType.PEEPER.get(), PeeperRenderer::new);
		event.registerEntityRenderer(TechnologicaEntityType.SWEEPER.get(), SweeperRenderer::new);

		event.registerEntityRenderer(TechnologicaEntityType.NAVAL_MINE.get(), NavalMineRenderer::new);

		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.ANNUNCIATOR_TILE.get(), AnnunciatorRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.VANILLA_SIGN.get(), SignRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.TECHNOLOGICA_SIGN.get(), TechnologicaSignRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.FRUIT_CROP.get(), FruitRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.POTION_CROP.get(), PotionRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.DISPLAY_TILE.get(), DisplayCaseRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.LINE_SHAFT_TILE.get(), LineShaftRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.SAWMILL_TILE.get(), SawmillRenderer::new);
		event.registerBlockEntityRenderer(TechnologicaBlockEntityType.LAND_MINE_TILE.get(), LandMineRenderer::new);
	}
}