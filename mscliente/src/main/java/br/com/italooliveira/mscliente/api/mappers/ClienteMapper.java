package br.com.italooliveira.mscliente.api.mappers;

import br.com.italooliveira.mscliente.api.dto.ClienteResponse;
import br.com.italooliveira.mscliente.api.dto.ClienteSaveRequest;
import br.com.italooliveira.mscliente.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public Cliente toEntity(ClienteSaveRequest cliente) {
        return new Cliente(cliente.nome(), cliente.cpf(), cliente.idade());
    }

    public ClienteResponse fromEntity(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getIdade());
    }

}
