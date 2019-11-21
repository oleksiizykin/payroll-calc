package payrollCalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollCalculation.model.StdTaxes;
import payrollCalculation.repository.StdTaxesRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StdTaxesServiceImpl implements StdTaxesService {

    @Autowired
    private StdTaxesRepository stdTaxesRepository;

    @Override
    public List<StdTaxes> getByYear(int year) {
        List<StdTaxes> stdTaxesList = stdTaxesRepository.getByYear(year);
        return stdTaxesList;
    }

    @Override
    public void set(StdTaxes stdTaxes) {
        stdTaxesRepository.saveAndFlush(stdTaxes);
    }

    @Override
    public StdTaxes get(int year, int month, int day) {
        return stdTaxesRepository.findOne(LocalDate.of(year, month, day));
    }

    @Override
    public void update(int year, int month, int day, double personalIncomeTax, double militaryTax) {
        stdTaxesRepository.saveAndFlush(new StdTaxes(year, month, day, personalIncomeTax, militaryTax));
    }

    @Override
    public void delete(int year, int month, int day) {
        stdTaxesRepository.delete(LocalDate.of(year, month, day));
    }
}
