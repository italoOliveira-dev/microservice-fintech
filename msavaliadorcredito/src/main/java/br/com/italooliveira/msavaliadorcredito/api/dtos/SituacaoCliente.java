package br.com.italooliveira.msavaliadorcredito.api.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record SituacaoCliente(DadosCliente dadosCliente, List<CartaoCliente> cartaoCliente) {
}
