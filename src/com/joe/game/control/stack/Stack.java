package com.joe.game.control.stack;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack<E> implements Controller<E>, Iterable<E> {

	private ArrayList<E> list = new ArrayList<>();

	@Override public void register(E e) {
		list.add(e);
	}

	@Override public void unregister(E e) {
		list.remove(e);
	}

	public E getTop() {
		return get(list.size() - 1);
	}

	public E getBottom() {
		return get(0);
	}

	public E get(int index) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(index);
	}

	public ArrayList<E> getList() {
		return list;
	}

	@Override public Iterator<E> iterator() {
		return list.iterator();
	}
}