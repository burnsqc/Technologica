package com.technologica.world.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.technologica.world.entity.projectile.ThrownSpear;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SpearItem extends Item implements Vanishable {
	public static final int THROW_THRESHOLD_TIME = 10;
	public static final float BASE_DAMAGE = 8.0F;
	public static final float SHOOT_POWER = 2.5F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public SpearItem(Item.Properties pProperties) {
		super(pProperties);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 8.0D, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.9F, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
		return !pPlayer.isCreative();
	}

	@Override
	public UseAnim getUseAnimation(ItemStack pStack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack pStack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
		if (pEntityLiving instanceof Player player) {
			int i = this.getUseDuration(pStack) - pTimeLeft;
			if (i >= 10) {
				if (!pLevel.isClientSide) {
					pStack.hurtAndBreak(1, player, (p_43388_) -> {
						p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
					});

					ThrownSpear throwntrident = new ThrownSpear(pLevel, player, pStack);
					throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
					if (player.getAbilities().instabuild) {
						throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					}

					pLevel.addFreshEntity(throwntrident);
					pLevel.playSound((Player) null, throwntrident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
					if (!player.getAbilities().instabuild) {
						player.getInventory().removeItem(pStack);
					}
				}
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}
	}

	/**
	 * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}.
	 */
	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pHand);
		if (itemstack.getDamageValue() >= itemstack.getMaxDamage() - 1) {
			return InteractionResultHolder.fail(itemstack);
		} else if (EnchantmentHelper.getRiptide(itemstack) > 0 && !pPlayer.isInWaterOrRain()) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			pPlayer.startUsingItem(pHand);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		pStack.hurtAndBreak(1, pAttacker, (p_43414_) -> {
			p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		return true;
	}

	/**
	 * Called when a {@link net.minecraft.world.level.block.Block} is destroyed using this Item. Return {@code true} to trigger the "Use Item" statistic.
	 */
	@Override
	public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
		if (pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
			pStack.hurtAndBreak(2, pEntityLiving, (p_43385_) -> {
				p_43385_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
			});
		}

		return true;
	}

	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 */
	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
		return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}
}