package com.joe.game.control;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import com.joe.game.model.component.Component;

/**
 * Controls the components of the parent.
 */
public class ComponentController {
	/**
	 * The components registered to the parent.
	 * K: Component.class
	 * V: Component Instance.
	 */
	private HashMap<Class<? extends Component>, Component> components = new HashMap<>();

	/**
	 * Do something with a component.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 * @param consumer
	 *            Do something if the component exists.
	 */
	public <T extends Component> void execute(Class<T> componentClass, Consumer<T> consumer) {
		if (containsComponent(componentClass)) {
			T component = getComponent(componentClass);
			consumer.accept(component);
		}
	}

	/**
	 * Get a component from the parent.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 * @return the component if it's there, other wise throw
	 *         NoSuchElementException.
	 */
	@SuppressWarnings("unchecked") public <T extends Component> T getComponent(Class<T> componentClass) {
		if (!containsComponent(componentClass)) {
			throw new NoSuchElementException("No component registered to " + componentClass + ".");
		}
		return (T) components.get(componentClass);
	}

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
	 * Checks if this parent has a component.
	 * 
	 * @param componentClass
	 *            The class name of the component.
	 * 
	 * @return true if the component is here.
	 */
	public <T extends Component> boolean containsComponent(Class<T> componentClass) {
		return components.containsKey(componentClass);
	}

	/**
	 * @return the components as a string.
	 */
	protected String componentsToString() {
		String s = "";

		for (Component component : components.values()) {
			s = s + component + "\n";
		}
		return s;
	}

	/**
	 * @return the components of the parent as a formated string.
	 */
	@Override public String toString() {
		return componentsToString();
	}

}
