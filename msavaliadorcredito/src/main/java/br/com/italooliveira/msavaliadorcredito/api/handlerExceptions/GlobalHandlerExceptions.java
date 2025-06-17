package br.com.italooliveira.msavaliadorcredito.api.handlerExceptions;

import br.com.italooliveira.msavaliadorcredito.api.exceptions.ErroSolicitacaoCartaoException;
import br.com.italooliveira.msavaliadorcredito.api.exceptions.GenericFeignException;
import br.com.italooliveira.msavaliadorcredito.api.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(GenericFeignException.class)
    public ResponseEntity<Map> handleGenericFeignException(final GenericFeignException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.getError());
    }

    @ExceptionHandler(ErroSolicitacaoCartaoException.class)
    public ResponseEntity<StandardError> handlerErroSolicitacaoCartaoException(final ErroSolicitacaoCartaoException ex,
                                                                               final HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
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
