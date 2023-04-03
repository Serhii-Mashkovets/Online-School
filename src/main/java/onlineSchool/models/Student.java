package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;

public class Student extends ParentingClassForModels implements Serializable {
    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private String studentLastName;
    private String studentName;
    private int studentAge;

    private int studentId;

    private String Email;

    private int courseId;

    public Student(String studentName, String studentLastName) {
        this.setStudentName(studentName);
        this.setStudentLastName(studentLastName);
    }


    public Student(String studentName, String studentLastName, String Email) {
        this.setStudentName(studentName);
        this.setStudentLastName(studentLastName);
        this.setEmail(Email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentLastName='" + studentLastName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        if (studentAge < 0) {
            studentAge = 0;
        } else
            this.studentAge = studentAge;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}


