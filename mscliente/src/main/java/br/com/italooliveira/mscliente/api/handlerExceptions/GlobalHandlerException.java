package br.com.italooliveira.mscliente.api.handlerExceptions;

import br.com.italooliveira.mscliente.infra.exceptions.ClienteNotFoundException;
import br.com.italooliveira.mscliente.infra.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<StandardError> handlerClienteNotFoundException(ClienteNotFoundException ex, HttpServletRequest request) {

        var status = HttpStatus.NOT_FOUND;

        var error = StandardError.builder()
                .path(request.getRequestURI())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(ex.getMessage())
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
