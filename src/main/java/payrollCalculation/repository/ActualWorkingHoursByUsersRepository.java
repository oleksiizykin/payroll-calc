package payrollCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollCalculation.model.ActualWorkingHoursByUsers;
import payrollCalculation.model.CKUsersIdAndDate;

import java.util.List;

public interface ActualWorkingHoursByUsersRepository
        extends JpaRepository<ActualWorkingHoursByUsers, CKUsersIdAndDate> {

    List<ActualWorkingHoursByUsers> findById_UserId(long userId);
}
