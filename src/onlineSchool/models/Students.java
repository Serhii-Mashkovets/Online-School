package onlineSchool.models;

public class Students {
    public String studentLastName;
    public String studentName;

public Students(String studentName, String studentLastName) {
    this.studentName = studentName;
   this.studentLastName = studentLastName;
}

private int studentAge;


    public int getStudentAge() {

        return studentAge;
    }
// Зробимо так, щоб вік студента не міг бути менше нуля
    public void setStudentAge (int studentAge) {
        if (studentAge <= 0) {
            studentAge = 0;
        } else
            this.studentAge = studentAge;
        }
    private int id;

    }


