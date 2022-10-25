import onlineSchool.models.ModelsLessons;
import onlineSchool.models.ModelsStudents;


public class Main {
    public static void main(String[] args) {
    ModelsLessons newLessonOne = new ModelsLessons();
    newLessonOne.lessonThemeOne = "Теорія ймовірності";
    System.out.println("Перша тема заняття: " + newLessonOne.lessonThemeOne);

    ModelsLessons newLessonTwo = new ModelsLessons();
    newLessonTwo.lessonThemeTwo = "Теорія математичної статистики";
    System.out.println("Друга тема заняття: " + newLessonTwo.lessonThemeTwo);

    ModelsLessons newLessonThree = new ModelsLessons();
    newLessonThree.lessonThemeThree = "Алан Тьюрінг. Машина Енігма. Тести Тьюрінга";
    System.out.println("Третя тема заняття: " + newLessonThree.lessonThemeThree);

    System.out.println("Виведемо лічильник. Він дорівнює " + ModelsLessons.counter);

    // "Пограємось" з modelsStudets класом
        ModelsStudents fullNameOne = new ModelsStudents("Тарас", "Шевченко");
        System.out.println("Перший студент: " + fullNameOne.studentName + " " + fullNameOne.studentLastName);

        ModelsStudents fullNameTwo = new ModelsStudents(" Іван ", "Франко");
        System.out.println("Другий студент: " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName);

        ModelsStudents fullNameThree = new ModelsStudents("Олена", "Бджілка");
        System.out.println("Третій студент: " + fullNameThree.studentName + " " + fullNameThree.studentLastName);

        fullNameThree.setStudentAge(-1);
        System.out.println("Олені Бджілці " + fullNameThree.getStudentAge() + " років");

        fullNameTwo.setStudentAge(23);
        System.out.println("Івану Франку " + fullNameTwo.getStudentAge() + " роки");

        fullNameOne.setStudentAge(70);
        System.out.println("Тарасу Шевченку " + fullNameOne.getStudentAge() + " років");

    }
}