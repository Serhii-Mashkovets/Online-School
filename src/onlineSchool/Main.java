package onlineSchool;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.repository.CourseRepository;
import onlineSchool.services.AddMaterialService;
import onlineSchool.services.CourseService;
import onlineSchool.services.HomeWorkService;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static LoggingRepository logRep = new LoggingRepository(Main.class.getName());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Бажаєте створити новий курс?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int crtOfCourse = sc.nextInt();
        logRep.debugLog("Створення курсу в Мейні");
        try {
            if (crtOfCourse == 1) {
                CourseService course = new CourseService();
                course.createNewCourseByUsers();
                CourseRepository courseRepository = CourseRepository.getNewExample();
                Collections.sort(courseRepository.getElements());
                System.out.println(course);
                logRep.debugLog("Закінчення створення курсу в Мейні");

                System.out.println("""
                        Бажаєте вказати додаткові матеріали до курсу?
                        Введіть 1, якщо так
                        Введіть 2 якщо бажаєте завершити роботу""");
                int addmatCrt = sc.nextInt();
                try {
                    logRep.debugLog("Створення додаткових матеріалів в мейні");
                    if (addmatCrt == 1) {
                        AddMaterialService addMaterialService = new AddMaterialService();
                        addMaterialService.createNewAddMaterial();
                        System.out.println("""
                                Бажаєте відсортувати додаткові матеріали до курсу?
                                Введіть 1, якщо так
                                Введіть 2 якщо бажаєте завершити роботу""");
                        int sortAddMat = sc.nextInt();
                        try {
                            if (sortAddMat == 1) {
                                addMaterialService.sortAddMat();
                            } else if (sortAddMat == 2) {
                                System.exit(0);
                            }
                        } catch (IllegalArgumentException e) {
                            logRep.warningLog("Помилка невірного аргументу додаткових матеріалів в мейні: ", e);
                            System.err.println(e.getMessage());
                        }
                        System.out.println("""
                                Бажаєте вивести всі додаткові матеріали?
                                Введіть 1, якщо так
                                Введіть 2, якщо ні""");
                        int showAddMat = sc.nextInt();
                        if (showAddMat == 1) {
                            try {
                                addMaterialService.showAllAddmat();
                                System.out.println(addMaterialService);
                            } catch (IllegalArgumentException e) {
                                logRep.warningLog("Помилка невірного аргументу додаткових матеріалів в мейні: ", e);
                                System.err.println(e.getMessage());
                            }
                        } else if (showAddMat == 2) {
                            System.exit(0);
                        }
                    } else if (addmatCrt == 2) {
                        System.exit(0);
                    }
                } catch (IllegalArgumentException e) {
                    logRep.warningLog("Помилка невірного аргументу додаткових матеріалів в мейні: ", e);
                    System.err.println(e.getMessage());
                }
                System.out.println("""
                        Бажаєте додати домашнє завдання?
                        Введіть 1, якщо так
                        Введіть 2, якщо ні""");
                int hw = sc.nextInt();
                logRep.debugLog("Створення домашніх завдань в мейні");
                if (hw == 1) {
                    try {
                        HomeWorkService homeWorkService = new HomeWorkService();
                        homeWorkService.createHw();
                    } catch (IllegalArgumentException e) {
                        logRep.warningLog("Помилка невірного аргументу домашніх завдань в мейні: ", e);
                        System.err.println(e.getMessage());
                    }
                } else if (hw == 2) System.exit(0);

            } else if (crtOfCourse == 2) System.exit(0);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        sc.close();
        logRep.debugLog("Програма закінчила роботу!");
    }
}