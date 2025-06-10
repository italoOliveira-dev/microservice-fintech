package br.com.italooliveira.mscartoes.api.requests;

import java.math.BigDecimal;

public record CartaoSaveRequest(String nome, String bandeira, BigDecimal renda, BigDecimal limite) {
}
