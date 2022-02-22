package com.technologica.entity.passive;

import com.technologica.entity.TechnologicaEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
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

public class DuckEntity extends AnimalEntity {
   private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.BREAD);
   public static final String EGG_LAY_TIME = "EggLayTime";
   private float wingRotation;
   private float destPos;
   private float oFlapSpeed;
   private float oFlap;
   private float wingRotDelta = 1.0F;
   private int timeUntilNextEgg = this.random.nextInt(6000) + 6000;

   public DuckEntity(EntityType<DuckEntity> type, World worldIn) {
      super(type, worldIn);
      this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
   }

   //Register Attributes and Goals
   public static AttributeModifierMap.MutableAttribute registerAttributes() {
      return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
   }

   @Override
   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
   }

   //General properties
   @Override
   public boolean causeFallDamage(float distance, float damageMultiplier) {
      return false;
   }

   //Spawning
   public DuckEntity getBreedOffspring(ServerWorld serverWorldIn, AgeableEntity ageableEntityIn) {
      return TechnologicaEntityType.DUCK.get().create(serverWorldIn);
   }

   //Animation
   @Override
   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isBaby() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
   }

   //Behavior
   @Override
   public void aiStep() {
      super.aiStep();
      this.oFlap = this.wingRotation;
      this.oFlapSpeed = this.destPos;
      this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);
      this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
      if (!this.onGround && this.wingRotDelta < 1.0F) {
         this.wingRotDelta = 1.0F;
      }
      this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.9D);
      Vector3d vector3d = this.getDeltaMovement();
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
   public void readAdditionalSaveData(CompoundNBT compound) {
      super.readAdditionalSaveData(compound);
      if (compound.contains(EGG_LAY_TIME)) {
         this.timeUntilNextEgg = compound.getInt(EGG_LAY_TIME);
      }
   }

   @Override
   public void addAdditionalSaveData(CompoundNBT compound) {
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
