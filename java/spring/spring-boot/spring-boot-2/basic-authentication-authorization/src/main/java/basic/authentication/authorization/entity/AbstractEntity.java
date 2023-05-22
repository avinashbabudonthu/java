package basic.authentication.authorization.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public class AbstractEntity {

	@Id
	@GenericGenerator(name = "custom-primary-key-generator", strategy = "basic.authentication.authorization.util.PrimaryKeyGenerator")
	@GeneratedValue(generator = "custom-primary-key-generator")
	@Column(name = "id")
	protected String id;
}
