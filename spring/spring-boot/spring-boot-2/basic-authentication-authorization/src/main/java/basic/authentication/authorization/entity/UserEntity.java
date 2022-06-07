package basic.authentication.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.BooleanUtils;

import basic.authentication.authorization.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled", columnDefinition = "TINYINT(1)")
	private Boolean enabled;

	@Column(name = "raw_password")
	private String rawPassword;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private ClientEntity clientEntity;

	public static final String getClassName() {
		return UserEntity.class.getSimpleName();
	}

	public UserModel buildModel() {
		return UserModel.builder().username(username).enabled(BooleanUtils.toBoolean(enabled)).build();
	}
}
