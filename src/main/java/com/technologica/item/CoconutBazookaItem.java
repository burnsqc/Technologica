package com.technologica.item;

import java.util.function.Predicate;

import com.technologica.client.renderer.tileentity.CoconutBazookaItemStackTileEntityRenderer;
import com.technologica.entity.projectile.CoconutEntity;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
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

public class CoconutBazookaItem extends ShootableItem implements IVanishable {
	private int remainingProjectiles = 0;
	private int spacingTimer = 0;

	public CoconutBazookaItem(Item.Properties builder) {
		super(builder.setISTER(() -> CoconutBazookaItemStackTileEntityRenderer::new));
	}

	@Override
	public void releaseUsing(ItemStack itemStackIn, World worldIn, LivingEntity livingEntityIn, int timeLeftIn) {
		if (livingEntityIn instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) livingEntityIn;
			boolean creativeMode = playerentity.abilities.instabuild;
			ItemStack itemstack;
			
			if (creativeMode) {
				itemstack = new ItemStack(TechnologicaItems.COCONUT.get()); 
			} else {
				itemstack = ItemStack.EMPTY;
				for(int i = 0; i < playerentity.inventory.getContainerSize(); ++i) {
	            	ItemStack testStack = playerentity.inventory.getItem(i);
	            	if (testStack.getItem() == TechnologicaItems.COCONUT.get()) {
	            		itemstack = testStack;
	            	}
	            }
			}

			int i = this.getUseDuration(itemStackIn) - timeLeftIn;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(itemStackIn, worldIn, playerentity, i, !itemstack.isEmpty() || creativeMode);
			
			remainingProjectiles = Math.min(i, 30) / 10;

			if (i < 0) return;

			if (!itemstack.isEmpty() || creativeMode) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(TechnologicaItems.COCONUT.get());
				}
				
				if (remainingProjectiles > 0) {
					spacingTimer = 15;
					if (!creativeMode) {
						itemstack.shrink(remainingProjectiles);
						if (itemstack.isEmpty()) {
							playerentity.inventory.removeItem(itemstack);
						}
						itemStackIn.hurtAndBreak(1, playerentity, (player) -> {
							player.broadcastBreakEvent(playerentity.getUsedItemHand());
						});
					}
					playerentity.awardStat(Stats.ITEM_USED.get(this));
				}	
			}
		}
	}

	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (spacingTimer > 0) {
			if (!worldIn.isClientSide && entityIn instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) entityIn;
				
				if (spacingTimer % 5 == 0 && remainingProjectiles > 0) {
					CoconutEntity coconutEntity = new CoconutEntity(worldIn, player);
					coconutEntity.setItem(new ItemStack(TechnologicaItems.COCONUT.get()));
					coconutEntity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 3.0F, 1.0F);
					worldIn.addFreshEntity(coconutEntity);
					worldIn.playSound((PlayerEntity) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F);
					--remainingProjectiles;
				}
				--spacingTimer;	
			}
		}
	}
	
	
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		boolean creativeMode = playerIn.abilities.instabuild;
		boolean flag;
		
		if (creativeMode) {
			flag = true; 
		} else {
			ItemStack itemstack2 = ItemStack.EMPTY;
			for(int i = 0; i < playerIn.inventory.getContainerSize(); ++i) {
            	ItemStack testStack = playerIn.inventory.getItem(i);
            	if (testStack.getItem() == TechnologicaItems.COCONUT.get()) {
            		itemstack2 = testStack;
            	}
            }
			flag = !itemstack2.isEmpty();
		}
		
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.abilities.instabuild && !flag) {
			return ActionResult.fail(itemstack);
		} else {
			playerIn.startUsingItem(handIn);
			return ActionResult.consume(itemstack);
		}
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return null;
	}
}
