package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentsRepository extends ParentingClassForRepositories {
    private static StudentsRepository newExample;
    private static Connection connection;

    static {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlineschool",
                    "Serhii Mashkovets", "Mashkovets");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StudentsRepository() {
    }

    public static StudentsRepository getNewExample() {
        if (newExample == null) {
            newExample = new StudentsRepository();
        }
        return newExample;
    }

    public List<Optional<Student>> usingStudentsByCourseId(int courseId) throws EntityNotFoundException, SQLException {
        List<Optional<Student>> studentsOfCourse = new ArrayList<>();
        String sql = "SELECT * FROM students INNER JOIN student_courses ON students.student_id = student_courses.student_id WHERE student_courses.course_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            Student student = new Student(studentName, studentSurname, studentEmail);
            studentsOfCourse.add(Optional.of(student));
        }
        if (studentsOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує студента з таким айді");
        else return studentsOfCourse;
    }

    public Optional<Student> usingStudentById(int studentId) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, studentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            Student student = new Student(studentName, studentSurname, studentEmail);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }

    public void add(Student student) throws SQLException {
        String sql = "INSERT INTO students (student_name, student_surname, student_email) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getStudentName());
        statement.setString(2, student.getStudentLastName());
        statement.setString(3, student.getEmail());
        statement.executeUpdate();
    }

    public void removeById(int studentId) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, studentId);
        statement.executeUpdate();
    }

    public int sizeCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM students";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("count");
        } else {
            return 0;
        }
    }

    public static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            Student student = new Student(studentName, studentSurname, studentEmail);
            student.setStudentId(studentId);
            students.add(student);
        }
        return students;
    }


}
