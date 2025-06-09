package br.com.italooliveira.mscliente.infra.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}
