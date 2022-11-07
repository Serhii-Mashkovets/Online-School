package onlineSchool.models;

public class Course {
    public String courseName ;
    public final int CLASSROOM_FOR_LESSONS = 12;
    private int lessonTime;
    public int getLessonTime() {
        return lessonTime;
    }
    // let`s make that the time of a lesson could not be smaller than zero
    public void setLessonTime(int lessonTime) {
        if (lessonTime < 0) {
            lessonTime = 0;
        }
        this.lessonTime = lessonTime;
    }

    // topic 6
    public static int id;
    public String courseNameOne;
    public  static int counterOfCourse;
    public void fullCourse (String courseNameOne, int id) {
        this.courseNameOne = courseNameOne;
        this.id = id;
        counterOfCourse++;
    }
    public int countId () { return id; }
}

