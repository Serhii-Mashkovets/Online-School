package onlineSchool.services;

import onlineSchool.models.Students;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentsServiceTest {

    @Test
    void testCreateNewStudentByUsers() {
        String input = "John Doe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Students> student = StudentsService.createNewStudentByUsers();
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getStudentName());
        assertEquals("Doe", student.get().getStudentLastName());
    }


    @Test
    void testCreateNewStudentByUsersWithEmptyInput() {
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Students> student = StudentsService.createNewStudentByUsers();
        assertFalse(student.isPresent());
    }
}