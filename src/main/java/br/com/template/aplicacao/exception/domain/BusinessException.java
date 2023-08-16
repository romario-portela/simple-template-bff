package br.com.template.aplicacao.exception.domain;

import br.com.template.aplicacao.exception.configuration.ConstantsExceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
    private final String code;

    private final String message;

    public BusinessException() {
        this.code = ConstantsExceptions.EXCEPTION_CODE_BUSINESS;
        this.message = "Negado por regra de negócio";
    }

    public BusinessException(String message) {
        this.code = ConstantsExceptions.EXCEPTION_CODE_BUSINESS;
        this.message = message;
    }
}
