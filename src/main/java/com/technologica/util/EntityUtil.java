package com.technologica.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import com.technologica.world.entity.decoration.InvisibleSeat;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityUtil {
	private static final Map<ResourceLocation, Map<BlockPos, Pair<InvisibleSeat, BlockPos>>> OCCUPIED = new HashMap<>();

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

	public static BlockPos getPreviousPlayerPosition(Player player, InvisibleSeat sitEntity) {
		Level level = player.level();
		if (!level.isClientSide) {
			ResourceLocation id = getDimensionTypeId(level);

			if (OCCUPIED.containsKey(id)) {
				for (Pair<InvisibleSeat, BlockPos> pair : OCCUPIED.get(id).values()) {
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