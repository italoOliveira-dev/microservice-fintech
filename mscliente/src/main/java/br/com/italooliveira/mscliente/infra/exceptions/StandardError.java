package br.com.italooliveira.mscliente.infra.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public class StandardError {

    private String path;
    private Integer status;
    private String error;
    private String message;
    private Instant timestamp;
}
