package org.example.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private String recordBookNumber;

    public Student(int id, String surname, String name, String patronymic, LocalDate birthDate, String recordBookNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return id + ": " + surname + " " + name + " " + patronymic + " (" + birthDate + ") [" + recordBookNumber + "]";
    }
}
