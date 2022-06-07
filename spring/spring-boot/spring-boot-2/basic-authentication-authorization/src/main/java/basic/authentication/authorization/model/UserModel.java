package basic.authentication.authorization.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import basic.authentication.authorization.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

	private String username;
	private String password;
	private String rawPassword;
	private Boolean enabled;
	private Integer status;
	private RoleModel roleModel;
	private List<String> pages;
	private String oldPassword;
	private String confirmPassword;
	private ClientModel clientModel;

	public static final String getClassName() {
		return UserModel.class.getSimpleName();
	}

	public UserEntity buildEntity() {
		return UserEntity.builder().username(username).enabled(enabled).password(password).rawPassword(password)
				.build();
	}
}
