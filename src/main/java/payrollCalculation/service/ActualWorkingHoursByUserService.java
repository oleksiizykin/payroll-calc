package payrollCalculation.service;

import payrollCalculation.model.ActualWorkingHoursByUsers;

import java.util.List;

public interface ActualWorkingHoursByUserService {
    List<ActualWorkingHoursByUsers> findAllByUserId(long userId);

    void setByUser(ActualWorkingHoursByUsers actualWorkingHoursByUser);

    ActualWorkingHoursByUsers getByUserIdAndDate(long userId, int year, int month, int day);


    void updateByUserIdAndDate(long userId, int year, int month, int day, int workingHoursOfFirstPartOfAMonth,
                               int workingHoursOfSecondPartOfAMonth);

    void deleteByUserIdAndDate(long userId, int year, int month, int day);
}
