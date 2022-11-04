package onlineSchool.models;

public class Lecture {
    public String lessonThemeOne;
    public String lessonThemeTwo;
    public String lessonThemeThree;
    public String lessonThemeFour;
    public String lessonThemeFive;

    private int lessonTime = 120;


    public final int CLASSROOM_FOR_LESSONS = 12;

    public int getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(int lessonTime) {
        this.lessonTime = lessonTime;
    }




public static int counter = 0;
    public Lecture() {
        counter++;
    }


    public int id;

    }

