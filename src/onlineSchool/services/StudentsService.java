package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.models.Students;


import java.util.Scanner;

public class StudentsService {
    private Integer id;

    public Students createNewStudent(String studentName, String studentLastName) {
        if (studentName == null || studentName.equals("") || studentName.equals("empty")) {
            try {
                throw new ValidationExceptions("Name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        if (studentLastName == null || studentLastName.equals("") ||
                studentLastName.equalsIgnoreCase("empty")) {
            try {
                throw new ValidationExceptions("Second name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        return new Students(studentName, studentLastName);
    }

    public static Students createNewStudentByUsers() {
        System.out.println("""
        Вкажіть студента кусу
        Введіть ім'я та прізвище""");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ім'я ");
        String studentName = sc.nextLine();
        System.out.println("Прізвище: ");
        String studentLastName = sc.nextLine();
        sc.close();
        return new Students(studentName, studentLastName);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
