package com.technologica.world.item;

import java.util.List;
import java.util.function.Predicate;

import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class VanillaBoatItem extends Item {
	   private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
	   private final VanillaBoat.Type type;

	   public VanillaBoatItem(VanillaBoat.Type typeIn, Item.Properties properties) {
	      super(properties);
	      this.type = typeIn;
	   }

	   public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
	      ItemStack itemstack = playerIn.getItemInHand(handIn);
	      HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.ANY);
	      if (raytraceresult.getType() == HitResult.Type.MISS) {
	         return InteractionResultHolder.pass(itemstack);
	      } else {
	         Vec3 vector3d = playerIn.getViewVector(1.0F);
	         List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
	         if (!list.isEmpty()) {
	            Vec3 vector3d1 = playerIn.getEyePosition(1.0F);

	            for(Entity entity : list) {
	               AABB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
	               if (axisalignedbb.contains(vector3d1)) {
	                  return InteractionResultHolder.pass(itemstack);
	               }
	            }
	         }

	         if (raytraceresult.getType() == HitResult.Type.BLOCK) {
	            VanillaBoat modBoatEntity = new VanillaBoat(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
	            modBoatEntity.setBoatType(this.type);
	            modBoatEntity.setYRot(playerIn.getYRot());
	            if (!worldIn.noCollision(modBoatEntity, modBoatEntity.getBoundingBox().inflate(-0.1D))) {
	               return InteractionResultHolder.fail(itemstack);
	            } else {
	               if (!worldIn.isClientSide) {
	                  worldIn.addFreshEntity(modBoatEntity);
	                  if (!playerIn.getAbilities().instabuild) {
	                     itemstack.shrink(1);
	                  }
	               }

	               playerIn.awardStat(Stats.ITEM_USED.get(this));
	               return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
	            }
	         } else {
	            return InteractionResultHolder.pass(itemstack);
	         }
	      }
	   }
	}