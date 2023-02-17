package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Lecture;

import java.util.Scanner;

public class LectureService {
    private static LoggingRepository logRep = new LoggingRepository(LectureService.class.getName());
    private Integer id;

    public Lecture createNewLecture(String lectureName, String discription) {
        if (lectureName == null || lectureName.equals("") || lectureName.equals("empty")) {
            try {
                throw new ValidationExceptions("Lecture name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        if (discription == null || discription.equals("") || discription.equalsIgnoreCase("empty")) {
            try {
                throw new ValidationExceptions("Discription to a Lecture can not be empty");
            } catch (ValidationExceptions e) {
                logRep.warningLog("Помилка валідації: ", e);
                System.out.println(String.valueOf(e));
            }
        }
        return new Lecture(lectureName, discription);
    }

    public static Lecture createNewLectureByUsers() {
        logRep.debugLog("Створення лекції");
        System.out.println("""
        Створіть нову лекцію
        Введіть назву та опис""");
        Scanner sc = new Scanner(System.in);
        System.out.println("Назва: ");
        String lectureName = sc.nextLine();
        System.out.println("Опис: ");
        String discription = sc.nextLine();
        sc.close();
        return new Lecture(lectureName, discription);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
