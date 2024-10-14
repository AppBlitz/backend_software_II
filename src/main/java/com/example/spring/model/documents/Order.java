package com.example.spring.model.documents;

import com.example.spring.model.enums.StateOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString

@Document("orders")
public class Order {

    @Id
    private String id;
    @NonNull
    private LocalDate fecha;

    private Double total;
    @NonNull
    private String tipo;
    @NonNull
    private String direccion;
    @NonNull
    private LocalDateTime hora;
    @NonNull
    private StateOrder estado;
    @NonNull
    private List<Detail> DetailProduct;

}
