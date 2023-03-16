package onlineSchool.services;

import onlineSchool.models.Teachers;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TeachersServiceTest {

    @Test
    void testCreateNewTeacherByUsersValidInput() {
        String input = "John\nDoe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Teachers> teacherOptional = TeachersService.createNewTeacherByUsers();
        assertTrue(teacherOptional.isPresent());
        assertEquals("John", teacherOptional.get().getTeacherName());
        assertEquals("Doe", teacherOptional.get().getTeacherSecondName());
    }

    @Test
    void testCreateNewTeacherByUsersInvalidInput() {
        String input = "\nDoe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Optional<Teachers> teacherOptional = TeachersService.createNewTeacherByUsers();
        assertFalse(teacherOptional.isPresent());
    }
}