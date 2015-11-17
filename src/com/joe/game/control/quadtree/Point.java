package com.joe.game.control.quadtree;

public class Point {

	private double x;
	
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void set(Point other) {
		this.x = other.getX();
		this.y = other.getY();
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	@Override public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point other = (Point) obj;

			return getX() == other.getX() && getY() == other.getY();
		}
		return super.equals(obj);
	}
}
