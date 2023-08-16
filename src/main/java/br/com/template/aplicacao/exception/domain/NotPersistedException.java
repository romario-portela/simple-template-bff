package br.com.template.aplicacao.exception.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotPersistedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;

    private final String message;

    public NotPersistedException() {
        this.code = HttpStatus.UNPROCESSABLE_ENTITY.toString();
        this.message = "Não processado";
    }

    public NotPersistedException(String message) {
        this.code = HttpStatus.UNPROCESSABLE_ENTITY.toString();
        this.message = message;
    }
}
