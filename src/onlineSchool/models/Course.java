package onlineSchool.models;

public class Course extends ParentingClassForModels {
    private String courseName;

    public static final int CLASSROOM_FOR_LESSONS = 12;
    private int lessonTime;

    public int getCourseId() {
        return this.id;
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

    public void setLessonTime(int lessonTime) {
        if (lessonTime < 0) {
            lessonTime = 0;
        }
        this.lessonTime = lessonTime;
    }

    private int id;
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


    public String getCourseNameOne() {
        return courseNameOne;
    }

    public void setCourseNameOne(String courseNameOne) {
        this.courseNameOne = courseNameOne;
    }

}

