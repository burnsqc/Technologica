package com.technologica.entity.passive;

import com.technologica.entity.TechnologicaEntityType;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TurkeyEntity extends AnimalEntity {
   private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
   public float wingRotation;
   public float destPos;
   public float oFlapSpeed;
   public float oFlap;
   public float wingRotDelta = 1.0F;
   public int timeUntilNextEgg = this.random.nextInt(6000) + 6000;
   public boolean chickenJockey;

   public TurkeyEntity(EntityType<? extends TurkeyEntity> type, World worldIn) {
      super(type, worldIn);
      this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
   }

   public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AttributeModifierMap.builder()
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE)
				.add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}
   
   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isBaby() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
   }

   public static AttributeModifierMap.MutableAttribute createAttributes() {
      return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void aiStep() {
      super.aiStep();
      this.oFlap = this.wingRotation;
      this.oFlapSpeed = this.destPos;
      this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
      this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
      if (!this.onGround && this.wingRotDelta < 1.0F) {
         this.wingRotDelta = 1.0F;
      }

      this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);
      Vector3d vector3d = this.getDeltaMovement();
      if (!this.onGround && vector3d.y < 0.0D) {
         this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
      }

      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && !this.isChickenJockey() && --this.timeUntilNextEgg <= 0) {
         this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
         this.spawnAtLocation(Items.EGG);
         this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
      }

   }

   public boolean causeFallDamage(float distance, float damageMultiplier) {
      return false;
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.CHICKEN_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.CHICKEN_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.CHICKEN_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
   }

   public TurkeyEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
      return TechnologicaEntityType.TURKEY.get().create(world);
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isFood(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }

   /**
    * Get the experience points the entity currently has.
    */
   protected int getExperienceReward(PlayerEntity player) {
      return this.isChickenJockey() ? 10 : super.getExperienceReward(player);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditionalSaveData(CompoundNBT compound) {
      super.readAdditionalSaveData(compound);
      this.chickenJockey = compound.getBoolean("IsChickenJockey");
      if (compound.contains("EggLayTime")) {
         this.timeUntilNextEgg = compound.getInt("EggLayTime");
      }
   }

   public void addAdditionalSaveData(CompoundNBT compound) {
      super.addAdditionalSaveData(compound);
      compound.putBoolean("IsChickenJockey", this.chickenJockey);
      compound.putInt("EggLayTime", this.timeUntilNextEgg);
   }

   public boolean removeWhenFarAway(double distanceToClosestPlayer) {
      return this.isChickenJockey();
   }

   public void positionRider(Entity passenger) {
      super.positionRider(passenger);
      float f = MathHelper.sin(this.yBodyRot * ((float)Math.PI / 180F));
      float f1 = MathHelper.cos(this.yBodyRot * ((float)Math.PI / 180F));
      passenger.setPos(this.getX() + (double)(0.1F * f), this.getY(0.5D) + passenger.getMyRidingOffset() + 0.0D, this.getZ() - (double)(0.1F * f1));
      if (passenger instanceof LivingEntity) {
         ((LivingEntity)passenger).yBodyRot = this.yBodyRot;
      }
   }

   /**
    * Determines if this chicken is a jokey with a zombie riding it.
    */
   public boolean isChickenJockey() {
      return this.chickenJockey;
   }

   /**
    * Sets whether this chicken is a jockey or not.
    */
   public void setChickenJockey(boolean jockey) {
      this.chickenJockey = jockey;
   }
}