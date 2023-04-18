package onlineSchool.repository;

import onlineSchool.models.Student;
import onlineSchool.persistanceObjects.StudentsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Integer> {
    List<StudentsEntity> findAllByCoursesCourseId(int courseId);

}
