package onlineSchool.persistanceObjects;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "students", schema = "onlineschool", catalog = "")
public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Basic
    @Column(name = "student_name")
    private String studentName;

    @Basic
    @Column(name = "student_surname")
    private String studentSurname;

    @Basic
    @Column(name = "student_email")
    private String studentEmail;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return studentId == that.studentId && Objects.equals(studentName, that.studentName) && Objects.equals(studentSurname, that.studentSurname) && Objects.equals(studentEmail, that.studentEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentSurname, studentEmail);
    }
}
