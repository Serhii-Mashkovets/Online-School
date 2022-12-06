package onlineSchool.models;

public class Teachers extends SuperPuperModels{
    private String teacherName;
    private String teacherSecondName;

    public Teachers(String teacherName, String teacherSecondName) {
        this.setTeacherName(teacherName);
        this.setTeacherSecondName(teacherSecondName);
    }

    private int id;

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

}
