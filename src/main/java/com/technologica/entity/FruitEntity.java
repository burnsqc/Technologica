package com.technologica.entity;

import com.technologica.setup.Registration;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class FruitEntity extends ProjectileItemEntity {
   public FruitEntity(EntityType<? extends FruitEntity> p_i50152_1_, World world) {
      super(p_i50152_1_, world);
   }

   public FruitEntity(World worldIn, double x, double y, double z) {
      super(EntityType.EXPERIENCE_BOTTLE, x, y, z, worldIn);
   }

   protected Item getDefaultItem() {
      return Registration.BANANA.get();
   }

   protected void onImpact(RayTraceResult result) {
      super.onImpact(result);
      if (!this.world.isRemote) {
         this.world.playEvent(2002, this.getPosition(), PotionUtils.getPotionColor(Potions.WATER));
         int i = 3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5);

         while(i > 0) {
//            int j = ExperienceOrbEntity.getXPSplit(i);
//            i -= j;
//            this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), j));
         }

         this.remove();
      }

   }
}
