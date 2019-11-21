package payrollCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import payrollCalculation.model.StdTaxes;

import java.time.LocalDate;
import java.util.List;

public interface StdTaxesRepository extends JpaRepository<StdTaxes, LocalDate> {

    @Query("select s from StdTaxes s where function('year', s.date) = :year")
    List<StdTaxes> getByYear(@Param("year") int year);
}
