package com.technologica.world.entity.animal;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class GrizzlyBear extends PolarBear implements NeutralMob {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.SALMON);
	private static final EntityDataAccessor<Boolean> IS_STANDING = SynchedEntityData.defineId(GrizzlyBear.class, EntityDataSerializers.BOOLEAN);
	private float clientSideStandAnimation0;
	private float clientSideStandAnimation;
	private int warningSoundTicks;
	private static final UniformInt angerTimeRange = TimeUtil.rangeOfSeconds(20, 39);
	private int angerTime;
	private UUID angerTarget;

	public GrizzlyBear(EntityType<GrizzlyBear> type, Level worldIn) {
		super(type, worldIn);
	}

	// Spawning
	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorldIn, AgeableMob mate) {
		return TechnologicaEntityTypes.GRIZZLY_BEAR.get().create(serverWorldIn);
	}

	// Breeding
	@Override
	public boolean isFood(ItemStack stack) {
		return false;
	}

	// Register Attributes, Goals, and Data
	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new GrizzlyBear.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new GrizzlyBear.PanicGoal());
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Bee.class, 8.0F, 1.5D, 1.5D));
		this.targetSelector.addGoal(1, new GrizzlyBear.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new GrizzlyBear.AttackPlayerGoal());
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Salmon.class, 10, true, true, (Predicate<LivingEntity>) null));
		this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_STANDING, false);
	}

	// Anger
	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(angerTimeRange.sample(this.random));
	}

	@Override
	public void setRemainingPersistentAngerTime(int time) {
		this.angerTime = time;
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.angerTime;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID target) {
		this.angerTarget = target;
	}

	@Override
	public UUID getPersistentAngerTarget() {
		return this.angerTarget;
	}

	// Audio
	@Override
	protected SoundEvent getAmbientSound() {
		return this.isBaby() ? SoundEvents.POLAR_BEAR_AMBIENT_BABY : SoundEvents.POLAR_BEAR_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.POLAR_BEAR_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.POLAR_BEAR_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
	}

	@Override
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundEvents.POLAR_BEAR_WARNING, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide) {
			if (this.clientSideStandAnimation != this.clientSideStandAnimation0) {
				this.refreshDimensions();
			}

			this.clientSideStandAnimation0 = this.clientSideStandAnimation;
			if (this.isStanding()) {
				this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
			} else {
				this.clientSideStandAnimation = Mth.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
			}
		}

		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}

		if (!this.level().isClientSide) {
			this.updatePersistentAnger((ServerLevel) this.level(), true);
		}

	}

	@Override
	public EntityDimensions getDimensions(Pose poseIn) {
		if (this.clientSideStandAnimation > 0.0F) {
			float f = this.clientSideStandAnimation / 6.0F;
			float f1 = 1.0F + f;
			return super.getDimensions(poseIn).scale(1.0F, f1);
		} else {
			return super.getDimensions(poseIn);
		}
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		boolean flag = entityIn.hurt(this.damageSources().mobAttack(this), ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}

	@Override
	public boolean isStanding() {
		return this.entityData.get(IS_STANDING);
	}

	@Override
	public void setStanding(boolean standing) {
		this.entityData.set(IS_STANDING, standing);
	}

	@Override
	protected float getWaterSlowDown() {
		return 0.98F;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		if (spawnDataIn == null) {
			spawnDataIn = new AgeableMob.AgeableMobGroupData(1.0F);
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(GrizzlyBear.this, Player.class, 20, true, true, (Predicate<LivingEntity>) null);
		}

		@Override
		public boolean canUse() {
			if (GrizzlyBear.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (GrizzlyBear grizzlybearentity : GrizzlyBear.this.level().getEntitiesOfClass(GrizzlyBear.class, GrizzlyBear.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (grizzlybearentity.isBaby()) {
							return true;
						}
					}
				}

				return false;
			}
		}

		@Override
		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(GrizzlyBear.this);
		}

		@Override
		public void start() {
			super.start();
			if (GrizzlyBear.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		@Override
		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof GrizzlyBear && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(GrizzlyBear.this, 1.25D, true);
		}

		@Override
		protected void checkAndPerformAttack(LivingEntity enemy, double p_29590_) {
			double d0 = this.getAttackReachSqr(enemy);
			if (p_29590_ <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
				GrizzlyBear.this.setStanding(false);
			} else if (this.mob.distanceToSqr(enemy) < (enemy.getBbWidth() + 3.0F) * (enemy.getBbWidth() + 3.0F)) {
				if (this.isTimeToAttack()) {
					GrizzlyBear.this.setStanding(false);
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					GrizzlyBear.this.setStanding(true);
					GrizzlyBear.this.playWarningSound();
				}
			} else {
				this.resetAttackCooldown();
				GrizzlyBear.this.setStanding(false);
			}

		}

		@Override
		public void stop() {
			GrizzlyBear.this.setStanding(false);
			super.stop();
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(GrizzlyBear.this, 2.0D);
		}

		@Override
		public boolean canUse() {
			return (GrizzlyBear.this.isBaby() || GrizzlyBear.this.isOnFire()) && super.canUse();
		}
	}

	// NBT
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.readPersistentAngerSaveData(this.level(), compound);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		this.addPersistentAngerSaveData(compound);
	}
}
