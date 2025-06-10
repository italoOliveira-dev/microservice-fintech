package br.com.italooliveira.mscartoes.api.controller.impl;

import br.com.italooliveira.mscartoes.api.controller.CartoesController;
import br.com.italooliveira.mscartoes.api.responses.CartaoResponse;
import br.com.italooliveira.mscartoes.api.requests.CartaoSaveRequest;
import br.com.italooliveira.mscartoes.api.responses.CartoesPorClienteResponse;
import br.com.italooliveira.mscartoes.service.CartaoService;
import br.com.italooliveira.mscartoes.service.ClienteCartoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartoesControllerImpl implements CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartoesService clienteCartoesService;

    @Override
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("OK");
    }

    @Override
    public ResponseEntity<Void> save(CartaoSaveRequest request) {
        cartaoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<CartaoResponse>> obterCartoesRendaAte(Long renda) {

        return ResponseEntity.ok(cartaoService.getCartoesRendaMenorIgual(renda));
    }

    @Override
    public ResponseEntity<List<CartoesPorClienteResponse>> obterCartoesPorCliente(String cpf) {

        return ResponseEntity.ok(clienteCartoesService.findByCpf(cpf));
    }
}
