package br.com.italooliveira.msavaliadorcredito.api.dtos;

import java.math.BigDecimal;

public record CartaoCliente(String nome, String bandeira, BigDecimal limiteLiberado) {
}
