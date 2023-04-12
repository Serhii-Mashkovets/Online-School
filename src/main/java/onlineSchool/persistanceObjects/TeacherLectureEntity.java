package onlineSchool.persistanceObjects;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_lecture", schema = "onlineschool", catalog = "")
public class TeacherLectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_lecture_id")
    private Integer teacherLectureId;
    @Basic
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Basic
    @Column(name = "lecture_id")
    private Integer lectureId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherLectureEntity that = (TeacherLectureEntity) o;
        return Objects.equals(teacherId, that.teacherId) && Objects.equals(lectureId, that.lectureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, lectureId);
    }
}
