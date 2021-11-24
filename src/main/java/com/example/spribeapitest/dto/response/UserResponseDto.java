package com.example.spribeapitest.dto.response;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private Set<String> roles;
}
