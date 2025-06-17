package br.com.italooliveira.mscartoes.api.excetpion;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException(String message) {
        super(message);
    }
}
