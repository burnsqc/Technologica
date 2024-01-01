package com.technologica.world.item;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.technologica.client.renderer.blockentity.CoconutBazookaRenderer;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.projectile.Coconut;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class CoconutBazookaItem extends ProjectileWeaponItem implements Vanishable {
	private int remainingProjectiles = 0;
	private int spacingTimer = 0;

	public CoconutBazookaItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public void releaseUsing(ItemStack itemStackIn, Level worldIn, LivingEntity livingEntityIn, int timeLeftIn) {
		if (livingEntityIn instanceof Player) {
			Player playerentity = (Player) livingEntityIn;
			boolean creativeMode = playerentity.getAbilities().instabuild;
			ItemStack itemstack;

			if (creativeMode) {
				itemstack = new ItemStack(TechnologicaItems.COCONUT.get());
			} else {
				itemstack = ItemStack.EMPTY;
				for (int i = 0; i < playerentity.getInventory().getContainerSize(); ++i) {
					ItemStack testStack = playerentity.getInventory().getItem(i);
					if (testStack.getItem() == TechnologicaItems.COCONUT.get()) {
						itemstack = testStack;
					}
				}
			}

			int i = this.getUseDuration(itemStackIn) - timeLeftIn;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(itemStackIn, worldIn, playerentity, i, !itemstack.isEmpty() || creativeMode);

			remainingProjectiles = Math.min(i, 30) / 10;

			if (i < 0)
				return;

			if (!itemstack.isEmpty() || creativeMode) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(TechnologicaItems.COCONUT.get());
				}

				if (remainingProjectiles > 0) {
					spacingTimer = 15;
					if (!creativeMode) {
						itemstack.shrink(remainingProjectiles);
						if (itemstack.isEmpty()) {
							playerentity.getInventory().removeItem(itemstack);
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
	public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (spacingTimer > 0) {
			if (!worldIn.isClientSide && entityIn instanceof Player) {
				Player player = (Player) entityIn;

				if (spacingTimer % 5 == 0 && remainingProjectiles > 0) {
					Coconut coconutEntity = new Coconut(worldIn, player);
					coconutEntity.setItem(new ItemStack(TechnologicaItems.COCONUT.get()));
					coconutEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
					worldIn.addFreshEntity(coconutEntity);
					worldIn.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (worldIn.random.nextFloat() * 0.4F + 1.2F) + 0.5F);
					--remainingProjectiles;
				}
				--spacingTimer;
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		boolean creativeMode = playerIn.getAbilities().instabuild;
		boolean flag;

		if (creativeMode) {
			flag = true;
		} else {
			ItemStack itemstack2 = ItemStack.EMPTY;
			for (int i = 0; i < playerIn.getInventory().getContainerSize(); ++i) {
				ItemStack testStack = playerIn.getInventory().getItem(i);
				if (testStack.getItem() == TechnologicaItems.COCONUT.get()) {
					itemstack2 = testStack;
				}
			}
			flag = !itemstack2.isEmpty();
		}

		InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		if (ret != null)
			return ret;

		if (!playerIn.getAbilities().instabuild && !flag) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			playerIn.startUsingItem(handIn);
			return InteractionResultHolder.consume(itemstack);
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

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return new CoconutBazookaRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
			}
		});
	}
}
