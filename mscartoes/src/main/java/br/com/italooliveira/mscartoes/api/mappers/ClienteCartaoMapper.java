package br.com.italooliveira.mscartoes.api.mappers;

import br.com.italooliveira.mscartoes.api.responses.CartoesPorClienteResponse;
import br.com.italooliveira.mscartoes.domain.ClienteCartao;
import org.springframework.stereotype.Service;

@Service
public class ClienteCartaoMapper {

    public CartoesPorClienteResponse fromEntity(ClienteCartao clienteCartao) {
        return new CartoesPorClienteResponse(
                clienteCartao.getCartao().getNome(),
                clienteCartao.getCartao().getBandeira().toString(),
                clienteCartao.getLimite()
        );
    }
}
