package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.*;
import onlineSchool.repository.*;

import java.util.Scanner;

public class CourseService {

    private static LoggingRepository logRep = new LoggingRepository(CourseService.class.getName());

    public Course createNewCourse(String courseName,
                                  Lecture lectureName, Teachers teacherOne, Students studentOne) {
        return new Course(courseName, lectureName, teacherOne, studentOne);
    }

    public Course createNewCourseByUsers() {
        logRep.debugLog("Створення нового курсу");
        System.out.println("Створіть новий курс");
        LectureRepository lectureRepository = LectureRepository.getNewExample();
        TeachersRepository teachersRepository = TeachersRepository.getNewExample();
        StudentsRepository studentsRepository = StudentsRepository.getNewExample();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть назву курсу: ");
        String courseName = sc.nextLine();
        Lecture lecture = LectureService.createNewLectureByUsers();
        logRep.debugLog("Лекція створена");
        lectureRepository.add(lecture);
        logRep.debugLog("Лекція додана");
        Teachers teacher = TeachersService.createNewTeacherByUsers();
        logRep.debugLog("Викладач створений");
        teachersRepository.add(teacher);
        logRep.debugLog("Викладач доданий");
        Students student = StudentsService.createNewStudentByUsers();
        logRep.debugLog("Студент створений");
        studentsRepository.add(student);
        logRep.debugLog("Студент доданий");
        sc.close();
        return new Course(courseName, lecture, teacher, student);
    }

    CourseRepository courseRepository = CourseRepository.getNewExample();
}

