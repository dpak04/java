package org.example.controller;

import org.example.model.Professor;
import org.example.model.Sex;

public class ProfessorCreator {
    public static Professor createProfessor(String firstName, String lastName, String middleName, Sex gender) {
        return new Professor(firstName, lastName, middleName, gender);
    }
}