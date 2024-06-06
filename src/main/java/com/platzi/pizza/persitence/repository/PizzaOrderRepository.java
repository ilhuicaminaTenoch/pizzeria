package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {
}
