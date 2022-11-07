package onlineSchool.models;

public class Students {
    public String studentLastName;
    public String studentName;
public Students(String studentName, String studentLastName) {
    this.studentName = studentName;
   this.studentLastName = studentLastName;
}
private int studentAge;
    public int getStudentAge() { return studentAge; }
// let`s make that the age of the student could not be smaller than zero
    public void setStudentAge (int studentAge) {
        if (studentAge <= 0) {
            studentAge = 0;
        } else
            this.studentAge = studentAge;
        }
    private int id;
    }


