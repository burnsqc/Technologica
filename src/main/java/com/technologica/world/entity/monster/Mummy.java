package com.technologica.world.entity.monster;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.world.entity.ai.goal.MummyAttackGoal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class Mummy extends Zombie {
	private static final UUID SPEED_MODIFIER_BABY_UUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final AttributeModifier SPEED_MODIFIER_BABY = new AttributeModifier(SPEED_MODIFIER_BABY_UUID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
	private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(Mummy.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_SPECIAL_TYPE_ID = SynchedEntityData.defineId(Mummy.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_DROWNED_CONVERSION_ID = SynchedEntityData.defineId(Mummy.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_PARALYZE_COOLDOWN = SynchedEntityData.defineId(Mummy.class, EntityDataSerializers.INT);
	
	
	
	
	private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (p_34284_) -> {
		return p_34284_ == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
	private boolean canBreakDoors;
	private int inWaterTime;
	private int conversionTime;

	public Mummy(EntityType<? extends Mummy> p_34271_, Level p_34272_) {
		super(p_34271_, p_34272_);
	}

	public Mummy(Level p_34274_) {
		this(TechnologicaEntityTypes.MUMMY.get(), p_34274_);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new MummyParalyzeWhenLookedAt(this));
		this.goalSelector.addGoal(4, new Mummy.ZombieAttackTurtleEggGoal(this, 1.0D, 3));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.addBehaviourGoals();
	}

	@Override
	protected void addBehaviourGoals() {
		this.goalSelector.addGoal(2, new MummyAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, 0.23F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(DATA_BABY_ID, false);
		this.getEntityData().define(DATA_SPECIAL_TYPE_ID, 0);
		this.getEntityData().define(DATA_DROWNED_CONVERSION_ID, false);
		this.getEntityData().define(DATA_PARALYZE_COOLDOWN, 0);
	}

	@Override
	public boolean isUnderWaterConverting() {
		return this.getEntityData().get(DATA_DROWNED_CONVERSION_ID);
	}

	@Override
	public boolean canBreakDoors() {
		return this.canBreakDoors;
	}

	public void setParalyzeCooldown(int cooldown) {
		this.getEntityData().set(DATA_PARALYZE_COOLDOWN, cooldown);
	}

	public int getParalyzeCooldown() {
		return this.getEntityData().get(DATA_PARALYZE_COOLDOWN);
	}

	@Override
	public void setCanBreakDoors(boolean p_34337_) {
		if (this.supportsBreakDoorGoal() && GoalUtils.hasGroundPathNavigation(this)) {
			if (this.canBreakDoors != p_34337_) {
				this.canBreakDoors = p_34337_;
				((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(p_34337_);
				if (p_34337_) {
					this.goalSelector.addGoal(1, this.breakDoorGoal);
				} else {
					this.goalSelector.removeGoal(this.breakDoorGoal);
				}
			}
		} else if (this.canBreakDoors) {
			this.goalSelector.removeGoal(this.breakDoorGoal);
			this.canBreakDoors = false;
		}

	}

	@Override
	protected boolean supportsBreakDoorGoal() {
		return true;
	}

	@Override
	public boolean isBaby() {
		return this.getEntityData().get(DATA_BABY_ID);
	}

	@Override
	public int getExperienceReward() {
		if (this.isBaby()) {
			this.xpReward = (int) (this.xpReward * 2.5D);
		}

		return super.getExperienceReward();
	}

	@Override
	public void setBaby(boolean p_34309_) {
		this.getEntityData().set(DATA_BABY_ID, p_34309_);
		if (this.level() != null && !this.level().isClientSide) {
			AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
			attributeinstance.removeModifier(SPEED_MODIFIER_BABY_UUID);
			if (p_34309_) {
				attributeinstance.addTransientModifier(SPEED_MODIFIER_BABY);
			}
		}

	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> p_34307_) {
		if (DATA_BABY_ID.equals(p_34307_)) {
			this.refreshDimensions();
		}

		super.onSyncedDataUpdated(p_34307_);
	}

	@Override
	protected boolean convertsInWater() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();
		int cooldown = this.getEntityData().get(DATA_PARALYZE_COOLDOWN);
		this.getEntityData().set(DATA_PARALYZE_COOLDOWN, Math.max(0, --cooldown));
	}

	@Override
	public void aiStep() {
		if (this.isAlive()) {
			boolean flag = this.isSunSensitive() && this.isSunBurnTick();
			if (flag) {
				ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
				if (!itemstack.isEmpty()) {
					if (itemstack.isDamageableItem()) {
						itemstack.setDamageValue(itemstack.getDamageValue() + this.random.nextInt(2));
						if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
							this.broadcastBreakEvent(EquipmentSlot.HEAD);
							this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
						}
					}

					flag = false;
				}

				if (flag) {
					this.setSecondsOnFire(8);
				}
			}
		}

		super.aiStep();
	}

	private void startUnderWaterConversion(int p_34279_) {
		this.conversionTime = p_34279_;
		this.getEntityData().set(DATA_DROWNED_CONVERSION_ID, true);
	}

	@Override
	protected boolean isSunSensitive() {
		return true;
	}

	@Override
	public boolean hurt(DamageSource p_34288_, float p_34289_) {
		if (!super.hurt(p_34288_, p_34289_)) {
			return false;
		} else if (!(this.level() instanceof ServerLevel)) {
			return false;
		} else {
			LivingEntity livingentity = this.getTarget();
			if (livingentity == null && p_34288_.getEntity() instanceof LivingEntity) {
				livingentity = (LivingEntity) p_34288_.getEntity();
			}
			return true;
		}
	}

	@Override
	public boolean doHurtTarget(Entity p_34276_) {
		boolean flag = super.doHurtTarget(p_34276_);
		if (flag) {
			float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
			if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < f * 0.3F) {
				p_34276_.setSecondsOnFire(2 * (int) f);
			}
		}

		return flag;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ZOMBIE_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_34327_) {
		return SoundEvents.ZOMBIE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ZOMBIE_DEATH;
	}

	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.ZOMBIE_STEP;
	}

	@Override
	protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_219165_, DifficultyInstance p_219166_) {
		super.populateDefaultEquipmentSlots(p_219165_, p_219166_);
		if (p_219165_.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
			int i = p_219165_.nextInt(3);
			if (i == 0) {
				this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
			} else {
				this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
			}
		}

	}

	@Override
	public void addAdditionalSaveData(CompoundTag p_34319_) {
		super.addAdditionalSaveData(p_34319_);
		p_34319_.putBoolean("IsBaby", this.isBaby());
		p_34319_.putBoolean("CanBreakDoors", this.canBreakDoors());
		p_34319_.putInt("InWaterTime", this.isInWater() ? this.inWaterTime : -1);
		p_34319_.putInt("DrownedConversionTime", this.isUnderWaterConverting() ? this.conversionTime : -1);
		p_34319_.putInt("ParalyzeCooldown", this.getParalyzeCooldown());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag p_34305_) {
		super.readAdditionalSaveData(p_34305_);
		this.setBaby(p_34305_.getBoolean("IsBaby"));
		this.setCanBreakDoors(p_34305_.getBoolean("CanBreakDoors"));
		this.inWaterTime = p_34305_.getInt("InWaterTime");
		if (p_34305_.contains("DrownedConversionTime", 99) && p_34305_.getInt("DrownedConversionTime") > -1) {
			this.startUnderWaterConversion(p_34305_.getInt("DrownedConversionTime"));
		}
		if (p_34305_.contains("ParalyzeCooldown", 99) && p_34305_.getInt("ParalyzeCooldown") > -1) {
			this.setParalyzeCooldown(p_34305_.getInt("ParalyzeCooldown"));
		}
	}

	@Override
	public boolean killedEntity(ServerLevel p_219160_, LivingEntity p_219161_) {
		boolean flag = super.killedEntity(p_219160_, p_219161_);
		if ((p_219160_.getDifficulty() == Difficulty.NORMAL || p_219160_.getDifficulty() == Difficulty.HARD) && p_219161_ instanceof Villager villager && net.minecraftforge.event.ForgeEventFactory.canLivingConvert(p_219161_, EntityType.ZOMBIE_VILLAGER, (timer) -> {
		})) {
			if (p_219160_.getDifficulty() != Difficulty.HARD && this.random.nextBoolean()) {
				return flag;
			}

			ZombieVillager zombievillager = villager.convertTo(EntityType.ZOMBIE_VILLAGER, false);
			if (zombievillager != null) {
				zombievillager.finalizeSpawn(p_219160_, p_219160_.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true), (CompoundTag) null);
				zombievillager.setVillagerData(villager.getVillagerData());
				zombievillager.setGossips(villager.getGossips().store(NbtOps.INSTANCE));
				zombievillager.setTradeOffers(villager.getOffers().createTag());
				zombievillager.setVillagerXp(villager.getVillagerXp());
				net.minecraftforge.event.ForgeEventFactory.onLivingConvert(p_219161_, zombievillager);
				if (!this.isSilent()) {
					p_219160_.levelEvent((Player) null, 1026, this.blockPosition(), 0);
				}

				flag = false;
			}
		}

		return flag;
	}

	@Override
	protected float getStandingEyeHeight(Pose p_34313_, EntityDimensions p_34314_) {
		return this.isBaby() ? 0.93F : 1.74F;
	}

	@Override
	public boolean canHoldItem(ItemStack p_34332_) {
		return p_34332_.is(Items.EGG) && this.isBaby() && this.isPassenger() ? false : super.canHoldItem(p_34332_);
	}

	@Override
	public boolean wantsToPickUp(ItemStack p_182400_) {
		return p_182400_.is(Items.GLOW_INK_SAC) ? false : super.wantsToPickUp(p_182400_);
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_, @Nullable CompoundTag p_34301_) {
		RandomSource randomsource = p_34297_.getRandom();
		p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_, p_34301_);
		float f = p_34298_.getSpecialMultiplier();
		this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * f);
		if (p_34300_ == null) {
			p_34300_ = new Mummy.ZombieGroupData(getSpawnAsBabyOdds(randomsource), true);
		}

		if (p_34300_ instanceof Mummy.ZombieGroupData zombie$zombiegroupdata) {
			if (zombie$zombiegroupdata.isBaby) {
				this.setBaby(true);
				if (zombie$zombiegroupdata.canSpawnJockey) {
					if (randomsource.nextFloat() < 0.05D) {
						List<Chicken> list = p_34297_.getEntitiesOfClass(Chicken.class, this.getBoundingBox().inflate(5.0D, 3.0D, 5.0D), EntitySelector.ENTITY_NOT_BEING_RIDDEN);
						if (!list.isEmpty()) {
							Chicken chicken = list.get(0);
							chicken.setChickenJockey(true);
							this.startRiding(chicken);
						}
					} else if (randomsource.nextFloat() < 0.05D) {
						Chicken chicken1 = EntityType.CHICKEN.create(this.level());
						chicken1.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						chicken1.finalizeSpawn(p_34297_, p_34298_, MobSpawnType.JOCKEY, (SpawnGroupData) null, (CompoundTag) null);
						chicken1.setChickenJockey(true);
						this.startRiding(chicken1);
						p_34297_.addFreshEntity(chicken1);
					}
				}
			}

			this.setCanBreakDoors(this.supportsBreakDoorGoal() && randomsource.nextFloat() < f * 0.1F);
			this.populateDefaultEquipmentSlots(randomsource, p_34298_);
			this.populateDefaultEquipmentEnchantments(randomsource, p_34298_);
		}

		if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
			LocalDate localdate = LocalDate.now();
			int i = localdate.get(ChronoField.DAY_OF_MONTH);
			int j = localdate.get(ChronoField.MONTH_OF_YEAR);
			if (j == 10 && i == 31 && randomsource.nextFloat() < 0.25F) {
				this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(randomsource.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
				this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
			}
		}

		this.handleAttributes(f);
		return p_34300_;
	}

	public static boolean getSpawnAsBabyOdds(RandomSource p_219163_) {
		return p_219163_.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get();
	}

	@Override
	protected void handleAttributes(float p_34340_) {
		this.randomizeReinforcementsChance();
		this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addPermanentModifier(new AttributeModifier("Random spawn bonus", this.random.nextDouble() * 0.05F, AttributeModifier.Operation.ADDITION));
		double d0 = this.random.nextDouble() * 1.5D * p_34340_;
		if (d0 > 1.0D) {
			this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random zombie-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}

		if (this.random.nextFloat() < p_34340_ * 0.05F) {
			this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).addPermanentModifier(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 0.25D + 0.5D, AttributeModifier.Operation.ADDITION));
			this.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(new AttributeModifier("Leader zombie bonus", this.random.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
			this.setCanBreakDoors(this.supportsBreakDoorGoal());
		}

	}

	@Override
	protected void randomizeReinforcementsChance() {
		this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(this.random.nextDouble() * net.minecraftforge.common.ForgeConfig.SERVER.zombieBaseSummonChance.get());
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource p_34291_, int p_34292_, boolean p_34293_) {
		super.dropCustomDeathLoot(p_34291_, p_34292_, p_34293_);
		Entity entity = p_34291_.getEntity();
		if (entity instanceof Creeper creeper) {
			if (creeper.canDropMobsSkull()) {
				ItemStack itemstack = this.getSkull();
				if (!itemstack.isEmpty()) {
					creeper.increaseDroppedSkulls();
					this.spawnAtLocation(itemstack);
				}
			}
		}

	}

	@Override
	protected ItemStack getSkull() {
		return new ItemStack(Items.ZOMBIE_HEAD);
	}

	class ZombieAttackTurtleEggGoal extends RemoveBlockGoal {
		ZombieAttackTurtleEggGoal(PathfinderMob p_34344_, double p_34345_, int p_34346_) {
			super(Blocks.TURTLE_EGG, p_34344_, p_34345_, p_34346_);
		}

		@Override
		public void playDestroyProgressSound(LevelAccessor p_34351_, BlockPos p_34352_) {
			p_34351_.playSound((Player) null, p_34352_, SoundEvents.ZOMBIE_DESTROY_EGG, SoundSource.HOSTILE, 0.5F, 0.9F + Mummy.this.random.nextFloat() * 0.2F);
		}

		@Override
		public void playBreakSound(Level p_34348_, BlockPos p_34349_) {
			p_34348_.playSound((Player) null, p_34349_, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + p_34348_.random.nextFloat() * 0.2F);
		}

		@Override
		public double acceptedDistance() {
			return 1.14D;
		}
	}

	public static class ZombieGroupData implements SpawnGroupData {
		public final boolean isBaby;
		public final boolean canSpawnJockey;

		public ZombieGroupData(boolean p_34357_, boolean p_34358_) {
			this.isBaby = p_34357_;
			this.canSpawnJockey = p_34358_;
		}
	}

	static class MummyParalyzeWhenLookedAt extends Goal {
		private final Mummy enderman;
		@Nullable
		private LivingEntity target;

		public MummyParalyzeWhenLookedAt(Mummy p_32550_) {
			this.enderman = p_32550_;
			this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		@Override
		public boolean canUse() {
			this.target = this.enderman.getTarget();
			if (!(this.target instanceof Player)) {
				return false;
			} else {
				double d0 = this.target.distanceToSqr(this.enderman);
				boolean stare = this.enderman.isLookingAtMe((Player) this.target);
				if (stare && enderman.getParalyzeCooldown() == 0) {
					this.target.addEffect(new MobEffectInstance(TechnologicaMobEffects.PARALYSIS.get(), 100, 0));
					enderman.setParalyzeCooldown(200);
				}
				return d0 > 256.0D ? false : this.enderman.isLookingAtMe((Player) this.target);
			}
		}

		@Override
		public void start() {
			this.enderman.getNavigation().stop();
		}

		@Override
		public void tick() {
			this.enderman.getLookControl().setLookAt(this.target.getX(), this.target.getEyeY(), this.target.getZ());
		}
	}

	boolean isLookingAtMe(Player p_32535_) {
		Vec3 vec3 = p_32535_.getViewVector(1.0F).normalize();
		Vec3 vec31 = new Vec3(this.getX() - p_32535_.getX(), this.getEyeY() - p_32535_.getEyeY(), this.getZ() - p_32535_.getZ());
		double d0 = vec31.length();
		vec31 = vec31.normalize();
		double d1 = vec3.dot(vec31);
		return d1 > 1.0D - 0.025D / d0 ? p_32535_.hasLineOfSight(this) : false;

	}
}
