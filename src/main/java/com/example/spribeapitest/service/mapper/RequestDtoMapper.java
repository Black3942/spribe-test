package com.example.spribeapitest.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
