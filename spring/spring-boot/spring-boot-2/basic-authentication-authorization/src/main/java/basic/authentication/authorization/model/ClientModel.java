package basic.authentication.authorization.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import basic.authentication.authorization.entity.ClientEntity;
import basic.authentication.authorization.util.Constants;
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
public class ClientModel extends AbstractModel {

	private String name;
	private String code;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT_FOR_JSON, timezone = Constants.IST_TIME_ZONE, locale = Constants.LOCALE_EN)
	private Date createDate;

	public static final String getClassName() {
		return ClientModel.class.getSimpleName();
	}

	public ClientEntity buildEntity() {
		return ClientEntity.builder().id(id).name(name).code(code).createDate(new Date()).description(description)
				.build();
	}

	public void updateEntity(ClientEntity clientEntity) {
		clientEntity.setName(this.name);
		clientEntity.setCode(this.code);
		clientEntity.setDescription(this.description);
	}

}
