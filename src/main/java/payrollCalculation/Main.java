package payrollCalculation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import payrollCalculation.service.ActualWorkingHoursByUserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        ActualWorkingHoursByUserService actualWorkingHoursByUserService = applicationContext.getBean(ActualWorkingHoursByUserService.class);

        System.out.println(actualWorkingHoursByUserService.getByUserIdAndDate(5L, 2017,6,1));
    }
}
