package br.com.italooliveira.mscliente.api.dto;

public record ClienteResponse(Long id, String cpf, String nome, Integer idade) {
}
