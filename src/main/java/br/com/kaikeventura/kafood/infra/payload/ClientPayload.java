package br.com.kaikeventura.kafood.infra.payload;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ClientPayload implements Serializable {

    private final String name;
    private final String document;

    public ClientPayload(String name, String document) {
        this.name = name;
        this.document = document;
    }
}
