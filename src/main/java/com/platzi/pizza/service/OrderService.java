package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //Recuperar todas las ordenes de la bd
    public List<OrderEntity> getAll(){
        return this.orderRepository.findAll();
    }


}
