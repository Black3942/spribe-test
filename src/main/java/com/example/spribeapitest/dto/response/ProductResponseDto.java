package com.example.spribeapitest.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal weight;
    private BigDecimal price;
}
