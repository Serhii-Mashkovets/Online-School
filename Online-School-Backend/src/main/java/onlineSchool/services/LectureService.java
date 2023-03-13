package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Lecture;
import onlineSchool.models.Teachers;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

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


    public static Lecture getMaxLecture(@NotNull List<Lecture> lectures) {
        return lectures.stream()
                .max(Comparator.comparingInt(lecture -> lecture.getAddMaterials().size()))
                .orElseThrow(() -> new IllegalStateException("Лекції не знайдено"));
    }


    public static @NotNull Lecture getTheEarliestLecture(@NotNull List<Lecture> lectures) {
        Lecture earliestLecture = lectures.stream()
                .min(Comparator.comparing(Lecture::getCreatedAt))
                .orElseThrow(() -> new IllegalStateException("Лекції не знайдено"));

        System.out.println("Лекція, котра була створена найраніше: " + earliestLecture.getCreatedAt());
        return earliestLecture;
    }


    public static void groupedLecturesByTeacher(@NotNull List<Lecture> lectures) {
        Map<Teachers, List<Lecture>> lecturesByTeacher = lectures.stream()
                .collect(Collectors.groupingBy(Lecture::getTeacherOfLecture));

        lecturesByTeacher.forEach((teacher, lectureList) -> {
            System.out.println(teacher.getTeacherName() + ":");
            lectureList.forEach(lecture -> System.out.println("\t" + lecture.getLectureName()));
        });
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}