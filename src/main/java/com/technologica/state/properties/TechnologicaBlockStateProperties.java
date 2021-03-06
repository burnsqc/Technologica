package com.technologica.state.properties;

import com.technologica.util.AnnunciatorOverlay;
import com.technologica.util.Radius;

import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.Direction;

public class TechnologicaBlockStateProperties {
	public static final DirectionProperty SUB_FACING = DirectionProperty.create("sub_facing", 
			Direction.NORTH,
			Direction.EAST, 
			Direction.SOUTH, 
			Direction.WEST, 
			Direction.UP, 
			Direction.DOWN);
	public static final EnumProperty<Radius> RADIUS = EnumProperty.create("radius", Radius.class);
	public static final EnumProperty<AnnunciatorOverlay> ANNUNCIATOR_OVERLAY = EnumProperty.create("annunciator_overlay", AnnunciatorOverlay.class);
}