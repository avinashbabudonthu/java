package basic.authentication.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.authentication.authorization.entity.AuthorityEntity;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {

	AuthorityEntity findByUserEntityUsername(String username);
}
