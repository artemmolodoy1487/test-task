package by.starovoytov.app.controllers;

import by.starovoytov.app.servicies.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String login,
            @RequestParam String password) {

        String token = authService.authenticate(login, password);
        return ResponseEntity.ok(token);
    }
}