package org.example.json;

import com.google.gson.*;
import org.example.model.Human;
import org.example.model.Professor;
import org.example.model.Student;

import java.lang.reflect.Type;

public class HumanAdapter implements JsonDeserializer<Human>, JsonSerializer<Human> {
    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String className = jsonObject.get("className").getAsString();

        if ("Professor".equals(className)) {
            return context.deserialize(json, Professor.class);
        } else if ("Student".equals(className)) {
            return context.deserialize(json, Student.class);
        }
        throw new JsonParseException("Unknown class: " + className);
    }

    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();
        jsonObject.addProperty("className", src.getClass().getSimpleName());
        return jsonObject;
    }
}
