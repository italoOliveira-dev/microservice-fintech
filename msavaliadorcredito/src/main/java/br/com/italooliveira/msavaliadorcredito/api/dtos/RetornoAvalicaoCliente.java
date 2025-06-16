package br.com.italooliveira.msavaliadorcredito.api.dtos;

import java.util.List;

public record RetornoAvalicaoCliente(List<CartaoAprovado> cartoes) {
}
