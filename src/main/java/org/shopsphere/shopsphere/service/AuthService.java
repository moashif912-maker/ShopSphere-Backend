package org.shopsphere.shopsphere.service;

import org.shopsphere.shopsphere.dto.*;
        import org.shopsphere.shopsphere.entity.User;
import org.shopsphere.shopsphere.repository.UserRepository;
import org.shopsphere.shopsphere.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(
                request.getEmail())) {
            return "Email already exists!";
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(
                request.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return "User registered successfully!";
    }

    public JwtResponse login(LoginRequest request) {
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found!"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException(
                    "Invalid password!");
        }

        String token = jwtUtil.generateToken(
                user.getEmail());
        return new JwtResponse(
                token,
                user.getEmail(),
                user.getRole());
    }
}
