package br.com.kaikeventura.kafood.error.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    @JsonProperty("error_code")
    private final String errorCode;
    @JsonProperty("error_message")
    private final String errorMessage;
}
