package payrollCalculation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CKUsersIdAndDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "period")
    private LocalDate date;

    public CKUsersIdAndDate() {
    }

    public CKUsersIdAndDate(long userId, int year, int month, int day) {
        this.userId = userId;
        this.date = LocalDate.of(year, month, day);
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDate(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CKUsersIdAndDate)) return false;

        CKUsersIdAndDate that = (CKUsersIdAndDate) o;

        if (getUserId() != that.getUserId()) return false;
        return getDate() != null ? getDate().equals(that.getDate()) : that.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CKUsersIdAndDate{" +
                "userId=" + userId +
                ", date=" + date +
                '}';
    }
}
