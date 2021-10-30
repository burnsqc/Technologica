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

	public static boolean removeInvisibleSeatEntity(World world, BlockPos pos) {
		if (!world.isRemote) {
			ResourceLocation id = getDimensionTypeId(world);

			if (OCCUPIED.containsKey(id)) {
				OCCUPIED.get(id).remove(pos);
				return true;
			}
		}

		return false;
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

	private static ResourceLocation getDimensionTypeId(World world) {
		return world.getDimensionKey().getLocation();
	}
}