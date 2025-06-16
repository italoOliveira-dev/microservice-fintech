package br.com.italooliveira.msavaliadorcredito.api.dtos;

import java.math.BigDecimal;

public record Cartao(Long id, String nome, String bandeira, BigDecimal limiteBasico) {
}
