package com.example.spring.dto.product;

import com.example.spring.model.enums.StateProduct;

import lombok.NonNull;

public record ProductsDto(@NonNull String nameProduct, double priceProduct, int amountProducts, int amountMinProduct,
        StateProduct stateProduct, @NonNull String nameSupplier, String image) {
}
