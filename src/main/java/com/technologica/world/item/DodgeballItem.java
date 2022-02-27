package com.technologica.world.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;

import com.technologica.world.entity.projectile.Dodgeball;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

public class DodgeballItem extends Item {
	public DodgeballItem(Item.Properties builderIn) {
		super(builderIn);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		worldIn.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (worldIn.random.nextFloat() * 0.4F + 0.8F));
		
		if (!worldIn.isClientSide) {
			Dodgeball dodgeballEntity = new Dodgeball(worldIn, playerIn);
			dodgeballEntity.setItem(itemstack);
			dodgeballEntity.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 2.5F, 0.0F);
			worldIn.addFreshEntity(dodgeballEntity);
		}

		playerIn.awardStat(Stats.ITEM_USED.get(this));
		
		if (!playerIn.getAbilities().instabuild) {
			itemstack.shrink(1);
		}

		return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
	}
}