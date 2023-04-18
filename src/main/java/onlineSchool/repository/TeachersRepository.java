package onlineSchool.repository;

import onlineSchool.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByCourseId(int courseId);

}
