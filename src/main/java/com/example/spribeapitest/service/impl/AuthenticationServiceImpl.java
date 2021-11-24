package com.example.spribeapitest.service.impl;

import com.example.spribeapitest.model.Role;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.AuthenticationService;
import com.example.spribeapitest.service.RoleService;
import com.example.spribeapitest.service.ShoppingCartService;
import com.example.spribeapitest.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String USER_ROLE = "USER";
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role userRole = roleService.getRoleByName(USER_ROLE);
        user.setRoles(Set.of(userRole));
        User savedUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(savedUser);
        return savedUser;
    }
}
