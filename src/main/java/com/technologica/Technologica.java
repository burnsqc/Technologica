package com.technologica;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.network.packets.clientbound.SetMeteorStorm;
import com.technologica.network.packets.clientbound.SetMeteorStormLevel;
import com.technologica.network.packets.clientbound.UpdateDiverCapability;
import com.technologica.network.packets.serverbound.UpdateAnnunciator;
import com.technologica.network.packets.serverbound.UpdateMonitor;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.setup.common.TechnologicaConfigCommon;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.TechnologicaMobCategory;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod(Technologica.MOD_ID)
public class Technologica {
	public static Technologica instance;
	public static final String MOD_ID = "technologica";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new TechnologicaLocation("main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static int PACKET_ID = 0;
	@Nullable
	public TechnologicaServerLevel serverLevel;
	@Nullable
	public TechnologicaClientLevel clientLevel;

	public Technologica() {
		LOGGER.info("TECHNOLOGICA NOW LOADING FOR DISTRIBUTION - " + FMLEnvironment.dist.toString());
		instance = this;
		MasterDeferredRegistrar.initDeferredRegisters();

		ModLoadingContext.get().registerConfig(Type.COMMON, TechnologicaConfigCommon.COMMON_SPEC, "technologica-common.toml");

		CHANNEL.registerMessage(PACKET_ID++, UpdateAnnunciator.class, UpdateAnnunciator::encode, UpdateAnnunciator::decode, UpdateAnnunciator::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateDiverCapability.class, UpdateDiverCapability::encode, UpdateDiverCapability::decode, UpdateDiverCapability::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateMonitor.class, UpdateMonitor::encode, UpdateMonitor::decode, UpdateMonitor::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStorm.class, SetMeteorStorm::encode, SetMeteorStorm::decode, SetMeteorStorm::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStormLevel.class, SetMeteorStormLevel::encode, SetMeteorStormLevel::decode, SetMeteorStormLevel::handle);

		// TODO: Determine best place for this. Maybe it's right here but that's unconfirmed.
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
		TechnologicaMobCategory.bootstrap();
	}

	public static Technologica getInstance() {
		return instance;
	}

	public void setServerLevel(TechnologicaServerLevel level) {
		this.serverLevel = level;
	}

	public void setClientLevel(TechnologicaClientLevel level) {
		this.clientLevel = level;
	}
}
