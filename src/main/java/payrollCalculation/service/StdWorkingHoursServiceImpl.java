package payrollCalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollCalculation.model.StdWorkingHours;
import payrollCalculation.repository.StdWorkingHoursRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StdWorkingHoursServiceImpl implements StdWorkingHoursService {

    @Autowired
    StdWorkingHoursRepository stdWorkingHoursRepository;

    @Override
    public void set(StdWorkingHours stdWorkingHours) {
        stdWorkingHoursRepository.saveAndFlush(stdWorkingHours);
    }

    @Override
    public StdWorkingHours get(int year, int month, int day) {
        return stdWorkingHoursRepository.findOne(LocalDate.of(year, month, day));
    }

    @Override
    public void update(int year, int month, int day, int stdWorkingHoursOfFirstPartOfAMonth,
                       int stdWorkingHoursOfSecondPartOfAMonth) {
        stdWorkingHoursRepository.saveAndFlush(new StdWorkingHours(year, month, day,
                stdWorkingHoursOfFirstPartOfAMonth, stdWorkingHoursOfSecondPartOfAMonth));
    }

    @Override
    public void delete(int year, int month, int day) {
        stdWorkingHoursRepository.delete(LocalDate.of(year, month, day));
    }

    @Override
    public List<StdWorkingHours> getByYear(int year) {
        List<StdWorkingHours> stdWorkingHoursList = stdWorkingHoursRepository.getByYear(year);
        return stdWorkingHoursList;
    }
}
