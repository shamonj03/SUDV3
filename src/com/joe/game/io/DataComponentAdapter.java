package com.joe.game.io;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.joe.game.io.data.ComponentData;
import com.joe.game.model.Component;
import com.joe.game.model.component.DefinitionComponent;

public class DataComponentAdapter implements JsonDeserializer<ComponentData> {

	@Override public ComponentData deserialize(JsonElement element, Type t, JsonDeserializationContext ctx)
			throws JsonParseException {
		int id = element.getAsJsonObject().get("id").getAsInt();

		ComponentData data = new ComponentData(id);
		loadComponents(element, data, ctx);
		return data;
	}

	/**
	 * Parse the data components for the class name and register them to the
	 * Data class.
	 */
	private void loadComponents(JsonElement e, ComponentData data, JsonDeserializationContext ctx) {
		JsonElement comps = e.getAsJsonObject().get("components");
		Gson gson = new Gson();
		Type stringStringMap = new TypeToken<Map<String, JsonElement>>() {
		}.getType();
		Map<String, JsonElement> map = gson.fromJson(comps, stringStringMap);

		for (Entry<String, JsonElement> entry : map.entrySet()) {
			JsonElement test = comps.getAsJsonObject().get(entry.getKey());
			try {
				@SuppressWarnings("unchecked")
				Class<? extends Component> cz = (Class<? extends Component>) Class.forName(entry.getKey());

				if (cz.isAnnotationPresent(DefinitionComponent.class)) {
					data.getComponents().put(cz, ctx.deserialize(test, cz));
				} else {
					throw new UnsupportedOperationException(cz
							+ " is not usable here as it is not a definition component.");
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

}
