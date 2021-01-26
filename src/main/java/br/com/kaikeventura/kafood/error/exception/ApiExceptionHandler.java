package br.com.kaikeventura.kafood.error.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(DocumentAlreadyExistsException.class)
    public ResponseEntity<ApiError> exception(final DocumentAlreadyExistsException exception, Locale locale) {

        return ResponseEntity.status(BAD_REQUEST).body(buildApiError(exception.getErrorCode(), locale));
    }

    private ApiError buildApiError(String errorCode, Locale locale, String... args) {
        String errorMessage;

        try {
            errorMessage = messageSource.getMessage(errorCode, args, locale);
        }
        catch (NoSuchMessageException e) {
            errorCode = "ERROR-00";
            errorMessage = "No error message available";
        }

        return new ApiError(errorCode, errorMessage);
    }
}
