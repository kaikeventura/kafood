package br.com.kaikeventura.kafood.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String document;

    @OneToMany(mappedBy = "client")
    private Set<PaymentOrder> paymentOrders;

    public Client(final String name, final String document) {
        this.name = name;
        this.document = document;
    }
}
