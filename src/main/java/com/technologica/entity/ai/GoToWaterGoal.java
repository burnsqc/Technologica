package com.technologica.entity.ai;

import java.util.EnumSet;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class GoToWaterGoal extends Goal {
      private final CreatureEntity field_204730_a;
      private double field_204731_b;
      private double field_204732_c;
      private double field_204733_d;
      private final double field_204734_e;
      private final World field_204735_f;

      public GoToWaterGoal(CreatureEntity p_i48910_1_, double p_i48910_2_) {
         this.field_204730_a = p_i48910_1_;
         this.field_204734_e = p_i48910_2_;
         this.field_204735_f = p_i48910_1_.world;
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      public boolean shouldExecute() {
         if (!this.field_204735_f.isDaytime()) {
            return false;
         } else if (this.field_204730_a.isInWater()) {
            return false;
         } else {
            Vector3d vector3d = this.func_204729_f();
            if (vector3d == null) {
               return false;
            } else {
               this.field_204731_b = vector3d.x;
               this.field_204732_c = vector3d.y;
               this.field_204733_d = vector3d.z;
               return true;
            }
         }
      }

      public boolean shouldContinueExecuting() {
         return !this.field_204730_a.getNavigator().noPath();
      }

      public void startExecuting() {
         this.field_204730_a.getNavigator().tryMoveToXYZ(this.field_204731_b, this.field_204732_c, this.field_204733_d, this.field_204734_e);
      }

      @Nullable
      private Vector3d func_204729_f() {
         Random random = this.field_204730_a.getRNG();
         BlockPos blockpos = this.field_204730_a.getPosition();

         for(int i = 0; i < 10; ++i) {
            BlockPos blockpos1 = blockpos.add(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
            if (this.field_204735_f.getBlockState(blockpos1).matchesBlock(Blocks.WATER)) {
               return Vector3d.copyCenteredHorizontally(blockpos1);
            }
         }

         return null;
      }
   }