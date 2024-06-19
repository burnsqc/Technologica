package com.technologica.world.level.material;

import java.util.function.Consumer;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

public class MoltenFluidType extends FluidType {

	public MoltenFluidType() {
		super(FluidType.Properties.create().descriptionId("block.technologica.molten").canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).lightLevel(15).density(3000).viscosity(6000).temperature(1300));
	}

	@Override
	public double motionScale(Entity entity) {
		return entity.level().dimensionType().ultraWarm() ? 0.007D : 0.0023333333333333335D;
	}

	@Override
	public void setItemMovement(ItemEntity entity) {
		Vec3 vec3 = entity.getDeltaMovement();
		entity.setDeltaMovement(vec3.x * 0.95F, vec3.y + (vec3.y < 0.06F ? 5.0E-4F : 0.0F), vec3.z * 0.95F);
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation MOLTEN_STILL = new TechnologicaLocation("block/molten_still"), MOLTEN_FLOW = new TechnologicaLocation("block/molten_flow");

			@Override
			public ResourceLocation getStillTexture() {
				return MOLTEN_STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return MOLTEN_FLOW;
			}
		});
	}
}
