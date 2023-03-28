package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;

public class Teacher extends ParentingClassForModels implements Serializable {

    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private String teacherName;
    private String teacherSecondName;

    private int courseId;

    public Teacher(String teacherName, String teacherSecondName) {
        this.teacherName = teacherName;
        this.teacherSecondName = teacherSecondName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherSecondName='" + teacherSecondName + '\'' +
                '}';
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSecondName() {
        return teacherSecondName;
    }

    public void setTeacherSecondName(String teacherSecondName) {
        this.teacherSecondName = teacherSecondName;
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
}
