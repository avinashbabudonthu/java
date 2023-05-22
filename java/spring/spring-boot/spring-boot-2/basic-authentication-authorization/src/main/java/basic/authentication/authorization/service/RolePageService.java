package basic.authentication.authorization.service;

import static basic.authentication.authorization.util.ErrorsEnum.NULL_PROPERTY;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.authentication.authorization.entity.RolePageEntity;
import basic.authentication.authorization.model.RoleModel;
import basic.authentication.authorization.repository.RolePageRepository;
import basic.authentication.authorization.util.Constants;
import basic.authentication.authorization.util.Utils;
import lombok.SneakyThrows;

@Service
public class RolePageService {

	@Autowired
	private RolePageRepository rolePageRepository;

	@Autowired
	private Utils utils;

	private List<RolePageEntity> findRolePageEntitiesByRoleId(String roleId) {
		return Optional.ofNullable(rolePageRepository.findByRoleEntityId(roleId)).orElse(new ArrayList<>());
	}

	@SneakyThrows
	public List<String> findPageNamesByRoleId(String roleId) {
		roleId = Optional.ofNullable(roleId).orElseThrow(utils.buildAppException(NULL_PROPERTY.getCode(),
				NULL_PROPERTY.getMessage(), roleId, RoleModel.getClassName(), Constants.ID));
		List<RolePageEntity> rolePageEntitiesList = findRolePageEntitiesByRoleId(roleId);
		return rolePageEntitiesList.stream().map(RolePageEntity::getPageName).collect(Collectors.toList());
	}
}
