package com.platzi.pizza.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(name = "id_customer", nullable = false, columnDefinition = "VARCHAR(15)")
    private String idCustomer;

    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false, columnDefinition = "VARCHAR(20)")
    private String phoneNumber;
}
