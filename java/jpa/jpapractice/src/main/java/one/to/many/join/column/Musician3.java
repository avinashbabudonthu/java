package one.to.many.join.column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_musician3")
public class Musician3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician3_pk")
	private Integer id;

	@Column(name = "musician_name")
	private String name;

	public Musician3(String name) {
		this.name = name;
	}

	public Musician3() {
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
		return "Musician3 [id=" + id + ", name=" + name + "]";
	}
}