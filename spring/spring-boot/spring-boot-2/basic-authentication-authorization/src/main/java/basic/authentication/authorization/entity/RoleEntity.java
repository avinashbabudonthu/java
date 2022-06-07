package basic.authentication.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import basic.authentication.authorization.model.RoleModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_role")
public class RoleEntity extends AbstractEntity {

	@Column(name = "role")
	private String role;

	@Column(name = "description")
	private String description;

	public static final String getClassName() {
		return RoleEntity.class.getSimpleName();
	}

	public RoleModel buildModel() {
		return RoleModel.builder().id(id).role(role).description(description).build();
	}

}
