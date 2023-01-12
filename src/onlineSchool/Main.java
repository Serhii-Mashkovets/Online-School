package onlineSchool;

import onlineSchool.models.Role;
import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.models.Person;
import onlineSchool.services.CourseService;
import onlineSchool.services.LectureService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        initData();

    }


    private static void initData() {
        CourseService course = new CourseService();
        course.createNewCourse("", 1, new Lecture("  ", "  ",
                        new HomeWork[]{new HomeWork()}),
                new Person("", " ", 1, Role.TEACHER, "", ""),
                new Person("", " ", 1, Role.STUDENT, "", ""));

        LectureService lec = new LectureService();
        LectureService lec1 = new LectureService();
        LectureService lec2 = new LectureService();
        lec.createNewLecture("Name One", "Discription One", new HomeWork[]{new HomeWork()});
        lec2.createNewLecture("Name two", "Disription two", new HomeWork[]{new HomeWork()});
        lec1.createNewLecture("Name three", "Description three", new HomeWork[]{new HomeWork()});
        Scanner sc = new Scanner(System.in);
        System.out.println("Оберіть від 1 до 3 номер лекції, з якою бажаєте працювати: ");
        int nm = sc.nextInt();
        switch (nm) {
            case 1 -> System.out.println(lec);
            case 2 -> System.out.println(lec1);
            case 3 -> System.out.println(lec2);
            default -> throw new IllegalArgumentException();
        }
        sc.close();
    }
}