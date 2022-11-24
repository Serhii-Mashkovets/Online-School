import onlineSchool.models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // topic 7
        Course courseOne = new Course();
        courseOne.fullCourse("Математична логіка ЕВМ", 1);

        Course courseTwo = new Course();
        courseTwo.fullCourse("Недвійкова логіка ЕВМ", 1);

        System.out.println("Оберіть, будь ласка, курс: " +
                "\n" + "1 " + courseOne.courseNameOne +
                "\n" + "2 " + courseTwo.courseNameOne);

        Scanner sc = new Scanner(System.in);
        int numberOfTheCourse = sc.nextInt();
        System.out.println("Ви ввели: " + numberOfTheCourse);

        switch (numberOfTheCourse) {
            case 1 -> System.out.println("Ви обрали курс: " + courseOne.courseNameOne);
            case 2 -> System.out.println("Ви обрали курс: " + courseTwo.courseNameOne);
            default -> System.out.println("Такого курсу не існує!");
        }

        // to pick a lecture
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

        System.out.println("Оберіть необхідну лекцію: " +
                "\n" + "10 " + lectureOne.lectureTopic +
                "\n" + "11 " + lectureTwo.lectureTopic +
                "\n" + "12 " + lectureThree.lectureTopic +
                "\n" + "13 " + lectureFour.lectureTopic +
                "\n" + "14 " + lectureFive.lectureTopic +
                "\n" + "15 " + lectureSix.lectureTopic);
        int numberOfTheLecture = sc.nextInt();
        System.out.println("Ви ввели: " + numberOfTheLecture);

        switch (numberOfTheLecture) {
            case 10 -> System.out.println("Ви обрали лекцію: " + lectureOne.lectureTopic);
            case 11 -> System.out.println("Ви обрали лекцію: " + lectureTwo.lectureTopic);
            case 12 -> System.out.println("Ви обрали лекцію: " + lectureThree.lectureTopic);
            case 13 -> System.out.println("Ви обрали лекцію: " + lectureFour.lectureTopic);
            case 14 -> System.out.println("Ви обрали лекцію: " + lectureFive.lectureTopic);
            case 15 -> System.out.println("Ви обрали лекцію: " + lectureSix.lectureTopic);
            default -> System.out.println("Такої лекції не існує!");
        }

        // to pick student
        Students fullNameOne = new Students("Тарас", "Шевченко");
        System.out.println("Перший студент: " + fullNameOne.studentName + " " + fullNameOne.studentLastName);

        Students fullNameTwo = new Students(" Іван ", "Франко");
        System.out.println("Другий студент: " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName);

        Students fullNameThree = new Students("Олена", "Бджілка");
        System.out.println("Третій студент: " + fullNameThree.studentName + " " + fullNameThree.studentLastName);

        System.out.println("Оберіть студента, котрий відвідає курс: " +
                "\n" + "20 " + fullNameOne.studentName + " " + fullNameOne.studentLastName +
                "\n" + "21 " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName +
                "\n" + "22 " + fullNameThree.studentName + " " + fullNameThree.studentLastName);
        int numberOfTheStudent = sc.nextInt();
        System.out.println("Ви ввели: " + numberOfTheStudent);

        switch (numberOfTheStudent) {
            case 20 -> System.out.println("Відвідувати курс буде: " + fullNameOne.studentName
                    + " " + fullNameOne.studentLastName);
            case 21 -> System.out.println("Відвідувати курс буде: " + fullNameTwo.studentName + " "
                    + fullNameTwo.studentLastName);
            case 22 -> System.out.println("Відвідувати курс буде: " + fullNameThree.studentName + " "
                    + fullNameThree.studentLastName);
            default -> System.out.println("Такого студента не знайдено!");
        }

        // to pick teacher
        Teachers teacherOne = new Teachers("Альберт", "Енштейн");
        Teachers teacherTwo = new Teachers("Річард", "Докінз");
        Teachers teacherThree = new Teachers("Фермі", "Енріко");

        System.out.println("Оберіть викладача для курсу: " +
                "\n" + "30 " + teacherOne.teacherName + " " + teacherOne.teacherSecondName +
                "\n" + "31 " + teacherTwo.teacherName + " " + teacherTwo.teacherSecondName +
                "\n" + "32 " + teacherThree.teacherName + " " + teacherThree.teacherSecondName);
        int numberOfTheTeacher = sc.nextInt();
        System.out.println("Ви ввели: " + numberOfTheTeacher);

        switch (numberOfTheTeacher) {
            case 30 -> System.out.println("Викладати буде: " + teacherOne.teacherName +
                    " " + teacherOne.teacherSecondName);
            case 31 -> System.out.println("Викладати буде: " + teacherTwo.teacherName +
                    " " + teacherTwo.teacherSecondName);
            case 32 -> System.out.println("Викладати буде: " + teacherThree.teacherName +
                    " " + teacherThree.teacherSecondName);
            default -> System.out.println("Такого викладача не знайдено!");
        }
        System.out.println("Вітаю! Ваш курс складено.");


        // to create a new lecture and don`t abort this program
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

        System.out.println("Введіть id: ");
        Course.id = sc.nextInt();
        System.out.println("Id лекції: " + Course.id);
        Lecture lecture123 = new Lecture(lectureThemeOne6, lectureTeacherName, lectureMainBook, Course.id);
        Course.id++;
        System.out.printf("%s", "Назва лекції " + lectureThemeOne6 +
                " Ім'я викладача " + lectureTeacherName +
                " Книга для навчання " + lectureMainBook +
                " id " + Course.id);

        System.out.println("\n" + "Бажаєте створити ще одну лекцію?");
        System.out.println("1 Так" + "\n" + "2 Ні ");
        int toBeOrNotToBe = sc.nextInt();

        if (toBeOrNotToBe == 1) {
            System.out.println("Введіть тему лекції: ");
            String lectureThemeOne1 = sc2.nextLine();
            System.out.println("Тема лекції: " + lectureThemeOne1);

            System.out.println("Введіть ім'я викладача лекції: ");
            String lectureTeacherName1 = sc2.nextLine();
            System.out.println("Ім'я викладача: " + lectureTeacherName1);

            System.out.println("Введіть книгу для вивчення теми: ");
            String lectureMainBook1 = sc2.nextLine();
            System.out.println("Книга: " + lectureMainBook1);

            System.out.println("Введіть id: ");
            Course.id = sc.nextInt();
            System.out.println("Id лекції: " + Course.id);
            Lecture lecture1234 = new Lecture(lectureThemeOne1, lectureTeacherName1, lectureMainBook1, Course.id);
            System.out.printf("%s", "Назва лекції " + lectureThemeOne1 +
                    "\n" + " Ім'я викладача " + lectureTeacherName1 +
                    "\n" + " Книга для навчання " + lectureMainBook1 +
                    "\n" + " id " + Course.id);
            Course.id++;

            System.out.println(" id:" + Course.id);
        } else if (toBeOrNotToBe == 2) {
            System.out.println("Ще одну лекцію не буде створено!");
            System.out.println("id:" + Course.id);
        } else {
            System.out.println("Такого числа не знайдено!");
            System.out.println("id:" + Course.id);
        }

        sc.close();
        sc2.close();
    }
}