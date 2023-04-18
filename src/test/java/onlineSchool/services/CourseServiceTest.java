package onlineSchool.services;

import onlineSchool.models.Course;
import onlineSchool.models.Lecture;
import onlineSchool.models.Student;
import onlineSchool.models.Teacher;
import onlineSchool.repository.LectureRepository;
import onlineSchool.repository.StudentsRepository;
import onlineSchool.repository.TeachersRepository;
import onlineSchool.services.CourseService;
import onlineSchool.services.LectureService;
import onlineSchool.services.StudentsService;
import onlineSchool.services.TeachersService;
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
            Optional<Teacher> teacher = Optional.of(new Teacher("1", "Test teacher"));
            Optional<Student> student = Optional.of(new Student("1", "Test student"));
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
            Mockito.when(teachersServiceMock.createNewTeacherByUsers()).thenReturn(Optional.of(new Teacher("1", "Test teacher")));
            StudentsService studentsServiceMock = Mockito.mock(StudentsService.class);
            Mockito.when(studentsServiceMock.createNewStudentByUsers()).thenReturn(Optional.of(new Student("1", "Test student")));

            Scanner scannerMock = Mockito.mock(Scanner.class);
            Mockito.when(scannerMock.nextLine()).thenReturn("Test course");

            CourseService courseService = new CourseService();
            courseService.lectureRepository.findAll();
            courseService.teachersRepository.findAll();
            courseService.studentsRepository.findAll();

            // when
            Course actualCourse = courseService.createNewCourseByUsers();

            // then
            assertEquals("Test course", actualCourse.getCourseName());
            assertEquals(Optional.of(new Lecture("1", "Test lecture")), actualCourse.getLectureName());
            assertEquals(Optional.of(new Teacher("1", "Test teacher")), actualCourse.getTeaherNameOne());
            assertEquals(Optional.of(new Student("1", "Test student")), actualCourse.getStudentNameOne());
        }
    }
