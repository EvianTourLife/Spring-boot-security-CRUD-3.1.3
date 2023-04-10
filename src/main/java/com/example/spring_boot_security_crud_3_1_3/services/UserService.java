package com.example.spring_boot_security_crud_3_1_3.services;

import com.example.spring_boot_security_crud_3_1_3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {



    User getById(Long id);
    void addUser(User user);

    User edit(User user);

    List<User> getAll();

    void delete(Long id);

    Optional<User> findByUsername(String username);
}
