package org.example.controller;

import org.example.model.*;

public class UniversityCreator {
    public static University createTypicalUniversity() {
        Professor universityHead = ProfessorCreator.createProfessor("John", "Doe", "Edward", Sex.MALE);
        University university = new University("Tech University", universityHead);

        Professor facultyHead = ProfessorCreator.createProfessor("Alice", "Smith", "Ann", Sex.FEMALE);
        Faculty faculty = FacultyCreator.createFaculty("Computer Science", facultyHead);
        university.addFaculty(faculty);

        Professor departmentHead = ProfessorCreator.createProfessor("Bob", "Brown", "Michael", Sex.MALE);
        Department department = DepartmentCreator.createDepartment("Software Engineering", departmentHead);
        faculty.addDepartment(department);

        Professor groupHead = ProfessorCreator.createProfessor("Charlie", "Davis", "Lee", Sex.MALE);
        Group group = GroupCreator.createGroup("SE-2025", groupHead);
        department.addGroup(group);

        group.addStudent(StudentCreator.createStudent("Eva", "White", "Maria", Sex.FEMALE));
        group.addStudent(StudentCreator.createStudent("Daniel", "Black", "James", Sex.MALE));

        return university;
    }
}
