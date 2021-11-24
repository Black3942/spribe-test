package com.example.spribeapitest.service;

import com.example.spribeapitest.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
