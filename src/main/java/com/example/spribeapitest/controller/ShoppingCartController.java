package com.example.spribeapitest.controller;

import com.example.spribeapitest.dto.response.ShoppingCartResponseDto;
import com.example.spribeapitest.exception.DataProcessingException;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.ProductService;
import com.example.spribeapitest.service.ShoppingCartService;
import com.example.spribeapitest.service.UserService;
import com.example.spribeapitest.service.mapper.ShoppingCartMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final ProductService productService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  UserService userService,
                                  ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.productService = productService;
    }

    @PutMapping("/products")
    public void addToCart(Authentication auth, @RequestParam Long productId,
                          @RequestParam Integer amount) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(() ->
                new DataProcessingException("User with email " + email + " not found"));
        Product product = productService.get(productId);
        shoppingCartService.addProduct(product, user, amount);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(() ->
                new DataProcessingException("User with email " + email + " not found"));
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
