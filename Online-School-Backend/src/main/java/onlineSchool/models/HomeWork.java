package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;

public class HomeWork extends ParentingClassForModels implements Serializable {
    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private int numberOfHW;
    private static int counterNew = 0;
    private static Integer id;
    private int lectureId;


    public String HomeWork(int numberOfHW) {
        return "The number of home work is: " + numberOfHW;
    }

    public void homeWork() {
        setCounterNew(getCounterNew() + 1);
    }

    @Override
    public String toString() {
        return "homeWork{" +
                "numberOfHW=" + numberOfHW +
                ", lectureId=" + lectureId +
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

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }
}
