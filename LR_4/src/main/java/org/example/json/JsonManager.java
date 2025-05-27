package org.example.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.University;
import org.example.model.Human;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final String FILE_PATH = "university.json";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Human.class, new HumanAdapter()) // Реєструємо адаптер
            .setPrettyPrinting()
            .create();

    public static void saveToJson(University university) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(university, writer);
            System.out.println("Університет збережено у JSON-файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University loadFromJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
