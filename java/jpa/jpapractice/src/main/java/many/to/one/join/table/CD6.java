package many.to.one.join.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd6")
public class CD6 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd6_pk")
	private Integer id;

	@Column(name = "cd6_name")
	private String name;

	public CD6(String name) {
		this.name = name;
	}

	public CD6() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CD6 [id=" + id + ", name=" + name + "]";
	}

}