package br.com.italooliveira.mscartoes.api.handlerException;

import br.com.italooliveira.mscartoes.api.excetpion.CartaoNaoEncontradoException;
import br.com.italooliveira.mscartoes.api.excetpion.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(CartaoNaoEncontradoException.class)
    public ResponseEntity<StandardError> handlerCartaoNaoEncontrado(CartaoNaoEncontradoException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(
                StandardError.builder()
                        .path(request.getRequestURI())
                        .statusCode(status.value())
                        .statusErro(status.getReasonPhrase())
                        .message(ex.getMessage())
                        .timestamp(Instant.now())
                        .build()
        );
    }
}
