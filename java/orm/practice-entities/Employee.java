import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {

    @Id
    @Column(name = "EMPNO")
    private Integer id;

    @Column(name = "ENAME")
    private String name;

    @Column(name = "JOB")
    private String job;

    @Column(name = "SAL")
    private Long salary;

    @Column(name = "COMM")
    private Long comm;

    @Column(name = "MGR")
    private Integer manager;

    @Column(name = "HIREDATE")
    private Date hiredate;

    @Column(name = "ACTIVE")
    private Boolean active;

    // JoinColumn annotation, name == foreign key colunm, referencedColumnName == primary key Column
    @ManyToOne
    @JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
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

    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    public Long getSalary() {
	return salary;
    }

    public void setSalary(Long salary) {
	this.salary = salary;
    }

    public Long getComm() {
	return comm;
    }

    public void setComm(Long comm) {
	this.comm = comm;
    }

    public Integer getManager() {
	return manager;
    }

    public void setManager(Integer manager) {
	this.manager = manager;
    }

    
    public Date getHiredate() {
	return hiredate;
    }

    public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
    }

    public Boolean getActive() {
	return active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    @Override
    public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + ", comm=" + comm + ", manager=" + manager
    	+ ", hiredate=" + hiredate + ", active=" + active + ", department=" + department + "]";
    }

}