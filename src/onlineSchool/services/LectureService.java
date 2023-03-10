package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.AddMaterials;
import onlineSchool.models.Lecture;
import onlineSchool.repository.AddMaterialsRepository;
import onlineSchool.repository.LectureRepository;

import java.time.LocalDateTime;
import java.util.*;

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


    public static Optional<Lecture> createNewLectureByUsers() {
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
        return Optional.ofNullable(new Lecture(lectureName, discription));
    }


    public static Lecture getMaxLecture(List<Lecture> lectures) {
        return lectures.stream()
                .max(Comparator.comparingInt(lecture -> lecture.getAddMaterials().size()))
                .orElseThrow(() -> new IllegalStateException("Лекції не знайдено"));
    }


    public static Lecture getTheEarliestLecture(List<Lecture> lectures) {
        Lecture earliestLecture = lectures.stream()
                .min(Comparator.comparing(Lecture::getCreatedAt))
                .orElseThrow(() -> new IllegalStateException("Лекції не знайдено"));

        System.out.println("Лекція, котра була створена найраніше: " + earliestLecture.getCreatedAt());
        return earliestLecture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
