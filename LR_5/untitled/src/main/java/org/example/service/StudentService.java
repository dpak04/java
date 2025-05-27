package org.example.service;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.util.List;

public class StudentService {
    private final StudentDAO dao = new StudentDAO();

    public List<Student> getStudentsByMonth(int month) {
        return dao.getStudentsBornInMonth(month);
    }
}
