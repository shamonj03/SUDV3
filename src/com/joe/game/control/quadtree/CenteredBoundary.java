package com.joe.game.control.quadtree;

public class CenteredBoundary extends Boundary {

	public CenteredBoundary(double x, double y, int width) {
		super(x, y, width, width);
	}

	public CenteredBoundary(int width) {
		super(new Point(0, 0), width, width);
	}

	@Override public double getLeftX() {
		return getPoint().getX() - getWidth();
	}

	@Override public double getLeftY() {
		return getPoint().getY() - getHeight();
	}

	@Override public double getRightX() {
		return getPoint().getX() + getWidth();
	}
	
	@Override public double getRightY() {
		return getPoint().getY() + getHeight();
	}

}
