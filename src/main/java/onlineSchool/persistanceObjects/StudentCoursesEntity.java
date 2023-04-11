package onlineSchool.persistanceObjects;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_courses", schema = "onlineschool", catalog = "")
public class StudentCoursesEntity {

    @EmbeddedId
    private StudentCoursesEntityPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private CoursesEntity course;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentsEntity student;

    public StudentCoursesEntityPK getId() {
        return id;
    }

    public void setId(StudentCoursesEntityPK id) {
        this.id = id;
    }

    public CoursesEntity getCourse() {
        return course;
    }

    public void setCourse(CoursesEntity course) {
        this.course = course;
    }

    public StudentsEntity getStudent() {
        return student;
    }

    public void setStudent(StudentsEntity student) {
        this.student = student;
    }
}

