package onlineSchool.models;

public class School extends ParentingClassForModels {
    private static int id;
    private String name;
    public static int schoolCounter;

    public School(int id, String name) {
        this.id = id;
        this.name = name;
        schoolCounter++;
    }

    public int getSchoolId() {
        return this.id;
    }
}
