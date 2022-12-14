package onlineSchool;

import onlineSchool.models.*;
import onlineSchool.repository.ParentingClassForRepositories;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        initData();

        while (true) {
            Scanner sc = new Scanner(System.in);

            Course courseOne = new Course();
            courseOne.fullCourse("Математична логіка ЕВМ", 1);

            Course courseTwo = new Course();
            courseTwo.fullCourse("Недвійкова логіка ЕВМ", 1);

            int numberOfTheCourse = 0;
            do {
                System.out.println("Оберіть, будь ласка, курс: " +
                        "\n" + "1 " + courseOne.getCourseNameOne() +
                        "\n" + "2 " + courseTwo.getCourseNameOne());
                numberOfTheCourse = sc.nextInt();
                System.out.println("Ви ввели: " + numberOfTheCourse);
            } while (numberOfTheCourse < 1 || numberOfTheCourse > 2);

            String courseChoise = "Ви обрали курс: ";
            switch (numberOfTheCourse) {
                case 1 -> System.out.println(courseChoise + courseOne.getCourseNameOne());
                case 2 -> System.out.println(courseChoise + courseTwo.getCourseNameOne());
                default -> System.out.println("Такого курсу не існує!");
            }

            Lecture lectureOne = new Lecture("Основи двійкового коду",
                    "Олег Скрипка", "Двійкове кодування", courseOne.countId());
            Lecture lectureTwo = new Lecture("Вивчення основ Assembly",
                    "Олег Винник", "Ease Assembly", courseOne.countId());
            Lecture lectureThree = new Lecture("Процедурне програмування",
                    "Святослав Вакарчук", "Інформатика 7 клас", courseOne.countId());
            Lecture lectureFour = new Lecture("Принцип об'єкто-орієнтованості в програмуванні",
                    "Олександр Пономарьов", "Інформатика 8 клас", courseOne.countId());
            Lecture lectureFive = new Lecture("Інкапсуляція, Поліморфізм, Наслідування",
                    "Олексій Завгородній", "Інформатика 9 клас", courseOne.countId());
            Lecture lectureSix = new Lecture("Фреймворки",
                    "Олексій Потапенко", "Інформатика 10 клас", courseOne.countId());

            int numberOfTheLecture = 0;
            do {
                System.out.println("Оберіть необхідну лекцію: " +
                        "\n" + "10 " + lectureOne.getLectureTopic() +
                        "\n" + "11 " + lectureTwo.getLectureTopic() +
                        "\n" + "12 " + lectureThree.getLectureTopic() +
                        "\n" + "13 " + lectureFour.getLectureTopic() +
                        "\n" + "14 " + lectureFive.getLectureTopic() +
                        "\n" + "15 " + lectureSix.getLectureTopic());
                numberOfTheLecture = sc.nextInt();
                System.out.println("Ви ввели: " + numberOfTheLecture);
            } while (numberOfTheLecture < 10 || numberOfTheLecture > 15);

            String lectureChoise = "Ви обрали лекцію: ";
            switch (numberOfTheLecture) {
                case 10 -> System.out.println(lectureChoise + lectureOne.getLectureTopic());
                case 11 -> System.out.println(lectureChoise + lectureTwo.getLectureTopic());
                case 12 -> System.out.println(lectureChoise + lectureThree.getLectureTopic());
                case 13 -> System.out.println(lectureChoise + lectureFour.getLectureTopic());
                case 14 -> System.out.println(lectureChoise + lectureFive.getLectureTopic());
                case 15 -> System.out.println(lectureChoise + lectureSix.getLectureTopic());
                default -> System.out.println("Такої лекції не існує!");
            }

            Students fullNameOne = new Students("Тарас", "Шевченко");
            System.out.println("Перший студент: " + fullNameOne.getStudentName() + " " + fullNameOne.getStudentLastName());

            Students fullNameTwo = new Students(" Іван ", "Франко");
            System.out.println("Другий студент: " + fullNameTwo.getStudentName() + " " + fullNameTwo.getStudentLastName());

            Students fullNameThree = new Students("Олена", "Бджілка");
            System.out.println("Третій студент: " + fullNameThree.getStudentName() + " " + fullNameThree.getStudentLastName());

            int numberOfTheStudent = 0;
            do {
                System.out.println("Оберіть студента, котрий відвідає курс: " +
                        "\n" + "20 " + fullNameOne.getStudentName() + " " + fullNameOne.getStudentLastName() +
                        "\n" + "21 " + fullNameTwo.getStudentName() + " " + fullNameTwo.getStudentLastName() +
                        "\n" + "22 " + fullNameThree.getStudentName() + " " + fullNameThree.getStudentLastName());
                numberOfTheStudent = sc.nextInt();
                System.out.println("Ви ввели: " + numberOfTheStudent);
            } while (numberOfTheStudent < 20 || numberOfTheStudent > 22);

            String studentChoise = "Відвідувати курс буде: ";
            switch (numberOfTheStudent) {
                case 20 -> System.out.println(studentChoise + fullNameOne.getStudentName()
                        + " " + fullNameOne.getStudentLastName());
                case 21 -> System.out.println(studentChoise + fullNameTwo.getStudentName() + " "
                        + fullNameTwo.getStudentLastName());
                case 22 -> System.out.println(studentChoise + fullNameThree.getStudentName() + " "
                        + fullNameThree.getStudentLastName());
                default -> System.out.println("Такого студента не знайдено!");
            }

            Teachers teacherOne = new Teachers("Альберт", "Енштейн");
            Teachers teacherTwo = new Teachers("Річард", "Докінз");
            Teachers teacherThree = new Teachers("Фермі", "Енріко");

            int numberOfTheTeacher = 0;
            do {
                System.out.println("Оберіть викладача для курсу: " +
                        "\n" + "30 " + teacherOne.getTeacherName() + " " + teacherOne.getTeacherSecondName() +
                        "\n" + "31 " + teacherTwo.getTeacherName() + " " + teacherTwo.getTeacherSecondName() +
                        "\n" + "32 " + teacherThree.getTeacherName() + " " + teacherThree.getTeacherSecondName());
                numberOfTheTeacher = sc.nextInt();
                System.out.println("Ви ввели: " + numberOfTheTeacher);
            } while (numberOfTheTeacher < 30 || numberOfTheTeacher > 32);

            String teacherChoise = "Викладати буде: ";
            switch (numberOfTheTeacher) {
                case 30 -> System.out.println(teacherChoise + teacherOne.getTeacherName() +
                        " " + teacherOne.getTeacherSecondName());
                case 31 -> System.out.println(teacherChoise + teacherTwo.getTeacherName() +
                        " " + teacherTwo.getTeacherSecondName());
                case 32 -> System.out.println(teacherChoise + teacherThree.getTeacherName() +
                        " " + teacherThree.getTeacherSecondName());
                default -> System.out.println("Такого викладача не знайдено!");
            }
            System.out.println("Вітаю! Ваш курс складено.");

            System.out.println("Введіть тему лекції: ");
            Scanner sc2 = new Scanner(System.in);
            String lectureThemeOne6 = sc2.nextLine();
            System.out.println("Тема лекції: " + lectureThemeOne6);

            System.out.println("Введіть ім'я викладача лекції: ");
            String lectureTeacherName = sc2.nextLine();
            System.out.println("Ім'я викладача: " + lectureTeacherName);

            System.out.println("Введіть книгу для вивчення теми: ");
            String lectureMainBook = sc2.nextLine();
            System.out.println("Книга: " + lectureMainBook);

            Course.setId(Course.getId() + 1);
            System.out.printf("%s", "Назва лекції " + lectureThemeOne6 +
                    " Ім'я викладача " + lectureTeacherName +
                    " Книга для навчання " + lectureMainBook +
                    " id " + Course.getId() + " Номер лекції " + Course.getId() + "\n");

            if (Course.getId() > 8) System.exit(0);

            System.out.println("Бажаєте завершити роботу: введіть `exit` " + "\n" +
                    "Якщо бажаєте продовжити, то введіть будь-який символ або строку");
            String exitButton = sc2.nextLine();
            if ("exit".equals(exitButton)) {
                System.exit(0);
            }

            sc.close();
            sc2.close();
        }
    }


    private static void initData() {
        Course course = new Course();
        Lecture lecture = new Lecture("I", "II", "III", course.getId());
        Lecture lecture2 = new Lecture("IV", "V", "VI", course.getId());
        Lecture lecture3 = new Lecture("VII", "VIII", "IX", course.getId());
    }

    private static void showArray(Lecture[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " " + Lecture.getId());
            System.out.println(Arrays.toString(a));
        }

    }
}