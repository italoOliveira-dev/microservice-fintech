package br.com.italooliveira.mscartoes.api.responses;

import java.math.BigDecimal;

public record CartoesPorClienteResponse(String nome, String bandeira, BigDecimal limiteLiberado) {
}
