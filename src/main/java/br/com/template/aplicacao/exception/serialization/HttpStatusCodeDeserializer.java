package br.com.template.aplicacao.exception.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class HttpStatusCodeDeserializer extends JsonDeserializer<HttpStatus> {

    public HttpStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return HttpStatus.valueOf(Integer.parseInt(p.getText()));
    }
}