package payrollCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payrollCalculation.model.CKUsersIdAndDate;
import payrollCalculation.model.StdPayrollOfUser;

import java.util.List;

public interface StdPayrollOfUserRepository
        extends JpaRepository<StdPayrollOfUser, CKUsersIdAndDate> {

    List<StdPayrollOfUser> findById_UserId(long userId);
}
