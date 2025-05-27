package org.example;

import org.example.controller.UniversityCreator;
import org.example.model.University;

public class Run {
    public static void main(String[] args) {
        University university = UniversityCreator.createTypicalUniversity();
        System.out.println(university);
    }
}