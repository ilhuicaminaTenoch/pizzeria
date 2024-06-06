package com.platzi.pizza.service;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import com.platzi.pizza.persitence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaOrderService {
    // se una final para obligarla a que se use desde el contructor
    private final PizzaOrderRepository pizzaOrderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";


    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrderEntity> getAll(){
        return this.pizzaOrderRepository.findAll();
    }

    public List<PizzaOrderEntity> getTodayOrders(){
        LocalDateTime toDate = LocalDate.now().atTime(0,0);
        return this.pizzaOrderRepository.findAllByDateAfter(LocalDate.from(toDate));
    }

    public List<PizzaOrderEntity> getOutsiderOrders(){
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.pizzaOrderRepository.findAllByMethodIn(methods);
    }
}
