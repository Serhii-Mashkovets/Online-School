package onlineSchool.models;

public class HomeWork {
    public String homeWorkOne () {
        String firstPart = "Використати елементи мат. статистики в завданні ";
        String secondPart = "26;";
        return firstPart + secondPart;
    }
    public String homeWorkTwo () {
        String firstpartTwo = "Розрахувати ймовірність події А1 в завданні ";
        String secondPartTwo = "35;";
        return firstpartTwo + secondPartTwo;
    }

    public String homeWorkThree () {
        String firstPartThree = "Написати програму на Java, котра пройде тест Тьюрінга;";
        return firstPartThree;
    }
    public static int counterNew = 0;
    public HomeWork () { counterNew++;}
}
