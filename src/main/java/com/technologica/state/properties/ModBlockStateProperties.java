package com.technologica.state.properties;

import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;

public class ModBlockStateProperties {
	public static final DirectionProperty SUB_FACING = DirectionProperty.create("sub_facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
}
