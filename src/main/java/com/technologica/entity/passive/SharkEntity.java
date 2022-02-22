package com.technologica.entity.passive;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.DolphinLookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.ai.goal.FollowBoatGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.TickRangeConverter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class SharkEntity extends WaterMobEntity implements IAngerable {
   private static final DataParameter<Integer> MOISTNESS = EntityDataManager.defineId(SharkEntity.class, DataSerializers.INT);
   public static final Predicate<ItemEntity> ITEM_SELECTOR = p_205023_0_ -> !p_205023_0_.hasPickUpDelay() && p_205023_0_.isAlive() && p_205023_0_.isInWater();
   private static final RangedInteger angerTimeRange = TickRangeConverter.rangeOfSeconds(20, 39);
   private int angerTime;
   private UUID angerTarget;

   public SharkEntity(EntityType<? extends SharkEntity> type, World worldIN) {
      super(type, worldIN);
      this.moveControl = new SharkEntity.MoveHelperController(this);
      this.lookControl = new DolphinLookController(this, 10);
      this.setCanPickUpLoot(true);
   }

   @Override
   @Nullable
   public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      this.xRot = 0.0F;
      return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Override
   public boolean canBreatheUnderwater() {
      return true;
   }

   public int getMoistness() {
      return this.entityData.get(MOISTNESS);
   }

   public void setMoistness(int p_211137_1_) {
      this.entityData.set(MOISTNESS, p_211137_1_);
   }

   //Register Attributes, Goals, and Data
   public static AttributeModifierMap.MutableAttribute registerAttributes() {
      return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, (double) 1.0F).add(Attributes.ATTACK_DAMAGE, 10.0D);
   }

   @Override
   protected void registerGoals() {
      this.goalSelector.addGoal(0, new FindWaterGoal(this));
      this.goalSelector.addGoal(1, new SharkEntity.AttackGoal());
      this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
      this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new FollowBoatGoal(this));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, GuardianEntity.class)).setAlertOthers());
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, 10, true, true, (Predicate<LivingEntity>) null));
   }

   @Override
   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(MOISTNESS, 2400);
   }

   @Override
   protected PathNavigator createNavigation(World worldIn) {
      return new SwimmerPathNavigator(this, worldIn);
   }

   @Override
   public boolean doHurtTarget(Entity entityIn) {
      boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.doEnchantDamageEffects(this, entityIn);
         this.playSound(SoundEvents.DOLPHIN_ATTACK, 1.0F, 1.0F);
      }

      return flag;
   }

   @Override
   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return 0.3F;
   }

   /**
    * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
    * better.
    */
   @Override
   protected void pickUpItem(ItemEntity itemEntity) {
      if (this.getItemBySlot(EquipmentSlotType.MAINHAND).isEmpty()) {
         ItemStack itemstack = itemEntity.getItem();
         if (this.canHoldItem(itemstack)) {
            this.onItemPickup(itemEntity);
            this.setItemSlot(EquipmentSlotType.MAINHAND, itemstack);
            this.handDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.take(itemEntity, itemstack.getCount());
            itemEntity.remove();
         }
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   @Override
   public void tick() {
      super.tick();
      if (this.isNoAi()) {
         this.setAirSupply(this.getMaxAirSupply());
      } else {
         if (this.isInWaterRainOrBubble()) {
            this.setMoistness(2400);
         } else {
            this.setMoistness(this.getMoistness() - 1);
            if (this.getMoistness() <= 0) {
               this.hurt(DamageSource.DRY_OUT, 1.0F);
            }

            if (this.onGround) {
               this.setDeltaMovement(this.getDeltaMovement().add((double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
               this.yRot = this.random.nextFloat() * 360.0F;
               this.onGround = false;
               this.hasImpulse = true;
            }
         }

         if (this.level.isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03D) {
            Vector3d vector3d = this.getViewVector(0.0F);
            float f = MathHelper.cos(this.yRot * ((float) Math.PI / 180F)) * 0.3F;
            float f1 = MathHelper.sin(this.yRot * ((float) Math.PI / 180F)) * 0.3F;
            float f2 = 1.2F - this.random.nextFloat() * 0.7F;

            for (int i = 0; i < 2; ++i) {
               this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f, this.getY() - vector3d.y, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
               this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f, this.getY() - vector3d.y, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            }
         }

      }
   }

   @Override
   protected ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
      ItemStack itemstack = playerIn.getItemInHand(hand);
      if (!itemstack.isEmpty() && itemstack.getItem().is(ItemTags.FISHES)) {
         if (!this.level.isClientSide) {
            this.playSound(SoundEvents.DOLPHIN_EAT, 1.0F, 1.0F);
         }
         if (!playerIn.abilities.instabuild) {
            itemstack.shrink(1);
         }

         return ActionResultType.sidedSuccess(this.level.isClientSide);
      } else {
         return super.mobInteract(playerIn, hand);
      }
   }

   public static boolean checkDolphinSpawnRules(EntityType<SharkEntity> p_223364_0_, World p_223364_1_, SpawnReason reason, BlockPos p_223364_3_, Random p_223364_4_) {
      if (p_223364_3_.getY() > 45 && p_223364_3_.getY() < p_223364_1_.getSeaLevel()) {
         Optional<RegistryKey<Biome>> optional = p_223364_1_.getBiomeName(p_223364_3_);
         return (!Objects.equals(optional, Optional.of(Biomes.OCEAN)) || !Objects.equals(optional, Optional.of(Biomes.DEEP_OCEAN))) && p_223364_1_.getFluidState(p_223364_3_).is(FluidTags.WATER);
      } else {
         return false;
      }
   }

   class AttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
      public AttackGoal() {
         super(SharkEntity.this, 1.50D, true);
      }

      @Override
      protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
         double d0 = this.getAttackReachSqr(enemy);
         if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
            this.resetAttackCooldown();
            this.mob.doHurtTarget(enemy);

         } else if (distToEnemySqr <= d0 * 2.0D) {
            if (this.isTimeToAttack()) {

               this.resetAttackCooldown();
            }

            if (this.getTicksUntilNextAttack() <= 10) {
               // todo: what happens here?
            }
         } else {
            this.resetAttackCooldown();

         }

      }

      @Override
      protected double getAttackReachSqr(LivingEntity attackTarget) {
         return (double) (4.0F + attackTarget.getBbWidth());
      }
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
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.DOLPHIN_HURT;
   }

   @Override
   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundEvents.DOLPHIN_DEATH;
   }

   @Override
   @Nullable
   protected SoundEvent getAmbientSound() {
      return this.isInWater() ? SoundEvents.DOLPHIN_AMBIENT_WATER : SoundEvents.DOLPHIN_AMBIENT;
   }

   @Override
   protected SoundEvent getSwimSplashSound() {
      return SoundEvents.DOLPHIN_SPLASH;
   }

   @Override
   protected SoundEvent getSwimSound() {
      return SoundEvents.DOLPHIN_SWIM;
   }

   protected boolean closeToTarget() {
      BlockPos blockpos = this.getNavigation().getTargetPos();
      return blockpos != null && blockpos.closerThan(this.position(), 12.0D);
   }

   @Override
   public void travel(Vector3d travelVector) {
      if (this.isEffectiveAi() && this.isInWater()) {
         this.moveRelative(this.getSpeed(), travelVector);
         this.move(MoverType.SELF, this.getDeltaMovement());
         this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
         if (this.getTarget() == null) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
         }
      } else {
         super.travel(travelVector);
      }

   }

   static class MoveHelperController extends MovementController {
      private final SharkEntity shark;

      public MoveHelperController(SharkEntity sharkIn) {
         super(sharkIn);
         this.shark = sharkIn;
      }

      @Override
      public void tick() {
         if (this.shark.isInWater()) {
            this.shark.setDeltaMovement(this.shark.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
         }

         if (this.operation == MovementController.Action.MOVE_TO && !this.shark.getNavigation().isDone()) {
            double d0 = this.wantedX - this.shark.getX();
            double d1 = this.wantedY - this.shark.getY();
            double d2 = this.wantedZ - this.shark.getZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 < (double) 2.5000003E-7F) {
               this.mob.setZza(0.0F);
            } else {
               float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
               this.shark.yRot = this.rotlerp(this.shark.yRot, f, 10.0F);
               this.shark.yBodyRot = this.shark.yRot;
               this.shark.yHeadRot = this.shark.yRot;
               float f1 = (float) (this.speedModifier * this.shark.getAttributeValue(Attributes.MOVEMENT_SPEED));
               if (this.shark.isInWater()) {
                  this.shark.setSpeed(f1 * 0.02F);
                  float f2 = -((float) (MathHelper.atan2(d1, (double) MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double) (180F / (float) Math.PI)));
                  f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
                  this.shark.xRot = this.rotlerp(this.shark.xRot, f2, 5.0F);
                  float f3 = MathHelper.cos(this.shark.xRot * ((float) Math.PI / 180F));
                  float f4 = MathHelper.sin(this.shark.xRot * ((float) Math.PI / 180F));
                  this.shark.zza = f3 * f1;
                  this.shark.yya = -f4 * f1;
               } else {
                  this.shark.setSpeed(f1 * 0.1F);
               }

            }
         } else {
            this.shark.setSpeed(0.0F);
            this.shark.setXxa(0.0F);
            this.shark.setYya(0.0F);
            this.shark.setZza(0.0F);
         }
      }
   }

   //NBT
   @Override
   public void addAdditionalSaveData(CompoundNBT compound) {
      super.addAdditionalSaveData(compound);
      compound.putInt("Moistness", this.getMoistness());
   }

   @Override
   public void readAdditionalSaveData(CompoundNBT compound) {
      super.readAdditionalSaveData(compound);
      this.setMoistness(compound.getInt("Moistness"));
   }
}
