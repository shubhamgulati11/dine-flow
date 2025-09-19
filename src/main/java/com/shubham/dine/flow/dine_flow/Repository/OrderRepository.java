package com.shubham.dine.flow.dine_flow.Repository;

import com.shubham.dine.flow.dine_flow.entity.OrderStatus;
import com.shubham.dine.flow.dine_flow.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByCustomerId(Long customerId);
    List<Orders> findByTableId(Long tableId);
    List<Orders> findByStatusIn(List<OrderStatus> statuses);

}
