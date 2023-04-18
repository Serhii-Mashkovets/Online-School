package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

public class Course extends ParentingClassForModels implements Serializable {
    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private Optional<Lecture> lectureName;
    private String courseName;
    private int lessonTime;
    private String courseNameOne;
    private static int counterOfCourse;
    private static Integer id;
    private Optional<Teacher> teaherNameOne;
    private Student studentNameOne;

    public Course(String courseName, Optional<Lecture> lectureName, Optional<Teacher> teacherOne, Optional<Student> studentOne) {
        this.courseName = courseName;
        this.setId(id);
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

    public Optional<Lecture> getLectureName() {
        return lectureName;
    }

    public void setLectureName(Optional<Lecture> lectureName) {
        this.lectureName = lectureName;
    }

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }

    public Optional<Teacher> getTeaherNameOne() {
        return teaherNameOne;
    }

    public void setTeaherNameOne(Optional<Teacher> teaherNameOne) {
        this.teaherNameOne = teaherNameOne;
    }

    public Student getStudentNameOne() {
        return studentNameOne;
    }

    public void setStudentNameOne(Student studentNameOne) {
        this.studentNameOne = studentNameOne;
    }

    public void setTeacherNameOne(Optional<Teacher> teacher) {
        this.teaherNameOne = teacher;
    }

    public void setStudentOne(Student student) {
        this.studentNameOne = student;
    }
}

