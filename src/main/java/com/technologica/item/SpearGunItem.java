package com.technologica.item;

import java.util.function.Predicate;

import com.technologica.client.renderer.tileentity.SpearGunItemStackTileEntityRenderer;
import com.technologica.entity.projectile.HarpoonEntity;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SpearGunItem extends ShootableItem implements IVanishable {
	public SpearGunItem(Item.Properties builder) {
		super(builder.setISTER(() -> SpearGunItemStackTileEntityRenderer::new));
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean creativeMode = playerentity.abilities.isCreativeMode;
			ItemStack harpoon;

			if (creativeMode) {
				harpoon = new ItemStack(TechnologicaItems.HARPOON.get());
			} else {
				harpoon = ItemStack.EMPTY;
				for (int i = 0; i < playerentity.inventory.getSizeInventory(); ++i) {
					ItemStack testStack = playerentity.inventory.getStackInSlot(i);
					if (testStack.getItem() == TechnologicaItems.HARPOON.get()) {
						harpoon = testStack;
					}
				}
			}

			int i = this.getUseDuration(stack) - timeLeft;
			if (i < 0)
				return;

			if (!harpoon.isEmpty() || creativeMode) {

				Float velocity = (playerentity.isInWater()) ? 3.0F : 0.5F;

				if (!worldIn.isRemote) {

					HarpoonEntity harpoonEntity = new HarpoonEntity(worldIn, playerentity);
					harpoonEntity.setDirectionAndMovement(playerentity, playerentity.rotationPitch,
							playerentity.rotationYaw, 0.0F, velocity, 1.0F);

					stack.damageItem(1, playerentity, (player) -> {
						player.sendBreakAnimation(playerentity.getActiveHand());
					});

					worldIn.addEntity(harpoonEntity);
				}

				worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
						playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
						1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
				if (!creativeMode) {
					harpoon.shrink(1);
					if (harpoon.isEmpty()) {
						playerentity.inventory.deleteStack(harpoon);
					}
				}

				playerentity.addStat(Stats.ITEM_USED.get(this));
			}
		}
	}

	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (!playerIn.abilities.isCreativeMode ) {
			return ActionResult.resultFail(itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(itemstack);
		}
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return null;
	}
}
