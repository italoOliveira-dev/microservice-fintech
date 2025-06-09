package br.com.italooliveira.mscliente.application;

import br.com.italooliveira.mscliente.api.dto.ClienteResponse;
import br.com.italooliveira.mscliente.api.dto.ClienteSaveRequest;
import br.com.italooliveira.mscliente.api.mappers.ClienteMapper;
import br.com.italooliveira.mscliente.domain.Cliente;
import br.com.italooliveira.mscliente.infra.exceptions.ClienteNotFoundException;
import br.com.italooliveira.mscliente.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    @Transactional
    public ClienteResponse save(ClienteSaveRequest cliente) {
        Cliente clienteSalvo = clienteRepository.save(mapper.toEntity(cliente));
        return mapper.fromEntity(clienteSalvo);
    }

    @Transactional(readOnly = true)
    public ClienteResponse getByCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException(String.format("Cliente com CPF: %s não encontrado", cpf)));

        return mapper.fromEntity(cliente);
    }
}
