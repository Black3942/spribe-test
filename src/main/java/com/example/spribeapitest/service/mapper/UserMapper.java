package com.example.spribeapitest.service.mapper;

import com.example.spribeapitest.dto.response.UserResponseDto;
import com.example.spribeapitest.model.User;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setRoles(user.getRoles()
                .stream()
                .map(role -> role.getRole().toString())
                .collect(Collectors.toSet()));
        return responseDto;
    }
}
