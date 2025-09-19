package com.shubham.dine.flow.dine_flow.Repository;

import com.shubham.dine.flow.dine_flow.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    List<RestaurantTable> findByTableCode(String tableCode);
}
