package br.com.italooliveira.mscartoes.api.controller;

import br.com.italooliveira.mscartoes.api.responses.CartaoResponse;
import br.com.italooliveira.mscartoes.api.requests.CartaoSaveRequest;
import br.com.italooliveira.mscartoes.api.responses.CartoesPorClienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cartoes")
public interface CartoesController {

    @GetMapping
    ResponseEntity<String> status();

    @PostMapping
    ResponseEntity<Void> save(@RequestBody CartaoSaveRequest request);

    @GetMapping(params = "renda")
    ResponseEntity<List<CartaoResponse>> obterCartoesRendaAte(@RequestParam Long renda);

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartoesPorClienteResponse>> obterCartoesPorCliente(@RequestParam String cpf);
}
