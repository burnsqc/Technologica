package com.technologica.item;

import com.technologica.entity.projectile.DodgeballEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DodgeballItem extends Item {
	public DodgeballItem(Item.Properties builderIn) {
		super(builderIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		
		if (!worldIn.isRemote) {
			DodgeballEntity dodgeballEntity = new DodgeballEntity(worldIn, playerIn);
			dodgeballEntity.setItem(itemstack);
			dodgeballEntity.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 0.0F);
			worldIn.addEntity(dodgeballEntity);
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		
		if (!playerIn.abilities.isCreativeMode) {
			itemstack.shrink(1);
		}

		return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
	}
}