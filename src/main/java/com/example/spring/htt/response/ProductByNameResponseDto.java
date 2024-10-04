package com.example.spring.htt.response;

import com.example.spring.model.enums.StateProduct;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProductByNameResponseDto(@NonNull String id, @NonNull String nameProduct, double priceProduct,
    int amountProduct,
    int amountMinProduct, StateProduct stateProduct) {
}
