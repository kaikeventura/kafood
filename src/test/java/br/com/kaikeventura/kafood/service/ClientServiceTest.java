package br.com.kaikeventura.kafood.service;

import br.com.kaikeventura.kafood.domain.entity.Client;
import br.com.kaikeventura.kafood.domain.repository.ClientRepository;
import br.com.kaikeventura.kafood.error.exception.DocumentAlreadyExistsException;
import br.com.kaikeventura.kafood.factory.ClientFactory;
import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ClientServiceTest {

    @Mock
    protected ClientRepository clientRepository;

    @InjectMocks
    protected ClientService clientService;

    private ClientPayload newClientPayload;

    @BeforeEach
    void setup() {
        openMocks(this);
        newClientPayload = new ClientPayload(
                ClientFactory.any().build().getName(),
                ClientFactory.any().build().getDocument()
        );
    }

    @Test
    void save_new_ClientEntity() {
        var expectClientPayload = new ClientPayload(
                ClientFactory.any().build().getName(),
                ClientFactory.any().build().getDocument()
        );

        when(clientRepository.save(any(Client.class))).thenReturn(ClientFactory.any().build());

        var actualClientPayload = clientService.createClient(newClientPayload);

        assertThat(actualClientPayload).usingRecursiveComparison().isEqualTo(expectClientPayload);
    }

    @Test
    void throws_DocumentAlreadyExistsException_when_creating_an_existing_document_client() {
        var newClientPayload = new ClientPayload(
                ClientFactory.any().build().getName(),
                ClientFactory.any().build().getDocument()
        );

        when(clientRepository.findByDocument(anyString())).thenReturn(Optional.of(ClientFactory.any().build()));

        assertThrows(DocumentAlreadyExistsException.class, () -> clientService.createClient(newClientPayload));
    }

}