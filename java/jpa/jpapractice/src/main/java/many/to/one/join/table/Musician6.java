package many.to.one.join.table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_musician6")
public class Musician6 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician6_pk")
	private Integer id;

	@Column(name = "musician6_name")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "cd6_musician6", joinColumns = @JoinColumn(name = "cd6_fk"), inverseJoinColumns = @JoinColumn(name = "musician6_fk"))
	private CD6 cd6;

	public Musician6(String name, CD6 cd5) {
		this.name = name;
		this.cd6 = cd5;
	}

	public Musician6() {
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

	public CD6 getCd6() {
		return cd6;
	}

	public void setCd6(CD6 cd6) {
		this.cd6 = cd6;
	}

	@Override
	public String toString() {
		return "Musician6 [id=" + id + ", name=" + name + ", cd6=" + cd6 + "]";
	}
}