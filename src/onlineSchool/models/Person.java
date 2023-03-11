package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;

public class Person extends ParentingClassForModels implements Serializable {
    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private String firstName;
    private String lastName;
    private static int courseId;
    private int personID;
    private String lectureName;
    private Role role;
    private String phone;
    private String email;

    public Person(String fname, String lname,
                  String phone, String email) {
        this.setFirstName(fname);
        this.setLastName(lname);
        this.phone = phone;
        this.setEmail(email);
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone1='" + phone + '\'' +
                ", email1='" + getEmail() + '\'' +
                '}';
    }

    public static int getCourseId() {
        return courseId;
    }

    public static void setCourseId(int courseId) {
        Person.courseId = courseId;
    }

    public int getPersonID() {
        return personID;
    }

    public Role getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
