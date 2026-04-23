package org.shopsphere.shopsphere.repository;

import org.shopsphere.shopsphere.entity.Order;
import org.shopsphere.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
    List<Order> findByStatus(String status);

}
