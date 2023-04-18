package onlineSchool.repository;

import onlineSchool.models.Lecture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {
    List<Lecture> findByCourseLectureId(int courseID);
}
