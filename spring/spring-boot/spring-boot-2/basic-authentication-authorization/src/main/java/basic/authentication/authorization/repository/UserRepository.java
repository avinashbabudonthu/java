package basic.authentication.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.authentication.authorization.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	Long countByUsername(String username);
}
