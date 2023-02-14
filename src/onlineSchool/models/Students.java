package onlineSchool.models;

public class Students extends ParentingClassForModels {
    private String studentLastName;
    private String studentName;
    private int studentAge;

    private Integer id;

    public Students(String studentName, String studentLastName) {
        this.setStudentName(studentName);
        this.setStudentLastName(studentLastName);
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        if (studentAge <= 0) {
            studentAge = 0;
        } else
            this.studentAge = studentAge;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public int getNew() {
        return 0;
    }
}


