package br.com.kaikeventura.kafood.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Form {
    CASH(1L),
    CREDIT(2L),
    DEBIT(3L);

    private final Long id;

    public PaymentForm paymentForm() {
        return new PaymentForm(this.id, this, null);
    }
}
