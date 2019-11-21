package payrollCalculation.service;

import payrollCalculation.model.StdPayrollOfUser;

import java.util.List;

public interface StdPayrollOfUserService {
    List<StdPayrollOfUser> findAllByUserId(long userId);

    void setByUser(StdPayrollOfUser stdPayrollOfUser);

    StdPayrollOfUser getByUserAndDate(long id, int year, int month, int day);

    void update(long id, int year, int month, int day, double grossSalary, double percentOfBonus);

    void deleteByUserAndDate(long id, int year, int month, int day);
}
