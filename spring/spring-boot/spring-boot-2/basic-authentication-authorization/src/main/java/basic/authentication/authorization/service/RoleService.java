package basic.authentication.authorization.service;

import static basic.authentication.authorization.util.Constants.ID;
import static basic.authentication.authorization.util.ErrorsEnum.NULL_OBJECT;
import static basic.authentication.authorization.util.ErrorsEnum.OBJECT_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.authentication.authorization.entity.RoleEntity;
import basic.authentication.authorization.model.ResponseModel;
import basic.authentication.authorization.model.RoleModel;
import basic.authentication.authorization.repository.RoleRepository;
import basic.authentication.authorization.util.Utils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private Utils utils;

	@SneakyThrows
	public RoleEntity saveOrUpdateRoleEntity(RoleEntity roleEntity) {
		roleEntity = Optional.ofNullable(roleEntity).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), RoleEntity.getClassName(), RoleEntity.getClassName()));
		roleEntity = roleRepository.save(roleEntity);
		return roleEntity;
	}

	@SneakyThrows
	public RoleModel saveOrUpdateRoleModel(RoleModel roleModel) {
		String roleModelClassName = RoleModel.class.getSimpleName();
		roleModel = Optional.ofNullable(roleModel).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), RoleModel.getClassName(), RoleModel.getClassName()));
		String id = roleModel.getId();

		RoleEntity roleEntity = null;
		if (Objects.isNull(id)) {
			log.info("Saving ROLE_MODEL={}", roleModel);
			roleEntity = roleModel.buildEntity();
			roleEntity = saveOrUpdateRoleEntity(roleEntity);
		} else {
			log.info("Updating ROLE_MODEL={}", roleModel);
			roleEntity = findRoleEntityById(id).orElseThrow(utils.buildAppException(OBJECT_NOT_FOUND.getCode(),
					OBJECT_NOT_FOUND.formatString(id), roleModelClassName, ID));
			roleModel.fullUpdateEntity(roleEntity);
			roleEntity = saveOrUpdateRoleEntity(roleEntity);
		}

		return roleEntity.buildModel();
	}

	@SneakyThrows
	public RoleModel deleteRoleEntityById(String roleId) {
		RoleEntity roleEntity = findRoleEntityById(roleId).orElseThrow(utils.buildAppException(
				OBJECT_NOT_FOUND.getCode(), OBJECT_NOT_FOUND.getMessage(), roleId, RoleModel.getClassName(), ID));
		roleRepository.deleteById(roleId);
		return roleEntity.buildModel();
	}

	public List<RoleEntity> findAllRoleEntitiesList() {
		return Optional.ofNullable(roleRepository.findAll()).orElse(new ArrayList<>());
	}

	public ResponseModel findAllRoleModel() {
		List<RoleModel> result = findAllRoleEntitiesList().stream().map(RoleEntity::buildModel)
				.collect(Collectors.toList());
		return utils.buildResponseModel(result, result.size(), result.size());
	}

	public Optional<RoleEntity> findRoleEntityById(String roleId) {
		return roleRepository.findById(roleId);
	}

	@SneakyThrows
	public RoleModel findRoleModelById(String roleId) {
		RoleEntity roleEntity = findRoleEntityById(roleId).orElseThrow(utils.buildAppException(
				OBJECT_NOT_FOUND.getCode(), OBJECT_NOT_FOUND.getMessage(), roleId, RoleModel.getClassName(), ID));
		return roleEntity.buildModel();
	}
}
