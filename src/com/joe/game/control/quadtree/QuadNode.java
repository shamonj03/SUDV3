package com.joe.game.control.quadtree;

public class QuadNode<T> {

	private Point point;

	private T value;

	private QuadTree<T> parent;

	public QuadNode(Point point, T value) {
		this(point.getX(), point.getY(), value);
	}

	public QuadNode(double x, double y, T value) {
		this.point = new Point(x, y);
		this.value = value;
	}

	public void move(Point target) {
		move(parent, target);
	}

	private void move(QuadTree<T> tree, Point target) {
		if (tree.getBoundary().contains(target)) {
			point.set(target);
		} else {
			QuadTree<T> parent = tree.getParent();
			if (parent.hasParent()) {
				move(parent.getNorthWest(), target);
				move(parent.getNorthEast(), target);
				move(parent.getSouthWest(), target);
				move(parent.getSouthEast(), target);
			}
		}
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setParent(QuadTree<T> parent) {
		this.parent = parent;
	}

	public QuadTree<T> getParent() {
		return parent;
	}

	public Point getPoint() {
		return point;
	}

	public T getValue() {
		return value;
	}

	@Override public String toString() {
		return "Point: " + getPoint() + " " + value;
	}
}
