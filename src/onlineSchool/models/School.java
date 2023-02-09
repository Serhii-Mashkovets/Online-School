package onlineSchool.models;

public class School extends ParentingClassForModels {
    private static Integer id;
    private String name;
    public static int schoolCounter;

    public School(Integer id, String name) {
        this.id = id;
        this.name = name;
        schoolCounter++;
    }

    public int getSchoolId() {
        return this.id;
    }

    @Override
    public int getNew() {
        return 0;
    }
}
