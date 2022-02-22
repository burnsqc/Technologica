package com.technologica.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WaterWalk {
	
	@SubscribeEvent
	public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntity();
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;
			Iterable<ItemStack> armor = player.getArmorSlots();

			for (ItemStack piece : armor) {
				if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!piece.getItem().getRegistryName().getPath().contains("scuba")) {
					fullScubaSet = false;
				}
			}

			if (fullDiveSet) {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(2.0F);
			} else if (fullScubaSet) {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(3.0F);
			} else {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.0F);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = (PlayerEntity) event.player;
		Minecraft mc = Minecraft.getInstance();
		boolean fullDiveSet = true;
		boolean fullScubaSet = true;
		Iterable<ItemStack> armor = player.getArmorSlots();

		for (ItemStack piece : armor) {
			if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
				fullDiveSet = false;
			}
			if (!piece.getItem().getRegistryName().getPath().contains("scuba")) {
				fullScubaSet = false;
			}
		}

		if (player instanceof ClientPlayerEntity && fullDiveSet && !player.abilities.flying) {
			if (event.phase == TickEvent.Phase.START) {
				unHandleWaterAcceleration(player);
				if (player.isInWater()) {
					if (!player.isOnGround()) {
						player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y - 0.12, player.getDeltaMovement().z);
						player.hurtMarked = true;
					} else {
						if (mc.options.keyJump.isDown()) {
							player.jumpFromGround();
						}
					}
				}
			}
		} else if (player instanceof ClientPlayerEntity && fullScubaSet && !player.abilities.flying) {
			if (event.phase == TickEvent.Phase.START) {
				if (player.isInWater()) {
					player.setDeltaMovement(player.getDeltaMovement().x, 0.0F, player.getDeltaMovement().z);
					player.hurtMarked = true;
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean unHandleWaterAcceleration(PlayerEntity player) {
		AxisAlignedBB axisalignedbb = player.getBoundingBox().deflate(0.001D);
		int i = MathHelper.floor(axisalignedbb.minX);
		int j = MathHelper.ceil(axisalignedbb.maxX);
		int k = MathHelper.floor(axisalignedbb.minY);
		int l = MathHelper.ceil(axisalignedbb.maxY);
		int i1 = MathHelper.floor(axisalignedbb.minZ);
		int j1 = MathHelper.ceil(axisalignedbb.maxZ);
		if (!player.level.hasChunksAt(i, k, i1, j, l, j1)) {
			return false;
		} else {
			double d0 = 0.0D;
			boolean flag = player.isPushedByFluid();
			boolean flag1 = false;
			Vector3d vector3d = Vector3d.ZERO;
			int k1 = 0;
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = k; i2 < l; ++i2) {
					for (int j2 = i1; j2 < j1; ++j2) {
						blockpos$mutable.set(l1, i2, j2);
						FluidState fluidstate = player.level.getFluidState(blockpos$mutable);
						if (fluidstate.is(FluidTags.WATER)) {
							double d1 = (double) ((float) i2
									+ fluidstate.getHeight(player.level, blockpos$mutable));
							if (d1 >= axisalignedbb.minY) {
								flag1 = true;
								d0 = Math.max(d1 - axisalignedbb.minY, d0);
								if (flag) {
									Vector3d vector3d1 = fluidstate.getFlow(player.level, blockpos$mutable);
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
					vector3d = vector3d.scale(1.0D / (double) k1);
				}

				if (!(player instanceof PlayerEntity)) {
					vector3d = vector3d.normalize();
				}

				Vector3d vector3d2 = player.getDeltaMovement();
				vector3d = vector3d.scale(0.014D * 1.0D);

				if (Math.abs(vector3d2.x) < 0.003D && Math.abs(vector3d2.z) < 0.003D
						&& vector3d.length() < 0.0045000000000000005D) {
					vector3d = vector3d.normalize().scale(0.0045000000000000005D);
				}

				player.setDeltaMovement(player.getDeltaMovement().add(-vector3d.x, -vector3d.y, -vector3d.z));
			}

			return flag1;
		}
	}
}