package org.example.dao;

import org.example.model.Student;
import org.example.*;
import org.example.utl.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getStudentsBornInMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student WHERE MONTH(birth_date) = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("surname"),
                        rs.getString("name"),
                        rs.getString("patronymic"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("record_book_number")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
