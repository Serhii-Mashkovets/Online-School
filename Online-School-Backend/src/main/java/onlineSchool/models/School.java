package onlineSchool.models;

import java.io.Serializable;

public class School extends ParentingClassForModels implements Serializable {
    private static Integer id;
    public static int schoolCounter;

    public School(Integer id, String name) {
        this.id = id;
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
