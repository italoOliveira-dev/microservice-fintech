package br.com.italooliveira.mscartoes.api.dtos;

import java.math.BigDecimal;

public record DadosSolicitacaoEmissaoCartao(Long idCartao, String cpf, String endereco, BigDecimal limiteLiberado) {
}
