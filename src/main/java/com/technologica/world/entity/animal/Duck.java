package com.technologica.world.entity.animal;

import com.technologica.world.entity.TechnologicaEntityType;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class Duck extends Animal {
   private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.BREAD);
   public static final String EGG_LAY_TIME = "EggLayTime";
   private float wingRotation;
   private float destPos;
   private float oFlapSpeed;
   private float oFlap;
   private float wingRotDelta = 1.0F;
   private int timeUntilNextEgg = this.random.nextInt(6000) + 6000;

   public Duck(EntityType<Duck> type, Level worldIn) {
      super(type, worldIn);
      this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
   }

   //Register Attributes and Goals
   public static AttributeSupplier.Builder registerAttributes() {
      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
   }

   @Override
   protected void registerGoals() {
      this.goalSelector.addGoal(0, new FloatGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, TEMPTATION_ITEMS, false));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
   }

   //General properties
   @Override
   public boolean causeFallDamage(float p_148875_, float p_148876_, DamageSource p_148877_) {
	   return false;
   }

   //Spawning
   public Duck getBreedOffspring(ServerLevel serverWorldIn, AgeableMob ageableEntityIn) {
      return TechnologicaEntityType.DUCK.get().create(serverWorldIn);
   }

   //Animation
   @Override
   protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
      return this.isBaby() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
   }

   //Behavior
   @Override
   public void aiStep() {
      super.aiStep();
      this.oFlap = this.wingRotation;
      this.oFlapSpeed = this.destPos;
      this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);
      this.destPos = Mth.clamp(this.destPos, 0.0F, 1.0F);
      if (!this.onGround && this.wingRotDelta < 1.0F) {
         this.wingRotDelta = 1.0F;
      }
      this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.9D);
      Vec3 vector3d = this.getDeltaMovement();
      if (!this.onGround && vector3d.y < 0.0D) {
         this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
      }
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && --this.timeUntilNextEgg <= 0) {
         this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
         this.spawnAtLocation(Items.EGG);
         this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
      }
   }

   //Breeding
   @Override
   public boolean isFood(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }

   //Audio
   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.CHICKEN_AMBIENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.CHICKEN_HURT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.CHICKEN_DEATH;
   }

   @Override
   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
   }

   //NBT
   @Override
   public void readAdditionalSaveData(CompoundTag compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains(EGG_LAY_TIME)) {
         this.timeUntilNextEgg = compound.getInt(EGG_LAY_TIME);
      }
   }

   @Override
   public void addAdditionalSaveData(CompoundTag compound) {
      super.addAdditionalSaveData(compound);
      compound.putInt(EGG_LAY_TIME, this.timeUntilNextEgg);
   }

	public float getWingRotation() {
		return wingRotation;
	}

	public void setWingRotation(float wingRotation) {
		this.wingRotation = wingRotation;
	}

	public float getDestPos() {
		return destPos;
	}

	public void setDestPos(float destPos) {
		this.destPos = destPos;
	}

	public float getoFlapSpeed() {
		return oFlapSpeed;
	}

	public void setoFlapSpeed(float oFlapSpeed) {
		this.oFlapSpeed = oFlapSpeed;
	}

	public float getoFlap() {
		return oFlap;
	}

	public void setoFlap(float oFlap) {
		this.oFlap = oFlap;
	}

	public float getWingRotDelta() {
		return wingRotDelta;
	}

	public void setWingRotDelta(float wingRotDelta) {
		this.wingRotDelta = wingRotDelta;
	}

	public int getTimeUntilNextEgg() {
		return timeUntilNextEgg;
	}

	public void setTimeUntilNextEgg(int timeUntilNextEgg) {
		this.timeUntilNextEgg = timeUntilNextEgg;
	}
}
