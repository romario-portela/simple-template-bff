package br.com.template.aplicacao.exception.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;

    private final String message;

    public NotFoundException() {
        this.code = String.valueOf(HttpStatus.NOT_FOUND.value());
        this.message = HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    public NotFoundException(String message) {
        this.code = String.valueOf(HttpStatus.NOT_FOUND.value());
        this.message = message;
    }
}
