package payrollCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import payrollCalculation.model.StdWorkingHours;

import java.time.LocalDate;
import java.util.List;

public interface StdWorkingHoursRepository extends JpaRepository<StdWorkingHours, LocalDate> {

    @Query("select s from StdWorkingHours s where function('year', s.date)= :year")
    List<StdWorkingHours> getByYear(@Param("year") int year);
}
