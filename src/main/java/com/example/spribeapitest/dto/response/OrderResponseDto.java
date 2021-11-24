package com.example.spribeapitest.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderResponseDto {
    private Long id;
    private List<Long> productIds;
    private Long userId;
    private String orderTime;
}
