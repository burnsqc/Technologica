package com.technologica.world.item;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.google.common.collect.Lists;
import com.technologica.client.renderer.blockentity.SpearGunRenderer;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.projectile.Harpoon;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ForgeMod;

public class SpearGunItem extends ProjectileWeaponItem implements Vanishable {
	private boolean isLoadingStart = false;
	private boolean isLoadingMiddle = false;

	public SpearGunItem(Item.Properties propertiesIn) {
		super(propertiesIn);
	}

	@Override
	public Predicate<ItemStack> getSupportedHeldProjectiles() {
		return (stack) -> {
			return stack.getItem() == TechnologicaItems.HARPOON.get();
		};
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return (stack) -> {
			return stack.getItem() == TechnologicaItems.HARPOON.get();
		};
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack spearGunStack = playerIn.getItemInHand(handIn);
		if (isCharged(spearGunStack)) {
			fireProjectiles(worldIn, playerIn, handIn, spearGunStack, setVelocity(spearGunStack, playerIn), 1.0F);
			setCharged(spearGunStack, false);
			return InteractionResultHolder.consume(spearGunStack);
		} else if (!playerIn.getProjectile(spearGunStack).isEmpty()) {
			if (!isCharged(spearGunStack)) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				playerIn.startUsingItem(handIn);
			}
			return InteractionResultHolder.consume(spearGunStack);
		} else {
			return InteractionResultHolder.fail(spearGunStack);
		}
	}

	@Override
	public void releaseUsing(ItemStack itemStackIn, Level worldIn, LivingEntity entityLiving, int timeLeft) {
		int i = this.getUseDuration(itemStackIn) - timeLeft;
		float f = getCharge(i, itemStackIn);
		if (f >= 1.0F && !isCharged(itemStackIn) && hasAmmo(entityLiving, itemStackIn)) {
			setCharged(itemStackIn, true);
			SoundSource soundcategory = entityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
			worldIn.playSound((Player) null, entityLiving.getX(), entityLiving.getY(), entityLiving.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundcategory, 1.0F, 1.0F / (worldIn.random.nextFloat() * 0.5F + 1.0F) + 0.2F);
		}
	}

	private static boolean hasAmmo(LivingEntity entityIn, ItemStack stack) {
		int i = 0;
		int j = i == 0 ? 1 : 3;
		boolean flag = entityIn instanceof Player && ((Player) entityIn).getAbilities().instabuild;
		ItemStack itemstack = entityIn.getProjectile(stack);
		ItemStack itemstack1 = itemstack.copy();

		for (int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}

			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(TechnologicaItems.HARPOON.get());
				itemstack1 = itemstack.copy();
			}

			if (!loadProjectile(entityIn, stack, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	private static boolean loadProjectile(LivingEntity livingEntityIn, ItemStack spearGunStackIn, ItemStack harpoonStackIn, boolean p_220023_3_, boolean p_220023_4_) {
		if (harpoonStackIn.isEmpty()) {
			return false;
		} else {
			boolean flag = p_220023_4_ && harpoonStackIn.getItem() == TechnologicaItems.HARPOON.get();
			ItemStack itemstack;
			if (!flag && !p_220023_4_ && !p_220023_3_) {
				itemstack = harpoonStackIn.split(1);
				if (harpoonStackIn.isEmpty() && livingEntityIn instanceof Player) {
					((Player) livingEntityIn).getInventory().removeItem(harpoonStackIn);
				}
			} else {
				itemstack = harpoonStackIn.copy();
			}
			addChargedProjectile(spearGunStackIn, itemstack);
			return true;
		}
	}

	public static boolean isCharged(ItemStack stack) {
		CompoundTag compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("Charged");
	}

	public static void setCharged(ItemStack stack, boolean chargedIn) {
		CompoundTag compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("Charged", chargedIn);
	}

	private static void addChargedProjectile(ItemStack spearGunStackIn, ItemStack harpoonStackIn) {
		CompoundTag compoundnbt = spearGunStackIn.getOrCreateTag();
		ListTag listnbt;
		if (compoundnbt.contains("ChargedProjectiles", 9)) {
			listnbt = compoundnbt.getList("ChargedProjectiles", 10);
		} else {
			listnbt = new ListTag();
		}
		CompoundTag compoundnbt1 = new CompoundTag();
		harpoonStackIn.save(compoundnbt1);
		listnbt.add(compoundnbt1);
		compoundnbt.put("ChargedProjectiles", listnbt);
	}

	private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
		List<ItemStack> list = Lists.newArrayList();
		CompoundTag compoundnbt = stack.getTag();
		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9)) {
			ListTag listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			if (listnbt != null) {
				for (int i = 0; i < listnbt.size(); ++i) {
					CompoundTag compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.of(compoundnbt1));
				}
			}
		}
		return list;
	}

	private static void clearProjectiles(ItemStack stack) {
		CompoundTag compoundnbt = stack.getTag();
		if (compoundnbt != null) {
			ListTag listnbt = compoundnbt.getList("ChargedProjectiles", 9);
			listnbt.clear();
			compoundnbt.put("ChargedProjectiles", listnbt);
		}
	}

	public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
			return p_220010_1_.getItem() == ammoItem;
		});
	}

	private static void fireProjectile(Level worldIn, LivingEntity livingEntityIn, InteractionHand handIn, ItemStack spearGunStackIn, ItemStack harpoonStackIn, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy, float projectileAngle) {
		if (!worldIn.isClientSide) {

			Harpoon harpoonEntity = new Harpoon(worldIn, livingEntityIn);
			harpoonEntity.shootFromRotation(livingEntityIn, livingEntityIn.getXRot(), livingEntityIn.getYRot(), 0.0F, velocity, 1.0F);

			if (livingEntityIn instanceof CrossbowAttackMob) {
				CrossbowAttackMob icrossbowuser = (CrossbowAttackMob) livingEntityIn;
				icrossbowuser.shootCrossbowProjectile(icrossbowuser.getTarget(), spearGunStackIn, harpoonEntity, projectileAngle);
			} else {
				Vec3 vec31 = livingEntityIn.getUpVector(1.0F);
				Quaternionf quaternionf = (new Quaternionf()).setAngleAxis(projectileAngle * ((float) Math.PI / 180F), vec31.x, vec31.y, vec31.z);
				Vec3 vec3 = livingEntityIn.getViewVector(1.0F);
				Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
				harpoonEntity.shoot(vector3f.x(), vector3f.y(), vector3f.z(), velocity, inaccuracy);
			}

			spearGunStackIn.hurtAndBreak(1, livingEntityIn, (p_220017_1_) -> {
				p_220017_1_.broadcastBreakEvent(handIn);
			});

			worldIn.addFreshEntity(harpoonEntity);
			worldIn.playSound((Player) null, livingEntityIn.getX(), livingEntityIn.getY(), livingEntityIn.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 1.0F, soundPitch);
		}
	}

	public static void fireProjectiles(Level worldIn, LivingEntity shooter, InteractionHand handIn, ItemStack stack, float velocityIn, float inaccuracyIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		float[] afloat = getRandomSoundPitches(shooter.getRandom());

		for (int i = 0; i < list.size(); ++i) {
			ItemStack itemstack = list.get(i);
			boolean flag = shooter instanceof Player && ((Player) shooter).getAbilities().instabuild;
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

	private static float[] getRandomSoundPitches(RandomSource randomSource) {
		boolean flag = randomSource.nextBoolean();
		return new float[] { 1.0F, getRandomSoundPitch(flag, randomSource), getRandomSoundPitch(!flag, randomSource) };
	}

	private static float getRandomSoundPitch(boolean flagIn, RandomSource randomSource) {
		float f = flagIn ? 0.63F : 0.43F;
		return 1.0F / (randomSource.nextFloat() * 0.5F + 1.8F) + f;
	}

	private static void fireProjectilesAfter(Level worldIn, LivingEntity shooter, ItemStack stack) {
		if (shooter instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) shooter;
			if (!worldIn.isClientSide) {
				CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayerentity, stack);
			}
			serverplayerentity.awardStat(Stats.ITEM_USED.get(stack.getItem()));
		}
		clearProjectiles(stack);
	}

	@Override
	public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (!worldIn.isClientSide) {
			int i = 0;
			SoundEvent soundevent = this.getSoundEvent();
			SoundEvent soundevent1 = i == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
			float f = (float) (stack.getUseDuration() - count) / (float) getChargeTime(stack);
			if (f < 0.2F) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
			}
			if (f >= 0.2F && !this.isLoadingStart) {
				this.isLoadingStart = true;
				worldIn.playSound((Player) null, livingEntityIn.getX(), livingEntityIn.getY(), livingEntityIn.getZ(), soundevent, SoundSource.PLAYERS, 0.5F, 1.0F);
			}
			if (f >= 0.5F && soundevent1 != null && !this.isLoadingMiddle) {
				this.isLoadingMiddle = true;
				worldIn.playSound((Player) null, livingEntityIn.getX(), livingEntityIn.getY(), livingEntityIn.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
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
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.CROSSBOW;
	}

	private SoundEvent getSoundEvent() {
		return SoundEvents.CROSSBOW_LOADING_START;
	}

	private static float getCharge(int useTime, ItemStack stack) {
		float f = (float) useTime / (float) getChargeTime(stack);
		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		if (isCharged(stack) && !list.isEmpty()) {
			ItemStack itemstack = list.get(0);
			tooltip.add((Component.literal("item.minecraft.crossbow.projectile")).append(" ").append(itemstack.getDisplayName()));
		}
	}

	private static float setVelocity(ItemStack itemStackIn, Player playerIn) {
		return (hasChargedProjectile(itemStackIn, TechnologicaItems.HARPOON.get()) || playerIn.getAbilities().instabuild) && playerIn.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) ? 3.0F : 0.5F;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 8;
	}

	@Override
	public boolean useOnRelease(ItemStack stack) {
		return true;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return new SpearGunRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
			}
		});
	}
}