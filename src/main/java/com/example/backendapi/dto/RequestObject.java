package com.example.backendapi.dto;

import jakarta.validation.constraints.NotNull;

public record RequestObject(
        @NotNull String productName,
        @NotNull double price,
        @NotNull int itemLeft,
        @NotNull String categoryName
) {
}
