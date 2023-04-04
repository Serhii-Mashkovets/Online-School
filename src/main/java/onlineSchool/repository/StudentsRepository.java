package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentsRepository extends ParentingClassForRepositories {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Optional<Student>> usingStudentsByCourseId(int courseId) throws EntityNotFoundException, SQLException {
        List<Optional<Student>> studentsOfCourse = new ArrayList<>();
        String sql = "SELECT * FROM students INNER JOIN student_courses ON students.student_id = student_courses.student_id WHERE student_courses.course_id = ?";
        List<Student> students = jdbcTemplate.query(sql, new Object[]{courseId}, (rs, rowNum) -> {
            Student student = new Student(rs.getString("student_name"), rs.getString("student_surname"), rs.getString("student_email"));
            student.setStudentId(rs.getInt("student_id"));
            return student;
        });
        students.forEach(student -> studentsOfCourse.add(Optional.of(student)));
        if (studentsOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує студента з таким айді");
        else return studentsOfCourse;
    }

    public Optional<Student> usingStudentById(int studentId) throws SQLException {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{studentId}, (rs, rowNum) -> {
            Student s = new Student(rs.getString("student_name"), rs.getString("student_surname"), rs.getString("student_email"));
            s.setStudentId(rs.getInt("student_id"));
            return s;
        });
        return Optional.ofNullable(student);
    }

    public void add(Student student) throws SQLException {
        String sql = "INSERT INTO students (student_name, student_surname, student_email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentName(), student.getStudentLastName(), student.getEmail());
    }

    public void removeById(int studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        jdbcTemplate.update(sql, studentId);
    }

    public int sizeCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM students";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student(rs.getString("student_name"), rs.getString("student_surname"), rs.getString("student_email"));
            student.setStudentId(rs.getInt("student_id"));
            return student;
        });
    }

}
