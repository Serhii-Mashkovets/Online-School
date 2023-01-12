package onlineSchool.models;

public class Course extends  ParentingClassForModels{
    private Person studentOne;
    private Person teacherOne;
    private Lecture lectureName;
    private String courseName;

    private int lessonTime;
    private String courseNameOne;
    private static int counterOfCourse;
    private static int id;

    public Course(String courseName, int id, Lecture lectureName, Person teacherOne, Person studentOne) {
        this.courseName = courseName;
        this.id = id;
        this.setLectureName(lectureName);
        this.setTeacherOne(teacherOne);
        this.setStudentOne(studentOne);
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

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getStudentOne() {
        return studentOne;
    }

    public void setStudentOne(Person studentOne) {
        this.studentOne = studentOne;
    }

    public Person getTeacherOne() {
        return teacherOne;
    }

    public void setTeacherOne(Person teacherOne) {
        this.teacherOne = teacherOne;
    }

    public Lecture getLectureName() {
        return lectureName;
    }

    public void setLectureName(Lecture lectureName) {
        this.lectureName = lectureName;
    }
}

