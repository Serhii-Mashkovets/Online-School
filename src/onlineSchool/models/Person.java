package onlineSchool.models;

import onlineSchool.enums.Role;

public class Person extends ParentingClassForModels {

    private String role;

    private static int courseId;

    private int personID;

    private String lectureName1;

    private final Role role1;

    private final String phone1;

    private final String email1;


    public Person(String role, String firstPersoneName, String lastPersonName,
                  int personID, Role role1, String phone1, String email1) {
        super.setFirstPersoneName(firstPersoneName);
        super.setLastPersonName(lastPersonName);
        this.role = role;
        this.personID = personID;
        this.role1 = role1;
        this.phone1 = phone1;
        this.email1 = email1;
    }

    public static int getCourseId() {
        return courseId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPersonID() {
        return personID;
    }

    public Role getRole1() {
        return role1;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getEmail1() {
        return email1;
    }

    public String getLectureName1() {
        return lectureName1;
    }

    public void setLectureName1(String lectureName1) {
        this.lectureName1 = lectureName1;
    }
}
