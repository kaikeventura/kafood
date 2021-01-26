package br.com.kaikeventura.kafood.error.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DocumentAlreadyExistsException extends RuntimeException {
    private final String errorCode = "CLIENT-ERROR-01";
}
