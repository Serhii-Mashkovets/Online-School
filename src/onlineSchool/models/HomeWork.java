package onlineSchool.models;

public class HomeWork extends ParentingClassForModels {
    private int numberOfHW;

    public String HomeWork(int numberOfHW) {
        return "The number of home work is: " + numberOfHW;
    }

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

    public int getNumberOfHW() {
        return numberOfHW;
    }

    public void setNumberOfHW(int numberOfHW) {
        this.numberOfHW = numberOfHW;
    }
}
