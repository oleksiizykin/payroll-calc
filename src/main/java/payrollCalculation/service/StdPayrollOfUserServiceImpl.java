package payrollCalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollCalculation.model.CKUsersIdAndDate;
import payrollCalculation.model.StdPayrollOfUser;
import payrollCalculation.repository.StdPayrollOfUserRepository;

import java.util.List;

@Service
public class StdPayrollOfUserServiceImpl implements StdPayrollOfUserService {
    @Autowired
    private StdPayrollOfUserRepository stdPayrollOfUserRepository;

    @Override
    public List<StdPayrollOfUser> findAllByUserId(long userId) {
        List<StdPayrollOfUser> stdPayrollOfUsers =
                stdPayrollOfUserRepository.findById_UserId(userId);
        return stdPayrollOfUsers;
    }

    @Override
    public void setByUser(StdPayrollOfUser stdPayrollOfUser) {
        stdPayrollOfUserRepository.saveAndFlush(stdPayrollOfUser);
    }

    @Override
    public StdPayrollOfUser getByUserAndDate(long id, int year, int month, int day) {
        return stdPayrollOfUserRepository.getOne(new CKUsersIdAndDate(id, year, month, day));
    }

    @Override
    public void update(long id, int year, int month, int day, double grossSalary, double percentOfBonus) {
        stdPayrollOfUserRepository.saveAndFlush(new StdPayrollOfUser(id, year, month, day, grossSalary, percentOfBonus));
    }

    @Override
    public void deleteByUserAndDate(long id, int year, int month, int day) {
        stdPayrollOfUserRepository.delete(new CKUsersIdAndDate(id, year, month, day));
    }
}
