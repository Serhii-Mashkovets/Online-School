package onlineSchool.models;

public class HomeWork extends ParentingClassForModels {
    private int numberOfHW;
    private static int counterNew = 0;

    private int id;

    public String HomeWork(int numberOfHW) {
        return "The number of home work is: " + numberOfHW;
    }

    public HomeWork() {
        setCounterNew(getCounterNew() + 1);
    }

    public static int getCounterNew() {
        return counterNew;
    }

    public static void setCounterNew(int counterNew) {
        HomeWork.counterNew = counterNew;
    }

    public int getNumberOfHW() {
        return numberOfHW;
    }

    public void setNumberOfHW(int numberOfHW) {
        this.numberOfHW = numberOfHW;
    }
}
