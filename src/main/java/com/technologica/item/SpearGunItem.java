package com.technologica.item;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.technologica.client.renderer.tileentity.SpearGunItemStackTileEntityRenderer;
import com.technologica.entity.projectile.HarpoonEntity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SpearGunItem extends ShootableItem implements IVanishable {
	private boolean isLoadingStart = false;
	private boolean isLoadingMiddle = false;

	public SpearGunItem(Item.Properties propertiesIn) {
		super(propertiesIn.setISTER(() -> SpearGunItemStackTileEntityRenderer::new));
	}

	@Override
	public Predicate<ItemStack> getAmmoPredicate() {
		return (stack) -> {
			return stack.getItem() == TechnologicaItems.HARPOON.get();
		};
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return (stack) -> {
			return stack.getItem() == TechnologicaItems.HARPOON.get();
		};
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack spearGunStack = playerIn.getHeldItem(handIn);
		if (isCharged(spearGunStack)) {
			fireProjectiles(worldIn, playerIn, handIn, spearGunStack, setVelocity(spearGunStack, playerIn), 1.0F);
			setCharged(spearGunStack, false);
			return ActionResult.resultConsume(spearGunStack);
		} else if (!playerIn.findAmmo(spearGunStack).isEmpty()) {
			if (!isCharged(spearGunStack)) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				playerIn.setActiveHand(handIn);
			}
			return ActionResult.resultConsume(spearGunStack);
		} else {
			return ActionResult.resultFail(spearGunStack);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStackIn, World worldIn, LivingEntity entityLiving, int timeLeft) {
		int i = this.getUseDuration(itemStackIn) - timeLeft;
		float f = getCharge(i, itemStackIn);
		if (f >= 1.0F && !isCharged(itemStackIn) && hasAmmo(entityLiving, itemStackIn)) {
			setCharged(itemStackIn, true);
			SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
			worldIn.playSound((PlayerEntity) null, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
		}
	}

	private static boolean hasAmmo(LivingEntity entityIn, ItemStack stack) {
		int i = 0;
		int j = i == 0 ? 1 : 3;
		boolean flag = entityIn instanceof PlayerEntity && ((PlayerEntity) entityIn).abilities.isCreativeMode;
		ItemStack itemstack = entityIn.findAmmo(stack);
		ItemStack itemstack1 = itemstack.copy();

		for (int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}

			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(TechnologicaItems.HARPOON.get());
				itemstack1 = itemstack.copy();
			}

			if (!func_220023_a(entityIn, stack, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	private static boolean func_220023_a(LivingEntity livingEntityIn, ItemStack spearGunStackIn, ItemStack harpoonStackIn, boolean p_220023_3_, boolean p_220023_4_) {
		if (harpoonStackIn.isEmpty()) {
			return false;
		} else {
			boolean flag = p_220023_4_ && harpoonStackIn.getItem() == TechnologicaItems.HARPOON.get();
			ItemStack itemstack;
			if (!flag && !p_220023_4_ && !p_220023_3_) {
				itemstack = harpoonStackIn.split(1);
				if (harpoonStackIn.isEmpty() && livingEntityIn instanceof PlayerEntity) {
					((PlayerEntity) livingEntityIn).inventory.deleteStack(harpoonStackIn);
				}
			} else {
				itemstack = harpoonStackIn.copy();
			}
			addChargedProjectile(spearGunStackIn, itemstack);
			return true;
		}
	}

	public static boolean isCharged(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("Charged");
	}

	public static void setCharged(ItemStack stack, boolean chargedIn) {
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("Charged", chargedIn);
	}

	private static void addChargedProjectile(ItemStack spearGunStackIn, ItemStack harpoonStackIn) {
		CompoundNBT compoundnbt = spearGunStackIn.getOrCreateTag();
		ListNBT listnbt;
		if (compoundnbt.contains("ChargedProjectiles", 9)) {
			listnbt = compoundnbt.getList("ChargedProjectiles", 10);
		} else {
			listnbt = new ListNBT();
		}
		CompoundNBT compoundnbt1 = new CompoundNBT();
		harpoonStackIn.write(compoundnbt1);
		listnbt.add(compoundnbt1);
		compoundnbt.put("ChargedProjectiles", listnbt);
	}

	private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
		List<ItemStack> list = Lists.newArrayList();
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9)) {
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			if (listnbt != null) {
				for (int i = 0; i < listnbt.size(); ++i) {
					CompoundNBT compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.read(compoundnbt1));
				}
			}
		}
		return list;
	}

	private static void clearProjectiles(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null) {
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 9);
			listnbt.clear();
			compoundnbt.put("ChargedProjectiles", listnbt);
		}
	}

	public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
			return p_220010_1_.getItem() == ammoItem;
		});
	}

	private static void fireProjectile(World worldIn, LivingEntity livingEntityIn, Hand handIn, ItemStack spearGunStackIn, ItemStack harpoonStackIn, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle) {
		if (!worldIn.isRemote) {
			
			HarpoonEntity harpoonEntity = new HarpoonEntity(worldIn, livingEntityIn);
			harpoonEntity.setDirectionAndMovement(livingEntityIn, livingEntityIn.rotationPitch, livingEntityIn.rotationYaw, 0.0F, velocity, 1.0F);

			if (livingEntityIn instanceof ICrossbowUser) {
				ICrossbowUser icrossbowuser = (ICrossbowUser) livingEntityIn;
				icrossbowuser.fireProjectile(icrossbowuser.getAttackTarget(), spearGunStackIn, harpoonEntity, projectileAngle);
			} else {
				Vector3d vector3d1 = livingEntityIn.getUpVector(1.0F);
				Quaternion quaternion = new Quaternion(new Vector3f(vector3d1), projectileAngle, true);
				Vector3d vector3d = livingEntityIn.getLook(1.0F);
				Vector3f vector3f = new Vector3f(vector3d);
				vector3f.transform(quaternion);
				harpoonEntity.shoot((double) vector3f.getX(), (double) vector3f.getY(), (double) vector3f.getZ(), velocity, inaccuracy);
			}

			spearGunStackIn.damageItem(1, livingEntityIn, (p_220017_1_) -> {
				p_220017_1_.sendBreakAnimation(handIn);
			});
			
			worldIn.addEntity(harpoonEntity);
			worldIn.playSound((PlayerEntity) null, livingEntityIn.getPosX(), livingEntityIn.getPosY(), livingEntityIn.getPosZ(),
					SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
		}
	}

	private static AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter, ItemStack crossbow, ItemStack ammo) {
		ArrowItem arrowitem = (ArrowItem) (ammo.getItem() instanceof ArrowItem ? ammo.getItem() : Items.ARROW);
		AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, ammo, shooter);
		if (shooter instanceof PlayerEntity) {
			abstractarrowentity.setIsCritical(true);
		}

		abstractarrowentity.setHitSound(SoundEvents.ITEM_CROSSBOW_HIT);
		abstractarrowentity.setShotFromCrossbow(true);
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, crossbow);
		if (i > 0) {
			abstractarrowentity.setPierceLevel((byte) i);
		}

		return abstractarrowentity;
	}

	public static void fireProjectiles(World worldIn, LivingEntity shooter, Hand handIn, ItemStack stack, float velocityIn, float inaccuracyIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		float[] afloat = getRandomSoundPitches(shooter.getRNG());

		for (int i = 0; i < list.size(); ++i) {
			ItemStack itemstack = list.get(i);
			boolean flag = shooter instanceof PlayerEntity && ((PlayerEntity) shooter).abilities.isCreativeMode;
			if (!itemstack.isEmpty()) {
				if (i == 0) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 0.0F);
				} else if (i == 1) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, -10.0F);
				} else if (i == 2) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn, inaccuracyIn, 10.0F);
				}
			}
		}

		fireProjectilesAfter(worldIn, shooter, stack);
	}

	private static float[] getRandomSoundPitches(Random rand) {
		boolean flag = rand.nextBoolean();
		return new float[] { 1.0F, getRandomSoundPitch(flag), getRandomSoundPitch(!flag) };
	}

	private static float getRandomSoundPitch(boolean flagIn) {
		float f = flagIn ? 0.63F : 0.43F;
		return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
	}

	private static void fireProjectilesAfter(World worldIn, LivingEntity shooter, ItemStack stack) {
		if (shooter instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) shooter;
			if (!worldIn.isRemote) {
				CriteriaTriggers.SHOT_CROSSBOW.test(serverplayerentity, stack);
			}
			serverplayerentity.addStat(Stats.ITEM_USED.get(stack.getItem()));
		}
		clearProjectiles(stack);
	}

	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (!worldIn.isRemote) {
			int i = 0;
			SoundEvent soundevent = this.getSoundEvent();
			SoundEvent soundevent1 = i == 0 ? SoundEvents.ITEM_CROSSBOW_LOADING_MIDDLE : null;
			float f = (float) (stack.getUseDuration() - count) / (float) getChargeTime(stack);
			if (f < 0.2F) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
			}
			if (f >= 0.2F && !this.isLoadingStart) {
				this.isLoadingStart = true;
				worldIn.playSound((PlayerEntity) null, livingEntityIn.getPosX(), livingEntityIn.getPosY(), livingEntityIn.getPosZ(), soundevent, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}
			if (f >= 0.5F && soundevent1 != null && !this.isLoadingMiddle) {
				this.isLoadingMiddle = true;
				worldIn.playSound((PlayerEntity) null, livingEntityIn.getPosX(), livingEntityIn.getPosY(), livingEntityIn.getPosZ(), soundevent1, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}
		}
	}
	

	@Override
	public int getUseDuration(ItemStack stack) {
		return getChargeTime(stack) + 3;
	}
	

	public static int getChargeTime(ItemStack stack) {
		return 25;
	}
	

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.CROSSBOW;
	}

	private SoundEvent getSoundEvent() {
		return SoundEvents.ITEM_CROSSBOW_LOADING_START;
	}

	private static float getCharge(int useTime, ItemStack stack) {
		float f = (float) useTime / (float) getChargeTime(stack);
		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		if (isCharged(stack) && !list.isEmpty()) {
			ItemStack itemstack = list.get(0);
			tooltip.add((new TranslationTextComponent("item.minecraft.crossbow.projectile")).appendString(" ").appendSibling(itemstack.getTextComponent()));
		}
	}

	private static float setVelocity(ItemStack itemStackIn, PlayerEntity playerIn) {
		return hasChargedProjectile(itemStackIn, TechnologicaItems.HARPOON.get()) && playerIn.isInWater() ? 3.0F : 0.5F;
	}

	public int func_230305_d_() {
		return 8;
	}
	
	@Override
	public boolean isCrossbow(ItemStack stack) {
	      return true;
	   }
}