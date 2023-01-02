package one.to.one.join.column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_musician1")
public class Musician1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician1_pk")
	private Integer id;

	@Column(name = "musician1_name")
	private String name;

	public Musician1(String name) {
		this.name = name;
	}

	public Musician1() {
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
		return "Musician [id=" + id + ", name=" + name + "]";
	}
}