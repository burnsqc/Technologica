package com.technologica.entity.monster;

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
   private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(SharkEntity.class, DataSerializers.VARINT);
   public static final Predicate<ItemEntity> ITEM_SELECTOR = p_205023_0_ -> !p_205023_0_.cannotPickup() && p_205023_0_.isAlive() && p_205023_0_.isInWater();
   private static final RangedInteger angerTimeRange = TickRangeConverter.convertRange(20, 39);
   private int angerTime;
   private UUID angerTarget;

   public SharkEntity(EntityType<? extends SharkEntity> type, World worldIN) {
      super(type, worldIN);
      this.moveController = new SharkEntity.MoveHelperController(this);
      this.lookController = new DolphinLookController(this, 10);
      this.setCanPickUpLoot(true);
   }

   @Override
   @Nullable
   public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      this.rotationPitch = 0.0F;
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Override
   public boolean canBreatheUnderwater() {
      return true;
   }

   public int getMoistness() {
      return this.dataManager.get(MOISTNESS);
   }

   public void setMoistness(int p_211137_1_) {
      this.dataManager.set(MOISTNESS, p_211137_1_);
   }

   //Register Attributes, Goals, and Data
   public static AttributeModifierMap.MutableAttribute registerAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 1.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D);
   }

   @Override
   protected void registerGoals() {
      this.goalSelector.addGoal(0, new FindWaterGoal(this));
      this.goalSelector.addGoal(1, new SharkEntity.AttackGoal());
      this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
      this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new FollowBoatGoal(this));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, GuardianEntity.class)).setCallsForHelp());
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, 10, true, true, (Predicate<LivingEntity>) null));
   }

   @Override
   protected void registerData() {
      super.registerData();
      this.dataManager.register(MOISTNESS, 2400);
   }

   @Override
   protected PathNavigator createNavigator(World worldIn) {
      return new SwimmerPathNavigator(this, worldIn);
   }

   @Override
   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.applyEnchantments(this, entityIn);
         this.playSound(SoundEvents.ENTITY_DOLPHIN_ATTACK, 1.0F, 1.0F);
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
   protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      if (this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
         ItemStack itemstack = itemEntity.getItem();
         if (this.canEquipItem(itemstack)) {
            this.triggerItemPickupTrigger(itemEntity);
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
            this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.onItemPickup(itemEntity, itemstack.getCount());
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
      if (this.isAIDisabled()) {
         this.setAir(this.getMaxAir());
      } else {
         if (this.isInWaterRainOrBubbleColumn()) {
            this.setMoistness(2400);
         } else {
            this.setMoistness(this.getMoistness() - 1);
            if (this.getMoistness() <= 0) {
               this.attackEntityFrom(DamageSource.DRYOUT, 1.0F);
            }

            if (this.onGround) {
               this.setMotion(this.getMotion().add((double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F)));
               this.rotationYaw = this.rand.nextFloat() * 360.0F;
               this.onGround = false;
               this.isAirBorne = true;
            }
         }

         if (this.world.isRemote && this.isInWater() && this.getMotion().lengthSquared() > 0.03D) {
            Vector3d vector3d = this.getLook(0.0F);
            float f = MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F)) * 0.3F;
            float f1 = MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F)) * 0.3F;
            float f2 = 1.2F - this.rand.nextFloat() * 0.7F;

            for (int i = 0; i < 2; ++i) {
               this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double) f2 + (double) f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
               this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double) f2 - (double) f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            }
         }

      }
   }

   @Override
   protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
      ItemStack itemstack = playerIn.getHeldItem(hand);
      if (!itemstack.isEmpty() && itemstack.getItem().isIn(ItemTags.FISHES)) {
         if (!this.world.isRemote) {
            this.playSound(SoundEvents.ENTITY_DOLPHIN_EAT, 1.0F, 1.0F);
         }
         if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
         }

         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else {
         return super.getEntityInteractionResult(playerIn, hand);
      }
   }

   public static boolean func_223364_b(EntityType<SharkEntity> p_223364_0_, World p_223364_1_, SpawnReason reason, BlockPos p_223364_3_, Random p_223364_4_) {
      if (p_223364_3_.getY() > 45 && p_223364_3_.getY() < p_223364_1_.getSeaLevel()) {
         Optional<RegistryKey<Biome>> optional = p_223364_1_.func_242406_i(p_223364_3_);
         return (!Objects.equals(optional, Optional.of(Biomes.OCEAN)) || !Objects.equals(optional, Optional.of(Biomes.DEEP_OCEAN))) && p_223364_1_.getFluidState(p_223364_3_).isTagged(FluidTags.WATER);
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
         if (distToEnemySqr <= d0 && this.isSwingOnCooldown()) {
            this.resetSwingCooldown();
            this.attacker.attackEntityAsMob(enemy);

         } else if (distToEnemySqr <= d0 * 2.0D) {
            if (this.isSwingOnCooldown()) {

               this.resetSwingCooldown();
            }

            if (this.getSwingCooldown() <= 10) {
               // todo: what happens here?
            }
         } else {
            this.resetSwingCooldown();

         }

      }

      @Override
      protected double getAttackReachSqr(LivingEntity attackTarget) {
         return (double) (4.0F + attackTarget.getWidth());
      }
   }

   //Anger
   @Override
   public void func_230258_H__() {
      this.setAngerTime(angerTimeRange.getRandomWithinRange(this.rand));
   }

   @Override
   public void setAngerTime(int time) {
      this.angerTime = time;
   }

   @Override
   public int getAngerTime() {
      return this.angerTime;
   }

   @Override
   public void setAngerTarget(@Nullable UUID target) {
      this.angerTarget = target;
   }

   @Override
   public UUID getAngerTarget() {
      return this.angerTarget;
   }

   //Audio
   @Override
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_DOLPHIN_HURT;
   }

   @Override
   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_DOLPHIN_DEATH;
   }

   @Override
   @Nullable
   protected SoundEvent getAmbientSound() {
      return this.isInWater() ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
   }

   @Override
   protected SoundEvent getSplashSound() {
      return SoundEvents.ENTITY_DOLPHIN_SPLASH;
   }

   @Override
   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_DOLPHIN_SWIM;
   }

   protected boolean closeToTarget() {
      BlockPos blockpos = this.getNavigator().getTargetPos();
      return blockpos != null && blockpos.withinDistance(this.getPositionVec(), 12.0D);
   }

   @Override
   public void travel(Vector3d travelVector) {
      if (this.isServerWorld() && this.isInWater()) {
         this.moveRelative(this.getAIMoveSpeed(), travelVector);
         this.move(MoverType.SELF, this.getMotion());
         this.setMotion(this.getMotion().scale(0.9D));
         if (this.getAttackTarget() == null) {
            this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
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
            this.shark.setMotion(this.shark.getMotion().add(0.0D, 0.005D, 0.0D));
         }

         if (this.action == MovementController.Action.MOVE_TO && !this.shark.getNavigator().noPath()) {
            double d0 = this.posX - this.shark.getPosX();
            double d1 = this.posY - this.shark.getPosY();
            double d2 = this.posZ - this.shark.getPosZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 < (double) 2.5000003E-7F) {
               this.mob.setMoveForward(0.0F);
            } else {
               float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
               this.shark.rotationYaw = this.limitAngle(this.shark.rotationYaw, f, 10.0F);
               this.shark.renderYawOffset = this.shark.rotationYaw;
               this.shark.rotationYawHead = this.shark.rotationYaw;
               float f1 = (float) (this.speed * this.shark.getAttributeValue(Attributes.MOVEMENT_SPEED));
               if (this.shark.isInWater()) {
                  this.shark.setAIMoveSpeed(f1 * 0.02F);
                  float f2 = -((float) (MathHelper.atan2(d1, (double) MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double) (180F / (float) Math.PI)));
                  f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
                  this.shark.rotationPitch = this.limitAngle(this.shark.rotationPitch, f2, 5.0F);
                  float f3 = MathHelper.cos(this.shark.rotationPitch * ((float) Math.PI / 180F));
                  float f4 = MathHelper.sin(this.shark.rotationPitch * ((float) Math.PI / 180F));
                  this.shark.moveForward = f3 * f1;
                  this.shark.moveVertical = -f4 * f1;
               } else {
                  this.shark.setAIMoveSpeed(f1 * 0.1F);
               }

            }
         } else {
            this.shark.setAIMoveSpeed(0.0F);
            this.shark.setMoveStrafing(0.0F);
            this.shark.setMoveVertical(0.0F);
            this.shark.setMoveForward(0.0F);
         }
      }
   }

   //NBT
   @Override
   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("Moistness", this.getMoistness());
   }

   @Override
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setMoistness(compound.getInt("Moistness"));
   }
}
