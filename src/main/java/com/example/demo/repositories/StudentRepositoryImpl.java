package com.example.demo.repositories;

import com.example.demo.models.Student;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private Connection conn;

    public StudentRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Student student) {
        Student studentToCreate = new Student();
        String sql = "INSERT INTO students(FirstName, LastName, EnrollmentDate,Cpr) VALUES (?,?,?,?)";
        try {
            PreparedStatement createStudent = conn.prepareStatement(sql);
            for (int i = 0; i < readAll().size(); i++)
                if (studentToCreate.cpr.equals(readAll().get(i).cpr)) {
                    return false;
                } else {
                    createStudent.setString(1, student.firstName);
                    createStudent.setString(2, student.lastName);
                    createStudent.setDate(3, (Date) student.enrollmentDate);
                    createStudent.setString(4, student.cpr);
                    int rowsInserted = createStudent.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Successfully!");
                    }
                }
            return true;
        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("Fejlet");
        }
        System.out.println("Successfully!2");
        return true;
    }

    @Override
    public Student read(int id) {
        Student studentToReturn = new Student();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM students WHERE id=" + id);
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                studentToReturn = new Student();
                studentToReturn.setCpr(String.valueOf(rs.getInt(1)));
                studentToReturn.setFirstName(rs.getString(2));
                studentToReturn.setLastName(rs.getString(3));
                studentToReturn.setEnrollmentDate(rs.getDate(4));
                studentToReturn.setCpr(rs.getString(5));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return studentToReturn;
    }

    @Override
    public List<Student> readAll() {
        List<Student> allStudents = new ArrayList<Student>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student tempStudent = new Student();
                tempStudent.setId(rs.getInt(1));
                tempStudent.setFirstName(rs.getString(2));
                tempStudent.setLastName(rs.getString(3));
                tempStudent.setEnrollmentDate(rs.getDate(4));
                tempStudent.setCpr(rs.getString(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {

        String sql = "DELETE FROM Students WHERE id=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
