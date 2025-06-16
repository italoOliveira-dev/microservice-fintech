package br.com.italooliveira.msavaliadorcredito.api.controller;

import br.com.italooliveira.msavaliadorcredito.api.dtos.DadosAvaliacao;
import br.com.italooliveira.msavaliadorcredito.api.dtos.RetornoAvalicaoCliente;
import br.com.italooliveira.msavaliadorcredito.api.dtos.SituacaoCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/avaliacoes-credito")
public interface AvaliadorCreditoController {

    @GetMapping
    ResponseEntity<String> status();

    @GetMapping(value = "/situacao-cliente", params = "cpf")
    ResponseEntity<SituacaoCliente> consultarSituacaoCliente(@RequestParam("cpf") String cpf);

    @PostMapping
    ResponseEntity<RetornoAvalicaoCliente> realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao);
}
