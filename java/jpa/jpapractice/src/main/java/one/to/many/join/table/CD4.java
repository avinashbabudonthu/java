package one.to.many.join.table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_cd4")
public class CD4 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd4_pk")
	private Integer id;

	@Column(name = "cd4_name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cd4_musician4", joinColumns = @JoinColumn(name = "cd4_fk"), inverseJoinColumns = @JoinColumn(name = "musician4_fk"))
	private Set<Musician4> musicians = new HashSet<>();

	public CD4(String name, Set<Musician4> musicians) {
		this.name = name;
		this.musicians = musicians;
	}

	public CD4() {
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

	public Set<Musician4> getMusicians() {
		return musicians;
	}

	public void setMusicians(Set<Musician4> musicians) {
		this.musicians = musicians;
	}

	@Override
	public String toString() {
		return "CD4 [id=" + id + ", name=" + name + ", musicians=" + musicians + "]";
	}
}