import onlineSchool.models.modelsLessons;
import onlineSchool.models.modelsStudents;


public class Main {
    public static void main(String[] args) {
    modelsLessons newLessonOne = new modelsLessons();
    newLessonOne.lessonThemeOne = "Теорія ймовірності";
    System.out.println("Перша тема заняття: " + newLessonOne.lessonThemeOne);

    modelsLessons newLessonTwo = new modelsLessons();
    newLessonTwo.lessonThemeTwo = "Теорія математичної статистики";
    System.out.println("Друга тема заняття: " + newLessonTwo.lessonThemeTwo);

    modelsLessons newLessonThree = new modelsLessons();
    newLessonThree.lessonThemeThree = "Алан Тьюрінг. Машина Енігма. Тести Тьюрінга";
    System.out.println("Третя тема заняття: " + newLessonThree.lessonThemeThree);

    System.out.println("Виведемо лічильник. Він дорівнює " + modelsLessons.counter);

    // "Пограємось" з modelsStudets класом
        modelsStudents fullNameOne = new modelsStudents("Тарас", "Шевченко");
        System.out.println("Перший студент: " + fullNameOne.studentName + " " + fullNameOne.studentLastName);

        modelsStudents fullNameTwo = new modelsStudents(" Іван ", "Франко");
        System.out.println("Другий студент: " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName);

        modelsStudents fullNameThree = new modelsStudents("Олена", "Бджілка");
        System.out.println("Третій студент: " + fullNameThree.studentName + " " + fullNameThree.studentLastName);

        fullNameThree.setStudentAge(-1);
        System.out.println("Олені Бджілці " + fullNameThree.getStudentAge() + " років");

        fullNameTwo.setStudentAge(23);
        System.out.println("Івану Франку " + fullNameTwo.getStudentAge() + " роки");

        fullNameOne.setStudentAge(70);
        System.out.println("Тарасу Шевченку " + fullNameOne.getStudentAge() + " років");

    }
}