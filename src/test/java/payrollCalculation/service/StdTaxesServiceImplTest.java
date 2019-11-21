package payrollCalculation.service;

import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import payrollCalculation.model.StdTaxes;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = "/sqlScriptsForTesting/before_run_test_StdTaxesService")
})
public class StdTaxesServiceImplTest {

    @Resource
    StdTaxesService stdTaxesService;

    @Test
    public void getByYear() throws Exception {
        stdTaxesService.set(new StdTaxes(2016, 1, 1, 18, 1.5));
        stdTaxesService.set(new StdTaxes(2017, 2, 1, 18, 1.5));
        stdTaxesService.set(new StdTaxes(2017, 3, 1, 18, 1.5));

        List<StdTaxes> stdTaxesList = stdTaxesService.getByYear(2017);
        assertEquals("Size of returned List don't match with created records",
                2, stdTaxesList.size());
    }

    @Test
    public void set() throws Exception {
        stdTaxesService.set(new StdTaxes(2017, 1, 1, 18, 1.5));
        stdTaxesService.set(new StdTaxes(2017, 2, 1, 18, 1.5));

        assertEquals(18, stdTaxesService.get(2017, 1, 1).getPersonalIncomeTax(), 0.01);
        assertEquals(1.5, stdTaxesService.get(2017, 2, 1).getMilitaryTax(), 0.01);
    }

    @Test
    public void get() throws Exception {
        stdTaxesService.set(new StdTaxes(2017, 3, 1, 18, 1.5));

        assertEquals(1.5, stdTaxesService.get(2017, 3, 1).getMilitaryTax(), 0.01);
    }

    @Test
    public void update() throws Exception {
        stdTaxesService.set(new StdTaxes(2017, 4, 1, 18, 1.5));
        assertEquals(1.5, stdTaxesService.get(2017, 4, 1).getMilitaryTax(), 0.01);

        stdTaxesService.update(2017, 4, 1, 20, 2);
        assertEquals(20, stdTaxesService.get(2017, 4, 1).getPersonalIncomeTax(), 0.01);
        assertEquals(2, stdTaxesService.get(2017, 4, 1).getMilitaryTax(), 0.01);

    }

    @Test
    public void delete() throws Exception {
        stdTaxesService.set(new StdTaxes(2017, 5, 1, 18, 1.5));
        assertEquals(18, stdTaxesService.get(2017, 5, 1).getPersonalIncomeTax(), 0.01);

        stdTaxesService.delete(2017, 5, 1);
        assertNull(stdTaxesService.get(2017, 5, 1));
    }

}