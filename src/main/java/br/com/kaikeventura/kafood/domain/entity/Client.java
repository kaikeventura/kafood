package br.com.kaikeventura.kafood.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String document;

    @OneToMany(mappedBy = "client")
    private Set<PaymentOrder> paymentOrders;
}
