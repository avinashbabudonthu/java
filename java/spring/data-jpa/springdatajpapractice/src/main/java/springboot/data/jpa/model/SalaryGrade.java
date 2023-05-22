package springboot.data.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALGRADE")
public class SalaryGrade {

    private Long highSalary;
    private Long lowSalary;
    private Long grade;

    public SalaryGrade(Long highSalary, Long lowSalary, Long grade) {
        this.highSalary = highSalary;
        this.lowSalary = lowSalary;
        this.grade = grade;
    }

    public SalaryGrade() {
    }

    @Id
    @Column(name = "GRADE")
    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    @Column(name = "HISAL")
    public Long getHighSalary() {
        return highSalary;
    }

    public void setHighSalary(Long highSalary) {
        this.highSalary = highSalary;
    }

    @Column(name = "LOSAL")
    public Long getLowSalary() {
        return lowSalary;
    }

    public void setLowSalary(Long lowSalary) {
        this.lowSalary = lowSalary;
    }

}
