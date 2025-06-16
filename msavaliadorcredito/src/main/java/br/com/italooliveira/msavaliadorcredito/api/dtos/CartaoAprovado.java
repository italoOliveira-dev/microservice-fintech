package br.com.italooliveira.msavaliadorcredito.api.dtos;

import java.math.BigDecimal;

public record CartaoAprovado(String cartao, String bandeira, BigDecimal limiteAprovado) {
}
