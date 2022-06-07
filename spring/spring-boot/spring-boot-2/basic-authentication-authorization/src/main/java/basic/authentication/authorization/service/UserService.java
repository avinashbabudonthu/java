package basic.authentication.authorization.service;

import static basic.authentication.authorization.util.Constants.USERNAME;
import static basic.authentication.authorization.util.ErrorsEnum.DUPLICATE_OBJECT_FOUND;
import static basic.authentication.authorization.util.ErrorsEnum.NULL_OBJECT;
import static basic.authentication.authorization.util.ErrorsEnum.NULL_PROPERTY;
import static basic.authentication.authorization.util.ErrorsEnum.OBJECT_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.authentication.authorization.entity.AuthorityEntity;
import basic.authentication.authorization.entity.ClientEntity;
import basic.authentication.authorization.entity.RoleEntity;
import basic.authentication.authorization.entity.UserEntity;
import basic.authentication.authorization.model.ClientModel;
import basic.authentication.authorization.model.ResponseModel;
import basic.authentication.authorization.model.RoleModel;
import basic.authentication.authorization.model.UserModel;
import basic.authentication.authorization.repository.UserRepository;
import basic.authentication.authorization.util.Constants;
import basic.authentication.authorization.util.PasswordEncoder;
import basic.authentication.authorization.util.Utils;
import lombok.SneakyThrows;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Utils utils;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private RolePageService rolePageService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserModel buildUserModel(UserEntity userEntity) {
		UserModel resultUserModel = userEntity.buildModel();

		AuthorityEntity authorityEntity = authorityService.findAuthorityEntityByUsername(userEntity.getUsername());
		if (Objects.nonNull(authorityEntity) && Objects.nonNull(authorityEntity.getRoleEntity())) {
			RoleEntity roleEntity = authorityEntity.getRoleEntity();
			RoleModel roleModel = roleEntity.buildModel();
			resultUserModel.setRoleModel(roleModel);
		}

		ClientEntity clientEntity = userEntity.getClientEntity();
		if (Objects.nonNull(clientEntity)) {
			ClientModel clientModel = clientEntity.buildModel();
			resultUserModel.setClientModel(clientModel);
		}

		return resultUserModel;
	}

	@SneakyThrows
	public Optional<UserEntity> findUserEntityByUsername(String username) {
		username = Optional.ofNullable(username).orElseThrow(utils.buildAppException(NULL_PROPERTY.getCode(),
				NULL_PROPERTY.getMessage(), username, UserModel.getClassName(), USERNAME));
		return userRepository.findById(username);
	}

	public Long countUserEntityByUsername(String username) {
		return Optional.ofNullable(userRepository.countByUsername(username)).orElse(0L);
	}

	@Transactional
	@SneakyThrows
	public UserEntity saveUserEntity(UserEntity userEntity) {
		userEntity = Optional.ofNullable(userEntity).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), UserEntity.getClassName(), UserEntity.getClassName()));
		userEntity = userRepository.save(userEntity);
		return userEntity;
	}

	@SneakyThrows
	@Transactional
	public UserModel saveUserModel(UserModel userModel) {
		userModel = Optional.ofNullable(userModel).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), UserModel.getClassName(), UserModel.getClassName()));
		final String username = userModel.getUsername();
		Long userCountByUsername = countUserEntityByUsername(username);

		// throw exception if user already exist
		if (userCountByUsername > 0) {
			throw utils.buildAppException(DUPLICATE_OBJECT_FOUND.getCode(),
					DUPLICATE_OBJECT_FOUND.formatString(username), UserModel.getClassName(), USERNAME).get();
		}

		final UserEntity userEntity = userModel.buildEntity();

		// encode password and set to user entity
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

		// get ClientEntity and set to UserEntity
		if (Objects.nonNull(userModel.getClientModel()) && Objects.nonNull(userModel.getClientModel().getId())) {
			Optional<ClientEntity> clientEntityOptional = clientService
					.findClientEntityById(userModel.getClientModel().getId());
			clientEntityOptional.ifPresent(clientEntity -> userEntity.setClientEntity(clientEntity));
		}

		// get RoleEntity
		final String roleModelId = userModel.getRoleModel().getId();
		RoleEntity roleEntity = roleService.findRoleEntityById(roleModelId)
				.orElseThrow(utils.buildAppException(OBJECT_NOT_FOUND.getCode(),
						OBJECT_NOT_FOUND.formatString(roleModelId), RoleModel.getClassName(), Constants.ID));

		UserEntity persistedUserEntity = saveUserEntity(userEntity);
		AuthorityEntity authorityEntity = AuthorityEntity.builder().userEntity(persistedUserEntity)
				.roleEntity(roleEntity).build();
		authorityEntity = authorityService.save(authorityEntity);

		UserModel resultUserModel = buildUserModel(persistedUserEntity);

		return resultUserModel;
	}

	@SneakyThrows
	public Boolean isUserExistByUsername(String username) {
		username = Optional.ofNullable(username).orElseThrow(
				utils.buildAppException(NULL_PROPERTY.getCode(), NULL_PROPERTY.getMessage(), username, USERNAME));
		Long userCount = userRepository.countByUsername(username);

		return userCount == 0L;
	}

	@SneakyThrows
	@Transactional
	public UserModel update(UserModel userModel) {
		userModel = Optional.ofNullable(userModel).orElseThrow(utils.buildAppException(NULL_PROPERTY.getCode(),
				NULL_PROPERTY.getMessage(), UserModel.getClassName(), UserModel.getClassName()));
		String username = userModel.getUsername();
		UserEntity userEntity = findUserEntityByUsername(username).orElseThrow(utils.buildAppException(
				OBJECT_NOT_FOUND.getCode(), OBJECT_NOT_FOUND.formatString(username), UserModel.getClassName()));

		// update password
		if (StringUtils.isNotBlank(userModel.getPassword())) {
			userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
			userEntity.setRawPassword(userModel.getPassword());
		}

		// enable/disable user
		if (Objects.nonNull(userModel.getEnabled())) {
			userEntity.setEnabled(BooleanUtils.toBoolean(userModel.getEnabled()));
		}

		userEntity = saveUserEntity(userEntity);

		return buildUserModel(userEntity);
	}

	public List<UserEntity> findAllUserEntities(Pageable pageable) {
		return Optional.ofNullable(userRepository.findAll(pageable).getContent()).orElse(new ArrayList<>());
	}

	public ResponseModel findAllUserModels(Pageable pageable) {
		List<UserModel> result = findAllUserEntities(pageable).stream().map(userEntity -> buildUserModel(userEntity))
				.collect(Collectors.toList());
		Long totalCount = userRepository.count();
		return utils.buildResponseModel(result, result.size(), totalCount);
	}

	@SneakyThrows
	public UserModel findUserModelByUsername(String username) {
		username = Optional.ofNullable(username).orElseThrow(
				utils.buildAppException(NULL_PROPERTY.getCode(), NULL_PROPERTY.getMessage(), username, USERNAME));
		UserEntity userEntity = findUserEntityByUsername(username)
				.orElseThrow(utils.buildAppException(OBJECT_NOT_FOUND.getCode(), OBJECT_NOT_FOUND.getMessage(),
						username, UserModel.getClassName(), USERNAME));

		UserModel userModel = buildUserModel(userEntity);
		userModel.setStatus(HttpStatus.OK.value());

		List<String> pages = rolePageService.findPageNamesByRoleId(userModel.getRoleModel().getId());
		userModel.setPages(pages);

		return userModel;
	}

}