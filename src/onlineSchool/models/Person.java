package onlineSchool.models;

public class Person extends ParentingClassForModels {
    private String firstName;
    private String lastName;
    private static int courseId;
    private int personID;
    private String lectureName;
    private Role role;
    private String phone;
    private String email;

    public Person(String fname, String lname,
                  int personID, Role role1, String phone1, String email) {
        this.setFirstName(fname);
        this.setLastName(lname);
        this.personID = personID;
        this.role = role;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personID=" + personID +
                ", role1=" + role +
                ", phone1='" + phone + '\'' +
                ", email1='" + email + '\'' +
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
}
