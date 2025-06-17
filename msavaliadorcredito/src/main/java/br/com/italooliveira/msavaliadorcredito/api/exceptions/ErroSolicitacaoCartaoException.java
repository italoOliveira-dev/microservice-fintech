package br.com.italooliveira.msavaliadorcredito.api.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException {
    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}
