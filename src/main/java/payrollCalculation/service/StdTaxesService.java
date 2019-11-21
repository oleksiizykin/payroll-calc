package payrollCalculation.service;

import payrollCalculation.model.StdTaxes;

import java.util.List;

public interface StdTaxesService {
    void set(StdTaxes stdTaxes);

    StdTaxes get(int year, int month, int day);

    void update(int year, int month, int day, double personalIncomeTax, double militaryTax);

    void delete(int year, int month, int day);

    List<StdTaxes> getByYear(int year);
}
