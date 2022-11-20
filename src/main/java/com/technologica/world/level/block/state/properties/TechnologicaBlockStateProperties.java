package com.technologica.world.level.block.state.properties;

import com.technologica.util.AnnunciatorOverlay;
import com.technologica.util.MiddleEnd;
import com.technologica.util.Radius;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class TechnologicaBlockStateProperties {
	public static final DirectionProperty SUB_FACING = DirectionProperty.create("sub_facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
	public static final EnumProperty<Radius> RADIUS = EnumProperty.create("radius", Radius.class);
	public static final EnumProperty<MiddleEnd> MIDDLE_END = EnumProperty.create("middle_end", MiddleEnd.class);
	public static final EnumProperty<AnnunciatorOverlay> ANNUNCIATOR_OVERLAY = EnumProperty.create("annunciator_overlay", AnnunciatorOverlay.class);
}