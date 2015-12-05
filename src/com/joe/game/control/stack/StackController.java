package com.joe.game.control.stack;

import java.util.ArrayList;
import java.util.Iterator;

import com.joe.game.control.Controller;

public class StackController<E> implements Controller<E>, Iterable<E> {
	/**
	 * List of objects.
	 */
	private ArrayList<E> list = new ArrayList<>();

	/**
	 * Register an object to this list.
	 */
	@Override public void register(E e) {
		list.add(e);
	}

	/**
	 * Unregister an object to this list.
	 */
	@Override public void unregister(E e) {
		list.remove(e);
	}

	/**
	 * @return the top or last element in the list.
	 */
	public E getTop() {
		return get(list.size() - 1);
	}

	/**
	 * @return the bottom or first element in the list.
	 */
	public E getBottom() {
		return get(0);
	}

	/**
	 * 
	 * @param index
	 * @return an element in the list.
	 */
	public E get(int index) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(index);
	}

	/**
	 * @return list of data.
	 */
	public ArrayList<E> getList() {
		return list;
	}

	@Override public Iterator<E> iterator() {
		return list.iterator();
	}
}