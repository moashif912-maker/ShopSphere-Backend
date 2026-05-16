package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.entity.User;
import org.shopsphere.shopsphere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public ResponseEntity<User> getProfile(
            @RequestParam String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found!"));
        return ResponseEntity.ok(user);
    }
}
