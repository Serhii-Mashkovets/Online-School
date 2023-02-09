package onlineSchool.models;

public class HomeWork extends ParentingClassForModels {
    private int numberOfHW;
    private static int counterNew = 0;
    private static Integer id;
    private int lectureId;
    private String task;

    public String HomeWork(int numberOfHW) {
        return "The number of home work is: " + numberOfHW;
    }

    public HomeWork() {
        setCounterNew(getCounterNew() + 1);
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "numberOfHW=" + numberOfHW +
                ", lectureId=" + lectureId +
                ", task='" + task + '\'' +
                '}';
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

    public static Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lecterId) {
        this.lectureId = lecterId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
