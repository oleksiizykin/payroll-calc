package payrollCalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payrollCalculation.model.User;
import payrollCalculation.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void set(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User get(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void updateUserName(long id, String name) {
        userRepository.updateUserName(id, name);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameContains(String name) {
        return userRepository.findByNameContains(name);
    }
}
