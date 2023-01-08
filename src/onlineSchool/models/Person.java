package onlineSchool.models;

import onlineSchool.enums.Role;

public class Person extends ParentingClassForModels {

    private static int counterOfStudents;
    private static int studentID;
    private static int counterOfTeachers;
    private static int teacherID;
    private String firstName;

    private String lastName;

    private static int courseId;

    private int personID;

    private String lectureName1;

    private Role role1;

    private String phone1;

    private String email1;


    public Person(String fname, String lname,
                  int personID, Role role1, String phone1, String email1) {
        this.setFirstName(fname);
        this.setLastName(lname);
        this.personID = personID;
        this.role1 = role1;
        this.phone1 = phone1;
        this.email1 = email1;
        if (this.role1 == Role.STUDENT) {
            ++counterOfStudents;
            studentID = super.getId1();
        } else {
            ++counterOfTeachers;
            teacherID = super.getId1();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personID=" + personID +
                ", role1=" + role1 +
                ", phone1='" + phone1 + '\'' +
                ", email1='" + email1 + '\'' +
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
}
