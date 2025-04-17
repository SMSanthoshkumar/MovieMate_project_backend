package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.User;
import com.smsk.MovieMate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;  // Ensure you have this bean configured

    @Autowired
    public UserService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public String signup(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists!";
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        emailService.sendWelcomeMail(user.getEmail());
        return "User registered successfully";
    }

    public String login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return "Login Successful";
        }
        return "Invalid username or password";
    }
}
