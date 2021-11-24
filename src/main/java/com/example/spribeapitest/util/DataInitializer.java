package com.example.spribeapitest.util;

import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.model.Role;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.ProductService;
import com.example.spribeapitest.service.RoleService;
import com.example.spribeapitest.service.UserService;
import java.math.BigDecimal;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final ProductService productService;

    public DataInitializer(RoleService roleService, UserService userService,
                           ProductService productService) {
        this.roleService = roleService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostConstruct
    public void inject() {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("password");
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.add(adminRole);
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("password");
        Role userRole = new Role();
        userRole.setRole("USER");
        roleService.add(userRole);
        user.setRoles(Set.of(userRole));
        userService.add(user);

        Product quantumComputer = new Product();
        quantumComputer.setName("Quantum computer");
        quantumComputer.setWeight(new BigDecimal("55.57"));
        quantumComputer.setPrice(new BigDecimal("15000000"));
        quantumComputer.setAmount(10);
        productService.add(quantumComputer);

        Product electronicComputer = new Product();
        electronicComputer.setName("Electronic Computer");
        electronicComputer.setWeight(new BigDecimal("3.5"));
        electronicComputer.setPrice(new BigDecimal("15000"));
        electronicComputer.setAmount(500);
        productService.add(electronicComputer);
    }
}
