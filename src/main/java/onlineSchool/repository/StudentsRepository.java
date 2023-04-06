package onlineSchool.repository;

import com.mysql.cj.jdbc.ha.MultiHostMySQLConnection;
import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class StudentsRepository extends ParentingClassForRepositories {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository() {
        DataSource dataSource = new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                Connection connection = null;

                Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlineschool",
                        "Serhii Mashkovets", "Mashkovets");
                return connection;
            }

            @Override
            public Connection getConnection(@Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password) throws SQLException {
                Connection connection = null;

                Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlineschool",
                        username, password);
                return connection;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Optional<Student>> usingStudentsByCourseId(int courseId) throws EntityNotFoundException, SQLException {
        List<Optional<Student>> studentsOfCourse = new ArrayList<>();
        String sql = "SELECT * FROM students INNER JOIN student_courses ON students.student_id = student_courses.student_id WHERE student_courses.course_id = ?";
        List<Student> students = jdbcTemplate.query(sql, new Object[]{courseId}, (resultSet, i) -> {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            return new Student(studentName, studentSurname, studentEmail);
        });
        if (students.isEmpty()) throw new EntityNotFoundException("Не існує студента з таким айді");
        else {
            for (Student student : students) {
                studentsOfCourse.add(Optional.of(student));
            }
        }
        return studentsOfCourse;
    }

    public Optional<Student> usingStudentById(int studentId) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        List<Student> students = jdbcTemplate.query(sql, new Object[]{studentId}, (resultSet, i) -> {
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            return new Student(studentName, studentSurname, studentEmail);
        });
        if (students.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(students.get(0));
        }
    }

    public void add(Student student) {
        String sql = "INSERT INTO students (student_name, student_surname, student_email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentName(), student.getStudentLastName(), student.getEmail());
    }

    public void removeById(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        jdbcTemplate.update(sql, studentId);
    }

    public int sizeCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM students";
        PreparedStatement statement = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("count");
        } else {
            return 0;
        }
    }


    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        jdbcTemplate.query(sql, (resultSet, i) -> {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            String studentSurname = resultSet.getString("student_surname");
            String studentEmail = resultSet.getString("student_email");
            Student student = new Student(studentName, studentSurname, studentEmail);
            student.setStudentId(studentId);
            students.add(student);
            return null;
        });
        return students;
    }

}
