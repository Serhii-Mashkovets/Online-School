package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Teachers;

import java.util.Scanner;

public class TeachersService {
    private static LoggingRepository logRep = new LoggingRepository(TeachersService.class.getName());
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
                logRep.warningLog("Помилка валідації: ", e);
                System.err.println(String.valueOf(e));
            }
        }
        return new Teachers(teacherName, teacherSecondName);
    }

    public static Teachers createNewTeacherByUsers() {
        logRep.debugLog("Створення студента");
        try {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("""
                    Вкажіть виклада кусу
                    Введіть ім'я та прізвище""");
            System.out.println("Ім'я:");
            if (sc2.hasNextLine()) {
                String teacherName = sc2.nextLine();
                System.out.println("Прізвище:");
                String teacherSecondName = sc2.next();
                sc2.close();
                return new Teachers(teacherName, teacherSecondName);
            }
        } catch (Exception e) {
            logRep.warningLog("Помилка: ",e);
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
