package by.starovoytov.app.repositories;

import by.starovoytov.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailDataList_Email(String email);

    Optional<User> findByPhoneDataList_Phone(String phone);

    default Optional<User> findByEmailOrPhone(String login) {
        return findByEmailDataList_Email(login).or(() -> findByPhoneDataList_Phone(login));
    }
}