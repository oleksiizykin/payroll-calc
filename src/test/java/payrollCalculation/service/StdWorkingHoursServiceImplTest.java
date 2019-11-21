package payrollCalculation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import payrollCalculation.model.StdWorkingHours;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = "/sqlScriptsForTesting/before_run_test_StdWorkingHoursService")
})
public class StdWorkingHoursServiceImplTest {

    @Resource
    StdWorkingHoursService stdWorkingHoursService;

    @Test
    public void set() throws Exception {
        stdWorkingHoursService.set(new StdWorkingHours(2017, 5, 1, 63, 96));
        stdWorkingHoursService.set(new StdWorkingHours(2017, 6, 1, 80, 79));

        assertEquals(63, stdWorkingHoursService.get(2017, 5, 1).getStdWorkingHoursOfFirstPartOfAMonth());
        assertEquals(79, stdWorkingHoursService.get(2017, 6, 1).getStdWorkingHoursOfSecondPartOfAMonth());
    }

    @Test
    public void get() throws Exception {
        stdWorkingHoursService.set(new StdWorkingHours(2017, 7, 1, 80, 88));

        assertEquals(88, stdWorkingHoursService.get(2017, 7, 1).getStdWorkingHoursOfSecondPartOfAMonth());
    }

    @Test
    public void update() throws Exception {
        stdWorkingHoursService.set(new StdWorkingHours(2017, 8, 1, 88, 87));
        assertEquals(87, stdWorkingHoursService.get(2017, 8, 1).getStdWorkingHoursOfSecondPartOfAMonth());

        stdWorkingHoursService.update(2017, 8, 1, 88, 88);
        assertEquals(88, stdWorkingHoursService.get(2017, 8, 1).getStdWorkingHoursOfSecondPartOfAMonth());
    }

    @Test
    public void delete() throws Exception {
        stdWorkingHoursService.set(new StdWorkingHours(2017, 9, 1, 88, 80));
        assertEquals(80, stdWorkingHoursService.get(2017, 9, 1).getStdWorkingHoursOfSecondPartOfAMonth());

        stdWorkingHoursService.delete(2017, 9, 1);
        assertNull(stdWorkingHoursService.get(2017, 9, 1));
    }

    @Test
    public void getByYear() throws Exception {
        stdWorkingHoursService.set(new StdWorkingHours(2016, 1, 1, 88, 88));
        stdWorkingHoursService.set(new StdWorkingHours(2017, 10, 1, 80, 87));
        stdWorkingHoursService.set(new StdWorkingHours(2017, 11, 1, 88, 88));
        stdWorkingHoursService.set(new StdWorkingHours(2017, 12, 1, 88, 80));

        assertEquals(3, stdWorkingHoursService.getByYear(2017).size());
    }

}