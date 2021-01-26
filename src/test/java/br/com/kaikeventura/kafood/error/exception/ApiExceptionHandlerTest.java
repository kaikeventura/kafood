package br.com.kaikeventura.kafood.error.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


class ApiExceptionHandlerTest {

    @InjectMocks
    protected ApiExceptionHandler apiExceptionHandler;

    @Mock
    protected MessageSource messageSource;

    private Locale locale;

    @BeforeEach
    void setUp() {
        openMocks(this);
        locale = new Locale ("pt", "BR");
    }

    @Test
    void return_DocumentAlreadyExistsException_error() {
        var expectedResponse = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("CLIENT-ERROR-01", "Document already registered"));

        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class)))
                .thenReturn("Document already registered");

        var actualResponse = apiExceptionHandler.exception(new DocumentAlreadyExistsException(), locale);

        assertThat(actualResponse).usingRecursiveComparison().isEqualTo(expectedResponse);
    }

    @Test
    void return_GenericError() {
        var expectedResponse = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError("ERROR-00", "No error message available"));

        when(messageSource.getMessage(anyString(), any(Object[].class), any(Locale.class)))
                .thenThrow(NoSuchMessageException.class);

        var actualResponse = apiExceptionHandler.exception(new DocumentAlreadyExistsException(), locale);

        assertThat(actualResponse).usingRecursiveComparison().isEqualTo(expectedResponse);
    }
}