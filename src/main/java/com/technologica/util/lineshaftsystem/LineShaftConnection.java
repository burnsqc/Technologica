package com.technologica.util.lineshaftsystem;

public class LineShaftConnection {
	private int from;
	private int to;
	private float ratio;

	public LineShaftConnection(int from, int to, float ratio) {
		this.from = from;
		this.to = to;
		this.ratio = ratio;
	}

	public int getFrom() {
		return this.from;
	}

	public int getTo() {
		return this.to;
	}

	public float getRatio() {
		return this.ratio;
	}
}
