package payrollCalculation.service;

import payrollCalculation.model.User;

import java.util.List;

public interface UserService {
    void set(User user);

    User get(long id);

    void updateUserName(long id, String name);

    void delete(long id);

    List<User> getAllUsers();

    List<User> findByName(String name);

    List<User> findByNameContains(String name);
}
