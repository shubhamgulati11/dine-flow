package com.shubham.dine.flow.dine_flow.Repository;

import com.shubham.dine.flow.dine_flow.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder_Id(Long orderId);

}
