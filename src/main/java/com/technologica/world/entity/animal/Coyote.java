package com.technologica.world.entity.animal;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.technologica.world.entity.TechnologicaEntityType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Coyote extends TamableAnimal implements NeutralMob {
   private static final EntityDataAccessor<Boolean> BEGGING = SynchedEntityData.defineId(Coyote.class, EntityDataSerializers.BOOLEAN);
   private static final EntityDataAccessor<Integer> COLLAR_COLOR = SynchedEntityData.defineId(Coyote.class, EntityDataSerializers.INT);
   private static final EntityDataAccessor<Integer> ANGER_TIME = SynchedEntityData.defineId(Coyote.class, EntityDataSerializers.INT);
   public static final Predicate<LivingEntity> TARGET_ENTITIES = (p_213440_0_) -> {
      EntityType<?> entitytype = p_213440_0_.getType();
      return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
   };
   private float headRotationCourse;
   private float headRotationCourseOld;
   private boolean isWet;
   private boolean isShaking;
   private float timeCoyoteIsShaking;
   private float prevTimeCoyoteIsShaking;
   private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(20, 39);
   private UUID persistentAngerTarget;

   public Coyote(EntityType<? extends Coyote> type, Level worldIn) {
      super(type, worldIn);
      this.setTame(false);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(1, new FloatGoal(this));
      this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
      this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
      this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
      this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false, TARGET_ENTITIES));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));
      this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
   }

   public static AttributeSupplier.Builder registerAttributes() {
      return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(BEGGING, false);
      this.entityData.define(COLLAR_COLOR, DyeColor.RED.getId());
      this.entityData.define(ANGER_TIME, 0);
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putByte("CollarColor", (byte)this.getCollarColor().getId());
      this.addPersistentAngerSaveData(compound);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains("CollarColor", 99)) {
         this.setCollarColor(DyeColor.byId(compound.getInt("CollarColor")));
      }

      if(!level.isClientSide) //FORGE: allow this entity to be read from nbt on client. (Fixes MC-189565)
      this.readPersistentAngerSaveData((ServerLevel)this.level, compound);
   }

   protected SoundEvent getAmbientSound() {
      if (this.isAngry()) {
         return SoundEvents.WOLF_GROWL;
      } else if (this.random.nextInt(3) == 0) {
         return this.isTame() && this.getHealth() < 10.0F ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
      } else {
         return SoundEvents.WOLF_AMBIENT;
      }
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.WOLF_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.WOLF_DEATH;
   }

   /**
    * Returns the volume for the sounds this mob makes.
    */
   protected float getSoundVolume() {
      return 0.4F;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void aiStep() {
      super.aiStep();
      if (!this.level.isClientSide && this.isWet && !this.isShaking && !this.isPathFinding() && this.onGround) {
         this.isShaking = true;
         this.timeCoyoteIsShaking = 0.0F;
         this.prevTimeCoyoteIsShaking = 0.0F;
         this.level.broadcastEntityEvent(this, (byte)8);
      }

      if (!this.level.isClientSide) {
         this.updatePersistentAnger((ServerLevel)this.level, true);
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.isAlive()) {
         this.headRotationCourseOld = this.headRotationCourse;
         if (this.isBegging()) {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
         } else {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
         }

         if (this.isInWaterRainOrBubble()) {
            this.isWet = true;
            if (this.isShaking && !this.level.isClientSide) {
               this.level.broadcastEntityEvent(this, (byte)56);
               this.cancelShake();
            }
         } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeCoyoteIsShaking == 0.0F) {
               this.playSound(SoundEvents.WOLF_SHAKE, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeCoyoteIsShaking = this.timeCoyoteIsShaking;
            this.timeCoyoteIsShaking += 0.05F;
            if (this.prevTimeCoyoteIsShaking >= 2.0F) {
               this.isWet = false;
               this.isShaking = false;
               this.prevTimeCoyoteIsShaking = 0.0F;
               this.timeCoyoteIsShaking = 0.0F;
            }

            if (this.timeCoyoteIsShaking > 0.4F) {
               float f = (float)this.getY();
               int i = (int)(Mth.sin((this.timeCoyoteIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
               Vec3 vector3d = this.getDeltaMovement();

               for(int j = 0; j < i; ++j) {
                  float f1 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                  float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
                  this.level.addParticle(ParticleTypes.SPLASH, this.getX() + (double)f1, (double)(f + 0.8F), this.getZ() + (double)f2, vector3d.x, vector3d.y, vector3d.z);
               }
            }
         }

      }
   }

   private void cancelShake() {
      this.isShaking = false;
      this.timeCoyoteIsShaking = 0.0F;
      this.prevTimeCoyoteIsShaking = 0.0F;
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void die(DamageSource cause) {
      this.isWet = false;
      this.isShaking = false;
      this.prevTimeCoyoteIsShaking = 0.0F;
      this.timeCoyoteIsShaking = 0.0F;
      super.die(cause);
   }

   /**
    * True if the wolf is wet
    */
   @OnlyIn(Dist.CLIENT)
   public boolean isCoyoteWet() {
      return this.isWet;
   }

   /**
    * Used when calculating the amount of shading to apply while the wolf is wet.
    */
   @OnlyIn(Dist.CLIENT)
   public float getShadingWhileWet(float partialTicks) {
      return Math.min(0.5F + Mth.lerp(partialTicks, this.prevTimeCoyoteIsShaking, this.timeCoyoteIsShaking) / 2.0F * 0.5F, 1.0F);
   }

   @OnlyIn(Dist.CLIENT)
   public float getShakeAngle(float partialTicks, float offset) {
      float f = (Mth.lerp(partialTicks, this.prevTimeCoyoteIsShaking, this.timeCoyoteIsShaking) + offset) / 1.8F;
      if (f < 0.0F) {
         f = 0.0F;
      } else if (f > 1.0F) {
         f = 1.0F;
      }

      return Mth.sin(f * (float)Math.PI) * Mth.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
   }

   @OnlyIn(Dist.CLIENT)
   public float getInterestedAngle(float partialTicks) {
      return Mth.lerp(partialTicks, this.headRotationCourseOld, this.headRotationCourse) * 0.15F * (float)Math.PI;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return sizeIn.height * 0.8F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getMaxHeadXRot() {
      return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean hurt(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         Entity entity = source.getEntity();
         this.setOrderedToSit(false);
         if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
            amount = (amount + 1.0F) / 2.0F;
         }

         return super.hurt(source, amount);
      }
   }

   public boolean doHurtTarget(Entity entityIn) {
      boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.doEnchantDamageEffects(this, entityIn);
      }

      return flag;
   }

   public void setTame(boolean tamed) {
      super.setTame(tamed);
      if (tamed) {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
         this.setHealth(20.0F);
      } else {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8.0D);
      }

      this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
   }

   public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
      ItemStack itemstack = playerIn.getItemInHand(hand);
      Item item = itemstack.getItem();
      if (this.level.isClientSide) {
         boolean flag = this.isOwnedBy(playerIn) || this.isTame() || item == Items.BONE && !this.isTame() && !this.isAngry();
         return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
      } else {
         if (this.isTame()) {
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
               if (!playerIn.getAbilities().instabuild) {
                  itemstack.shrink(1);
               }

               this.heal((float)item.getFoodProperties().getNutrition());
               return InteractionResult.SUCCESS;
            }

            if (!(item instanceof DyeItem)) {
               InteractionResult actionresulttype = super.mobInteract(playerIn, hand);
               if ((!actionresulttype.consumesAction() || this.isBaby()) && this.isOwnedBy(playerIn)) {
                  this.setOrderedToSit(!this.isOrderedToSit());
                  this.jumping = false;
                  this.navigation.stop();
                  this.setTarget((LivingEntity)null);
                  return InteractionResult.SUCCESS;
               }

               return actionresulttype;
            }

            DyeColor dyecolor = ((DyeItem)item).getDyeColor();
            if (dyecolor != this.getCollarColor()) {
               this.setCollarColor(dyecolor);
               if (!playerIn.getAbilities().instabuild) {
                  itemstack.shrink(1);
               }

               return InteractionResult.SUCCESS;
            }
         } else if (item == Items.BONE && !this.isAngry()) {
            if (!playerIn.getAbilities().instabuild) {
               itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, playerIn)) {
               this.tame(playerIn);
               this.navigation.stop();
               this.setTarget((LivingEntity)null);
               this.setOrderedToSit(true);
               this.level.broadcastEntityEvent(this, (byte)7);
            } else {
               this.level.broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
         }

         return super.mobInteract(playerIn, hand);
      }
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleEntityEvent(byte id) {
      if (id == 8) {
         this.isShaking = true;
         this.timeCoyoteIsShaking = 0.0F;
         this.prevTimeCoyoteIsShaking = 0.0F;
      } else if (id == 56) {
         this.cancelShake();
      } else {
         super.handleEntityEvent(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getTailRotation() {
      if (this.isAngry()) {
         return 1.5393804F;
      } else {
         return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F);
      }
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isFood(ItemStack stack) {
      Item item = stack.getItem();
      return item.isEdible() && item.getFoodProperties().isMeat();
   }

   /**
    * Will return how many at most can spawn in a chunk at once.
    */
   public int getMaxSpawnClusterSize() {
      return 8;
   }

   public int getRemainingPersistentAngerTime() {
      return this.entityData.get(ANGER_TIME);
   }

   public void setRemainingPersistentAngerTime(int time) {
      this.entityData.set(ANGER_TIME, time);
   }

   public void startPersistentAngerTimer() {
      this.setRemainingPersistentAngerTime(ANGER_TIME_RANGE.sample(this.random));
   }

   @Nullable
   public UUID getPersistentAngerTarget() {
      return this.persistentAngerTarget;
   }

   public void setPersistentAngerTarget(@Nullable UUID target) {
      this.persistentAngerTarget = target;
   }

   public DyeColor getCollarColor() {
      return DyeColor.byId(this.entityData.get(COLLAR_COLOR));
   }

   public void setCollarColor(DyeColor collarcolor) {
      this.entityData.set(COLLAR_COLOR, collarcolor.getId());
   }

   public Coyote getBreedOffspring(ServerLevel world, AgeableMob mate) {
      Coyote wolfentity = TechnologicaEntityType.COYOTE.get().create(world);
      UUID uuid = this.getOwnerUUID();
      if (uuid != null) {
         wolfentity.setOwnerUUID(uuid);
         wolfentity.setTame(true);
      }

      return wolfentity;
   }

   public void setBegging(boolean beg) {
      this.entityData.set(BEGGING, beg);
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMate(Animal otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (!this.isTame()) {
         return false;
      } else if (!(otherAnimal instanceof Coyote)) {
         return false;
      } else {
         Coyote wolfentity = (Coyote)otherAnimal;
         if (!wolfentity.isTame()) {
            return false;
         } else if (wolfentity.isInSittingPose()) {
            return false;
         } else {
            return this.isInLove() && wolfentity.isInLove();
         }
      }
   }

   public boolean isBegging() {
      return this.entityData.get(BEGGING);
   }

   public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
      if (!(target instanceof Creeper) && !(target instanceof Ghast)) {
         if (target instanceof Coyote) {
            Coyote wolfentity = (Coyote)target;
            return !wolfentity.isTame() || wolfentity.getOwner() != owner;
         } else if (target instanceof Player && owner instanceof Player && !((Player)owner).canHarmPlayer((Player)target)) {
            return false;
         } else if (target instanceof AbstractHorse && ((AbstractHorse)target).isTamed()) {
            return false;
         } else {
            return !(target instanceof TamableAnimal) || !((TamableAnimal)target).isTame();
         }
      } else {
         return false;
      }
   }

   public boolean canBeLeashed(Player player) {
      return !this.isAngry() && super.canBeLeashed(player);
   }

   @OnlyIn(Dist.CLIENT)
   public Vec3 getLeashOffset() {
      return new Vec3(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
   }

   class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.world.entity.ai.goal.AvoidEntityGoal<T> {
      private final Coyote wolf;

      public AvoidEntityGoal(Coyote wolfIn, Class<T> entityClassToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
         super(wolfIn, entityClassToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
         this.wolf = wolfIn;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean canUse() {
         if (super.canUse() && this.toAvoid instanceof Llama) {
            return !this.wolf.isTame() && this.avoidLlama((Llama)this.toAvoid);
         } else {
            return false;
         }
      }

      private boolean avoidLlama(Llama llamaIn) {
         return llamaIn.getStrength() >= Coyote.this.random.nextInt(5);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void start() {
         Coyote.this.setTarget((LivingEntity)null);
         super.start();
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         Coyote.this.setTarget((LivingEntity)null);
         super.tick();
      }
   }
}
