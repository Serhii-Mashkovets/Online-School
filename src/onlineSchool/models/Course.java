package onlineSchool.models;

public class Course extends SuperPuperModels{
    private String courseName;
    private final int CLASSROOM_FOR_LESSONS = 12;
    private int lessonTime;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Course.id = id;
    }

    public static int getCounterOfCourse() {
        return counterOfCourse;
    }

    public static void setCounterOfCourse(int counterOfCourse) {
        Course.counterOfCourse = counterOfCourse;
    }

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
    private static int id;
    private String courseNameOne;
    private static int counterOfCourse;

    public void fullCourse(String courseNameOne, int id) {
        this.setCourseNameOne(courseNameOne);
        this.setId(id);
        setCounterOfCourse(getCounterOfCourse() + 1);
    }

    public static int countId() {
        return getId();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCLASSROOM_FOR_LESSONS() {
        return CLASSROOM_FOR_LESSONS;
    }

    public String getCourseNameOne() {
        return courseNameOne;
    }

    public void setCourseNameOne(String courseNameOne) {
        this.courseNameOne = courseNameOne;
    }
}

