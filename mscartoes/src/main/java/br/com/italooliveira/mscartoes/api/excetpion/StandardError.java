package br.com.italooliveira.mscartoes.api.excetpion;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
@Getter
public class StandardError {

    private String path;
    private Integer statusCode;
    private String statusErro;
    private String message;
    private Instant timestamp;
}
