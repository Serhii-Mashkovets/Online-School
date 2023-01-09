package onlineSchool.models;

public class Course extends ParentingClassForModels {
    private String courseName;

    private int lessonTime;
    private String courseNameOne;
    private static int counterOfCourse;
    private int id;

    public Course(String courseName, int id, Lecture lectureName, Person teacherOne, Person studentOne) {
        super();
    }

    public void fullCourse(String courseNameOne, int id) {
        this.setCourseNameOne(courseNameOne);
        this.setId(id);
        setCounterOfCourse(getCounterOfCourse() + 1);
    }

    public static int countId() {
        return getId();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", lessonTime=" + lessonTime +
                ", id=" + id +
                ", courseNameOne='" + courseNameOne + '\'' +
                '}';
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

    public int getCourseId() {
        return this.id;
    }

    public static int getCounterOfCourse() {
        return counterOfCourse;
    }

    public static void setCounterOfCourse(int counterOfCourse) {
        Course.counterOfCourse = counterOfCourse;
    }

}

