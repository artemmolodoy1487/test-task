package by.starovoytov.app.servicies;

import by.starovoytov.app.models.Account;
import by.starovoytov.app.models.User;
import by.starovoytov.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void createUser(User user) {
        // Проверка: у пользователя должен быть хотя бы один телефон и email
        if (user.getPhoneDataList() == null || user.getPhoneDataList().isEmpty()) {
            throw new IllegalArgumentException("User must have at least one phone number.");
        }
        if (user.getEmailDataList() == null || user.getEmailDataList().isEmpty()) {
            throw new IllegalArgumentException("User must have at least one email.");
        }
        if (user.getAccount() == null) {
            throw new IllegalArgumentException("User must have an account.");
        }

        // Проверка: начальный баланс не может быть отрицательным
        if (user.getAccount().getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        userRepository.save(user);
    }

    @Transactional
    public void updateBalance(Long userId, BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Account account = user.getAccount();
        if (account.getBalance().add(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot go negative.");
        }

        account.setBalance(account.getBalance().add(amount));
        userRepository.save(user);
    }
}