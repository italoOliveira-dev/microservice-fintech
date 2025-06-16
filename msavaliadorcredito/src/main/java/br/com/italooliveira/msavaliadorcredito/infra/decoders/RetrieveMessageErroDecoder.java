package br.com.italooliveira.msavaliadorcredito.infra.decoders;

import br.com.italooliveira.msavaliadorcredito.api.exceptions.GenericFeignException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.InternalServerErrorException;

import java.io.InputStream;
import java.util.Map;

public class RetrieveMessageErroDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        try(InputStream bodyIs = response.body().asInputStream()) {

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            final var error = mapper.readValue(bodyIs, Map.class);
            final var status = (Integer) error.get("status");

            return new GenericFeignException(status, error);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error. Try again later.");
        }
    }
}
