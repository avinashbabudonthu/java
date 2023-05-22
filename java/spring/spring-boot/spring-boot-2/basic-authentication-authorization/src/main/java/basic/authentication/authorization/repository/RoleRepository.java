package basic.authentication.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.authentication.authorization.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {

}
