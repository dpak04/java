package org.example.json;

import org.example.controller.UniversityCreator;
import org.example.model.University;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonManagerTest {
    @Test
    public void testJsonSerialization() {
        University oldUniversity = UniversityCreator.createTypicalUniversity();
        System.out.println("Оригінальний університет:");
        System.out.println(oldUniversity);

        JsonManager.saveToJson(oldUniversity);
        System.out.println("\n JSON-файл успішно збережено.");

        University newUniversity = JsonManager.loadFromJson();
        System.out.println("\nВідновлений університет:");
        System.out.println(newUniversity);

        assertNotNull(newUniversity, " Помилка: newUniversity є null");
        assertEquals(oldUniversity.toString(), newUniversity.toString(), " Університети не збігаються");

        System.out.println("\n ТЕСТ ПРОЙДЕНО УСПІШНО! Університети однакові.");
    }
}
