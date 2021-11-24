package com.example.spribeapitest.dto.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRequestDto {
    @Positive
    private Long id;
    @NotNull
    private String name;
    @Positive
    private BigDecimal weight;
    @Positive
    private BigDecimal price;
    @Positive
    private int amount;
}
