package springboot.data.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*Named Query: In Spring Data JPA for NamedQuery -> name attribute should start with model name. 
 * For example below name=Employee.<anyUserDefinedName>*/
@NamedQuery(name = "Employee.namedFindByDeptName", query = "select e from Employee e where e.department.deptName = :inputDeptName")
/*Native SQL Query Example*/
@NamedNativeQuery(name = "Employee.namedNativeFindByName", query = "select * from emp where ename = :inputName")
@Entity
@Table(name = "EMP")
public class Employee {

    private Integer id;
    private String name;
    private String job;
    private Long salary;
    private Long comm;
    private Integer manager;
    private Date hiredate;
    private Boolean active;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, String job, Long salary, Long comm, Integer manager, Date hiredate) {
	super();
	this.id = id;
	this.name = name;
	this.job = job;
	this.salary = salary;
	this.comm = comm;
	this.manager = manager;
	this.hiredate = hiredate;
    }

    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPNO")
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "ENAME")
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Column(name = "JOB")
    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    @Column(name = "SAL")
    public Long getSalary() {
	return salary;
    }

    public void setSalary(Long salary) {
	this.salary = salary;
    }

    @Column(name = "COMM")
    public Long getComm() {
	return comm;
    }

    public void setComm(Long comm) {
	this.comm = comm;
    }

    @Column(name = "MGR")
    public Integer getManager() {
	return manager;
    }

    public void setManager(Integer manager) {
	this.manager = manager;
    }

    @Column(name = "HIREDATE")
    public Date getHiredate() {
	return hiredate;
    }

    public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
    }

    @Column(name = "ACTIVE")
    public Boolean getActive() {
	return active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }

    @ManyToOne
    @JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    /*@Override
    public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + ", comm=" + comm + ", manager=" + manager
    	+ ", hiredate=" + hiredate + ", active=" + active + ", department=" + department + "]";
    }*/

}