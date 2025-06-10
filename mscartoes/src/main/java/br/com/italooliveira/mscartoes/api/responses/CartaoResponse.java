package br.com.italooliveira.mscartoes.api.responses;

import java.math.BigDecimal;

public record CartaoResponse(Long id, String nome, String bandeira, BigDecimal renda, BigDecimal limiteBasico) {
}
