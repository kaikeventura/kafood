package br.com.kaikeventura.kafood.infra.http;

import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import br.com.kaikeventura.kafood.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientPayload> createNewClient(@RequestBody final ClientPayload clientPayload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientPayload));
    }
}
