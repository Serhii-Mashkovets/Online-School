import onlineSchool.models.AddMaterials;
import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.models.Students;
import onlineSchool.models.Course;


public class Main {
    public static void main(String[] args) {
        Course veryNewCourse = new Course ();
        veryNewCourse.courseName = "Математична логіка";
        System.out.println("Назва курсу, котрий ми будемо вивчати: " + veryNewCourse.courseName + ".");

    Lecture newLessonOne = new Lecture();
    newLessonOne.lessonThemeOne = "Теорія ймовірності";
    System.out.println("Перша тема заняття: " + newLessonOne.lessonThemeOne);

    Lecture newLessonTwo = new Lecture();
    newLessonTwo.lessonThemeTwo = "Теорія математичної статистики";
    System.out.println("Друга тема заняття: " + newLessonTwo.lessonThemeTwo);

    Lecture newLessonThree = new Lecture();
    newLessonThree.lessonThemeThree = "Алан Тьюрінг. Машина Енігма. Тести Тьюрінга";
    System.out.println("Третя тема заняття: " + newLessonThree.lessonThemeThree);

    System.out.println("Виведемо лічильник для класу Lecture. Він дорівнює " + Lecture.counter);

    // "Пограємось" з modelsStudets класом
        Students fullNameOne = new Students("Тарас", "Шевченко");
        System.out.println("Перший студент: " + fullNameOne.studentName + " " + fullNameOne.studentLastName);

        Students fullNameTwo = new Students(" Іван ", "Франко");
        System.out.println("Другий студент: " + fullNameTwo.studentName + " " + fullNameTwo.studentLastName);

        Students fullNameThree = new Students("Олена", "Бджілка");
        System.out.println("Третій студент: " + fullNameThree.studentName + " " + fullNameThree.studentLastName);

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
        AddMaterials firstAdd = new AddMaterials("Probability Theory and Mathematical Statistics, за авторством Розанова Ю.А.", "Mathematical logic за авторством Алана Т.");
        System.out.println(firstAdd.bookOne);
        System.out.println(firstAdd.bookTwo);

    }
}