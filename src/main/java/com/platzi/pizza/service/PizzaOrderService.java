package com.platzi.pizza.service;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import com.platzi.pizza.persitence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderService {
    // se una final para obligarla a que se use desde el contructor
    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrderEntity> getAll(){
        return this.pizzaOrderRepository.findAll();
    }
}
