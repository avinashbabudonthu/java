package basic.authentication.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.authentication.authorization.entity.AuthorityEntity;
import basic.authentication.authorization.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	public AuthorityEntity save(AuthorityEntity authorityEntity) {
		authorityEntity = authorityRepository.save(authorityEntity);
		return authorityEntity;
	}

	public AuthorityEntity findAuthorityEntityByUsername(String username) {
		return authorityRepository.findByUserEntityUsername(username);
	}
}
