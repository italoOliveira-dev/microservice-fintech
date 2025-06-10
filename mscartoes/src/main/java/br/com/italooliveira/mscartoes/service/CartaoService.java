package br.com.italooliveira.mscartoes.service;

import br.com.italooliveira.mscartoes.api.responses.CartaoResponse;
import br.com.italooliveira.mscartoes.api.requests.CartaoSaveRequest;
import br.com.italooliveira.mscartoes.api.mappers.CartaoMapper;
import br.com.italooliveira.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final CartaoMapper mapper;

    @Transactional
    public void save(CartaoSaveRequest request) {
        cartaoRepository.save(mapper.toEntity(request));
    }

    @Transactional(readOnly = true)
    public List<CartaoResponse> getCartoesRendaMenorIgual(Long renda) {
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal).stream().map((mapper::fromEntity)).toList();
    }
}
