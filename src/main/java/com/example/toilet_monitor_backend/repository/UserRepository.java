package com.example.toilet_monitor_backend.repository;

import com.example.toilet_monitor_backend.entity.User;
import com.example.toilet_monitor_backend.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsernameAndActiveTrue(String username);
//    List<User> findByRoleAndActiveTrue(Role role);
Optional<User> findByUsername(String username);
    List<User> findByRole(Role role);

}