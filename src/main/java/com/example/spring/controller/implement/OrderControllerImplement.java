package com.example.spring.controller.implement;

import com.example.spring.dto.orderDTO.CreateOrderDTO;
import com.example.spring.dto.orderDTO.DetailDTO;
import com.example.spring.dto.orderDTO.UpdateOrderDTO;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Detail;
import com.example.spring.model.documents.Order;
import com.example.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pedidos")
public class OrderControllerImplement {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/guardarPedido", method = RequestMethod.POST)
    public ResponseEntity<Order> saveOrder(@RequestBody CreateOrderDTO order) {
        Order o=orderService.saveOrder(order);
        return ResponseEntity.ok(o);
    }

    @RequestMapping(value = "/actualizarPedido", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@RequestBody UpdateOrderDTO order) {
        Order o=orderService.updateOrder(order);
        return ResponseEntity.ok(o);
    }

    @RequestMapping(value = "/eliminarPedido", method = RequestMethod.PUT)
    public ResponseEntity<Order> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body(null);
    }

    @RequestMapping(value = "/addDetail/{id}", method = RequestMethod.POST)
    public ResponseEntity<Detail> addDetail(@RequestBody DetailDTO detailDTO, @PathVariable String id) throws ProductException {
        orderService.addDetail(detailDTO,id);
        return ResponseEntity.status(200).body(null);
    }
}
