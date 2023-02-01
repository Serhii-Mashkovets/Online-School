package onlineSchool;

import onlineSchool.services.AddMaterialService;
import onlineSchool.services.CourseService;
import onlineSchool.services.LectureService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CourseService course = new CourseService();
        course.createNewCourseByUsers();
        System.out.println(course);

        LectureService lec = new LectureService();
        LectureService lec1 = new LectureService();
        LectureService lec2 = new LectureService();
        lec.createNewLecture("Name One", "Discription One");
        lec2.createNewLecture("Name two", "Disription two");
        lec1.createNewLecture("Name three", "Description three");
        Scanner sc = new Scanner(System.in);
        System.out.println("Оберіть від 1 до 3 номер лекції, з якою бажаєте працювати: ");
        int nm = sc.nextInt();
        try {
            switch (nm) {
                case 1 -> System.out.println(lec);
                case 2 -> System.out.println(lec1);
                case 3 -> System.out.println(lec2);
                default -> throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        sc.close();
        AddMaterialService addMaterialService = new AddMaterialService();
        addMaterialService.createNewAddMaterial();
        addMaterialService.showAllAddmat();
    }
}