package com.example.spring_boot_security_crud_3_1_3.repositories;

import com.example.spring_boot_security_crud_3_1_3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
