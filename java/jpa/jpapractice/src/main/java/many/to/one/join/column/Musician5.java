package many.to.one.join.column;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_musician5")
public class Musician5 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musician5_pk")
	private Integer id;

	@Column(name = "musician5_name")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd5_fk", referencedColumnName = "cd5_pk")
	private CD5 cd5;

	public Musician5(String name, CD5 cd5) {
		this.name = name;
		this.cd5 = cd5;
	}

	public Musician5() {
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

	public CD5 getCd5() {
		return cd5;
	}

	public void setCd5(CD5 cd5) {
		this.cd5 = cd5;
	}

	@Override
	public String toString() {
		return "Musician5 [id=" + id + ", name=" + name + ", cd5=" + cd5 + "]";
	}
}