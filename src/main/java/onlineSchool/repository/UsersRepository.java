package onlineSchool.repository;

import onlineSchool.models.User;
import onlineSchool.persistanceObjects.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository <UsersEntity, Long> {

    UsersEntity findByUsername(String username);
}
