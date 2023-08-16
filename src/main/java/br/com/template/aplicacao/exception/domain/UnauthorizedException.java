package br.com.template.aplicacao.exception.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnauthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;

    private final String message;

    public UnauthorizedException() {
        this.code = HttpStatus.UNAUTHORIZED.toString();
        this.message = "Não autorizado. Negócio";
    }

    public UnauthorizedException(String message) {
        this.code = HttpStatus.UNAUTHORIZED.toString();
        this.message = message;
    }
}
