package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.entity.CartItem;
import org.shopsphere.shopsphere.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(
            @RequestParam String email,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(
                cartService.addToCart(
                        email,
                        productId, quantity));
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCart(
            Principal principal) {
        return ResponseEntity.ok(
                cartService.getCart(
                        principal.getName()));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeItem(
            @PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.ok(
                "Item removed from cart!");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(
            Principal principal) {
        cartService.clearCart(
                principal.getName());
        return ResponseEntity.ok(
                "Cart cleared!");
    }
}
