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
			boolean fullSet = true;
			Iterable<ItemStack> armor = player.getArmorInventoryList();

			for (ItemStack piece : armor) {
				if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
					fullSet = false;
				}
			}

			if (fullSet) {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(2.0F);
			} else {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.0F);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = (PlayerEntity) event.player;
		Minecraft mc = Minecraft.getInstance();
		boolean fullSet = true;
		Iterable<ItemStack> armor = player.getArmorInventoryList();

		for (ItemStack piece : armor) {
			if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
				fullSet = false;
			}
		}
		
		
		if (player instanceof ClientPlayerEntity && fullSet && !player.abilities.isFlying) {
			if (event.phase == TickEvent.Phase.START) {
				unHandleWaterAcceleration(player);
				if (player.isInWater()) {
					if (!player.isOnGround()) {
						player.setMotion(player.getMotion().x, player.getMotion().y - 0.12, player.getMotion().z);
						player.velocityChanged = true;
					} else {
 						if (mc.gameSettings.keyBindJump.isKeyDown()) {
 							player.jump();
						}
					}  
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean unHandleWaterAcceleration(PlayerEntity player) {
		AxisAlignedBB axisalignedbb = player.getBoundingBox().shrink(0.001D);
		int i = MathHelper.floor(axisalignedbb.minX);
		int j = MathHelper.ceil(axisalignedbb.maxX);
		int k = MathHelper.floor(axisalignedbb.minY);
		int l = MathHelper.ceil(axisalignedbb.maxY);
		int i1 = MathHelper.floor(axisalignedbb.minZ);
		int j1 = MathHelper.ceil(axisalignedbb.maxZ);
		if (!player.world.isAreaLoaded(i, k, i1, j, l, j1)) {
			return false;
		} else {
			double d0 = 0.0D;
			boolean flag = player.isPushedByWater();
			boolean flag1 = false;
			Vector3d vector3d = Vector3d.ZERO;
			int k1 = 0;
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = k; i2 < l; ++i2) {
					for (int j2 = i1; j2 < j1; ++j2) {
						blockpos$mutable.setPos(l1, i2, j2);
						FluidState fluidstate = player.world.getFluidState(blockpos$mutable);
						if (fluidstate.isTagged(FluidTags.WATER)) {
							double d1 = (double) ((float) i2 + fluidstate.getActualHeight(player.world, blockpos$mutable));
							if (d1 >= axisalignedbb.minY) {
								flag1 = true;
								d0 = Math.max(d1 - axisalignedbb.minY, d0);
								if (flag) {
									Vector3d vector3d1 = fluidstate.getFlow(player.world, blockpos$mutable);
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

				Vector3d vector3d2 = player.getMotion();
				vector3d = vector3d.scale(0.014D * 1.0D);
				
				if (Math.abs(vector3d2.x) < 0.003D && Math.abs(vector3d2.z) < 0.003D
						&& vector3d.length() < 0.0045000000000000005D) {
					vector3d = vector3d.normalize().scale(0.0045000000000000005D);
				}

				player.setMotion(player.getMotion().add(-vector3d.x, -vector3d.y, -vector3d.z));
			}

			return flag1;
		}
	}

	
	
}