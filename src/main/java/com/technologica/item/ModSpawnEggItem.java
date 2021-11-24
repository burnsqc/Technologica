package com.technologica.item;

import java.util.Objects;
import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.fml.RegistryObject;

public class ModSpawnEggItem extends Item {
	private Supplier<? extends EntityType<?>> entityType;
	
	public ModSpawnEggItem(RegistryObject<? extends EntityType<?>> entityTypeIn) {
		super(new Item.Properties().maxStackSize(1).group(TechnologicaItemGroup.FAUNA));
		entityType = entityTypeIn;
	}

	@Override
    public ActionResultType onItemUse(ItemUseContext context) {
    	World world = context.getWorld();
        if (!(world instanceof ServerWorld)) {
           return ActionResultType.SUCCESS;
        } else {
           ItemStack itemstack = context.getItem();
           BlockPos blockpos = context.getPos();
           Direction direction = context.getFace();
           BlockState blockstate = world.getBlockState(blockpos);
           
		if (blockstate.matchesBlock(Blocks.SPAWNER)) {
              TileEntity tileentity = world.getTileEntity(blockpos);
              if (tileentity instanceof MobSpawnerTileEntity) {
                 AbstractSpawner abstractspawner = ((MobSpawnerTileEntity)tileentity).getSpawnerBaseLogic();
                 if (entityType != null) {
                    abstractspawner.setEntityType(entityType.get());
                 }
                 tileentity.markDirty();
                 world.notifyBlockUpdate(blockpos, blockstate, blockstate, 3);
                 itemstack.shrink(1);
                 return ActionResultType.CONSUME;
              }
           }

           BlockPos blockpos1;
           if (blockstate.getCollisionShapeUncached(world, blockpos).isEmpty()) {
              blockpos1 = blockpos;
           } else {
              blockpos1 = blockpos.offset(direction);
           }

           
           if (entityType != null && entityType.get().spawn((ServerWorld)world, itemstack, context.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
              itemstack.shrink(1);
           }

           return ActionResultType.CONSUME;
        }
     }

}
