package com.example.spribeapitest.service;

import com.example.spribeapitest.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
