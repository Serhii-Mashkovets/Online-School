package onlineSchool.repository;

import onlineSchool.models.AddMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddMaterialsRepository extends JpaRepository<AddMaterials, Integer> {

    @Query("SELECT a FROM AdditionalMaterialsEntity a WHERE a.lectureId = ?1")
    List<AddMaterials> findByLectureId(int lectureId);

}
