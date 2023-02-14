package onlineSchool.models;

public class Teachers extends ParentingClassForModels {
    private String teacherName;
    private String teacherSecondName;

    public Teachers(String teacherName, String teacherSecondName) {
        this.teacherName=teacherName;
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
}
