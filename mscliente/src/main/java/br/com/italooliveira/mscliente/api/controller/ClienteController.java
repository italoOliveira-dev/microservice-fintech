package br.com.italooliveira.mscliente.api.controller;

import br.com.italooliveira.mscliente.api.dto.ClienteResponse;
import br.com.italooliveira.mscliente.api.dto.ClienteSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clientes")
public interface ClienteController {

    @GetMapping
    ResponseEntity<String> status();

    @PostMapping
    ResponseEntity<Void> save(@RequestBody ClienteSaveRequest request);

    @GetMapping(params = "cpf")
    ResponseEntity<ClienteResponse> dadosCliente(@RequestParam("cpf") String cpf);
}
