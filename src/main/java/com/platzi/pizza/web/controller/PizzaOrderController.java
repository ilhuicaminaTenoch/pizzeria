package com.platzi.pizza.web.controller;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import com.platzi.pizza.persitence.projection.OrderSummary;
import com.platzi.pizza.service.PizzaOrderService;
import com.platzi.pizza.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PizzaOrderController {
    private final PizzaOrderService pizzaOrderService;

    @Autowired
    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrderEntity>> getAll(){
        return ResponseEntity.ok(this.pizzaOrderService.getAll());
    }

    @GetMapping("today")
    public ResponseEntity<List<PizzaOrderEntity>> getToDateOrders(){
        return ResponseEntity.ok(this.pizzaOrderService.getTodayOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<PizzaOrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(this.pizzaOrderService.getOutsiderOrders());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<PizzaOrderEntity>> getCustomerOrder(@PathVariable String id){
        return ResponseEntity.ok(this.pizzaOrderService.getCustomerOrder(id));
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable int id){
        return ResponseEntity.ok(this.pizzaOrderService.getSummary(id));
    }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto){
        return ResponseEntity.ok(this.pizzaOrderService.saveRandomOrder(dto));
    }
}
