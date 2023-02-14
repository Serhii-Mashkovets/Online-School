package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.models.Teachers;

import java.util.Scanner;

public class TeachersService {
    private Integer id;

    public Teachers createNewTeacher(String teacherName, String teacherSecondName) {
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
        return new Teachers(teacherName, teacherSecondName);
    }

    public static Teachers createNewTeacherByUsers() {
        try {
            System.out.println("""
                    Вкажіть виклада кусу
                    Введіть ім'я та прізвище""");
            Scanner sc = new Scanner(System.in);
            System.out.println("Ім'я: ");
            String teacherName = sc.nextLine();
            System.out.println("Прізвище:  ");
            String teacherSecondName = sc.nextLine();
            sc.close();
            return new Teachers(teacherName, teacherSecondName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
