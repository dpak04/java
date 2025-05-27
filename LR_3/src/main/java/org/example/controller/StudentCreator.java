package org.example.controller;

import org.example.model.Sex;
import org.example.model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}
