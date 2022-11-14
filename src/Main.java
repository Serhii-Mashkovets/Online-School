import onlineSchool.models.*;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /*
        Course veryNewCourse = new Course ();
        veryNewCourse.courseName = "Математична логіка";
        System.out.println("Назва курсу, котрий ми будемо вивчати: " + veryNewCourse.courseName + ".");
        System.out.println("Аудиторія для заняття: " + veryNewCourse.CLASSROOM_FOR_LESSONS);
        */

        // topic 7
        fullCourseP();
        lectureFromConsole();


    /* Lecture newLessonOne = new Lecture();
    newLessonOne.lessonThemeOne = "Теорія ймовірності";
    System.out.println("Перша тема заняття: " + newLessonOne.lessonThemeOne);

    Lecture newLessonTwo = new Lecture();
    newLessonTwo.lessonThemeTwo = "Теорія математичної статистики";
    System.out.println("Друга тема заняття: " + newLessonTwo.lessonThemeTwo);

    Lecture newLessonThree = new Lecture();
    newLessonThree.lessonThemeThree = "Алан Тьюрінг. Машина Енігма. Тести Тьюрінга";
    System.out.println("Третя тема заняття: " + newLessonThree.lessonThemeThree);

    Lecture newLessonFour = new Lecture();
    newLessonFour.lessonThemeFour = "Коофіцієнт кореляції Пірсона";
    System.out.printf ("%s %n", "Четверта тема заняття: " + newLessonFour.lessonThemeFour + ".");

    Lecture newLessonFive = new Lecture();
    newLessonFive.lessonThemeFive = "Комп'ютерні числові симуляції";
    System.out.printf ("%s %n", "П'ята тема заняття: " + newLessonFive.lessonThemeFive + ".");

    System.out.println("Виведемо лічильник для класу Lecture. Він дорівнює " + Lecture.counter);
    */

    /*
        fullNameThree.setStudentAge(-1);
        System.out.println("Олені Бджілці " + fullNameThree.getStudentAge() + " років");

        fullNameTwo.setStudentAge(23);
        System.out.println("Івану Франку " + fullNameTwo.getStudentAge() + " роки");

        fullNameOne.setStudentAge(70);
        System.out.println("Тарасу Шевченку " + fullNameOne.getStudentAge() + " років");

        System.out.println ("Виконати наступні домашні завдання: ");
       HomeWork lectureHomeWork = new HomeWork();
        lectureHomeWork.homeWorkOne();
        System.out.println(lectureHomeWork.homeWorkOne());

       HomeWork lectureHomeWorkTwo = new HomeWork();
        lectureHomeWorkTwo.homeWorkTwo();
        System.out.println( lectureHomeWorkTwo.homeWorkTwo());

        HomeWork lectureHomeWorkThree = new HomeWork ();
        lectureHomeWorkThree.homeWorkThree();
        System.out.println(lectureHomeWorkThree.homeWorkThree());

        System.out.println("Виведемо лічильник для класу HomeWork. Він дорівнює " + HomeWork.counterNew + ".");


        System.out.println("Для вивчення курсу можна ознайомитись з наступними додатковими матеріалами: ");
        AddMaterials firstAdd = new AddMaterials("Probability Theory and Mathematical Statistics, за авторством Розанова Ю.А.",
                "Mathematical logic за авторством Алана Тьюрінга.");
        System.out.println(firstAdd.bookOne);
        System.out.println(firstAdd.bookTwo);  */

    }

    public static void fullCourseP() {
        // to pick a course
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

        //        System.out.println(lectureSix.countId());
        //        System.out.println(Lecture.lectureCounter);

        System.out.println("Оберіть необхідну лекцію: " +
                "\n" + "10 " + lectureOne.lectureTopic +
                "\n" + "11 " + lectureTwo.lectureTopic +
                "\n" + "12 " + lectureThree.lectureTopic +
                "\n" + "13 " + lectureFour.lectureTopic +
                "\n" + "14 " + lectureFive.lectureTopic +
                "\n" + "15 " + lectureSix.lectureTopic);
        Scanner sc1 = new Scanner(System.in);
        int numberOfTheLecture = sc1.nextInt();
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
        Scanner sc2 = new Scanner(System.in);
        int numberOfTheStudent = sc2.nextInt();
        System.out.println("Ви ввели: " + numberOfTheStudent);

        switch (numberOfTheStudent) {
            case 20 ->
                    System.out.println("Відвідувати курс буде: " + fullNameOne.studentName + " " + fullNameOne.studentLastName);
            case 21 ->
                    System.out.println("Відвідувати курс буде: " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName);
            case 22 ->
                    System.out.println("Відвідувати курс буде: " + fullNameThree.studentName + " " + fullNameThree.studentLastName);
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
        Scanner sc3 = new Scanner(System.in);
        int numberOfTheTeacher = sc3.nextInt();
        System.out.println("Ви ввели: " + numberOfTheTeacher);

        switch (numberOfTheTeacher) {
            case 30 ->
                    System.out.println("Викладати буде: " + teacherOne.teacherName + " " + teacherOne.teacherSecondName);
            case 31 ->
                    System.out.println("Викладати буде: " + teacherTwo.teacherName + " " + teacherTwo.teacherSecondName);
            case 32 ->
                    System.out.println("Викладати буде: " + teacherThree.teacherName + " " + teacherThree.teacherSecondName);
            default -> System.out.println("Такого викладача не знайдено!");
        }

        System.out.println("Вітаю! Ваш курс складено.");
    }

    public static String lectureFromConsole() {
        System.out.println("Введіть тему лекції: ");
        Scanner sc123 = new Scanner(System.in);
        String lectureThemeOne = sc123.nextLine();
        System.out.println("Тема лекції: " + lectureThemeOne);

        System.out.println("Введіть ім'я викладача лекції: ");
        Scanner sc1234 = new Scanner(System.in);
        String lectureTeacherName = sc1234.nextLine();
        System.out.println("Ім'я викладача: " + lectureTeacherName);

        System.out.println("Введіть книгу для вивчення теми: ");
        Scanner sc12345 = new Scanner(System.in);
        String lectureMainBook = sc12345.nextLine();
        System.out.println("Книга: " + lectureMainBook);

        System.out.println("Введіть id: ");
        Scanner sc123456 = new Scanner(System.in);
        Course.id = sc123456.nextInt();
        System.out.println("Id лекції: " + Course.id);
        Lecture lecture123 = new Lecture(lectureThemeOne, lectureTeacherName, lectureMainBook, Course.id);
        Course.id++;
        System.out.printf("%s", "Назва лекції " + lectureThemeOne +
                " Ім'я викладача " + lectureTeacherName +
                " Книга для навчання " + lectureMainBook +
                " id " + Course.id);

        String result = "Назва лекції " + lectureThemeOne +
                " Ім'я викладача " + lectureTeacherName +
                " Книга для навчання " + lectureMainBook;

        System.out.println("\n" + "Бажаєте створити ще одну лекцію?");
        System.out.println("1 Так" + "\n" + "2 Ні ");
        Scanner sc1234567 = new Scanner(System.in);
        int toBeOrNotToBe = sc1234567.nextInt();

        if (toBeOrNotToBe == 1) {
            System.out.println("Введіть тему лекції: ");
            Scanner sc987 = new Scanner(System.in);
            String lectureThemeOne1 = sc987.nextLine();
            System.out.println("Тема лекції: " + lectureThemeOne1);

            System.out.println("Введіть ім'я викладача лекції: ");
            Scanner sc9876 = new Scanner(System.in);
            String lectureTeacherName1 = sc9876.nextLine();
            System.out.println("Ім'я викладача: " + lectureTeacherName1);

            System.out.println("Введіть книгу для вивчення теми: ");
            Scanner sc98765 = new Scanner(System.in);
            String lectureMainBook1 = sc98765.nextLine();
            System.out.println("Книга: " + lectureMainBook1);

            System.out.println("Введіть id: ");
            Scanner sc987654 = new Scanner(System.in);
            Course.id = sc987654.nextInt();
            System.out.println("Id лекції: " + Course.id);
            Lecture lecture1234 = new Lecture(lectureThemeOne1, lectureTeacherName1, lectureMainBook1, Course.id);
            System.out.printf("%s", "Назва лекції " + lectureThemeOne1 +
                    " Ім'я викладача " + lectureTeacherName1 +
                    " Книга для навчання " + lectureMainBook1 +
                    " id " + Course.id);
            Course.id++;

            String result1 = "Назва лекції " + lectureThemeOne +
                    " Ім'я викладача " + lectureTeacherName +
                    " Книга для навчання " + lectureMainBook;
            System.out.println("id:" + Course.id);
            return result1;
        } else if (toBeOrNotToBe == 2) {
            System.out.println("Ще одну лекцію не буде створено!");
            System.out.println("id:" + Course.id);
            return null;
        } else {
            System.out.println("Такого числа не знайдено!");
            System.out.println("id:" + Course.id);
        }

        sc123.close();
        sc1234.close();
        sc12345.close();
        sc123456.close();

        return result;
    }
}