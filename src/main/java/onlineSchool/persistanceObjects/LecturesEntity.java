package onlineSchool.persistanceObjects;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lectures", schema = "onlineschool", catalog = "")
public class LecturesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lecture_id")
    private int lectureId;
    @Basic
    @Column(name = "lecture_topic")
    private String lectureTopic;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "date")
    private Date date;

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureTopic() {
        return lectureTopic;
    }

    public void setLectureTopic(String lectureTopic) {
        this.lectureTopic = lectureTopic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturesEntity that = (LecturesEntity) o;
        return lectureId == that.lectureId && Objects.equals(lectureTopic, that.lectureTopic) && Objects.equals(description, that.description) && Objects.equals(courseId, that.courseId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId, lectureTopic, description, courseId, date);
    }
}
