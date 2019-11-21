package payrollCalculation.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actualworkinghoursbyusers")
public class ActualWorkingHoursByUsers {

    @EmbeddedId
    private CKUsersIdAndDate id;

    @Column(name = "workingHoursOfFirstPartOfAMonth")
    private int workingHoursOfFirstPartOfAMonth;

    @Column(name = "workingHoursOfSecondPartOfAMonth")
    private int workingHoursOfSecondPartOfAMonth;

    public ActualWorkingHoursByUsers() {
    }

    public ActualWorkingHoursByUsers(long userId, int year, int month, int day,
                                     int workingHoursOfFirstPartOfAMonth,
                                     int workingHoursOfSecondPartOfAMonth) {
        this.id = new CKUsersIdAndDate(userId, year, month, day);
        this.workingHoursOfFirstPartOfAMonth = workingHoursOfFirstPartOfAMonth;
        this.workingHoursOfSecondPartOfAMonth = workingHoursOfSecondPartOfAMonth;
    }

    public CKUsersIdAndDate getId() {
        return id;
    }

    public void setId(CKUsersIdAndDate id) {
        this.id = id;
    }

    public int getWorkingHoursOfFirstPartOfAMonth() {
        return workingHoursOfFirstPartOfAMonth;
    }

    public void setWorkingHoursOfFirstPartOfAMonth(int workingHoursOfFirstPartOfAMonth) {
        this.workingHoursOfFirstPartOfAMonth = workingHoursOfFirstPartOfAMonth;
    }

    public int getWorkingHoursOfSecondPartOfAMonth() {
        return workingHoursOfSecondPartOfAMonth;
    }

    public void setWorkingHoursOfSecondPartOfAMonth(int workingHoursOfSecondPartOfAMonth) {
        this.workingHoursOfSecondPartOfAMonth = workingHoursOfSecondPartOfAMonth;
    }

    @Override
    public String toString() {
        return "ActualWorkingHoursByUsers{" +
                "id=" + id +
                ", workingHoursOfFirstPartOfAMonth=" + workingHoursOfFirstPartOfAMonth +
                ", workingHoursOfSecondPartOfAMonth=" + workingHoursOfSecondPartOfAMonth +
                '}';
    }
}
