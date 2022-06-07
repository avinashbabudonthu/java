package basic.authentication.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basic.authentication.authorization.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {

}