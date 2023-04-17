package onlineSchool.persistanceObjects;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentCoursesEntityPK implements Serializable {
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id" )
    private int courseId;

    public StudentCoursesEntityPK(int studentId, int courseId) {
    }

    public StudentCoursesEntityPK() {

    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCoursesEntityPK that = (StudentCoursesEntityPK) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }


}
