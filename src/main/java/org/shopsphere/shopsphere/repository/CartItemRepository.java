package org.shopsphere.shopsphere.repository;

import jakarta.transaction.Transactional;
import org.shopsphere.shopsphere.entity.CartItem;
import org.shopsphere.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {


    List<CartItem> findByUser(User user);
    @Transactional
    void deleteByUser(User user);

}
