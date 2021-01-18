package br.com.kaikeventura.kafood.domain.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String document;

    @OneToMany(mappedBy = "restaurant")
    private Set<PaymentOrder> paymentOrders;

    @OneToMany(mappedBy = "restaurant")
    private Set<MenuItem> menuItems;
}
