package onlineSchool.services;

import onlineSchool.models.*;
import onlineSchool.repository.*;

import java.util.Scanner;

public class CourseService {

    public Course createNewCourse(String courseName, Integer id,
                                  Lecture lectureName, Teachers teacherOne, Students studentOne) {
        return new Course(courseName, id, lectureName, teacherOne, studentOne);
    }

    public Course createNewCourseByUsers() {
        System.out.println("Створіть новий курс: ");
        LectureRepository lectureRepository = LectureRepository.getNewExample();
        TeachersRepository teachersRepository = TeachersRepository.getNewExample();
        StudentsRepository studentsRepository = StudentsRepository.getNewExample();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть назву курсу: ");
        String courseName = sc.nextLine();
        Lecture lecture = LectureService.createNewLectureByUsers();
        lectureRepository.add(lecture);
        Teachers teacher = TeachersService.createNewTeacherByUsers();
        teachersRepository.add(teacher);
        Students student = StudentsService.createNewStudentByUsers();
        studentsRepository.add(student);
        sc.close();
        return new Course(courseName, Course.countId(), lecture, teacher, student);
    }

    CourseRepository courseRepository = CourseRepository.getNewExample();
}

