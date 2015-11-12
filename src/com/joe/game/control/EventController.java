package com.joe.game.control;

import java.util.HashMap;
import java.util.Stack;

import com.joe.game.model.Event;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.MessageEvent;
import com.joe.game.model.event.impl.InputEventHandler;
import com.joe.game.model.event.impl.MessageEventHandler;

public class EventController {
	/**
	 * A map containing all event handlers registered to an event.
	 */
	private static HashMap<Class<? extends Event>, EventHandler<? extends Event>> eventMap = new HashMap<>();

	/**
	 * Define the event handlers.
	 */
	static {
		eventMap.put(MessageEvent.class, new MessageEventHandler());
		eventMap.put(InputEvent.class, new InputEventHandler());
	}

	/**
	 * Stack of events ready to be processed.
	 */
	private static Stack<Event> eventStack = new Stack<>();

	/**
	 * Send an event to be processed.
	 * 
	 * @param event
	 *            The event to send.
	 */
	public static void sendEvent(Event event) {
		eventStack.push(event);
	}

	/**
	 * Handle the events in the stack.
	 * Handle one event every game tick.
	 */
	public static void handleEvents() {
		if (eventStack.isEmpty()) {
			return;
		}

		Event event = eventStack.pop();

		Class<? extends Event> key = event.getClass();
		if (eventMap.get(key) == null) {
			System.err.println("No event registered to " + key);
		}

		@SuppressWarnings("unchecked")
		EventHandler<Event> handler = (EventHandler<Event>) eventMap.get(key);
		handler.handle(event);
	}
}
