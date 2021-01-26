package br.com.kaikeventura.kafood.infra.conversor;

import br.com.kaikeventura.kafood.domain.entity.Client;
import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientConverter {

    public static Client toClientEntity(final ClientPayload clientPayload) {
        return new Client(clientPayload.getName(), clientPayload.getDocument());
    }

    public static ClientPayload toClientPayload(final Client client) {
        return new ClientPayload(client.getName(), client.getDocument());
    }
}
