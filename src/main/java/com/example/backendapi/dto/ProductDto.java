package com.example.backendapi.dto;

public record ProductDto(
        int id,
        String name,
        double price,
        int itemLeft
) {
}
