package onlineSchool.models;

public class HomeWork extends ParentingClassForModels {
    public static int getCounterNew() {
        return counterNew;
    }

    public static void setCounterNew(int counterNew) {
        HomeWork.counterNew = counterNew;
    }

    public String homeWorkOne() {
        String firstPart = "Використати елементи мат. статистики в завданні ";
        String secondPart = "26;";
        return firstPart + secondPart;
    }

    public String homeWorkTwo() {
        String firstpartTwo = "Розрахувати ймовірність події А1 в завданні ";
        String secondPartTwo = "35;";
        return firstpartTwo + secondPartTwo;
    }

    public String homeWorkThree() {
        return "Написати програму на Java, котра пройде тест Тьюрінга;";
    }

    private static int counterNew = 0;

    public HomeWork() {
        setCounterNew(getCounterNew() + 1);
    }

    private int id;

}
