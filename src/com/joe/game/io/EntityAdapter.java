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
import com.joe.game.model.Component;
import com.joe.game.model.component.DefinitionModuel;

public class EntityAdapter implements JsonDeserializer<Data> {

	@Override public Data deserialize(JsonElement element, Type t, JsonDeserializationContext ctx)
			throws JsonParseException {
		int id = element.getAsJsonObject().get("id").getAsInt();

		Data data = new Data(id);
		loadComponents(element, data, ctx);
		return data;
	}

	/**
	 * Parse the data components for the class name and register them to the
	 * Data class.
	 */
	private void loadComponents(JsonElement e, Data data, JsonDeserializationContext ctx) {
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

				if (cz.isAnnotationPresent(DefinitionModuel.class)) {
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
