package com.joe.game.control.quadtree;

public class Boundary {

	private Point point;
	
	private double width;
	
	private double height;

	public Boundary(Point point, double width, double height) {
		this.point = point;
		this.width = width;
		this.height = height;
	}

	public Boundary(double x, double y, double width, double height) {
		this(new Point(x, y), width, height);
	}

	public Boundary(double width, double height) {
		this(0, 0, width, height);
	}

	public Boundary(double width) {
		this(width, width);
	}

	public boolean contains(Point point) {
		return (point.getX() >= getLeftX() && point.getX() < getRightX())
				&& (point.getY() >= getLeftY() && point.getY() < getRightY());
	}

	public boolean contains(Boundary box) {
		return (box.getLeftX() >= getLeftX() && box.getRightX() <= getRightX())
				&& (box.getLeftY() >= getLeftY() && box.getRightY() <= getRightY());
	}

	public double getLeftX() {
		return point.getX();
	}

	public double getLeftY() {
		return point.getY();
	}

	public double getRightX() {
		return point.getX() + getWidth();
	}

	public double getRightY() {
		return point.getY() + getHeight();
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public Point getPoint() {
		return point;
	}

	@Override public String toString() {
		return "Bounds[(" + getLeftX() + ", " + getLeftY() + "), (" + getRightX() + ", " + getRightY() + ")]";
	}
}
