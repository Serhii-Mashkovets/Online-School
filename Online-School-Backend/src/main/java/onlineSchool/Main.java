package onlineSchool;

import onlineSchool.controlWork.StudentThread;
import onlineSchool.databases.AllInfoFromATableInDB;
import onlineSchool.exceptions.DuplicateEmailException;
import onlineSchool.ipChecker.Client;
import onlineSchool.ipChecker.Server;
import onlineSchool.loggingJournal.*;
import onlineSchool.loggingJournal.LevelOfLogging;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.loggingJournal.LoggingService;
import onlineSchool.models.*;
import onlineSchool.repository.CourseRepository;
import onlineSchool.repository.StudentsRepository;
import onlineSchool.serialization.SerializationForCourse;
import onlineSchool.services.*;
import onlineSchool.services.PersonService;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static final LoggingRepository logRep = new LoggingRepository(Main.class.getName());

    public static void main(String[] args) throws DuplicateEmailException {
        logRep.infoLog("Початок роботи в мейні");
        LoggingService.writeLevelConfig(LevelOfLogging.OFF);
        Thread levelWatcher = new Thread(new LevelWatcher(), "LevelWatcher");
        levelWatcher.start();

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Бажаєте згрупувати лекції за викладачем?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int techerLectureChoise = sc.nextInt();
        if (techerLectureChoise == 1) {
            logRep.infoLog("Початок роботи в блоці сортування лекцій за викладачем в мейні");
            LectureService.groupedLecturesByTeacher(lecturesListWithTeachers());
        } else if (techerLectureChoise == 2) {
            System.out.println("Переходимо до наступного етапу");
            logRep.infoLog("Кінець роботи в блоці сортування лекцій за викладачем в мейні");
        }

        System.out.println("""
                Бажаєте створити студента?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int crtOfStudDB = sc.nextInt();
        if (crtOfStudDB == 1) {
            try {
                studentFromDB();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (crtOfStudDB == 2) {
            System.out.println("Переходимо до наступного етапу");
        }


        System.out.println("""
                Бажаєте вивести всі дані з певної таблички бази даних ?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int dbChoise = sc.nextInt();
        if (dbChoise == 1) {
            System.out.println("Введіть назву таблички: ");
            String nameOfTable = sc.next();
            AllInfoFromATableInDB allInfoFromATableInDB = new AllInfoFromATableInDB();
            try {
                System.out.println(allInfoFromATableInDB.getTableData(nameOfTable));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (dbChoise == 2) {
            System.out.println("Переходимо до наступного етапу.");
        }

        System.out.println("""
                Бажаєте згрупувати додаткові матеріали за лекціями?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int addMatChoise = sc.nextInt();
        if (addMatChoise == 1) {
            logRep.infoLog("Початок роботи в блоці сортування додаткових матеріаліз за лекціями в мейні");
            AddMaterialService.groupAddMatByLectures(addMatList(), lecturesListWithTeachers());
        } else if (addMatChoise == 2) {
            System.out.println("Переходимо до наступного етапу");
            logRep.infoLog("Кінець роботи в блоці сортування додаткових матеріаліз за лекціями в мейні");
        }

        System.out.println("""
                Бажаєте створити Map, де key = email, a values = Ім'я та прізвище персони?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int personMapChoise = sc.nextInt();
        if (personMapChoise == 1) {
            logRep.infoLog("Початок роботи в блоці створення Map, де key = email, a values = Ім'я та прізвище персони в мейні");
            PersonService.mapWithEmailAndName(personList());
        } else if (personMapChoise == 2) {
            System.out.println("Переходимо до наступного етапу");
            logRep.infoLog("Кінець роботи в блоці створення Map, де key = email, a values = Ім'я та прізвище персони в мейні");
        }

        System.out.println("""
                Бажаєте вивести емейли студентів в окремий файл в натуральному порядку?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int emailInNaturalOrderChoise = sc.nextInt();
        if (emailInNaturalOrderChoise == 1) {
            logRep.infoLog("Початок роботи в блоці виведення емейлів студентів в окремий файл в натуральному порядку в мейні");
            Stream<Student> studentStream = studentsList().stream();
            Stream<String> emailStream = studentStream.map(Student::getEmail);
            Stream<String> sortedEmailStream = emailStream.sorted();

            try {
                Files.write(Paths.get("emails.txt"), (Iterable<String>) sortedEmailStream::iterator);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (emailInNaturalOrderChoise == 2) {
            System.out.println("Переходимо до наступного етапу");
            logRep.infoLog("Кінець роботи в блоці виведення емейлів студентів в окремий файл в натуральному порядку в мейні");

        }

        System.out.println("""
                Бажаєте створити нову персону?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int newPersonchoise = sc.nextInt();
        if (newPersonchoise == 1) {
            logRep.infoLog("Початок створення персони в мейні");
            PersonService.createNewPersonByUsers();
        } else if (newPersonchoise == 2) {
            System.out.println("Переходимо до наступного етапу");
            logRep.infoLog("Кінець роботи в блоці створення персони в мейні");
        }


        System.out.println("""
                Бажаєте вивести на екран лекцію, котра створена раніше за всіх, та з найбільшою кількістю додаткових матеріалів?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int lectureChoise = sc.nextInt();
        if (lectureChoise == 1) {
            logRep.infoLog("Початок роботи в блоці виведення лекції на екран ," +
                    " котра створена раніше всіх та з найбільшою кількістю додаткових матеріалів в мейні");
            Lecture lectureService = LectureService.getMaxLecture(lecturesList());
            LectureService.getTheEarliestLecture(lecturesList());
            System.out.println(lectureService);
        } else if (lectureChoise == 2) {
            logRep.infoLog("Закінчення роботи в блоці виведення лекції на екран ," +
                    " котра створена раніше всіх та з найбільшою кількістю додаткових матеріалів в мейні");
            System.out.println("Виведення лекції проведено не буде");
        }

        System.out.println("""
                Бажаєте вивести кількість логів з рівнем INFO починаючи з середини файлу
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int logInfoChoise = sc.nextInt();
        if (logInfoChoise == 1) {
            logRep.infoLog("Початок роботи в блоці виведення логів з рівнем інфо з середини файлу в мейні");
            File logFile = new File("src/onlineSchool/loggingJournal/Logging registration journal.txt");
            resultCountOfLogJournal(logFile);
        } else if (logInfoChoise == 2) {
            System.out.println("Виведення кількості логів проведено не буде");
            logRep.infoLog("Кінець роботи в блоці виведення логів з рівнем інфо з середини файлу в мейні");
        }

        System.out.println("""
                Бажаєте вивести прізвища викладачів до англійської літери N?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int choiseTN = sc.nextInt();
        if (choiseTN == 1) {
            logRep.infoLog("Початок порівняння прізвищ викладачів в мейні");
            teachersLastnameBeforeN((ArrayList<Teacher>) teachersList());
        } else if (choiseTN == 2) {
            System.out.println("Порівняння проведено не буде");
            logRep.infoLog("Кінець роботи в блоці порівняння прізвищ в мейні");
        }

        System.out.println("Виведемо в мейні всі строки з файлу, що містять повідомлення: ");
        LoggingService.readMessageFromFile();

        LoggingRepository.debugLog("Початок роботи перед контрольною роботою та створенням курсу");
        System.out.println("""
                Бажаєте провести контрольну роботу?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int choiceCW = sc.nextInt();
        if (choiceCW == 1) {
            logRep.infoLog("Початок контрольної роботи в мейні");
            controlWork();
            try {
                Thread.sleep(3000);
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
                Бажаєте увійти на сервер?
                Введіть 1, якщо так
                Введіть 2, якщо ні""");
        int choiseServer = sc.nextInt();
        if (choiseServer == 1) {
            logRep.infoLog("Початок роботи з сервером та перевірки айпі в мейні");
            Thread server = new Thread(new Server(), "Сервер");
            server.start();
            try {
                Thread.sleep(1000);
                Thread client = new Thread(new Client(), "Клієнт");
                client.start();
                server.join();
            } catch (InterruptedException e) {
                logRep.errorLog("Помилка переривання: ", e);
                throw new RuntimeException(e);
            }
        } else if (choiseServer == 2) {
            logRep.debugLog("Кінець роботи в блоці сервер в мейні");
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
                SerializationForCourse.serializeFile(course.createNewCourseByUsers());
                CourseRepository courseRepository = CourseRepository.getNewExample();
                Collections.sort(courseRepository.getElements());
                System.out.println(course);
                logRep.debugLog("Закінчення створення курсу в Мейні");

                System.out.println("""
                        Бажаєте вказати додаткові матеріали до курсу?
                        Введіть 1, якщо так
                        Введіть 2 якщо бажаєте завершити роботу""");

                int addmatCrt = 0;
                if (sc.hasNext()) {
                    sc.next();
                    addmatCrt = sc.nextInt();
                }
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

        levelWatcher.interrupt();

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

        Student[] students = new Student[10];
        students[0] = new Student("Ernest", "Heminguey");
        students[1] = new Student("Erih Maria", "Remark");
        students[2] = new Student("Lesya", "Ukrainka");
        students[3] = new Student("Willyam", "Shekspear");
        students[4] = new Student("Charls", "Bukovski");
        students[5] = new Student("Frederik", "Begbeder");
        students[6] = new Student("Taras", "Shevchenko");
        students[7] = new Student("Den", "Braun");
        students[8] = new Student("Sun", "Dzi");
        students[9] = new Student("Ivan", "Franko");

        int[] tasks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        int[] studentTasks = new int[students.length];


        shuffleArray(tasks);


        for (int i = 0; i < students.length; i++) {
            studentTasks[i] = tasks[i];
            System.out.println(students[i].getStudentName() + " " + students[i].getStudentLastName() +
                    " отримав завдання " + studentTasks[i]);
        }


        StudentThread[] threads = new StudentThread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new StudentThread(students[i], studentTasks[i]);
            threads[i].start();
        }


        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


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
        for (StudentThread finishedThread : finishedThreads) {
            System.out.println(finishedThread.fullName() + " закінчив за "
                    + finishedThread.getExecutionTime() + " секунд");
        }


        for (StudentThread thread : threads) {
            if (!thread.isFinished()) {
                System.out.println(thread.fullName() + " не встиг виконати завдання вчасно");
            }


        }


    }

    public static void shuffleArray(int @NotNull [] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static @NotNull List<Teacher> teachersList() {
        ArrayList<Teacher> teacherListExample = new ArrayList<>();
        teacherListExample.add(new Teacher("Bob", "Dilan"));
        teacherListExample.add(new Teacher("Naruto", "Uzumaki"));
        teacherListExample.add(new Teacher("Stepan", "Giga"));
        teacherListExample.add(new Teacher("Mikola", "Gogol"));
        teacherListExample.add(new Teacher("John", "Doe"));
        teacherListExample.add(new Teacher("Almera", "Nissan"));
        return teacherListExample;
    }

    public static void teachersLastnameBeforeN(@NotNull ArrayList<Teacher> teacherList) {
        teacherList.stream()
                .filter(t -> t.getTeacherSecondName().charAt(0) < 'N')
                .forEach(t -> System.out.println(t.getTeacherSecondName()));
    }

    public static void resultCountOfLogJournal(File logFile) {
        try {
            long infoCount = LoggingService.countLogs(logFile);
            System.out.println("Кількість логів INFO з середини файлу: " + infoCount);
        } catch (IOException e) {
            System.err.println("Помилка читання файлу логування: " + e.getMessage());
        }
    }

    public static @NotNull List<Lecture> lecturesList() {
        Person person = new Person("", "", "", "");

        ArrayList<AddMaterials> addMatForLectures = new ArrayList<>();
        addMatForLectures.add(new AddMaterials("1", 3, ResourseType.URL));
        addMatForLectures.add(new AddMaterials("2", 2, ResourseType.VIDEO));
        addMatForLectures.add(new AddMaterials("3", 1, ResourseType.BOOK));
        addMatForLectures.add(new AddMaterials("5", 5, ResourseType.URL));

        ArrayList<HomeWork> homeWorkForLectures = new ArrayList<>();
        homeWorkForLectures.add(new HomeWork());
        homeWorkForLectures.add(new HomeWork());

        ArrayList<Lecture> lectureArrayList = new ArrayList<>();
        lectureArrayList.add(new Lecture("", "", person, addMatForLectures, homeWorkForLectures));
        lectureArrayList.add(new Lecture("1", "2", person, addMatForLectures, homeWorkForLectures));
        return lectureArrayList;
    }

    public static @NotNull List<AddMaterials> addMatList() {
        ArrayList<AddMaterials> addMatForLectures = new ArrayList<>();
        addMatForLectures.add(new AddMaterials("1", 3, ResourseType.URL));
        addMatForLectures.add(new AddMaterials("2", 2, ResourseType.VIDEO));
        addMatForLectures.add(new AddMaterials("3", 1, ResourseType.BOOK));
        addMatForLectures.add(new AddMaterials("5", 4, ResourseType.URL));
        return addMatForLectures;
    }

    public static @NotNull List<Lecture> lecturesListWithTeachers() {
        ArrayList<HomeWork> homeWorkForLectures = new ArrayList<>();
        homeWorkForLectures.add(new HomeWork());
        homeWorkForLectures.add(new HomeWork());

        ArrayList<Lecture> lectureArrayList = new ArrayList<>();
        lectureArrayList.add(new Lecture("Децентралізація обробки даних", "Як створити один мега - комп'ютер, зі ста Пентіум перших"
                , new Teacher("Jhon", "Week"), addMatList(), homeWorkForLectures));
        lectureArrayList.add(new Lecture("Нові комп'ютерні технології в Занзібарі", "Вивчимо як створюють комп'ютер в Африці",
                new Teacher("Tanjiro", "Hamada"), addMatList(), homeWorkForLectures));
        lectureArrayList.add(new Lecture("Колекції в джава", "Нарешті дізнаємось , що ж це таке",
                new Teacher("Tanjiro", "Hamada"), addMatList(), homeWorkForLectures));
        lectureArrayList.add(new Lecture("Прогнозування, як функція", "Чи зможе наш ПК стати екстрасенсом?"
                , new Teacher("Tanjiro", "Hamada"), addMatList(), homeWorkForLectures));

        return lectureArrayList;
    }

    public static @NotNull List<Person> personList() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Mihaylo", "Kocubinskiy", "+380999999999", "MishaYbiyca@gmail.com"));
        personArrayList.add(new Person("Oleg", "Striychenko", "+380633333333", "OlegDoter@ukr.net"));
        personArrayList.add(new Person("Vasil`", "Dontsov", "+380737777777", "VasyaKryaKrya@yahoo.com"));
        personArrayList.add(new Person("Baba", "Galya", "0463071718", "BabaGalya1934@gmail.com"));
        personArrayList.add(new Person("Larysa", "Kosach", "+380935555555", "LarIsa@ukr.net"));
        personArrayList.add(new Person("Oksana", "Ksanax", "+30551111111", "Ok@gmail.com"));
        personArrayList.add(new Person("Mykola", "Saint", "+380672222222", "St.Mykola@rambler.net"));
        return personArrayList;
    }

    public static @NotNull List<Student> studentsList() {
        ArrayList<Student> studlist = new ArrayList<>();
        studlist.add(new Student("Tom", "Cat", "catTom@gmail.com"));
        studlist.add(new Student("Mike", "Tyson", "TYson@gmail.com"));
        studlist.add(new Student("Satosi", "Kon", "KonGenialno@gmeil.com"));
        studlist.add(new Student("Nobuhiko", "Tokado", "Nt@gmail.com"));
        studlist.add(new Student("Leo", "Messi", "LeoMessi@gmail.com"));
        studlist.add(new Student("Serhii", "Mashkovets", "SM@gmail.com"));
        return studlist;
    }

    public static void studentFromDB() throws SQLException {
        StudentsRepository studentsRepository = new StudentsRepository();
        try {
            studentsRepository.add(new Student("Boby12345", "Doe12345", "boyboby12345@gmail.com"));
            System.out.println(studentsRepository.usingStudentById(1));
            System.out.println("Загальна кількість студентів = " + studentsRepository.sizeCount());
            System.out.println("Виведемо всіх студентів на екран: " + studentsRepository.getAllStudents());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}