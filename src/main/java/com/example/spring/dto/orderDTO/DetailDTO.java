package com.example.spring.dto.orderDTO;

import com.example.spring.model.documents.Product;

public record DetailDTO(
                        @lombok.NonNull
                        Product product,

                        int cant,

                        int amount) {
}
