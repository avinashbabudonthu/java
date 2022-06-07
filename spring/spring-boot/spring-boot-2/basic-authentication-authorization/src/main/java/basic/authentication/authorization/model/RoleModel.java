package basic.authentication.authorization.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import basic.authentication.authorization.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleModel extends AbstractModel {

	private String role;
	private String description;

	public static final String getClassName() {
		return RoleModel.class.getSimpleName();
	}

	public RoleEntity buildEntity() {
		return RoleEntity.builder().id(id).role(role.toUpperCase()).description(description).build();
	}

	public void fullUpdateEntity(RoleEntity roleEntity) {
		roleEntity.setRole(role.toUpperCase());
		roleEntity.setDescription(description);
	}
}