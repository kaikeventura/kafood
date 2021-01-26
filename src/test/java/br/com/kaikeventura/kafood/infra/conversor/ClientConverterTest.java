package br.com.kaikeventura.kafood.infra.conversor;

import br.com.kaikeventura.kafood.factory.ClientFactory;
import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientConverterTest {

    @Test
    void convert_ClientPayload_in_ClientEntity() {
        var expectedClientEntity = ClientFactory.any().build();

        var actualClientPayload = ClientConverter.toClientEntity(
                new ClientPayload(ClientFactory.any().build().getName(), ClientFactory.any().build().getDocument())
        );

        assertThat(actualClientPayload).usingRecursiveComparison().isEqualTo(expectedClientEntity);
    }

    @Test
    void convert_ClientEntity_in_ClientPayload() {
        var expectedClientPayload = new ClientPayload(
                ClientFactory.any().build().getName(), ClientFactory.any().build().getDocument()
        );

        var actualClientPayload = ClientConverter.toClientPayload(ClientFactory.any().build());

        assertThat(actualClientPayload).usingRecursiveComparison().isEqualTo(expectedClientPayload);
    }

}