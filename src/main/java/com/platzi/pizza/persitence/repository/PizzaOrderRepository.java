package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.PizzaOrderEntity;
import com.platzi.pizza.persitence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {
    List<PizzaOrderEntity> findAllByDateAfter(LocalDate date);
    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

    @Query(value = "select * from pizza_order where id_customer = :id", nativeQuery = true)
    List<PizzaOrderEntity> findCustomerOrders(@Param("id") String idCustomer);

    @Query(value = """
SELECT po.id_order as idOrder,
       cu.name as customerName,
       po.date as orderDate,
       po.total as orderTotal,
       GROUP_CONCAT(pi.name) as pizzaNames
FROM pizza_order po
         INNER JOIN customer cu ON po.id_customer = cu.id_customer
         INNER JOIN order_item oi ON po.id_order = oi.id_order
         INNER JOIN pizza pi ON oi.id_pizza = pi.id_pizza
WHERE po.id_order = :orderId
GROUP BY po.id_order,
         cu.name,
         po.date,
         po.total
""", nativeQuery = true)
    OrderSummary findOrderSummaryById(@Param("orderId") int orderId);

    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);
}
