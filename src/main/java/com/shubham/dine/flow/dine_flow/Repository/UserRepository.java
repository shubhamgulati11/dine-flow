package com.shubham.dine.flow.dine_flow.Repository;

import com.shubham.dine.flow.dine_flow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber); // for login



}
