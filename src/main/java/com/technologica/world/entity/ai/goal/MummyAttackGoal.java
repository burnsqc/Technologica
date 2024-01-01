package com.technologica.world.entity.ai.goal;

import com.technologica.world.entity.monster.Mummy;

import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class MummyAttackGoal extends MeleeAttackGoal {
   private final Mummy mummy;
   private int raiseArmTicks;

   public MummyAttackGoal(Mummy p_26019_, double p_26020_, boolean p_26021_) {
      super(p_26019_, p_26020_, p_26021_);
      this.mummy = p_26019_;
   }

   @Override
public void start() {
      super.start();
      this.raiseArmTicks = 0;
   }

   @Override
public void stop() {
      super.stop();
      this.mummy.setAggressive(false);
   }

   @Override
public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
         this.mummy.setAggressive(true);
      } else {
         this.mummy.setAggressive(false);
      }

   }
}