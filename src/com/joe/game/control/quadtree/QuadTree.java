package com.joe.game.control.quadtree;

import java.util.ArrayList;

public class QuadTree<T> {

	private static final int NODE_CAPACITY = 4;

	private Boundary boundary;

	private ArrayList<QuadNode<T>> nodes = new ArrayList<>(NODE_CAPACITY);

	private QuadTree<T> northWest;
	private QuadTree<T> northEast;
	private QuadTree<T> southWest;
	private QuadTree<T> southEast;

	private QuadTree<T> parent;

	private QuadType type = QuadType.LEAF;

	public QuadTree(Boundary boundary) {
		this(null, boundary);
	}

	public QuadTree(QuadTree<T> parent, Boundary boundary) {
		this.boundary = boundary;
		this.parent = parent;
	}

	private void add(QuadNode<T> node) {
		node.setParent(this);
		nodes.add(node);
	}

	public boolean insert(QuadNode<T> node) {
		if (!boundary.contains(node.getPoint())) {
			return false;
		}

		if (nodes.size() < NODE_CAPACITY && getType() == QuadType.LEAF) {
			add(node);
			return true;
		}

		if (!hasLeafs()) {
			subdivide();
		}

		if (northWest.insert(node)) {
			return true;
		}
		if (northEast.insert(node)) {
			return true;
		}
		if (southWest.insert(node)) {
			return true;
		}
		if (southEast.insert(node)) {
			return true;
		}
		return false;
	}

	private void subdivide() {
		double topX = boundary.getLeftX();
		double topY = boundary.getLeftY();
		double width = boundary.getWidth() / 2.0;
		double height = boundary.getHeight() / 2.0;

		northWest = new QuadTree<T>(this, new Boundary(topX, topY, width, height));
		northEast = new QuadTree<T>(this, new Boundary(topX + width, topY, width, height));
		southWest = new QuadTree<T>(this, new Boundary(topX, topY + height, width, height));
		southEast = new QuadTree<T>(this, new Boundary(topX + width, topY + height, width, height));

		setType(QuadType.STEM);

		cleanUp();
	}

	public void cleanUp() {
		for (int i = 0; i < nodes.size(); i++) {
			QuadNode<T> node = nodes.get(i);

			getNorthWest().insert(node);
			getNorthEast().insert(node);
			getSouthWest().insert(node);
			getSouthEast().insert(node);
		}
		nodes.clear();
	}

	public ArrayList<QuadNode<T>> query(Boundary boundary) {
		ArrayList<QuadNode<T>> nodes = new ArrayList<>();

		query(nodes, boundary);

		return nodes;
	}

	public void remove(T value) {
		nodes.removeIf(n -> value == n.getValue());

		if (!hasLeafs()) {
			return;
		}
		northWest.remove(value);
		northEast.remove(value);
		southWest.remove(value);
		southEast.remove(value);
	}

	public boolean hasLeafs() {
		return northWest != null;
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public boolean hasParent() {
		return parent != null;
	}

	public void query(ArrayList<QuadNode<T>> list, Boundary boundary) {
		for (QuadNode<T> node : nodes) {
			if (boundary.contains(node.getPoint())) {
				list.add(node);
			}
		}

		if (!hasLeafs()) {
			return;
		}
		// Otherwise, add the points from the children
		northWest.query(list, boundary);
		northEast.query(list, boundary);
		southWest.query(list, boundary);
		southEast.query(list, boundary);
	}

	public Boundary getBoundary() {
		return boundary;
	}

	public QuadTree<T> getParent() {
		return parent;
	}

	public ArrayList<QuadNode<T>> getNodes() {
		return nodes;
	}

	public QuadTree<T> getNorthEast() {
		return northEast;
	}

	public QuadTree<T> getNorthWest() {
		return northWest;
	}

	public QuadTree<T> getSouthEast() {
		return southEast;
	}

	public QuadTree<T> getSouthWest() {
		return southWest;
	}

	public static int getNodeCapacity() {
		return NODE_CAPACITY;
	}

	public QuadType getType() {
		return type;
	}

	public void setType(QuadType type) {
		this.type = type;
	}
}
