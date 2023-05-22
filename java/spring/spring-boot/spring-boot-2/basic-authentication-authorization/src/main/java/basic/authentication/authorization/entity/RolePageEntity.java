package basic.authentication.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_role_page")
public class RolePageEntity extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private RoleEntity roleEntity;

	@Column(name = "page_name")
	private String pageName;
}
