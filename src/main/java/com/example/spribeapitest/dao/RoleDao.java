package com.example.spribeapitest.dao;

import com.example.spribeapitest.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String name);
}
