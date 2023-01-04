package onlineSchool;

import onlineSchool.models.*;
import onlineSchool.repository.CourseRepository;
import onlineSchool.repository.LectureRepository;

import java.util.Scanner;

import static onlineSchool.enums.Role.TEACHER;

public class Main {
    public static void main(String[] args) {

        initData();

    }


    private static void initData() {
        CourseRepository courseRep = new CourseRepository();
        Course courseO = new Course(1);
        courseO.fullCourse("Булева логіка в математиці", 1);
        courseRep.addCourse(courseO);

        LectureRepository lecRep = new LectureRepository();
        LectureRepository lecRep1 = new LectureRepository();
        LectureRepository lecRep2 = new LectureRepository();
        lecRep.addLecture(new Lecture("Лекція 1", "2", "3", 1, TEACHER));
        lecRep1.addLecture(new Lecture("Лекція 2", "5", "6", 2, TEACHER));
        lecRep2.addLecture(new Lecture("Лекція 3", "8", "9", 3, TEACHER));
        Scanner sc = new Scanner(System.in);
        System.out.println("Оберіть від 1 до 3 номер лекції, з якою бажаєте працювати: ");
        int nm = sc.nextInt();
        switch (nm) {
            case 1 -> System.out.println(lecRep);
            case 2 -> System.out.println(lecRep1);
            case 3 -> System.out.println(lecRep2);
        }
        sc.close();
    }

}