package com.example.spribeapitest.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ShoppingCartResponseDto {
    private Long userId;
    private List<Long> productIds;
}
