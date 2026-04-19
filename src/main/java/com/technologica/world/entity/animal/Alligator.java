package com.technologica.world.entity.animal;

import java.util.function.Predicate;

import com.technologica.world.entity.ai.goal.GoToLandGoal;
import com.technologica.world.entity.ai.goal.GoToWaterGoal;
import com.technologica.world.entity.ai.goal.LurkSurfaceGoal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;

public class Alligator extends Animal {
	private int landTime = 0;
	private int waterTime = 0;
	private boolean wantsLand = false;

	public Alligator(EntityType<? extends Alligator> entity, Level level) {
		super(entity, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 15.5F, 0.5F, false);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return AttributeSupplier.builder()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE)
				.add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(ForgeMod.SWIM_SPEED.get())
				.add(ForgeMod.NAMETAG_DISTANCE.get())
				.add(ForgeMod.ENTITY_GRAVITY.get());
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new RandomStrollGoal(this, 1.0F));
		this.goalSelector.addGoal(1, new GoToLandGoal(this));
		this.goalSelector.addGoal(1, new GoToWaterGoal(this));
		this.goalSelector.addGoal(1, new BreathAirGoal(this));
		this.goalSelector.addGoal(2, new LurkSurfaceGoal(this));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new FollowBoatGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TropicalFish.class, 10, true, true, (Predicate<LivingEntity>) null));
	}

	@Override
	protected float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
		return 0.5F;
	}

	@Override
	public void baseTick() {
		super.baseTick();


	}

	@Override
	public void tick() {
		super.tick();

		if (this.isInWater()) {
			waterTime++;
			landTime = 0;
			if (waterTime > 200 && this.random.nextFloat() < 0.002f) {
				wantsLand = true;
			}
		} else {
			landTime++;
			waterTime = 0;
			if (landTime > 200) {
				wantsLand = false;
			}
		}
	}

	public boolean wantsLand() {
		return wantsLand;
	}

	@Override
	public int getMaxAirSupply() {
		return 1200;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}

	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		return null;
	}
}
