package br.com.italooliveira.msavaliadorcredito.api.dtos;

import java.math.BigDecimal;

public record DadosSolicitacaoEmissaoCartao(Long idCartao, String cpf, String endereco, BigDecimal limiteLiberado) {
}
