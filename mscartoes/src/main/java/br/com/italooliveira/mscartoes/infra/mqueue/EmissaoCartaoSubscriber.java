package br.com.italooliveira.mscartoes.infra.mqueue;

import br.com.italooliveira.mscartoes.api.dtos.DadosSolicitacaoEmissaoCartao;
import br.com.italooliveira.mscartoes.api.excetpion.CartaoNaoEncontradoException;
import br.com.italooliveira.mscartoes.domain.Cartao;
import br.com.italooliveira.mscartoes.domain.ClienteCartao;
import br.com.italooliveira.mscartoes.infra.repository.CartaoRepository;
import br.com.italooliveira.mscartoes.infra.repository.ClienteCartaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queue.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
        Cartao cartao = cartaoRepository.findById(dados.idCartao()).orElseThrow(() -> new CartaoNaoEncontradoException(
                String.format("Cartão com id: %d não encontrado", dados.idCartao())
        ));

        clienteCartaoRepository.save(
                ClienteCartao.builder()
                        .cartao(cartao)
                        .cpf(dados.cpf())
                        .limite(dados.limiteLiberado())
                        .build()
        );

    }
}
