package basic.authentication.authorization.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import basic.authentication.authorization.entity.AuthorityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorityModel extends AbstractModel {

	private String authority;
	private UserModel userModel;

	public AuthorityEntity buildEntity() {
		return AuthorityEntity.builder().id(id).build();
	}

}
