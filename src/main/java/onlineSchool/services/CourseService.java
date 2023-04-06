package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Course;
import onlineSchool.models.*;
import onlineSchool.repository.*;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {
    @Autowired
    private static LoggingRepository logRep = new LoggingRepository(CourseService.class.getName());

    @Autowired
    AddMaterialsRepository addMaterialsRepository;

    @Autowired
    HomeWorkRepository homeWorkRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    TeachersRepository teachersRepository;

    @Transactional
    public Course createNewCourse(String courseName,
                                  Optional<Lecture> lectureName, Optional<Teacher> teacherOne, Optional<Student> studentOne) {
        return new Course(courseName, lectureName, teacherOne, studentOne);
    }

    @Transactional
    public Course createNewCourseByUsers() {
        logRep.debugLog("Створення нового курсу");
        System.out.println("Створіть новий курс");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть назву курсу: ");
        String courseName = sc.nextLine();
        Optional<Lecture> lecture = LectureService.createNewLectureByUsers();
        logRep.debugLog("Лекція створена");
        lectureRepository.add(lecture);
        logRep.debugLog("Лекція додана");
        Optional<Teacher> teacher = TeachersService.createNewTeacherByUsers();
        logRep.debugLog("Викладач створений");
        teachersRepository.add(teacher);
        logRep.debugLog("Викладач доданий");
        Optional<Student> student = StudentsService.createNewStudentByUsers();
        logRep.debugLog("Студент створений");
        studentsRepository.add(student);
        logRep.debugLog("Студент доданий");
        sc.close();
        return new Course(courseName, lecture, teacher, student);
    }

    @Autowired
    CourseRepository courseRepository;
}
