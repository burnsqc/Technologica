package com.technologica.listeners.forgebus;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class PlayerTickEventListener {

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		Player player = event.player;
		Level level = player.level();
		BlockPos pos = BlockPos.containing(player.getEyePosition());
		if (level.getBlockState(pos).getBlock() instanceof AirBlock && level instanceof ServerLevel) {
			Iterable<ItemStack> armor = player.getArmorSlots();
			for (ItemStack piece : armor) {
				if (piece.is(TechnologicaItems.MINING_HELMET.get())) {
					level.setBlockAndUpdate(pos, TechnologicaBlocks.LIGHT.get().defaultBlockState());
				}
			}
		}

		if (player instanceof ServerPlayer) {
			int air = player.getAirSupply();
			int maxAir = 300;
			boolean fullSnorkelSet = true;
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;
			Iterable<ItemStack> armor = player.getArmorSlots();

			for (ItemStack piece : armor) {
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("snorkel")) {
					fullSnorkelSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("scuba")) {
					fullScubaSet = false;
				}
			}

			maxAir = fullSnorkelSet ? 600 : 300;
			maxAir = fullDiveSet ? 6000 : maxAir;
			maxAir = fullScubaSet ? 12000 : maxAir;

			if (!player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || player.level().getBlockState(BlockPos.containing(player.getX(), player.getEyeY(), player.getZ())).is(Blocks.BUBBLE_COLUMN)) {
				if (air >= 300 && air < maxAir) {
					player.setAirSupply(Math.min(air + 4, maxAir));
				}
			}

			if (air > maxAir) {
				player.setAirSupply(300);
			}

			Minecraft mc = Minecraft.getInstance();

			if (player instanceof LocalPlayer && fullDiveSet && !player.getAbilities().flying) {
				if (event.phase == TickEvent.Phase.START) {
					unHandleWaterAcceleration(player);
					if (player.isInWater()) {
						if (!player.onGround()) {
							player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y - 0.12, player.getDeltaMovement().z);
							player.hurtMarked = true;
						} else {
							if (mc.options.keyJump.isDown()) {
								player.jumpFromGround();
							}
						}
					}
				}
			} else if (player instanceof LocalPlayer && fullScubaSet && !player.getAbilities().flying) {
				if (event.phase == TickEvent.Phase.START) {
					if (player.isInWater()) {
						player.setDeltaMovement(player.getDeltaMovement().x, 0.0F, player.getDeltaMovement().z);
						player.hurtMarked = true;
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean unHandleWaterAcceleration(Player player) {
		AABB axisalignedbb = player.getBoundingBox().deflate(0.001D);
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.minY);
		int l = Mth.ceil(axisalignedbb.maxY);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		if (!player.level().hasChunksAt(i, k, i1, j, l, j1)) {
			return false;
		} else {
			double d0 = 0.0D;
			boolean flag = player.isPushedByFluid();
			boolean flag1 = false;
			Vec3 vector3d = Vec3.ZERO;
			int k1 = 0;
			BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = k; i2 < l; ++i2) {
					for (int j2 = i1; j2 < j1; ++j2) {
						blockpos$mutable.set(l1, i2, j2);
						FluidState fluidstate = player.level().getFluidState(blockpos$mutable);
						if (fluidstate.is(FluidTags.WATER)) {
							double d1 = i2 + fluidstate.getHeight(player.level(), blockpos$mutable);
							if (d1 >= axisalignedbb.minY) {
								flag1 = true;
								d0 = Math.max(d1 - axisalignedbb.minY, d0);
								if (flag) {
									Vec3 vector3d1 = fluidstate.getFlow(player.level(), blockpos$mutable);
									if (d0 < 0.4D) {
										vector3d1 = vector3d1.scale(d0);
									}

									vector3d = vector3d.add(vector3d1);
									++k1;
								}
							}
						}
					}
				}
			}

			if (vector3d.length() > 0.0D) {
				if (k1 > 0) {
					vector3d = vector3d.scale(1.0D / k1);
				}

				if (!(player instanceof Player)) {
					vector3d = vector3d.normalize();
				}

				Vec3 vector3d2 = player.getDeltaMovement();
				vector3d = vector3d.scale(0.014D * 1.0D);

				if (Math.abs(vector3d2.x) < 0.003D && Math.abs(vector3d2.z) < 0.003D && vector3d.length() < 0.0045000000000000005D) {
					vector3d = vector3d.normalize().scale(0.0045000000000000005D);
				}

				player.setDeltaMovement(player.getDeltaMovement().add(-vector3d.x, -vector3d.y, -vector3d.z));
			}

			return flag1;
		}
	}
}