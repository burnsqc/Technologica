package com.technologica.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import com.technologica.entity.item.InvisibleSeatEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityUtil {

	private static final Map<ResourceLocation, Map<BlockPos, Pair<InvisibleSeatEntity, BlockPos>>> OCCUPIED = new HashMap<>();

	public static boolean addSitEntity(World world, BlockPos blockPos, InvisibleSeatEntity entity, BlockPos playerPos) {
		if (!world.isRemote) {
			ResourceLocation id = getDimensionTypeId(world);

			if (!OCCUPIED.containsKey(id))
				OCCUPIED.put(id, new HashMap<>());

			OCCUPIED.get(id).put(blockPos, Pair.of(entity, playerPos));
			return true;
		}

		return false;
	}

	public static boolean removeSitEntity(World world, BlockPos pos) {
		if (!world.isRemote) {
			ResourceLocation id = getDimensionTypeId(world);

			if (OCCUPIED.containsKey(id)) {
				OCCUPIED.get(id).remove(pos);
				return true;
			}
		}

		return false;
	}

	public static InvisibleSeatEntity getSitEntity(World world, BlockPos pos) {
		if (!world.isRemote) {
			ResourceLocation id = getDimensionTypeId(world);

			if (OCCUPIED.containsKey(id) && OCCUPIED.get(id).containsKey(pos))
				return OCCUPIED.get(id).get(pos).getLeft();
		}

		return null;
	}
	
	public static BlockPos getPreviousPlayerPosition(PlayerEntity player, InvisibleSeatEntity sitEntity) {
		if (!player.world.isRemote) {
			ResourceLocation id = getDimensionTypeId(player.world);

			if (OCCUPIED.containsKey(id)) {
				for (Pair<InvisibleSeatEntity, BlockPos> pair : OCCUPIED.get(id).values()) {
					if (pair.getLeft() == sitEntity)
						return pair.getRight();
				}
			}
		}

		return null;
	}

	public static boolean isOccupied(World world, BlockPos pos) {
		ResourceLocation id = getDimensionTypeId(world);

		return EntityUtil.OCCUPIED.containsKey(id) && EntityUtil.OCCUPIED.get(id).containsKey(pos);
	}

	public static boolean isPlayerSitting(PlayerEntity player) {
		for (ResourceLocation i : OCCUPIED.keySet()) {
			for (Pair<InvisibleSeatEntity, BlockPos> pair : OCCUPIED.get(i).values()) {
				if (pair.getLeft().isPassenger(player))
					return true;
			}
		}

		return false;
	}

	private static ResourceLocation getDimensionTypeId(World world) {
		return world.getDimensionKey().getLocation();
	}
}