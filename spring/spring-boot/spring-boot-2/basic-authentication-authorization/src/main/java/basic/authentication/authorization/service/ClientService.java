package basic.authentication.authorization.service;

import static basic.authentication.authorization.util.Constants.ID;
import static basic.authentication.authorization.util.ErrorsEnum.NULL_OBJECT;
import static basic.authentication.authorization.util.ErrorsEnum.OBJECT_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.authentication.authorization.entity.ClientEntity;
import basic.authentication.authorization.model.ClientModel;
import basic.authentication.authorization.model.ResponseModel;
import basic.authentication.authorization.repository.ClientRepository;
import basic.authentication.authorization.util.Utils;
import lombok.SneakyThrows;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private Utils utils;

	public Optional<ClientEntity> findClientEntityById(String id) {
		return clientRepository.findById(id);
	}

	public ClientModel buildClientModel(ClientEntity clientEntity) {
		ClientModel clientModel = clientEntity.buildModel();

		return clientModel;
	}

	@SneakyThrows
	@Transactional
	public ClientEntity saveOrUpdateClientEntity(ClientEntity clientEntity) {
		clientEntity = Optional.ofNullable(clientEntity).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), ClientEntity.getClassName(), ClientEntity.getClassName()));

		clientEntity = clientRepository.save(clientEntity);
		return clientEntity;
	}

	@SneakyThrows
	@Transactional
	public ClientModel saveOrUpdateClientModel(ClientModel clientModel) {
		clientModel = Optional.ofNullable(clientModel).orElseThrow(utils.buildAppException(NULL_OBJECT.getCode(),
				NULL_OBJECT.getMessage(), ClientModel.getClassName(), ClientModel.getClassName()));
		String clientId = clientModel.getId();
		ClientEntity clientEntity = null;

		if (StringUtils.isBlank(clientId)) {
			clientEntity = clientModel.buildEntity();
		} else {
			clientEntity = findClientEntityById(clientId)
					.orElseThrow(utils.buildAppException(OBJECT_NOT_FOUND.getCode(),
							OBJECT_NOT_FOUND.formatString(clientId), ClientModel.getClassName(), ID));
			clientModel.updateEntity(clientEntity);
		}

		ClientEntity persistedClientEntity = clientRepository.save(clientEntity);

		return persistedClientEntity.buildModel();
	}

	public List<ClientEntity> findAllClientEntities() {
		return Optional.ofNullable(clientRepository.findAll()).orElse(new ArrayList<>());
	}

	public List<ClientEntity> findAllClientEntities(Pageable pageable) {
		Optional<Page<ClientEntity>> records = Optional.ofNullable(clientRepository.findAll(pageable));
		return records.isPresent() ? records.get().getContent() : new ArrayList<>();
	}

	public ResponseModel findAllClientModels(Optional<Pageable> pageableOptional) {
		List<ClientEntity> clientEntitiesList = pageableOptional.isPresent()
				? findAllClientEntities(pageableOptional.get())
				: findAllClientEntities();
		List<ClientModel> result = clientEntitiesList.stream().map(clientEntity -> buildClientModel(clientEntity))
				.collect(Collectors.toList());
		Long totalCount = clientRepository.count();

		return utils.buildResponseModel(result, result.size(), totalCount);
	}

}