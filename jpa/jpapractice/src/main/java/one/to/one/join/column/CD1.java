package one.to.one.join.column;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd1")
public class CD1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd1_pk")
	private Integer id;

	@Column(name = "cd_name")
	private String name;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "musician1_fk", referencedColumnName = "musician1_pk")
	private Musician1 musician;

	public CD1(String name, Musician1 musician) {
		this.name = name;
		this.musician = musician;
	}

	public CD1() {
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

	public Musician1 getMusician() {
		return musician;
	}

	public void setMusician(Musician1 musician) {
		this.musician = musician;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", name=" + name + ", musician=" + musician + "]";
	}

}