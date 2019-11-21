package payrollCalculation.service;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import payrollCalculation.model.ActualWorkingHoursByUsers;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = "/sqlScriptsForTesting/before_run_test_ActualWorkingHoursByUsersService")
})
public class ActualWorkingHoursByUserServiceImplTest {
    @Resource
    ActualWorkingHoursByUserService actualWorkingHoursByUserService;

    @Test
    public void findAllByUserId() throws Exception {
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(4L, 2017, 6, 1, 80, 79));
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(4L, 2017, 7, 1, 80, 78));
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(4L, 2017, 5, 1, 63, 96));

        assertEquals("Size of returned List don't match with created records",
                3, actualWorkingHoursByUserService.findAllByUserId(4).size());

        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(5L, 2017, 7, 1, 80, 78));
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(5L, 2017, 5, 1, 63, 96));

        assertEquals("Size of returned List don't match with created records",
                2, actualWorkingHoursByUserService.findAllByUserId(5).size());
    }

    @Test
    public void setByUser() throws Exception {
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(2L, 2017, 6, 1, 80, 79));
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(2L, 2017, 7, 1, 80, 78));
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(1L, 2017, 6, 1, 80, 79));

        assertEquals("Working hours in a first part of month by user with id 1 don't equal 80 as in the test record",
                80, actualWorkingHoursByUserService.findAllByUserId(1L).get(0)
                        .getWorkingHoursOfFirstPartOfAMonth());
        assertEquals("Working hours in a second part of month by user with id 1 don't equal 78 as in the test record",
                78, actualWorkingHoursByUserService.findAllByUserId(2L).get(1)
                        .getWorkingHoursOfSecondPartOfAMonth());
    }

    @Test
    public void getByUserIdAndDate() throws Exception {
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(5L, 2017, 6, 1, 80, 79));

        ActualWorkingHoursByUsers actualWorkingHoursByUsers1 =
                actualWorkingHoursByUserService.getByUserIdAndDate(5L, 2017, 6, 1);
        assertEquals(5, actualWorkingHoursByUsers1.getId().getUserId());
        assertEquals(LocalDate.of(2017, 6, 1), actualWorkingHoursByUsers1.getId().getDate());
    }

    @Test
    public void updateByUserIdAndDate() throws Exception {
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(6L, 2017, 6, 1, 80, 79));
        assertEquals("Working hours in a first part of month by user with id 1 don't equal 80 as in the test record",
                80, actualWorkingHoursByUserService.findAllByUserId(6L).get(0)
                        .getWorkingHoursOfFirstPartOfAMonth());

        actualWorkingHoursByUserService.updateByUserIdAndDate(6L, 2017, 6, 1,
                63, 96);
        assertEquals("Working hours in a first part of month by user with id 1 don't equal 63 as in the test record",
                63, actualWorkingHoursByUserService.findAllByUserId(6L).get(0)
                        .getWorkingHoursOfFirstPartOfAMonth());
    }

    @Test
    public void deleteByUserIdAndDate() throws Exception {
        actualWorkingHoursByUserService.setByUser(new ActualWorkingHoursByUsers(7L, 2017, 8, 1, 88, 87));
        ActualWorkingHoursByUsers actualWorkingHoursByUsers1 =
                actualWorkingHoursByUserService.getByUserIdAndDate(7L, 2017, 8, 1);
        assertEquals(7, actualWorkingHoursByUsers1.getId().getUserId());
        assertEquals(LocalDate.of(2017, 8, 1), actualWorkingHoursByUsers1.getId().getDate());

        actualWorkingHoursByUserService.deleteByUserIdAndDate(7, 2017, 8, 1);
        try {
            assertNull(actualWorkingHoursByUserService.getByUserIdAndDate(7, 2017, 8, 1));
        } catch (LazyInitializationException e) {
            System.out.println(e.getMessage());
        }
    }
}