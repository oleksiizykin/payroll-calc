package payrollCalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollCalculation.model.ActualWorkingHoursByUsers;
import payrollCalculation.model.CKUsersIdAndDate;
import payrollCalculation.repository.ActualWorkingHoursByUsersRepository;

import java.util.List;

@Service
public class ActualWorkingHoursByUserServiceImpl implements ActualWorkingHoursByUserService {

    @Autowired
    private ActualWorkingHoursByUsersRepository actualWorkingHoursByUsersRepository;

    @Override
    public List<ActualWorkingHoursByUsers> findAllByUserId(long userId) {
        List<ActualWorkingHoursByUsers> actualWorkingHoursByUsers =
                actualWorkingHoursByUsersRepository.findById_UserId(userId);
        return actualWorkingHoursByUsers;
    }

    @Override
    public void setByUser(ActualWorkingHoursByUsers actualWorkingHoursByUser) {
        actualWorkingHoursByUsersRepository.saveAndFlush(actualWorkingHoursByUser);
    }

    @Override
    public ActualWorkingHoursByUsers getByUserIdAndDate(long userId, int year, int month, int day) {
        return actualWorkingHoursByUsersRepository.getOne(new CKUsersIdAndDate(userId, year, month, day));
    }

    @Override
    public void updateByUserIdAndDate(long userId, int year, int month, int day, int workingHoursOfFirstPartOfAMonth,
                                      int workingHoursOfSecondPartOfAMonth) {
        actualWorkingHoursByUsersRepository.saveAndFlush(new ActualWorkingHoursByUsers(
                userId, year, month, day, workingHoursOfFirstPartOfAMonth, workingHoursOfSecondPartOfAMonth));
    }

    @Override
    public void deleteByUserIdAndDate(long userId, int year, int month, int day) {
        actualWorkingHoursByUsersRepository.delete(new CKUsersIdAndDate(userId, year, month, day));
    }
}
