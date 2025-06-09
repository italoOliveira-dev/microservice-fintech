package br.com.italooliveira.mscliente.api.dto;

public record ClienteSaveRequest(String cpf, String nome, Integer idade) {
}
