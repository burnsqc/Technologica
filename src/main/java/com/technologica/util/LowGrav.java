package com.technologica.util;

import java.util.stream.Stream;

import net.minecraft.entity.Entity;
import net.minecraft.util.ReuseableStream;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LowGrav {
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {

		Entity entity = event.getEntity();

		if (entity.world.getDimensionKey().toString().contains("technologica:moon")) {

			Vector3d vec = entity.getMotion();

			AxisAlignedBB axisalignedbb = entity.getBoundingBox();
			ISelectionContext iselectioncontext = ISelectionContext.forEntity(entity);
			VoxelShape voxelshape = entity.world.getWorldBorder().getShape();
			Stream<VoxelShape> stream = VoxelShapes.compare(voxelshape, VoxelShapes.create(axisalignedbb.shrink(1.0E-7D)), IBooleanFunction.AND) ? Stream.empty() : Stream.of(voxelshape);
			Stream<VoxelShape> stream1 = entity.world.func_230318_c_(entity, axisalignedbb.expand(vec), (entity1) -> {
				return true;
			});
			ReuseableStream<VoxelShape> reuseablestream = new ReuseableStream<>(Stream.concat(stream1, stream));

			Vector3d vector3d = vec.lengthSquared() == 0.0D ? vec: Entity.collideBoundingBoxHeuristically(entity, vec, axisalignedbb, entity.world, iselectioncontext, reuseablestream);
			boolean flag = vec.x != vector3d.x;
			boolean flag1 = vec.y != vector3d.y;
			boolean flag2 = vec.z != vector3d.z;
			boolean flag3 = entity.isOnGround() || flag1 && vec.y < 0.0D;

			if (!(entity.stepHeight > 0.0F && flag3 && (flag || flag2))) {
				event.getEntity().addVelocity(0, 1, 0);
				event.getEntity().velocityChanged = true;
			}
		}
	}

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.getEntity().world.getDimensionKey().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}