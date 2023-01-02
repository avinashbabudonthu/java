package one.to.many.join.column;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd3")
public class CD3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd3_pk")
	private Integer id;

	@Column(name = "cd_name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd3_fk", referencedColumnName = "cd3_pk")
	private Set<Musician3> musicians = new HashSet<>();

	public CD3(String name, Set<Musician3> musicians) {
		this.name = name;
		this.musicians = musicians;
	}

	public CD3() {
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

	public Set<Musician3> getMusicians() {
		return musicians;
	}

	public void setMusicians(Set<Musician3> musicians) {
		this.musicians = musicians;
	}

	@Override
	public String toString() {
		return "CD3 [id=" + id + ", name=" + name + ", musicians=" + musicians + "]";
	}
}