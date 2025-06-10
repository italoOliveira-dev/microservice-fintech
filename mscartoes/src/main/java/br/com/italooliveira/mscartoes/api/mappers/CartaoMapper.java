package br.com.italooliveira.mscartoes.api.mappers;

import br.com.italooliveira.mscartoes.api.responses.CartaoResponse;
import br.com.italooliveira.mscartoes.api.requests.CartaoSaveRequest;
import br.com.italooliveira.mscartoes.domain.enums.BandeiraCartao;
import br.com.italooliveira.mscartoes.domain.Cartao;
import org.springframework.stereotype.Service;

@Service
public class CartaoMapper {

    public Cartao toEntity(CartaoSaveRequest request) {
        return Cartao.builder()
                .nome(request.nome())
                .bandeira(BandeiraCartao.findByBandeira(request.bandeira()))
                .renda(request.renda())
                .limiteBasico(request.limite())
                .build();
    }

    public CartaoResponse fromEntity(Cartao cartao) {
        return new CartaoResponse(cartao.getId(), cartao.getNome(), cartao.getBandeira().getBandeira(), cartao.getRenda(), cartao.getLimiteBasico());
    }
}
