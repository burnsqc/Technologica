package com.technologica.entity.passive;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.technologica.entity.TechnologicaEntityType;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.ResetAngerGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.TickRangeConverter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class GrizzlyBearEntity extends PolarBearEntity implements IAngerable {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.SALMON);
	private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.defineId(GrizzlyBearEntity.class, DataSerializers.BOOLEAN);
	private float clientSideStandAnimation0;
	private float clientSideStandAnimation;
	private int warningSoundTicks;
	private static final RangedInteger angerTimeRange = TickRangeConverter.rangeOfSeconds(20, 39);
	private int angerTime;
	private UUID angerTarget;

	public GrizzlyBearEntity(EntityType<GrizzlyBearEntity> type, World worldIn) {
		super(type, worldIn);
	}

	//Spawning
	@Override
   public AgeableEntity getBreedOffspring(ServerWorld serverWorldIn, AgeableEntity mate) {
		return TechnologicaEntityType.GRIZZLY_BEAR.get().create(serverWorldIn);
	}

	//Breeding
	@Override
   public boolean isFood(ItemStack stack) {
		return false;
	}

	//Register Attributes, Goals, and Data
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D);
	}
   
	@Override
   protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new GrizzlyBearEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new GrizzlyBearEntity.PanicGoal());
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, BeeEntity.class, 8.0F, 1.5D, 1.5D));
		this.targetSelector.addGoal(1, new GrizzlyBearEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new GrizzlyBearEntity.AttackPlayerGoal());
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, 10, true, true, (Predicate<LivingEntity>)null));
		this.targetSelector.addGoal(5, new ResetAngerGoal<>(this, false));
	}
	
	@Override
   protected void defineSynchedData() {
		super.defineSynchedData();
	    this.entityData.define(IS_STANDING, false);
	}
   
   	//Anger
   	@Override
      public void startPersistentAngerTimer() {
   		this.setRemainingPersistentAngerTime(angerTimeRange.randomValue(this.random));
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

   	//Audio
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
      if (this.level.isClientSide) {
         if (this.clientSideStandAnimation != this.clientSideStandAnimation0) {
            this.refreshDimensions();
         }

         this.clientSideStandAnimation0 = this.clientSideStandAnimation;
         if (this.isStanding()) {
            this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
         } else {
            this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
         }
      }

      if (this.warningSoundTicks > 0) {
         --this.warningSoundTicks;
      }

      if (!this.level.isClientSide) {
         this.updatePersistentAnger((ServerWorld)this.level, true);
      }

   }

   @Override
   public EntitySize getDimensions(Pose poseIn) {
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
      boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
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
   public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (spawnDataIn == null) {
         spawnDataIn = new AgeableEntity.AgeableData(1.0F);
      }
      return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
      public AttackPlayerGoal() {
         super(GrizzlyBearEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
      }

      @Override
      public boolean canUse() {
         if (GrizzlyBearEntity.this.isBaby()) {
            return false;
         } else {
            if (super.canUse()) {
               for(GrizzlyBearEntity grizzlybearentity : GrizzlyBearEntity.this.level.getEntitiesOfClass(GrizzlyBearEntity.class, GrizzlyBearEntity.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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

   class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
      public HurtByTargetGoal() {
         super(GrizzlyBearEntity.this);
      }

      @Override
      public void start() {
         super.start();
         if (GrizzlyBearEntity.this.isBaby()) {
            this.alertOthers();
            this.stop();
         }

      }

      @Override
      protected void alertOther(MobEntity mobIn, LivingEntity targetIn) {
         if (mobIn instanceof GrizzlyBearEntity && !mobIn.isBaby()) {
            super.alertOther(mobIn, targetIn);
         }

      }
   }

   class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
      public MeleeAttackGoal() {
         super(GrizzlyBearEntity.this, 1.25D, true);
      }

      @Override
      protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
         double d0 = this.getAttackReachSqr(enemy);
         if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
            this.resetAttackCooldown();
            this.mob.doHurtTarget(enemy);
            GrizzlyBearEntity.this.setStanding(false);
         } else if (distToEnemySqr <= d0 * 2.0D) {
            if (this.isTimeToAttack()) {
               GrizzlyBearEntity.this.setStanding(false);
               this.resetAttackCooldown();
            }

            if (this.getTicksUntilNextAttack() <= 10) {
               GrizzlyBearEntity.this.setStanding(true);
               GrizzlyBearEntity.this.playWarningSound();
            }
         } else {
            this.resetAttackCooldown();
            GrizzlyBearEntity.this.setStanding(false);
         }

      }

      @Override
      public void stop() {
         GrizzlyBearEntity.this.setStanding(false);
         super.stop();
      }

      @Override
      protected double getAttackReachSqr(LivingEntity attackTarget) {
         return (double)(4.0F + attackTarget.getBbWidth());
      }
   }

   class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
      public PanicGoal() {
         super(GrizzlyBearEntity.this, 2.0D);
      }

      @Override
      public boolean canUse() {
         return (GrizzlyBearEntity.this.isBaby() || GrizzlyBearEntity.this.isOnFire()) && super.canUse();
      }
   }
   
   	//NBT
   	@Override
      public void readAdditionalSaveData(CompoundNBT compound) {
   		super.readAdditionalSaveData(compound);
   		this.readPersistentAngerSaveData((ServerWorld)this.level, compound);
   	}

   	@Override
      public void addAdditionalSaveData(CompoundNBT compound) {
   		super.addAdditionalSaveData(compound);
   		this.addPersistentAngerSaveData(compound);
   	}
}
