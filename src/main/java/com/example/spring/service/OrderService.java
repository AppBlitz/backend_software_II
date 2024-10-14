package com.example.spring.service;

import com.example.spring.dto.orderDTO.CreateOrderDTO;
import com.example.spring.dto.orderDTO.DetailDTO;
import com.example.spring.dto.orderDTO.UpdateOrderDTO;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Detail;
import com.example.spring.model.documents.Order;

import java.util.List;

public interface OrderService {

    public Order saveOrder(CreateOrderDTO order);

    public Order updateOrder(UpdateOrderDTO order);

    public void deleteOrder(String id);

    public List<Detail> getAllDetailProducts(String id);

    public Detail addDetail(DetailDTO detail, String idOrder) throws ProductException;

    public Double calcularTotal(String id);

    public Order orderDTOToOrder(CreateOrderDTO orderDto);

    public Order orderDTOToOrder(UpdateOrderDTO orderDto);
}
