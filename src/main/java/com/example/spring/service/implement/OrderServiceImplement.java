package com.example.spring.service.implement;

import com.example.spring.dto.orderDTO.CreateOrderDTO;
import com.example.spring.dto.orderDTO.DetailDTO;
import com.example.spring.dto.orderDTO.UpdateOrderDTO;
import com.example.spring.dto.product.ProductsDto;
import com.example.spring.dto.product.UpdateProduct;
import com.example.spring.exceptions.OrderException;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Detail;
import com.example.spring.model.documents.Order;
import com.example.spring.model.documents.Product;
import com.example.spring.model.enums.StateOrder;
import com.example.spring.repository.OrderRepository;
import com.example.spring.service.OrderService;
import com.example.spring.service.ProductService;
import jakarta.validation.constraints.Null;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplement implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;

    @Override
    public Order saveOrder(CreateOrderDTO order) {
        Order o = orderDTOToOrder(order);
        return orderRepository.save(o);
    }

    @Override
    public Order updateOrder(UpdateOrderDTO order) {
        Order o = orderDTOToOrder(order);
        return orderRepository.save(o);
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Detail> getAllDetailProducts(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            List<Detail> details = order.get().getDetailProduct();
            return details;
        } else {
            throw new OrderException("pedido no encontrado");
        }

    }

    public Detail addDetail(DetailDTO detail, String idOrder) throws ProductException {

        Detail detailProduct = Detail.builder().cant(detail.cant()).amount(detail.amount()).product(detail.product())
                .build();
        Optional<Order> orderOptional = orderRepository.findById(idOrder);
        Order order = orderOptional.get();
        order.getDetailProduct().add(detailProduct);
        orderRepository.save(order);
        Product product = detailProduct.getProduct();
        product.setAmountProduct(product.getAmountProduct() - detailProduct.getCant());
        productService.updateProducts(objectToDto(product));

        return detailProduct;
    }

    private UpdateProduct objectToDto(Product product) {
        return new UpdateProduct(
                product.getId(),
                product.getNameProduct(),
                product.getStateProduct(),
                product.getPriceProduct(),
                product.getAmountProduct(),
                product.getAmountMinProduct(),
                product.getImage(), product.getNameSupplier());

    }

    @Override
    public Double calcularTotal(String id) {
        Double total = 0.0;
        List<Detail> details = getAllDetailProducts(id);
        for (Detail detail : details) {
            total += detail.getAmount();
        }
        return total;
    }

    @Override
    public Order orderDTOToOrder(CreateOrderDTO orderDto) {
        Order order = new Order();
        return getOrder(order, orderDto.hora(), orderDto.direccion(), orderDto.fecha(), orderDto.tipo(),
                orderDto.estado(), orderDto.total(), orderDto.DetailProduct());
    }

    @Override
    public Order orderDTOToOrder(UpdateOrderDTO orderDto) {
        Order order = new Order();
        order.setId(orderDto.id());
        return getOrder(order, orderDto.hora(), orderDto.direccion(), orderDto.fecha(), orderDto.tipo(),
                orderDto.estado(), orderDto.total(), orderDto.DetailProduct());
    }

    private Order getOrder(Order order, LocalDateTime hora, String direccion, LocalDate fecha, String tipo,
            StateOrder estado, Double total, List<Detail> details) {
        order.setHora(hora);
        order.setDireccion(direccion);
        order.setFecha(fecha);
        order.setTipo(tipo);
        order.setEstado(estado);
        order.setTotal(total);
        order.setDetailProduct(details);

        return order;
    }
}
