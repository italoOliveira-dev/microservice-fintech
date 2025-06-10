package br.com.italooliveira.mscartoes.service;

import br.com.italooliveira.mscartoes.api.mappers.ClienteCartaoMapper;
import br.com.italooliveira.mscartoes.api.responses.CartoesPorClienteResponse;
import br.com.italooliveira.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartoesService {

    private final ClienteCartaoRepository clienteCartaoRepository;
    private final ClienteCartaoMapper mapper;

    public List<CartoesPorClienteResponse> findByCpf(String cpf) {
        return clienteCartaoRepository.findByCpf(cpf).stream().map(mapper::fromEntity).toList();
    }
}
