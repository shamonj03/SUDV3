package com.joe.game.control.event;

import java.util.ArrayList;

import com.joe.game.model.EventHandler;
import com.joe.game.model.event.Event;

public class EventHandlerChain<T extends Event> {

	private ArrayList<EventHandler<T>> chain = new ArrayList<>();

	public EventHandlerChain() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked") public EventHandlerChain(EventHandler<T>... defaultHandlers) {
		for (EventHandler<T> handler : defaultHandlers) {
			addHandler(handler);
		}
	}

	public void addHandler(EventHandler<T> handler) {
		chain.add(handler);
	}

	public ArrayList<EventHandler<T>> getChain() {
		return chain;
	}
}
