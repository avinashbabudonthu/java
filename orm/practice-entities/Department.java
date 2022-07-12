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
@Table(name = "DEPT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPTNO")
    private Integer id;
    
    @Column(name = "DNAME")
    private String deptName;

    @Column(name = "LOC")
    private String location;

    // JoinColumn annotation, name == foreign key colunm, referencedColumnName == primary key Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
    private Set<Employee> employees;

    public Department(Integer id, String deptName, String location, Set<Employee> employees) {
	this.id = id;
	this.deptName = deptName;
	this.location = location;
	this.employees = employees;
    }

    public Department() {
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
   
    public String getDeptName() {
	return deptName;
    }

    public void setDeptName(String deptName) {
	this.deptName = deptName;
    }

    
    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public Set<Employee> getEmployees() {
	return employees;
    }

    public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
    }

    @Override
    public String toString() {
	return "Department [id=" + id + ", deptName=" + deptName + ", location=" + location + ", employees=" + employees + "]";
    }
}