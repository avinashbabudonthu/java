package one.to.one.join.table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd2")
public class CD2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd2_pk")
	private Integer id;

	@Column(name = "cd_name")
	private String name;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "cd2_musician2", joinColumns = @JoinColumn(name = "cd2_fk"), inverseJoinColumns = @JoinColumn(name = "musician2_fk"))
	private Musician2 musician;

	public CD2(String name, Musician2 musician) {
		this.name = name;
		this.musician = musician;
	}

	public CD2() {
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

	public Musician2 getMusician() {
		return musician;
	}

	public void setMusician(Musician2 musician) {
		this.musician = musician;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", name=" + name + ", musician=" + musician + "]";
	}

}