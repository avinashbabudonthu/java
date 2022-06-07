package basic.authentication.authorization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.authentication.authorization.entity.RolePageEntity;

@Repository
public interface RolePageRepository extends JpaRepository<RolePageEntity, String> {

	List<RolePageEntity> findByRoleEntityId(String id);
}
