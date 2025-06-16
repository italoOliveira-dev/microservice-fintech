package br.com.italooliveira.msavaliadorcredito.api.exceptions;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenericFeignException extends RuntimeException {

    private Integer status;
    private Map error;
}
