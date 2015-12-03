package com.joe.game.control.event;

import java.util.HashMap;
import java.util.LinkedList;

import com.joe.game.model.EventHandler;
import com.joe.game.model.event.CameraPositionEvent;
import com.joe.game.model.event.DrawGameScreenEvent;
import com.joe.game.model.event.EquipItemEvent;
import com.joe.game.model.event.Event;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.MessageEvent;
import com.joe.game.model.event.MovementEvent;
import com.joe.game.model.event.impl.CameraPositionEventHandler;
import com.joe.game.model.event.impl.DrawGameScreenEventHandler;
import com.joe.game.model.event.impl.EquipItemEventHandler;
import com.joe.game.model.event.impl.InputEventHandler;
import com.joe.game.model.event.impl.MessageEventHandler;
import com.joe.game.model.event.impl.MovementEventHandler;

public class EventController {
	/**
	 * A map containing all event handlers registered to an event.
	 */
	private final HashMap<Class<? extends Event>, EventHandlerChain<? extends Event>> eventMap = new HashMap<>();

	/**
	 * Stack of events ready to be processed.
	 */
	private final LinkedList<? super Event> eventStack = new LinkedList<>();

	/**
	 * Define the event handlers.
	 */
	public EventController() {
		/*
		 * Predefined handlers. These are core features.
		 */
		register(InputEvent.class, new InputEventHandler());
		register(MessageEvent.class, new MessageEventHandler());
		register(MovementEvent.class, new MovementEventHandler());
		register(DrawGameScreenEvent.class, new DrawGameScreenEventHandler());
		register(CameraPositionEvent.class, new CameraPositionEventHandler());
		register(EquipItemEvent.class, new EquipItemEventHandler());
	}

	@SuppressWarnings("unchecked") public <T extends Event> void register(Class<T> key, EventHandler<T> handler) {
		if (eventMap.get(key) == null) {
			/*
			 * Register the event chain if it doesn't exist.
			 */
			eventMap.put(key, new EventHandlerChain<T>());
		}

		EventHandlerChain<T> chains = (EventHandlerChain<T>) eventMap.get(key);
		chains.addHandler(handler);
	}

	/**
	 * Send an event to be processed.
	 * 
	 * @param event
	 *            The event to send.
	 */
	public <M extends Event> void sendEvent(M event) {
		eventStack.add(event);
	}

	/**
	 * Handle the events in the stack.
	 * Handle one event every game tick.
	 */
	@SuppressWarnings("unchecked") public <M extends Event> void handleEvents() {
		if (eventStack.isEmpty()) {
			return;
		}

		M event = (M) eventStack.pollFirst();

		Class<? extends Event> key = event.getClass();
		if (eventMap.get(key) == null) {
			System.err.println("No event registered to " + key);
		}

		EventHandlerChain<? super M> chains = (EventHandlerChain<? super M>) eventMap.get(key);

		for (EventHandler<? super M> handler : chains.getChain()) {
			handler.handle(event);
		}
	}
}
