package java.onlineSchool.services;

import onlineSchool.models.Student;
import onlineSchool.services.StudentsService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testCreateNewStudentByUsers() {
        String input = "John Doe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Student> student = StudentsService.createNewStudentByUsers();
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getStudentName());
        assertEquals("Doe", student.get().getStudentLastName());
    }


    @Test
    void testCreateNewStudentByUsersWithEmptyInput() {
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Student> student = StudentsService.createNewStudentByUsers();
        assertFalse(student.isPresent());
    }
}