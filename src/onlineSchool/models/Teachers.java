package onlineSchool.models;

import onlineSchool.exceptions.EntityNotFoundException;

import java.io.Serial;
import java.io.Serializable;

public class Teachers extends ParentingClassForModels implements Serializable {

    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private String teacherName;
    private String teacherSecondName;

    private int courseId;

    public Teachers(String teacherName, String teacherSecondName) {
        this.teacherName = teacherName;
        this.teacherSecondName = teacherSecondName;
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
