package com.joe.game.control.stack;

public interface Controller<E> {

	public void register(E e);

	public void unregister(E e);

}
