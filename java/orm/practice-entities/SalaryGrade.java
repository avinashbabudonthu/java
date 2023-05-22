import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALGRADE")
public class SalaryGrade {

    @Id
    @Column(name = "GRADE")
    private Long grade;

    @Column(name = "HISAL")
    private Long highSalary;

    @Column(name = "LOSAL")
    private Long lowSalary;
    

    public SalaryGrade(Long highSalary, Long lowSalary, Long grade) {
	this.highSalary = highSalary;
	this.lowSalary = lowSalary;
	this.grade = grade;
    }

    public SalaryGrade() {
    }

    public Long getGrade() {
	return grade;
    }

    public void setGrade(Long grade) {
	this.grade = grade;
    }

    public Long getHighSalary() {
	return highSalary;
    }

    public void setHighSalary(Long highSalary) {
	this.highSalary = highSalary;
    }

    public Long getLowSalary() {
	return lowSalary;
    }

    public void setLowSalary(Long lowSalary) {
	this.lowSalary = lowSalary;
    }

}