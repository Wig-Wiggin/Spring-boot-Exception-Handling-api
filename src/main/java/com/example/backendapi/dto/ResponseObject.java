package com.example.backendapi.dto;

public record ResponseObject(
        int productId,
        String productName,
        double price,
        int itemLeft,
        String categoryName,

        int categoryId
) {
}
