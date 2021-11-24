package com.example.spribeapitest.controller;

import com.example.spribeapitest.dto.request.UserRequestDto;
import com.example.spribeapitest.dto.response.UserResponseDto;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.AuthenticationService;
import com.example.spribeapitest.service.mapper.UserMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }
}
