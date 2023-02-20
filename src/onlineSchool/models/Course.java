package onlineSchool.models;

public class Course extends ParentingClassForModels {
    private Lecture lectureName;
    private String courseName;
    private int lessonTime;
    private String courseNameOne;
    private static int counterOfCourse;
    private static Integer id;

    public Course(String courseName, Lecture lectureName, Teachers teacherOne, Students studentOne) {
        this.courseName = courseName;
        this.id = id;
        this.setLectureName(lectureName);
    }

    public void fullCourse(String courseNameOne, Integer id) {
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
                ", id=" + getId() +
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
        return this.getId();
    }

    public static int getCounterOfCourse() {
        return counterOfCourse;
    }

    public static void setCounterOfCourse(int counterOfCourse) {
        Course.counterOfCourse = counterOfCourse;
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public Lecture getLectureName() {
        return lectureName;
    }

    public void setLectureName(Lecture lectureName) {
        this.lectureName = lectureName;
    }

}

