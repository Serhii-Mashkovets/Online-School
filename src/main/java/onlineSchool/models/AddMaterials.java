package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;

public class AddMaterials extends ParentingClassForModels implements Serializable {

    @Serial

    private static final long serialazibleNumID = Long.MAX_VALUE;
    private static Integer id;
    private String name;
    private int lectureId;
    private ResourseType resourseType;

    private Lecture lecture;

    public AddMaterials(String name, int lectureId, ResourseType resourseType) {
        this.name = name;
        this.lectureId = lectureId;
        this.resourseType = resourseType;
    }


    @Override
    public String toString() {
        return "AddMaterials{" +
                "name='" + getName() + '\'' +
                ", lectureId=" + lectureId +
                ", resourseType=" + resourseType +
                '}';
    }

    public static Integer getId() {
        return id;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public ResourseType getResourseType() {
        return resourseType;
    }

    public void setResourseType(ResourseType resourseType) {
        this.resourseType = resourseType;
    }

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
