package onlineSchool.models;

import java.io.Serializable;

public abstract class ParentingClassForModels implements Serializable {

    private static final long serialazibleNumID = Long.MAX_VALUE;
    private String firstPersoneName;
    private String lastPersonName;
    private static Integer id;

    public ParentingClassForModels() {
        this.id = id;
    }



    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return firstPersoneName + lastPersonName;
    }

    public static Integer getId() {
        return id = 0;
    }

    public void setId(Integer id) {
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

    public abstract int getNew();
    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }
}
