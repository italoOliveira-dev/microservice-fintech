package br.com.italooliveira.msavaliadorcredito.api.controller.impl;

import br.com.italooliveira.msavaliadorcredito.api.controller.AvaliadorCreditoController;
import br.com.italooliveira.msavaliadorcredito.api.dtos.*;
import br.com.italooliveira.msavaliadorcredito.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvaliadorCreditorControllerImpl implements AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @Override
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("OK");
    }

    @Override
    public ResponseEntity<SituacaoCliente> consultarSituacaoCliente(String cpf) {
        SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
        return ResponseEntity.ok(situacaoCliente);
    }

    @Override
    public ResponseEntity<RetornoAvalicaoCliente> realizarAvaliacao(DadosAvaliacao dadosAvaliacao) {
        RetornoAvalicaoCliente retornoAvalicaoCliente = avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao);
        return ResponseEntity.ok(retornoAvalicaoCliente);
    }

    @Override
    public ResponseEntity<ProtocoloSolicitacaoCartao> solicitarCartao(DadosSolicitacaoEmissaoCartao dados) {
        ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = avaliadorCreditoService.solicitarEmissaoCartao(dados);
        return ResponseEntity.ok(protocoloSolicitacaoCartao);
    }
}
