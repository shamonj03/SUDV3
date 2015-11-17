package com.joe.game.control.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import com.joe.game.model.Event;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.CommandEvent;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.MessageEvent;
import com.joe.game.model.event.impl.InputEventHandler;
import com.joe.game.model.event.impl.MessageEventHandler;

public class EventController {
	/**
	 * A map containing all event handlers registered to an event.
	 */
	private static HashMap<Class<? extends Event>, EventHandlerChain<? extends Event>> eventMap = new HashMap<>();

	/**
	 * Define the event handlers.
	 */
	static {
		eventMap.put(MessageEvent.class, new EventHandlerChain<MessageEvent>());
		eventMap.put(InputEvent.class, new EventHandlerChain<InputEvent>());
		eventMap.put(CommandEvent.class, new EventHandlerChain<CommandEvent>());
		
		register(InputEvent.class, new InputEventHandler());
	}

	public static <T extends Event> void register(Class<T> key, EventHandler<T> handler) {
		if (eventMap.get(key) == null) {
			System.err.println("No event registered to " + key);
		}

		EventHandlerChain<T> chains = (EventHandlerChain<T>) eventMap.get(key);
		chains.addHandler(handler);
	}

	/**
	 * Stack of events ready to be processed.
	 */
	private static Stack<? super Event> eventStack = new Stack<>();

	/**
	 * Send an event to be processed.
	 * 
	 * @param event
	 *            The event to send.
	 */
	public static <M extends Event> void sendEvent(M event) {
		eventStack.push(event);
	}

	/**
	 * Handle the events in the stack.
	 * Handle one event every game tick.
	 */
	@SuppressWarnings("unchecked") public static <M extends Event> void handleEvents() {
		if (eventStack.isEmpty()) {
			return;
		}

		M event = (M) eventStack.pop();

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
