package data.jpa.custom.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import data.jpa.entity.EmployeeEntity;
import data.jpa.util.Constants;

@SuppressWarnings("unchecked")
@Repository
public class EmployeeRepositoryImpl implements CustomEmployeeRespository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EmployeeEntity> findAllEmployees() {
		StoredProcedureQuery storedProcedureQuery = entityManager
				.createNamedStoredProcedureQuery(Constants.FIND_ALL_EMPLOYEES_NAME);

		return storedProcedureQuery.getResultList();
	}

	@Override
	public List<EmployeeEntity> findAllEmployeesByDeptId(Integer deptId) {
		StoredProcedureQuery storedProcedureQuery = entityManager
				.createNamedStoredProcedureQuery(Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_NAME);
		storedProcedureQuery.registerStoredProcedureParameter("deptId", Integer.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("deptId", deptId);

		List<EmployeeEntity> result = storedProcedureQuery.getResultList();

		return result;
	}

}