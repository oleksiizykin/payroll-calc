package payrollCalculation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import payrollCalculation.model.User;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = "/sqlScriptsForTesting/before_run_test_UserServiceImpl")
})
public class UserServiceImplTest {

    @Resource
    UserService userService;

    @Test
    public void set() throws Exception {
        userService.set(new User("John"));

        assertEquals("John", userService.get(1).getName());
    }

    @Test
    public void get() throws Exception {
        userService.set(new User("Jane"));

        assertEquals("Jane", userService.get(1).getName());
    }

    @Test
    public void updateUserName() throws Exception {
        userService.set(new User("Jake"));

        userService.updateUserName(1, "Nick");
        assertEquals("Nick", userService.get(1).getName());
    }

    @Test
    public void delete() throws Exception {
        userService.set(new User("Jim"));

        userService.delete(1);
        User user = userService.get(1);
        assertNull(user);
    }

    @Test
    public void getAllUsers() throws Exception {
        userService.set(new User("Bobby"));
        userService.set(new User("Mike"));
        userService.set(new User("Bill"));

        List<User> userList = userService.getAllUsers();
        assertEquals(3, userList.size());
    }

    @Test
    public void findByName() throws Exception {
        userService.set(new User("Bobby"));
        userService.set(new User("Mike"));
        userService.set(new User("Bill"));
        userService.set(new User("Bill"));
        userService.set(new User("Billy"));

        List<User> userList = userService.findByName("Bill");
        assertEquals(2, userList.size());
    }

    @Test
    public void findByNameContains() throws Exception{
        userService.set(new User("Bobby"));
        userService.set(new User("Mike"));
        userService.set(new User("Bill"));
        userService.set(new User("Bill"));
        userService.set(new User("Billy"));

        List<User> userList = userService.findByNameContains("Bill");
        assertEquals(3, userList.size());
    }

}