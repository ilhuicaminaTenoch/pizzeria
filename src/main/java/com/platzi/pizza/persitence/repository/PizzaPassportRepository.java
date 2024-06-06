package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.PizzaEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPassportRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {
}
