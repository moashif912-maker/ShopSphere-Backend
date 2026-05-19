package org.shopsphere.shopsphere.service;

import org.shopsphere.shopsphere.entity.*;
        import org.shopsphere.shopsphere.repository.*;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private EmailService emailService;

    public Order placeOrder(
            String email, String address) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found!"));

        List<CartItem> cartItems =
                cartService.getCart(email);

        if (cartItems.isEmpty()) {
            throw new RuntimeException(
                    "Cart is empty!");
        }

        double total = cartItems.stream()
                .mapToDouble(item ->
                        item.getProduct().getPrice()
                                * item.getQuantity())
                .sum();

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setStatus("PENDING");
        order.setAddress(address);
        order.setOrderDate(LocalDateTime.now());

        orderRepository.save(order);
        emailService.sendOrderConfirmation(
                email,
                order.getId(),
                order.getTotalAmount()
        );
        cartService.clearCart(email);
        return order;
    }

    public List<Order> getMyOrders(String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found!"));
        return orderRepository.findByUser(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateStatus(
            Long orderId, String status) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found!"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}