package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Students;


import java.util.Scanner;

public class StudentsService {

    private static LoggingRepository logRep = new LoggingRepository(StudentsService.class.getName());
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
        logRep.debugLog("Створення студента");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("""
                Вкажіть студента кусу
                Введіть ім'я та прізвище""");
        System.out.println("Ім'я ");
        if (sc2.hasNextLine()) {
            String studentName = sc2.next();
            System.out.println("Прізвище: ");
            String studentLastName = sc2.next();
            sc2.close();
            return new Students(studentName, studentLastName);
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
