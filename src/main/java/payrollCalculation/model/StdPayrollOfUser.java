package payrollCalculation.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stdpayrollofuser")
public class StdPayrollOfUser {

    @EmbeddedId
    private CKUsersIdAndDate id;

    @Column(name = "gross_salary")
    private double grossSalary;

    @Column(name = "percent_of_bonus")
    private double percentOfBonus;

    public StdPayrollOfUser() {
    }

    public StdPayrollOfUser(long userId, int year, int month, int day,
                            double grossSalary, double percentOfBonus) {
        this.id = new CKUsersIdAndDate(userId, year, month, day);
        this.grossSalary = grossSalary;
        this.percentOfBonus = percentOfBonus;
    }

    public CKUsersIdAndDate getId() {
        return id;
    }

    public void setId(CKUsersIdAndDate userId) {
        this.id = userId;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getPercentOfBonus() {
        return percentOfBonus;
    }

    public void setPercentOfBonus(double percentOfBonus) {
        this.percentOfBonus = percentOfBonus;
    }

    @Override
    public String toString() {
        return "StdPayrollOfUser{" +
                "userId=" + id +
                ", grossSalary=" + grossSalary +
                ", percentOfBonus=" + percentOfBonus +
                '}';
    }
}
