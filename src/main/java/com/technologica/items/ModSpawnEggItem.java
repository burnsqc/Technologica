package com.technologica.items;

import java.util.Objects;

import com.technologica.entity.passive.DuckEntity;
import com.technologica.setup.ModSetup;
import com.technologica.setup.Registration;

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

public class ModSpawnEggItem extends Item {

    public ModSpawnEggItem() {
        super(new Item.Properties().maxStackSize(1).group(ModSetup.TECHNOLOGICA_FLORA));
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
           if (blockstate.isIn(Blocks.SPAWNER)) {
              TileEntity tileentity = world.getTileEntity(blockpos);
              if (tileentity instanceof MobSpawnerTileEntity) {
                 AbstractSpawner abstractspawner = ((MobSpawnerTileEntity)tileentity).getSpawnerBaseLogic();
                 EntityType<DuckEntity> entitytype1 = Registration.DUCK.get();
                 abstractspawner.setEntityType(entitytype1);
                 tileentity.markDirty();
                 world.notifyBlockUpdate(blockpos, blockstate, blockstate, 3);
                 itemstack.shrink(1);
                 return ActionResultType.CONSUME;
              }
           }

           BlockPos blockpos1;
           if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
              blockpos1 = blockpos;
           } else {
              blockpos1 = blockpos.offset(direction);
           }

           EntityType<DuckEntity> entitytype = Registration.DUCK.get();
           if (entitytype.spawn((ServerWorld)world, itemstack, context.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
              itemstack.shrink(1);
           }

           return ActionResultType.CONSUME;
        }
     }

}
