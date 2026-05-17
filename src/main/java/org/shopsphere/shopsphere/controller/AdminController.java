package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.entity.Order;
import org.shopsphere.shopsphere.entity.User;
import org.shopsphere.shopsphere.repository.OrderRepository;
import org.shopsphere.shopsphere.repository.UserRepository;
import org.shopsphere.shopsphere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    // Saare users dekho
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(
                userRepository.findAll());
    }

    // Saare orders dekho
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(
                orderRepository.findAll());
    }

    // Order status change karo
    @PutMapping("/orders/{id}/status")
    public ResponseEntity<Order> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(
                orderService.updateStatus(id, status));
    }

    // User delete karo
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok(
                "User deleted successfully!");
    }

    // Dashboard stats
    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        long totalUsers = userRepository.count();
        long totalOrders = orderRepository.count();
        return ResponseEntity.ok(
                java.util.Map.of(
                        "totalUsers", totalUsers,
                        "totalOrders", totalOrders
                ));
    }
}