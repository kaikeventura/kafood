package br.com.kaikeventura.kafood.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class DeliveryMan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String document;

    @OneToMany(mappedBy = "deliveryMan")
    private Set<PaymentOrder> paymentOrders;
}
