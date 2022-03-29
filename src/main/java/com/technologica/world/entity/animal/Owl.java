package com.technologica.world.entity.animal;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LandOnOwnersShoulderGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Owl extends ShoulderRidingEntity implements FlyingAnimal {
   private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Owl.class, EntityDataSerializers.INT);
   private static final Predicate<Mob> CAN_MIMIC = new Predicate<Mob>() {
      public boolean test(@Nullable Mob p_test_1_) {
         return p_test_1_ != null && Owl.IMITATION_SOUND_EVENTS.containsKey(p_test_1_.getType());
      }
   };
   private static final Item DEADLY_ITEM = Items.COOKIE;
   private static final Set<Item> TAME_ITEMS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
   private static final Map<EntityType<?>, SoundEvent> IMITATION_SOUND_EVENTS = Util.make(Maps.newHashMap(), (p_200609_0_) -> {
      p_200609_0_.put(EntityType.BLAZE, SoundEvents.PARROT_IMITATE_BLAZE);
      p_200609_0_.put(EntityType.CAVE_SPIDER, SoundEvents.PARROT_IMITATE_SPIDER);
      p_200609_0_.put(EntityType.CREEPER, SoundEvents.PARROT_IMITATE_CREEPER);
      p_200609_0_.put(EntityType.DROWNED, SoundEvents.PARROT_IMITATE_DROWNED);
      p_200609_0_.put(EntityType.ELDER_GUARDIAN, SoundEvents.PARROT_IMITATE_ELDER_GUARDIAN);
      p_200609_0_.put(EntityType.ENDER_DRAGON, SoundEvents.PARROT_IMITATE_ENDER_DRAGON);
      p_200609_0_.put(EntityType.ENDERMITE, SoundEvents.PARROT_IMITATE_ENDERMITE);
      p_200609_0_.put(EntityType.EVOKER, SoundEvents.PARROT_IMITATE_EVOKER);
      p_200609_0_.put(EntityType.GHAST, SoundEvents.PARROT_IMITATE_GHAST);
      p_200609_0_.put(EntityType.GUARDIAN, SoundEvents.PARROT_IMITATE_GUARDIAN);
      p_200609_0_.put(EntityType.HOGLIN, SoundEvents.PARROT_IMITATE_HOGLIN);
      p_200609_0_.put(EntityType.HUSK, SoundEvents.PARROT_IMITATE_HUSK);
      p_200609_0_.put(EntityType.ILLUSIONER, SoundEvents.PARROT_IMITATE_ILLUSIONER);
      p_200609_0_.put(EntityType.MAGMA_CUBE, SoundEvents.PARROT_IMITATE_MAGMA_CUBE);
      p_200609_0_.put(EntityType.PHANTOM, SoundEvents.PARROT_IMITATE_PHANTOM);
      p_200609_0_.put(EntityType.PIGLIN, SoundEvents.PARROT_IMITATE_PIGLIN);
      p_200609_0_.put(EntityType.PIGLIN_BRUTE, SoundEvents.PARROT_IMITATE_PIGLIN_BRUTE);
      p_200609_0_.put(EntityType.PILLAGER, SoundEvents.PARROT_IMITATE_PILLAGER);
      p_200609_0_.put(EntityType.RAVAGER, SoundEvents.PARROT_IMITATE_RAVAGER);
      p_200609_0_.put(EntityType.SHULKER, SoundEvents.PARROT_IMITATE_SHULKER);
      p_200609_0_.put(EntityType.SILVERFISH, SoundEvents.PARROT_IMITATE_SILVERFISH);
      p_200609_0_.put(EntityType.SKELETON, SoundEvents.PARROT_IMITATE_SKELETON);
      p_200609_0_.put(EntityType.SLIME, SoundEvents.PARROT_IMITATE_SLIME);
      p_200609_0_.put(EntityType.SPIDER, SoundEvents.PARROT_IMITATE_SPIDER);
      p_200609_0_.put(EntityType.STRAY, SoundEvents.PARROT_IMITATE_STRAY);
      p_200609_0_.put(EntityType.VEX, SoundEvents.PARROT_IMITATE_VEX);
      p_200609_0_.put(EntityType.VINDICATOR, SoundEvents.PARROT_IMITATE_VINDICATOR);
      p_200609_0_.put(EntityType.WITCH, SoundEvents.PARROT_IMITATE_WITCH);
      p_200609_0_.put(EntityType.WITHER, SoundEvents.PARROT_IMITATE_WITHER);
      p_200609_0_.put(EntityType.WITHER_SKELETON, SoundEvents.PARROT_IMITATE_WITHER_SKELETON);
      p_200609_0_.put(EntityType.ZOGLIN, SoundEvents.PARROT_IMITATE_ZOGLIN);
      p_200609_0_.put(EntityType.ZOMBIE, SoundEvents.PARROT_IMITATE_ZOMBIE);
      p_200609_0_.put(EntityType.ZOMBIE_VILLAGER, SoundEvents.PARROT_IMITATE_ZOMBIE_VILLAGER);
   });
   public float flap;
   public float flapSpeed;
   public float oFlapSpeed;
   public float oFlap;
   private float flapping = 1.0F;
   private boolean partyParrot;
   private BlockPos jukeboxPosition;

   public Owl(EntityType<? extends Owl> type, Level worldIn) {
      super(type, worldIn);
      this.moveControl = new FlyingMoveControl(this, 10, false);
      this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
      this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
      this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
   }

   @Nullable
   public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
      this.setVariant(this.random.nextInt(5));
      if (spawnDataIn == null) {
         spawnDataIn = new AgeableMob.AgeableMobGroupData(false);
      }

      return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   /**
    * If Animal, checks if the age timer is negative
    */
   public boolean isBaby() {
      return false;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
      this.goalSelector.addGoal(0, new FloatGoal(this));
      this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
      this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
      this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 5.0F, 1.0F, true));
      this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this));
      this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0D, 3.0F, 7.0F));
   }

   public static AttributeSupplier.Builder registerAttributes() {
      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FLYING_SPEED, (double)0.4F).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
   }

   /**
    * Returns new PathNavigateGround instance
    */
   protected PathNavigation createNavigation(Level worldIn) {
      FlyingPathNavigation flyingpathnavigator = new FlyingPathNavigation(this, worldIn);
      flyingpathnavigator.setCanOpenDoors(false);
      flyingpathnavigator.setCanFloat(true);
      flyingpathnavigator.setCanPassDoors(true);
      return flyingpathnavigator;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return sizeIn.height * 0.6F;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void aiStep() {
      if (this.jukeboxPosition == null || !this.jukeboxPosition.closerToCenterThan(this.position(), 3.46D) || !this.level.getBlockState(this.jukeboxPosition).is(Blocks.JUKEBOX)) {
         this.partyParrot = false;
         this.jukeboxPosition = null;
      }

      if (this.level.random.nextInt(400) == 0) {
         playMimicSound(this.level, this);
      }

      super.aiStep();
      this.calculateFlapping();
   }

   /**
    * Called when a record starts or stops playing. Used to make parrots start or stop partying.
    */
   @OnlyIn(Dist.CLIENT)
   public void setRecordPlayingNearby(BlockPos pos, boolean isPartying) {
      this.jukeboxPosition = pos;
      this.partyParrot = isPartying;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isPartying() {
      return this.partyParrot;
   }

   private void calculateFlapping() {
      this.oFlap = this.flap;
      this.oFlapSpeed = this.flapSpeed;
      this.flapSpeed = (float)((double)this.flapSpeed + (double)(!this.onGround && !this.isPassenger() ? 4 : -1) * 0.3D);
      this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
      if (!this.onGround && this.flapping < 1.0F) {
         this.flapping = 1.0F;
      }

      this.flapping = (float)((double)this.flapping * 0.9D);
      Vec3 vector3d = this.getDeltaMovement();
      if (!this.onGround && vector3d.y < 0.0D) {
         this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
      }

      this.flap += this.flapping * 2.0F;
   }

   public static boolean playMimicSound(Level worldIn, Entity parrotIn) {
      if (parrotIn.isAlive() && !parrotIn.isSilent() && worldIn.random.nextInt(2) == 0) {
         List<Mob> list = worldIn.getEntitiesOfClass(Mob.class, parrotIn.getBoundingBox().inflate(20.0D), CAN_MIMIC);
         if (!list.isEmpty()) {
            Mob mobentity = list.get(worldIn.random.nextInt(list.size()));
            if (!mobentity.isSilent()) {
               SoundEvent soundevent = getMimicSound(mobentity.getType());
               worldIn.playSound((Player)null, parrotIn.getX(), parrotIn.getY(), parrotIn.getZ(), soundevent, parrotIn.getSoundSource(), 0.7F, getPitch(worldIn.random));
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
      ItemStack itemstack = playerIn.getItemInHand(hand);
      if (!this.isTame() && TAME_ITEMS.contains(itemstack.getItem())) {
         if (!playerIn.getAbilities().instabuild) {
            itemstack.shrink(1);
         }

         if (!this.isSilent()) {
            this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.PARROT_EAT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
         }

         if (!this.level.isClientSide) {
            if (this.random.nextInt(10) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, playerIn)) {
               this.tame(playerIn);
               this.level.broadcastEntityEvent(this, (byte)7);
            } else {
               this.level.broadcastEntityEvent(this, (byte)6);
            }
         }

         return InteractionResult.sidedSuccess(this.level.isClientSide);
      } else if (itemstack.getItem() == DEADLY_ITEM) {
         if (!playerIn.getAbilities().instabuild) {
            itemstack.shrink(1);
         }

         this.addEffect(new MobEffectInstance(MobEffects.POISON, 900));
         if (playerIn.isCreative() || !this.isInvulnerable()) {
            this.hurt(DamageSource.playerAttack(playerIn), Float.MAX_VALUE);
         }

         return InteractionResult.sidedSuccess(this.level.isClientSide);
      } else if (!this.isFlying() && this.isTame() && this.isOwnedBy(playerIn)) {
         if (!this.level.isClientSide) {
            this.setOrderedToSit(!this.isOrderedToSit());
         }

         return InteractionResult.sidedSuccess(this.level.isClientSide);
      } else {
         return super.mobInteract(playerIn, hand);
      }
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isFood(ItemStack stack) {
      return false;
   }

   public static boolean checkParrotSpawnRules(EntityType<Owl> parrotIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos p_223317_3_, Random random) {
      BlockState blockstate = worldIn.getBlockState(p_223317_3_.below());
      return (blockstate.is(BlockTags.LEAVES) || blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(BlockTags.LOGS) || blockstate.is(Blocks.AIR)) && worldIn.getRawBrightness(p_223317_3_, 0) > 8;
   }

   public boolean causeFallDamage(float distance, float damageMultiplier) {
      return false;
   }

   protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMate(Animal otherAnimal) {
      return false;
   }

   @Nullable
   public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
      return null;
   }

   public boolean doHurtTarget(Entity entityIn) {
      return entityIn.hurt(DamageSource.mobAttack(this), 3.0F);
   }

   @Nullable
   public SoundEvent getAmbientSound() {
      return getAmbient(this.level, this.level.random);
   }

   public static SoundEvent getAmbient(Level p_234212_0_, Random p_234212_1_) {
      if (p_234212_0_.getDifficulty() != Difficulty.PEACEFUL && p_234212_1_.nextInt(1000) == 0) {
         List<EntityType<?>> list = Lists.newArrayList(IMITATION_SOUND_EVENTS.keySet());
         return getMimicSound(list.get(p_234212_1_.nextInt(list.size())));
      } else {
         return SoundEvents.PARROT_AMBIENT;
      }
   }

   private static SoundEvent getMimicSound(EntityType<?> type) {
      return IMITATION_SOUND_EVENTS.getOrDefault(type, SoundEvents.PARROT_AMBIENT);
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.PARROT_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.PARROT_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.PARROT_STEP, 0.15F, 1.0F);
   }

   protected float playFlySound(float volume) {
      this.playSound(SoundEvents.PARROT_FLY, 0.15F, 1.0F);
      return volume + this.flapSpeed / 2.0F;
   }

   protected boolean makeFlySound() {
      return true;
   }

   /**
    * Gets the pitch of living sounds in living entities.
    */
   public float getVoicePitch() {
      return getPitch(this.random);
   }

   public static float getPitch(Random random) {
      return (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F;
   }

   public SoundSource getSoundSource() {
      return SoundSource.NEUTRAL;
   }

   /**
    * Returns true if this entity should push and be pushed by other entities when colliding.
    */
   public boolean isPushable() {
      return true;
   }

   protected void doPush(Entity entityIn) {
      if (!(entityIn instanceof Player)) {
         super.doPush(entityIn);
      }
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean hurt(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         this.setOrderedToSit(false);
         return super.hurt(source, amount);
      }
   }

   public int getVariant() {
      return Mth.clamp(this.entityData.get(VARIANT), 0, 4);
   }

   public void setVariant(int variantIn) {
      this.entityData.set(VARIANT, variantIn);
   }

   protected void defineSynchedData() {
      super.defineSynchedData();
      this.entityData.define(VARIANT, 0);
   }

   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putInt("Variant", this.getVariant());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      this.setVariant(compound.getInt("Variant"));
   }

   public boolean isFlying() {
      return !this.onGround;
   }

   @OnlyIn(Dist.CLIENT)
   public Vec3 getLeashOffset() {
      return new Vec3(0.0D, (double)(0.5F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
   }
}
