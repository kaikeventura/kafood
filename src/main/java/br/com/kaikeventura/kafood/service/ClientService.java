package br.com.kaikeventura.kafood.service;

import br.com.kaikeventura.kafood.domain.repository.ClientRepository;
import br.com.kaikeventura.kafood.error.exception.DocumentAlreadyExistsException;
import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static br.com.kaikeventura.kafood.infra.conversor.ClientConverter.toClientEntity;
import static br.com.kaikeventura.kafood.infra.conversor.ClientConverter.toClientPayload;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientPayload createClient(final ClientPayload clientPayload) {
        verifyIfDocumentIsExists(clientPayload.getDocument());

        return toClientPayload(clientRepository.save(toClientEntity(clientPayload)));
    }

    private void verifyIfDocumentIsExists(final String document) {
        if (clientRepository.findByDocument(document).isPresent()) {
            log.error(String.format("Document %s already registered", document));
            throw new DocumentAlreadyExistsException();
        }
    }
}
