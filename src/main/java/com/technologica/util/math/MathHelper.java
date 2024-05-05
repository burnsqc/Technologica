package com.technologica.util.math;

import net.minecraft.util.Mth;

public class MathHelper {

	public static float[] circleTangents(float x1, float y1, float x2, float y2, float r1, float r2) {
		float[] coords = new float[8];

		float r1I = r1 - 0.03125F;
		float r1O = r1 + 0.03125F;
		float r2I = r2 - 0.03125F;
		float r2O = r2 + 0.03125F;

		float d = (float) Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		float l = (float) Math.sqrt(Math.pow(d, 2) - Math.pow(r1 - r2, 2));
		float h = (float) Math.sqrt(Math.pow(l, 2) + Math.pow(r2, 2));
		float theta1 = (float) (Math.atan2(y2 - y1, x2 - x1) + Math.acos((Math.pow(r1, 2) + Math.pow(d, 2) - Math.pow(h, 2)) / (2 * r1 * d)));

		coords[0] = (float) (x1 + r1I * Math.cos(theta1));
		coords[1] = (float) (y1 + r1I * Math.sin(theta1));

		coords[2] = (float) (x2 + r2I * Math.cos(theta1));
		coords[3] = (float) (y2 + r2I * Math.sin(theta1));

		coords[4] = (float) (x2 + r2O * Math.cos(theta1));
		coords[5] = (float) (y2 + r2O * Math.sin(theta1));

		coords[6] = (float) (x1 + r1O * Math.cos(theta1));
		coords[7] = (float) (y1 + r1O * Math.sin(theta1));

		return coords;
	}

	public static float[][] remainingCircumference(float x1, float y1, float x2, float y2, float r1, float r2) {
		float r1I = r1 - 0.03125F;
		float r1O = r1 + 0.03125F;

		float d = (float) Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		float l = (float) Math.sqrt(Math.pow(d, 2) - Math.pow(r1 - r2, 2));
		float h = (float) Math.sqrt(Math.pow(l, 2) + Math.pow(r2, 2));
		float theta1 = (float) (Math.atan2(y2 - y1, x2 - x1) + Math.acos((Math.pow(r1, 2) + Math.pow(d, 2) - Math.pow(h, 2)) / (2 * r1 * d)));
		float theta2 = (float) (Math.atan2(y2 - y1, x2 - x1) - Math.acos((Math.pow(r1, 2) + Math.pow(d, 2) - Math.pow(h, 2)) / (2 * r1 * d)));

		float diff = (float) (2 * Math.PI - (theta1 - theta2));
		int segments = (int) Math.ceil(diff / (2 * Math.PI) * 32);
		float segmentLength = diff / segments;
		float[][] coords = new float[segments][];
		for (int segment = 0; segment < segments; segment++) {
			coords[segment] = new float[] { (float) (x1 + r1I * Math.cos(theta1 + segmentLength * (segment + 1))), (float) (y1 + r1I * Math.sin(theta1 + segmentLength * (segment + 1))), (float) (x1 + r1I * Math.cos(theta1 + segmentLength * segment)), (float) (y1 + r1I * Math.sin(theta1 + segmentLength * segment)), (float) (x1 + r1O * Math.cos(theta1 + segmentLength * segment)), (float) (y1 + r1O * Math.sin(theta1 + segmentLength * segment)), (float) (x1 + r1O * Math.cos(theta1 + segmentLength * (segment + 1))), (float) (y1 + r1O * Math.sin(theta1 + segmentLength * (segment + 1))) };
		}
		return coords;
	}

	public static float trueBlockPosDistance(int posX1, int posY1, int posZ1, int posX2, int posY2, int posZ2) {
		return Mth.sqrt((posX2 - posX1) * (posX2 - posX1) + (posY2 - posY1) * (posY2 - posY1) + (posZ2 - posZ1) * (posZ2 - posZ1));
	}

}
