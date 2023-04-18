package onlineSchool.repository;

import onlineSchool.models.HomeWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeWorkRepository extends CrudRepository<HomeWork, Integer> {

    List<HomeWork> findAllByLectureId(int lectureId);

    List<HomeWork> findAllByLectureCourseId(int courseId);

}
