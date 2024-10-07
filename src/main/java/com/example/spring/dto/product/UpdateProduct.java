package com.example.spring.dto.product;

import java.util.List;

import com.example.spring.model.enums.StateProduct;

import jakarta.validation.constraints.Null;
import lombok.NonNull;

public record UpdateProduct(@NonNull String id, @NonNull String nameProduct, @NonNull StateProduct stateProduct,
    double priceProduct,
    int amountProduct, int amountMinProduct, @Null List<String> images) {
}
