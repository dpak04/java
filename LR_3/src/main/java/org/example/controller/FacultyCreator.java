package org.example.controller;

import org.example.model.Faculty;
import org.example.model.Human;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
