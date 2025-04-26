package by.starovoytov.app.servicies;

import by.starovoytov.app.models.User;
import by.starovoytov.app.repositories.UserRepository;
import by.starovoytov.app.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticate(String login, String password) {
        User user = userRepository.findByEmailOrPhone(login)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getId());
    }
}