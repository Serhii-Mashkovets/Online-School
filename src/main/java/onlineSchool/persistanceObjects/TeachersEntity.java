package onlineSchool.persistanceObjects;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers", schema = "onlineschool", catalog = "")
public class TeachersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "teacher_id")
    private int teacherId;
    @Basic
    @Column(name = "teacher_name")
    private String teacherName;
    @Basic
    @Column(name = "teacher_surname")
    private String teacherSurname;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachersEntity that = (TeachersEntity) o;
        return teacherId == that.teacherId && Objects.equals(teacherName, that.teacherName) && Objects.equals(teacherSurname, that.teacherSurname) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherSurname, courseId);
    }
}
