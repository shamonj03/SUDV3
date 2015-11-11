package com.joe.game.control;

import java.util.HashMap;
import java.util.NoSuchElementException;

import com.joe.game.model.Component;

/**
 * Controls the components of the parent.
 */
public class ComponentComponent {

	/**
	 * The components registered to the parent.
	 * K: Component.class
	 * V: Component Instance.
	 */
	private HashMap<Class<? extends Component>, Component> components = new HashMap<>();

	/**
	 * Unregister a component from the parent.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 */
	public <T extends Component> void unregister(Class<T> componentClass) {
		if (!components.containsKey(componentClass)) {
			throw new NoSuchElementException("No component registered to " + componentClass + ".");
		}
		components.remove(componentClass);
	}

	/**
	 * Register a component to the parent.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 */
	public <T extends Component> void register(T component) {
		components.put(component.getClass(), component);
	}

	/**
	 * Get a component from the parent.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 * @return the component if it's there, other wise throw NoSuchElementException.
	 */
	@SuppressWarnings("unchecked") public <T extends Component> T getComponent(Class<T> componentClass) {
		if (!components.containsKey(componentClass)) {
			throw new NoSuchElementException("No component registered to " + componentClass + ".");
		}
		return (T) components.get(componentClass);
	}

	@Override public String toString() {
		String s = "";

		for (Component component : components.values()) {
			s = s + component + "\n";
		}
		return s;
	}
}
