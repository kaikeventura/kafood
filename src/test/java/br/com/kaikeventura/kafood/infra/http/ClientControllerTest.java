package br.com.kaikeventura.kafood.infra.http;

import br.com.kaikeventura.kafood.factory.ClientFactory;
import br.com.kaikeventura.kafood.infra.payload.ClientPayload;
import br.com.kaikeventura.kafood.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Mock
    protected ClientService clientService;

    private ClientPayload clientPayload;
    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        openMocks(this);

        mapper = new ObjectMapper();
        clientPayload = new ClientPayload(
                ClientFactory.any().build().getName(),
                ClientFactory.any().build().getDocument()
        );
    }

    @Test
    void create_newClient_and_return_StatusCode_201Created() throws Exception {
        when(clientService.createClient(any(ClientPayload.class))).thenReturn(clientPayload);

        mockMvc.perform(
                post("/v1/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(clientPayload))
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(clientPayload.getName()))
                .andExpect(jsonPath("$.document").value(clientPayload.getDocument()));
    }

}