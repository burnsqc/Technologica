package com.technologica.world.level.block.entity;

import java.util.List;

import com.technologica.world.effect.TechnologicaMobEffects;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.entity.monster.AtomicCreeper;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.RadioactiveOreBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

public class RadioactiveOreBlockEntity extends BlockEntity {

	public RadioactiveOreBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.RADIOACTIVE_ORE_BLOCK_ENTITY.get(), p_155700_, p_155701_);
	}

	public void serverTick(Level level, BlockState blockStateIn) {
		if (blockStateIn.getValue(RadioactiveOreBlock.LIT)) {
			applyRadiation(level, worldPosition);
		}
	}

	private void applyRadiation(Level p_221914_, BlockPos p_221915_) {
		AABB mbb = new AABB(p_221915_);
		AABB aabb = mbb.inflate(4.0D, 4.0D, 4.0D);
		List<LivingEntity> list = p_221914_.getEntitiesOfClass(LivingEntity.class, aabb);
		if (!list.isEmpty()) {
			MobEffect mobeffect = TechnologicaMobEffects.RADIATION.get();
			MobEffectInstance instance = new MobEffectInstance(mobeffect, 1200, 0);
			instance.setCurativeItems(List.of(new ItemStack(TechnologicaItems.IODINE_PILL.get())));
			for (LivingEntity livingentity : list) {
				if (!(livingentity instanceof AtomicCreeper)) {
					if (livingentity instanceof Creeper) {
						AtomicCreeper atomicCreeper = new AtomicCreeper(TechnologicaEntityType.ATOMIC_CREEPER.get(), p_221914_);
						atomicCreeper.moveTo(livingentity.getX(), livingentity.getY(), livingentity.getZ());
						livingentity.setRemoved(Entity.RemovalReason.DISCARDED);
						p_221914_.addFreshEntity(atomicCreeper);
					} else if (livingentity instanceof Player) {
						Player player = (Player) livingentity;
						boolean fullHazmatSuit = true;
						Iterable<ItemStack> armor = player.getArmorSlots();

						for (ItemStack piece : armor) {
							if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("hazmat")) {
								fullHazmatSuit = false;
							}
						}
						
						if (!fullHazmatSuit) {
							livingentity.addEffect(instance);
						}
					} else {
						livingentity.addEffect(instance);
					}
				}
			}
		}
	}
}