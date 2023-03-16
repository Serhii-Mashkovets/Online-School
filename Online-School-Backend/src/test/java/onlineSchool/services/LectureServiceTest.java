package onlineSchool.services;

import onlineSchool.models.Lecture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LectureServiceTest {

    @Test
    public void testCreateNewLectureByUsersWithValidInput() {
        String lectureName = "Introduction to Java";
        String description = "An introduction to the Java programming language";

        ByteArrayInputStream in = new ByteArrayInputStream((lectureName + "\n" + description + "\n").getBytes());
        System.setIn(in);

        Optional<Lecture> lecture = LectureService.createNewLectureByUsers();

        assertTrue(lecture.isPresent());
        assertEquals(lectureName, lecture.get().getLectureName());
        assertEquals(description, lecture.get().getDescription());
    }


    @Test
    public void testCreateNewLectureByUsersWithEmptyLectureName() {
        String lectureName = "";
        String description = "An introduction to the Java programming language";

        ByteArrayInputStream in = new ByteArrayInputStream((lectureName + "\n" + description + "\n").getBytes());
        System.setIn(in);

        Optional<Lecture> lecture = LectureService.createNewLectureByUsers();

        assertFalse(lecture.isPresent());
    }


    @Test
    public void testCreateNewLectureByUsersWithEmptyDescription() {
        String lectureName = "Introduction to Java";
        String description = "";

        ByteArrayInputStream in = new ByteArrayInputStream((lectureName + "\n" + description + "\n").getBytes());
        System.setIn(in);

        Optional<Lecture> lecture = LectureService.createNewLectureByUsers();

        assertFalse(lecture.isPresent());
    }


    @Test
    public void testCreateNewLectureByUsersWithEmptyDescriptionAndValidLectureName() {
        String lectureName = "Introduction to Java";
        String description = "";

        ByteArrayInputStream in = new ByteArrayInputStream((lectureName + "\n" + description + "\n").getBytes());
        System.setIn(in);

        Optional<Lecture> lecture = LectureService.createNewLectureByUsers();

        assertFalse(lecture.isPresent());
    }

}