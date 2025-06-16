package br.com.italooliveira.msavaliadorcredito.infra.config;

import br.com.italooliveira.msavaliadorcredito.infra.decoders.RetrieveMessageErroDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder  errorDecoder() {
        return new RetrieveMessageErroDecoder();
    }
}
