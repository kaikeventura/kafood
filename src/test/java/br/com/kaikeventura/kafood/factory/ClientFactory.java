package br.com.kaikeventura.kafood.factory;

import br.com.kaikeventura.kafood.domain.entity.Client;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFactory {

    public static ClientBuilder.ClientBuilderBuilder any() {
        return ClientBuilder.builder()
                .name("James Bond")
                .document("12345678978");
    }

    public static class ClientBuilder extends Client {

        @Builder
        public ClientBuilder(
            final Long id,
            final String name,
            final String document
        ) {
            super(name, document);
        }

        public final Client toEntity() {
            return new Client(getName(), getDocument());
        }
    }
}
