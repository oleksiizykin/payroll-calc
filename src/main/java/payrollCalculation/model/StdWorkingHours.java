package payrollCalculation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "stdworkinghours")
public class StdWorkingHours {

    @Id
    @Column(name = "period")
    private LocalDate date;

    @Column(name = "stdWorkingHoursOfFirstPartOfAMonth")
    private int stdWorkingHoursOfFirstPartOfAMonth;

    @Column(name = "stdWorkingHoursOfSecondPartOfAMonth")
    private int stdWorkingHoursOfSecondPartOfAMonth;

    @Column(name = "stdWorkingHoursOfAMonth")
    private int stdWorkingHoursOfAMonth;

    public StdWorkingHours() {
    }

    public StdWorkingHours(int year, int month, int day, int stdWorkingHoursOfFirstPartOfAMonth,
                           int stdWorkingHoursOfSecondPartOfAMonth) {
        this.date = LocalDate.of(year, month, day);
        this.stdWorkingHoursOfFirstPartOfAMonth = stdWorkingHoursOfFirstPartOfAMonth;
        this.stdWorkingHoursOfSecondPartOfAMonth = stdWorkingHoursOfSecondPartOfAMonth;
        this.stdWorkingHoursOfAMonth = stdWorkingHoursOfFirstPartOfAMonth + stdWorkingHoursOfSecondPartOfAMonth;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStdWorkingHoursOfFirstPartOfAMonth() {
        return stdWorkingHoursOfFirstPartOfAMonth;
    }

    public void setStdWorkingHoursOfFirstPartOfAMonth(int stdWorkingHoursOfFirstPartOfAMonth) {
        this.stdWorkingHoursOfFirstPartOfAMonth = stdWorkingHoursOfFirstPartOfAMonth;
    }

    public int getStdWorkingHoursOfSecondPartOfAMonth() {
        return stdWorkingHoursOfSecondPartOfAMonth;
    }

    public void setStdWorkingHoursOfSecondPartOfAMonth(int stdWorkingHoursOfSecondPartOfAMonth) {
        this.stdWorkingHoursOfSecondPartOfAMonth = stdWorkingHoursOfSecondPartOfAMonth;
    }

    public int getStdWorkingHoursOfAMonth() {
        return stdWorkingHoursOfAMonth;
    }

    public void setStdWorkingHoursOfAMonth(int stdWorkingHoursOfAMonth) {
        this.stdWorkingHoursOfAMonth = stdWorkingHoursOfAMonth;
    }

    @Override
    public String toString() {
        return "StdWorkingHours{" +
                "date=" + date +
                ", stdWorkingHoursOfFirstPartOfAMonth=" + stdWorkingHoursOfFirstPartOfAMonth +
                ", stdWorkingHoursOfSecondPartOfAMonth=" + stdWorkingHoursOfSecondPartOfAMonth +
                ", stdWorkingHoursOfAMonth=" + stdWorkingHoursOfAMonth +
                '}';
    }
}
