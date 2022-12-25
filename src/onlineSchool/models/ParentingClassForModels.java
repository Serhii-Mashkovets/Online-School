package onlineSchool.models;

public class ParentingClassForModels {

    private String firstPersoneName;

    private String lastPersonName;

    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ParentingClassForModels.id = id;
    }

    public String getFirstPersoneName() {
        return firstPersoneName;
    }

    public void setFirstPersoneName(String firstPersoneName) {
        this.firstPersoneName = firstPersoneName;
    }

    public String getLastPersonName() {
        return lastPersonName;
    }

    public void setLastPersonName(String lastPersonName) {
        this.lastPersonName = lastPersonName;
    }
}
