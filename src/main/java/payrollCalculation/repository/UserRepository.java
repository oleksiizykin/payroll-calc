package payrollCalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import payrollCalculation.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Modifying
    @Query("update User u set u.name = :name where u.id = :id")
    void updateUserName(@Param("id") long id, @Param("name") String name);

    List<User> findByName(String name);

    List<User> findByNameContains(String name);
}
