package payrollCalculation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "stdtaxes")
public class StdTaxes {

    @Id
    @Column(name = "period")
    private LocalDate date;

    @Column(name = "personalincometax")
    private double personalIncomeTax;

    @Column(name = "militarytax")
    private double militaryTax;

    public StdTaxes() {
    }

    public StdTaxes(int year, int month, int day, double personalIncomeTax, double militaryTax) {
        this.date = LocalDate.of(year, month, day);
        this.personalIncomeTax = personalIncomeTax;
        this.militaryTax = militaryTax;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPersonalIncomeTax() {
        return personalIncomeTax;
    }

    public void setPersonalIncomeTax(double personalIncomeTax) {
        this.personalIncomeTax = personalIncomeTax;
    }

    public double getMilitaryTax() {
        return militaryTax;
    }

    public void setMilitaryTax(double militaryTax) {
        this.militaryTax = militaryTax;
    }

    @Override
    public String toString() {
        return "StdTaxes{" +
                "date=" + date +
                ", personalIncomeTax=" + personalIncomeTax +
                ", militaryTax=" + militaryTax +
                '}';
    }
}
