package com.joe.game.control.event;

import java.util.ArrayList;

import com.joe.game.control.Controller;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.Event;

public class EventHandlerChain<T extends Event> implements Controller<EventHandler<T>> {
	/**
	 * List of event handlers registered to this chain.
	 */
	private ArrayList<EventHandler<T>> chain = new ArrayList<>();

	@SuppressWarnings("unchecked") public EventHandlerChain(EventHandler<T>... defaultHandlers) {
		for (EventHandler<T> handler : defaultHandlers) {
			register(handler);
		}
	}

	@Override public void register(EventHandler<T> handler) {
		chain.add(handler);
	}

	@Override public void unregister(EventHandler<T> e) {
		chain.remove(e);
	}

	public ArrayList<EventHandler<T>> getChain() {
		return chain;
	}
}
