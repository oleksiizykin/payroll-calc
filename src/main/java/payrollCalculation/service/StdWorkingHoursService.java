package payrollCalculation.service;

import payrollCalculation.model.StdWorkingHours;

import java.util.List;

public interface StdWorkingHoursService {
    void set(StdWorkingHours stdWorkingHours);

    StdWorkingHours get(int year, int month, int day);

    void update(int year, int month, int day, int stdWorkingHoursOfFirstPartOfAMonth,
                int stdWorkingHoursOfSecondPartOfAMonth);

    void delete(int year, int month, int day);

    List<StdWorkingHours> getByYear(int year);
}
