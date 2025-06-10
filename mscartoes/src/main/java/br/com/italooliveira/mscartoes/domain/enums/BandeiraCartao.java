package br.com.italooliveira.mscartoes.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum BandeiraCartao {
    MASTERCARD("Mastercard"),
    VISA("Visa");

    private final String bandeira;

    public static BandeiraCartao findByBandeira(String bandeira) {
        return Arrays.stream(BandeiraCartao.values())
                .filter(bandeiraCartao -> bandeiraCartao.getBandeira().equals(bandeira))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Bandeira do catão não encontrado!"));
    }

    @Override
    public String toString() {
        return bandeira;
    }
}
