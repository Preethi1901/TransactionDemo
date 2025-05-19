package com.example.demo.Repositories;



import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   // User findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    User findByUsername(String username);
}




