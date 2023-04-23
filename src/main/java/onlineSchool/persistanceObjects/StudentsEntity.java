package onlineSchool.persistanceObjects;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private List<CoursesEntity> courses;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


@NotBlank(message = "students.name.invalid.blank.message")
@Size(message = "student.name.invalid.size.message")
@Pattern(regexp = "", message = "student.name.invalid.message")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    @NotBlank(message = "students.lastName.invalid.blank.message")
    @Size(message = "students.lastName.invalid.size.message")
    @Pattern(regexp = "", message = "student.lastName.invalid.message")
    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }


    @NotBlank(message = "students.email.invalid.blank.message")
    @Size(message = "students.email.invalid.size.message")
    @Pattern(regexp = "BilGates@gmail.com", message = "student.email.invalid.form.message")
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
