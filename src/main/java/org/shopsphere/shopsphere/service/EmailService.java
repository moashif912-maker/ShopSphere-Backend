package org.shopsphere.shopsphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOrderConfirmation(
            String toEmail,
            Long orderId,
            Double totalAmount) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject(
                "ShopSphere — Order Confirmed! 🛒");
        message.setText(
                "Hello!\n\n" +
                        "Your order has been placed successfully!\n\n" +
                        "Order ID: #" + orderId + "\n" +
                        "Total Amount: ₹" + totalAmount + "\n" +
                        "Status: PENDING\n\n" +
                        "Thank you for shopping with ShopSphere!\n\n" +
                        "Team ShopSphere 🛒"
        );

        mailSender.send(message);
    }
}
