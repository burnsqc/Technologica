package com.technologica.util.math;

public class ModMathHelper {
	
	public static float[] CircleTangents(Float pos1x, Float pos1y, Float pos2x, Float pos2y, Float radius1, Float radius2) {
		float[] coords = new float[8];
		
		float radiusI1 = radius1 - 0.0625F;
		float radiusO1 = radius1 + 0.0625F;
		float radiusI2 = radius2 - 0.0625F;
		float radiusO2 = radius2 + 0.0625F;
		
		float distance = (float) Math.sqrt((Math.pow(pos1x - pos2x, 2) + Math.pow(pos1y - pos2y, 2))); 
		float length = (float) Math.sqrt(Math.pow(distance, 2) - Math.pow(radiusI1 - radiusI2, 2));
		float hypotenuse = (float) Math.sqrt(Math.pow(length, 2) + Math.pow(radiusI1, 2));
		float theta = (float) (Math.acos((Math.pow(radiusI1, 2) + Math.pow(distance, 2) - Math.pow(hypotenuse, 2)) / (2 * radiusI1 * distance)) + Math.atan((pos2y - pos1y) / (pos2x - pos1x)));
		
		coords[0] = (float) (pos1x + radiusI1 * Math.cos(theta));
		coords[1] = (float) (pos1y + radiusI1 * Math.sin(theta));
		coords[2] = (float) (pos2x + radiusI2 * Math.cos(theta));
		coords[3] = (float) (pos2y + radiusI2 * Math.sin(theta));
		
		float distance2 = (float) Math.sqrt((Math.pow(pos1x - pos2x, 2) + Math.pow(pos1y - pos2y, 2))); 
		float length2 = (float) Math.sqrt(Math.pow(distance2, 2) - Math.pow(radiusO1 - radiusO2, 2));
		float hypotenuse2 = (float) Math.sqrt(Math.pow(length2, 2) + Math.pow(radiusO1, 2));
		float theta2 = (float) (Math.acos((Math.pow(radiusO1, 2) + Math.pow(distance2, 2) - Math.pow(hypotenuse2, 2)) / (2 * radiusO1 * distance2)) + Math.atan((pos2y - pos1y) / (pos2x - pos1x)));
		
		coords[4] = (float) (pos1x + radiusO1 * Math.cos(theta2));
		coords[5] = (float) (pos1y + radiusO1 * Math.sin(theta2));
		coords[6] = (float) (pos2x + radiusO2 * Math.cos(theta2));
		coords[7] = (float) (pos2y + radiusO2 * Math.sin(theta2));
		
		return coords;
	}
}
