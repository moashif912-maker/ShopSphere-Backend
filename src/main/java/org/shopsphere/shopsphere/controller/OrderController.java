package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.entity.Order;
import org.shopsphere.shopsphere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(
            Principal principal,
            @RequestParam String address) {
        return ResponseEntity.ok(
                orderService.placeOrder(
                        principal.getName(),
                        address));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Order>> myOrders(
            Principal principal) {
        return ResponseEntity.ok(
                orderService.getMyOrders(
                        principal.getName()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> allOrders() {
        return ResponseEntity.ok(
                orderService.getAllOrders());
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Order> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(
                orderService.updateStatus(
                        id, status));
    }
    @PostMapping("/test")
    public ResponseEntity<Order> placeOrderTest(
            @RequestParam String address,
            @RequestParam String email) {
        return ResponseEntity.ok(
                orderService.placeOrder(
                        email, address));
    }
}