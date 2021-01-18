package br.com.kaikeventura.kafood.domain.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "delivery_man_id")
    private DeliveryMan deliveryMan;

    @ManyToOne
    @JoinColumn(name = "payment_form_id")
    private PaymentForm paymentForm;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany
    @JoinTable(
            name = "payment_order_menu_item",
            joinColumns = { @JoinColumn(name = "payment_order_id") },
            inverseJoinColumns = { @JoinColumn(name = "menu_item_id") }
    )
    private Set<MenuItem> menuItems;

    public PaymentOrder(
            BigDecimal totalPrice,
            Client client,
            DeliveryMan deliveryMan,
            PaymentForm paymentForm,
            Restaurant restaurant,
            Set<MenuItem> menuItems
    ) {
        this.totalPrice = totalPrice;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.paymentForm = paymentForm;
        this.restaurant = restaurant;
        this.menuItems = menuItems;
    }
}
