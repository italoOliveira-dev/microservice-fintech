package br.com.italooliveira.mscliente.infra.repository;

import br.com.italooliveira.mscliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}
