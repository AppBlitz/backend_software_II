package com.example.spring.dto.orderDTO;

import com.example.spring.model.enums.*;
import com.example.spring.model.documents.Detail;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public record CreateOrderDTO( @NonNull LocalDate fecha,
                              Double total,
                              @NonNull String tipo,
                              @NonNull String direccion,
                              @NonNull LocalDateTime hora,
                              @NonNull StateOrder estado,
                              @NonNull List<Detail> DetailProduct) {
}
