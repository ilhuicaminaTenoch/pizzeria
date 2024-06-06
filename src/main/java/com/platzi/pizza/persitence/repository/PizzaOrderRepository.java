package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;


import java.time.LocalDate;
import java.util.List;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {
    List<PizzaOrderEntity> findAllByDateAfter(LocalDate date);
    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);
}
