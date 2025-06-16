package br.com.italooliveira.msavaliadorcredito.infra.clients;

import br.com.italooliveira.msavaliadorcredito.api.dtos.Cartao;
import br.com.italooliveira.msavaliadorcredito.api.dtos.CartaoCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "mscartoes",
        path = "/cartoes"
)
public interface CartoesResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCliente>> obterCartoesPorCliente(@RequestParam String cpf);

    @GetMapping(params = "renda")
    ResponseEntity<List<Cartao>> obterCartoesRendaAte(@RequestParam Long renda);
}
