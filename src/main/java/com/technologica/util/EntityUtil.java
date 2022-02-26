package com.technologica.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import com.technologica.world.entity.decoration.InvisibleSeatEntity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class EntityUtil {
	private static final Map<ResourceLocation, Map<BlockPos, Pair<InvisibleSeatEntity, BlockPos>>> OCCUPIED = new HashMap<>();

	public static boolean removeInvisibleSeatEntity(Level world, BlockPos pos) {
		if (!world.isClientSide) {
			ResourceLocation id = getDimensionTypeId(world);

			if (OCCUPIED.containsKey(id)) {
				OCCUPIED.get(id).remove(pos);
				return true;
			}
		}

		return false;
	}

	public static BlockPos getPreviousPlayerPosition(Player player, InvisibleSeatEntity sitEntity) {
		if (!player.level.isClientSide) {
			ResourceLocation id = getDimensionTypeId(player.level);

			if (OCCUPIED.containsKey(id)) {
				for (Pair<InvisibleSeatEntity, BlockPos> pair : OCCUPIED.get(id).values()) {
					if (pair.getLeft() == sitEntity)
						return pair.getRight();
				}
			}
		}

		return null;
	}

	private static ResourceLocation getDimensionTypeId(Level world) {
		return world.dimension().location();
	}
}