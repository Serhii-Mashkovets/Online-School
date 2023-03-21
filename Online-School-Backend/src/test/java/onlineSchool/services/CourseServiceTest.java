package onlineSchool.services;

import onlineSchool.models.Course;
import onlineSchool.models.Lecture;
import onlineSchool.models.Students;
import onlineSchool.models.Teachers;
import onlineSchool.repository.LectureRepository;
import onlineSchool.repository.StudentsRepository;
import onlineSchool.repository.TeachersRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

class CourseServiceTest {

        @Test
        public void testCreateNewCourse() {
            CourseService courseService = new CourseService();
            String courseName = "Test course";
            Optional<Lecture> lecture = Optional.of(new Lecture("1", "Test lecture"));
            Optional<Teachers> teacher = Optional.of(new Teachers("1", "Test teacher"));
            Optional<Students> student = Optional.of(new Students("1", "Test student"));
            Course expectedCourse = new Course(courseName, lecture, teacher, student);
            Course actualCourse = courseService.createNewCourse(courseName, lecture, teacher, student);
            assertEquals(expectedCourse, actualCourse);
        }

        @Test
        public void testCreateNewCourseByUsers() throws SQLException {
            // given
            LectureService lectureServiceMock = Mockito.mock(LectureService.class);
            Mockito.when(lectureServiceMock.createNewLectureByUsers()).thenReturn(Optional.of(new Lecture("1", "Test lecture")));
            TeachersService teachersServiceMock = Mockito.mock(TeachersService.class);
            Mockito.when(teachersServiceMock.createNewTeacherByUsers()).thenReturn(Optional.of(new Teachers("1", "Test teacher")));
            StudentsService studentsServiceMock = Mockito.mock(StudentsService.class);
            Mockito.when(studentsServiceMock.createNewStudentByUsers()).thenReturn(Optional.of(new Students("1", "Test student")));

            Scanner scannerMock = Mockito.mock(Scanner.class);
            Mockito.when(scannerMock.nextLine()).thenReturn("Test course");

            CourseService courseService = new CourseService();
            courseService.lectureRepository = new LectureRepository();
            courseService.teachersRepository = new TeachersRepository();
            courseService.studentsRepository = new StudentsRepository();

            // when
            Course actualCourse = courseService.createNewCourseByUsers();

            // then
            assertEquals("Test course", actualCourse.getCourseName());
            assertEquals(Optional.of(new Lecture("1", "Test lecture")), actualCourse.getLectureName());
            assertEquals(Optional.of(new Teachers("1", "Test teacher")), actualCourse.getTeaherNameOne());
            assertEquals(Optional.of(new Students("1", "Test student")), actualCourse.getStudentNameOne());
        }
    }
