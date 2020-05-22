package com.example.eksamenS2.repositories;

/*
public class StudentRepositoryImpl implements IStudentRepository {
    private Connection conn;

    public StudentRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Student student) {
        System.out.println(student.firstName);
        //Student studentToCreate = new Student();
        String sql = "INSERT INTO students(FirstName, LastName, Enrollment,Cpr) VALUES (?,?,?,?)";
        try {
            PreparedStatement createStudent = conn.prepareStatement(sql);

            //createStudent.setInt(1, student.id);
            createStudent.setString(1, student.firstName);
            createStudent.setString(2, student.lastName);
            createStudent.setDate(3, student.enrollmentDate);
            createStudent.setString(4, student.cpr);
            int rowsInserted = createStudent.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Successfully!");
            }

            return true;
        } catch (
                SQLException s) {
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
            while (rs.next()) {
                studentToReturn = new Student();
                //studentToReturn.setCpr(String.valueOf(rs.getInt(1)));
                studentToReturn.setId(rs.getInt(1));
                studentToReturn.setFirstName(rs.getString(2));
                studentToReturn.setLastName(rs.getString(3));
                studentToReturn.setEnrollmentDate(rs.getDate(4));
                studentToReturn.setCpr(rs.getString(5));
            }
        } catch (SQLException s) {
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
            while (rs.next()) {
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

    // jeg er ikke sikker på om dette er den korrekte måde at updatere et student objekt
    // det kan være der skal tages input parameter til metoden udover selve student objektet
    // som så skal brugers som parameter til PreparedStatement som sendes til Sql
    @Override
    public boolean update(Student student) {
        String sql = "UPDATE students SET FirstName=?, LastName=?, Enrollment=?, Cpr=? WHERE id="+ student.id;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, student.firstName);
            statement.setString(2,student.lastName);
            statement.setDate(3, student.enrollmentDate);
            statement.setString(4,student.cpr);
            //statement.setInt(5,student.id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing student was updated successfully!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {

        String sql = "DELETE FROM Students WHERE id=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}


 */