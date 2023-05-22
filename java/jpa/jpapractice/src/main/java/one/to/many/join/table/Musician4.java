package one.to.many.join.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_musician4")
public class Musician4 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician4_pk")
	private Integer id;

	@Column(name = "musician4_name")
	private String name;

	public Musician4(String name) {
		this.name = name;
	}

	public Musician4() {
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
		return "Musician4 [id=" + id + ", name=" + name + "]";
	}
}