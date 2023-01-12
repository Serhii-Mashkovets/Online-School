package onlineSchool.models;

public abstract class ParentingClassForModels {
    private String firstPersoneName;
    private String lastPersonName;
    private static int id;

    public ParentingClassForModels() {
        this.id = id;
    }

    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return firstPersoneName + lastPersonName;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
