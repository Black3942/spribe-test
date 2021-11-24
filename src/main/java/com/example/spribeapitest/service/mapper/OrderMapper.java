package com.example.spribeapitest.service.mapper;

import com.example.spribeapitest.dto.response.OrderResponseDto;
import com.example.spribeapitest.model.Order;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.util.DateTimePatternUtil;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime().format(formatter));
        responseDto.setProductIds(order.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
