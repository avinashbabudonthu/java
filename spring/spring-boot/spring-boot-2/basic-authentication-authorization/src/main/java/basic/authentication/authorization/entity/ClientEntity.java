package basic.authentication.authorization.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import basic.authentication.authorization.model.ClientModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_client")
public class ClientEntity extends AbstractEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "create_date")
	private Date createDate;

	public static final String getClassName() {
		return ClientEntity.class.getSimpleName();
	}

	public ClientModel buildModel() {
		return ClientModel.builder().id(id).name(name).code(code).createDate(createDate).description(description)
				.build();
	}

}
