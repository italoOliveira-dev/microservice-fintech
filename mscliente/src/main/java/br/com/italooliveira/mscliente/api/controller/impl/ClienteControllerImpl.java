package br.com.italooliveira.mscliente.api.controller.impl;

import br.com.italooliveira.mscliente.api.controller.ClienteController;
import br.com.italooliveira.mscliente.api.dto.ClienteResponse;
import br.com.italooliveira.mscliente.api.dto.ClienteSaveRequest;
import br.com.italooliveira.mscliente.application.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body("OK");
    }

    @Override
    public ResponseEntity<Void> save(ClienteSaveRequest request) {
        ClienteResponse cliente = clienteService.save(request);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.cpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @Override
    public ResponseEntity<ClienteResponse> dadosCliente(String cpf) {
        ClienteResponse cliente = clienteService.getByCpf(cpf);
        return ResponseEntity.ok(cliente);
    }
}
