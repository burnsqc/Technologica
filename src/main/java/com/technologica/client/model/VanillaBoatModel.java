package com.technologica.client.model;

import com.google.common.collect.ImmutableList;
import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;

public class VanillaBoatModel extends ListModel<VanillaBoat> {
	private final ModelPart leftPaddle;
	private final ModelPart rightPaddle;
	private final ModelPart waterPatch;
	private final ImmutableList<ModelPart> parts;

	public VanillaBoatModel(ModelPart modelPartIn) {
		this.leftPaddle = modelPartIn.getChild("left_paddle");
		this.rightPaddle = modelPartIn.getChild("right_paddle");
		this.waterPatch = modelPartIn.getChild("water_patch");
		this.parts = ImmutableList.of(modelPartIn.getChild("bottom"), modelPartIn.getChild("back"), modelPartIn.getChild("front"), modelPartIn.getChild("right"), modelPartIn.getChild("left"), this.leftPaddle, this.rightPaddle);
	}

	

	@Override
	public void setupAnim(VanillaBoat p_102269_, float p_102270_, float p_102271_, float p_102272_, float p_102273_, float p_102274_) {
		animatePaddle(p_102269_, 0, this.leftPaddle, p_102270_);
		animatePaddle(p_102269_, 1, this.rightPaddle, p_102270_);
	}

	@Override
	public ImmutableList<ModelPart> parts() {
		return this.parts;
	}

	public ModelPart waterPatch() {
		return this.waterPatch;
	}

	private static void animatePaddle(Boat p_170465_, int p_170466_, ModelPart p_170467_, float p_170468_) {
		float f = p_170465_.getRowingTime(p_170466_, p_170468_);
		p_170467_.xRot = Mth.clampedLerp((-(float) Math.PI / 3F), -0.2617994F, (Mth.sin(-f) + 1.0F) / 2.0F);
		p_170467_.yRot = Mth.clampedLerp((-(float) Math.PI / 4F), ((float) Math.PI / 4F), (Mth.sin(-f + 1.0F) + 1.0F) / 2.0F);
		if (p_170466_ == 1) {
			p_170467_.yRot = (float) Math.PI - p_170467_.yRot;
		}
	}
}