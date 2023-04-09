package com.example.spring_boot_security_crud_3_1_3.repositories;

import com.example.spring_boot_security_crud_3_1_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);

}