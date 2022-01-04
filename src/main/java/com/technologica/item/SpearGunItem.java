package com.technologica.item;

import java.util.function.Predicate;

import com.technologica.entity.projectile.HarpoonEntity;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
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
		super(builder);
	}

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerEntityIn, Hand handIn) {
		boolean creativeMode = playerEntityIn.abilities.isCreativeMode;
		ItemStack spearGun = playerEntityIn.getHeldItem(handIn);
		ItemStack harpoon;
		
		if (creativeMode) {
			harpoon = new ItemStack(TechnologicaItems.HARPOON.get()); 
		} else {
			harpoon = ItemStack.EMPTY;
			for(int i = 0; i < playerEntityIn.inventory.getSizeInventory(); ++i) {
            	ItemStack testStack = playerEntityIn.inventory.getStackInSlot(i);
            	if (testStack.getItem() == TechnologicaItems.HARPOON.get()) {
            		harpoon = testStack;
            	}
            }
		}
		
		Float velocity = (playerEntityIn.isInWater()) ? 3.0F : 0.5F;
		
		if (!worldIn.isRemote) {
			HarpoonEntity harpoonEntity = new HarpoonEntity(worldIn, playerEntityIn);
			harpoonEntity.setDirectionAndMovement(playerEntityIn, playerEntityIn.rotationPitch, playerEntityIn.rotationYaw, 0.0F, velocity, 1.0F);
			
			spearGun.damageItem(1, playerEntityIn, (player) -> {
				player.sendBreakAnimation(playerEntityIn.getActiveHand());
			});
			
			worldIn.addEntity(harpoonEntity);
		}

		worldIn.playSound((PlayerEntity) null, playerEntityIn.getPosX(), playerEntityIn.getPosY(), playerEntityIn.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
		if (!creativeMode) {
			harpoon.shrink(1);
			if (harpoon.isEmpty()) {
				playerEntityIn.inventory.deleteStack(harpoon);
			}
		}

		playerEntityIn.addStat(Stats.ITEM_USED.get(this));
		return ActionResult.resultFail(spearGun);
	}

	/**
	 * Get the predicate to match ammunition when searching the player's inventory,
	 * not their main/offhand
	 */
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return ARROWS;
	}

	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		return arrow;
	}

	public int func_230305_d_() {
		return 15;
	}
}
