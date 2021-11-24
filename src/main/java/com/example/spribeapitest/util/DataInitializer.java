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

        IntStream.range(0, 50).forEach(i -> {
            Product product = new Product();
            product.setName("Product " + i);
            product.setWeight(new BigDecimal(String.valueOf(new Random().nextInt(500))));
            product.setPrice(new BigDecimal(String.valueOf(new Random().nextInt(5000000))));
            product.setAmount(new Random().nextInt(5000));
            productService.add(product);
        });
    }
}
