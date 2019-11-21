package payrollCalculation.service;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import payrollCalculation.model.StdPayrollOfUser;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = "/sqlScriptsForTesting/before_run_test_StdPayrollOfUserService")
})
public class StdPayrollOfUserServiceImplTest {
    @Resource
    StdPayrollOfUserService stdPayrollOfUserService;

    @Test
    public void findAllByUserId() throws Exception {
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(1L, 2016, 1, 1, 20694, 40));
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(1L, 2017, 1, 1, 22340, 40));
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(2L, 2017, 1, 1, 52340, 40));

        assertEquals("Size of returned List don't match with created records",
                2, stdPayrollOfUserService.findAllByUserId(1).size());
        assertEquals("Size of returned List don't match with created records",
                1, stdPayrollOfUserService.findAllByUserId(2).size());
    }

    @Test
    public void setByUser() throws Exception {
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(3L, 2016, 1, 1, 20694, 40));
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(3L, 2017, 1, 1, 22340, 40));
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(4L, 2017, 1, 1, 52340, 40));

        assertEquals(20694, stdPayrollOfUserService.findAllByUserId(3).get(0).getGrossSalary(), 0.01);
        assertEquals(40, stdPayrollOfUserService.findAllByUserId(3).get(0).getPercentOfBonus(), 0.01);
        assertEquals(52340, stdPayrollOfUserService.findAllByUserId(4).get(0).getGrossSalary(), 0.01);
    }

    @Test
    public void getByUserAndDate() throws Exception {
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(5L, 2016, 1, 1, 20694, 40));

        StdPayrollOfUser stdPayrollOfUser = stdPayrollOfUserService.getByUserAndDate(5, 2016, 1, 1);
        assertEquals(5, stdPayrollOfUser.getId().getUserId());
        assertEquals(LocalDate.of(2016, 1, 1), stdPayrollOfUser.getId().getDate());
    }

    @Test
    public void update() throws Exception {
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(6L, 2016, 1, 1, 20694, 40));
        assertEquals(20694, stdPayrollOfUserService.findAllByUserId(6).get(0).getGrossSalary(), 0.01);

        stdPayrollOfUserService.update(6L, 2016, 1, 1, 30694, 0);
        assertEquals(30694, stdPayrollOfUserService.findAllByUserId(6).get(0).getGrossSalary(), 0.01);
    }

    @Test
    public void deleteByUserAndDate() throws Exception {
        stdPayrollOfUserService.setByUser(new StdPayrollOfUser(7L, 2016, 1, 1, 20694, 40));
        StdPayrollOfUser stdPayrollOfUser = stdPayrollOfUserService.getByUserAndDate(7, 2016, 1, 1);
        assertEquals(20694, stdPayrollOfUser.getGrossSalary(), 0.01);

        stdPayrollOfUserService.deleteByUserAndDate(7, 2016, 1, 1);
        try {
            assertNull(stdPayrollOfUserService.getByUserAndDate(7, 2016, 1, 1));
        } catch (LazyInitializationException e) {
            System.out.println(e.getMessage());
        }
    }

}