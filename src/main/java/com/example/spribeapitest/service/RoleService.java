package com.example.spribeapitest.service;

import com.example.spribeapitest.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
