package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.models.Lecture;
import onlineSchool.models.Teachers;

import java.util.Scanner;

public class TeachersService {
    private Integer id;

    public Lecture createNewTeacher(String teacherName, String teacherSecondName) {
        if (teacherName == null || teacherName.equals("") || teacherName.equals("empty")) {
            try {
                throw new ValidationExceptions("Name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        if (teacherSecondName == null || teacherSecondName.equals("") ||
                teacherSecondName.equalsIgnoreCase("empty")) {
            try {
                throw new ValidationExceptions("Second name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        return new Lecture(teacherName, teacherSecondName);
    }

    public static Teachers createNewTeacherByUsers() {
        System.out.println("""
                Вкажіть виклада кусу
                Введіть ім'я та прізвище
                """);
        Scanner sc = new Scanner(System.in);
        String teacherName = sc.next();
        String teacherSecondName = sc.next();
        sc.close();
        return new Teachers(teacherName, teacherSecondName);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
