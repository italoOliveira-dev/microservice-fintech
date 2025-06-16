package br.com.italooliveira.msavaliadorcredito.service;

import br.com.italooliveira.msavaliadorcredito.api.dtos.*;
import br.com.italooliveira.msavaliadorcredito.infra.clients.CartoesResourceClient;
import br.com.italooliveira.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesClient;

    public SituacaoCliente obterSituacaoCliente(@RequestParam("cpf") String cpf) {
        DadosCliente dadosClienteResponse = verificarClientePeloCpf(cpf);
        ResponseEntity<List<CartaoCliente>> dadosCartoes = cartoesClient.obterCartoesPorCliente(cpf);
        return SituacaoCliente.builder()
                .dadosCliente(dadosClienteResponse)
                .cartaoCliente(dadosCartoes.getBody())
                .build();
    }

    public RetornoAvalicaoCliente realizarAvaliacao(final DadosAvaliacao dadosAvaliacao) {
        DadosCliente dadosCliente = verificarClientePeloCpf(dadosAvaliacao.cpf());
        ResponseEntity<List<Cartao>> cartoesResponse = cartoesClient.obterCartoesRendaAte(dadosAvaliacao.renda());
        List<Cartao> cartoes = cartoesResponse.getBody();
        var listCartoesAprovado = Objects.requireNonNull(cartoes).stream().map((cartao) -> {

            BigDecimal limiteBasico = cartao.limiteBasico();
            BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente.idade());
            BigDecimal fator = idadeBD.divide(BigDecimal.TEN, 2, RoundingMode.HALF_UP);
            BigDecimal limiteAprovado = fator.multiply(limiteBasico).setScale(2, RoundingMode.HALF_UP);

            return new CartaoAprovado(cartao.nome(), cartao.bandeira(), limiteAprovado);
        }).toList();


        return new RetornoAvalicaoCliente(listCartoesAprovado);
    }

    private DadosCliente verificarClientePeloCpf(String cpf) {
        return clientesClient.dadosCliente(cpf).getBody();
    }
}
