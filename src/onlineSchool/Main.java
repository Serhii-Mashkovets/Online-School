package onlineSchool;

import onlineSchool.controlWork.StudentThread;
import onlineSchool.loggingJournal.LogReader;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Students;
import onlineSchool.repository.CourseRepository;
import onlineSchool.services.AddMaterialService;
import onlineSchool.services.CourseService;
import onlineSchool.services.HomeWorkService;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static LoggingRepository logRep = new LoggingRepository(Main.class.getName());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Бажаєте провести контрольну роботу?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int choiceCW = sc.nextInt();
        if (choiceCW == 1) {
            logRep.infoLog("Початок контрольної роботи в мейні");
            controlWork();
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                logRep.errorLog("Сталась помилка ", e);
                throw new RuntimeException(e);
            }
            logRep.infoLog("Кінець роботи в блоці Контрольна робота в мейні");

        } else if (choiceCW == 2) {
            System.out.println("Контрольна робота проведена не буде");
            logRep.infoLog("Кінець роботи в блоці Контрольна робота в мейні");
        }

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

            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        logRep.debugLog("Програма закінчила роботу!");
        System.out.println("""
                Бажаєте вивести файли логу в консоль?
                Введіть 1, якщо так
                Введіть 2, якщо бажаєте вийти з програми""");
        int logToScreen = sc.nextInt();
        if (logToScreen == 1) {
            LogReader logReader = new LogReader();
            logReader.readDataFromFile();
        } else if (logToScreen == 2) System.exit(0);
        sc.close();
    }

    public static void controlWork() {
        // Створюємо масив студентів
        Students[] students = new Students[10];
        students[0] = new Students("Ernest", "Heminguey");
        students[1] = new Students("Erih Maria", "Remark");
        students[2] = new Students("Lesya", "Ukrainka");
        students[3] = new Students("Willyam", "Shekspear");
        students[4] = new Students("Charls", "Bukovski");
        students[5] = new Students("Frederik", "Begbeder");
        students[6] = new Students("Taras", "Shevchenko");
        students[7] = new Students("Den", "Braun");
        students[8] = new Students("Sun", "Dzi");
        students[9] = new Students("Ivan", "Franko");

        int[] tasks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Створюємо масив для збереження завдання для кожного студента
        int[] studentTasks = new int[students.length];

        // Перемішуємо завдання
        shuffleArray(tasks);

        // Перебираємо студентів і розподіляємо завдання
        for (int i = 0; i < students.length; i++) {
            studentTasks[i] = tasks[i];
            System.out.println(students[i].getStudentName() + " " + students[i].getStudentLastName() +
                    " отримав завдання " + studentTasks[i]);
        }

        // Запускаємо студентів
        StudentThread[] threads = new StudentThread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new StudentThread(students[i], studentTasks[i]);
            threads[i].start();
        }

        // Чекаємо 12 секунд
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Перевіряємо, хто закінчив першим, другим і т.д.
        StudentThread[] finishedThreads = new StudentThread[students.length];
        System.arraycopy(threads, 0, finishedThreads, 0, threads.length);
        for (int i = 0; i < finishedThreads.length - 1; i++) {
            for (int j = i + 1; j < finishedThreads.length; j++) {
                if (finishedThreads[j].getExecutionTime() < finishedThreads[i].getExecutionTime()) {
                    StudentThread temp = finishedThreads[i];
                    finishedThreads[i] = finishedThreads[j];
                    finishedThreads[j] = temp;
                }
            }
        }
        System.out.println("Результати:");
        for (int i = 0; i < finishedThreads.length; i++) {
            System.out.println(finishedThreads[i].fullName() + " закінчив за "
                    + finishedThreads[i].getExecutionTime() + " секунд");
        }

        // Перевіряємо, хто не встиг виконати завдання вчасно
        for (int i = 0; i < threads.length; i++) {
            if (!threads[i].isFinished()) {
                System.out.println(threads[i].fullName() + " не встиг виконати завдання вчасно");
            }


        }


    }

    public static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}