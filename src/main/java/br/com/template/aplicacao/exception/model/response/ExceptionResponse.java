package br.com.template.aplicacao.exception.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private String httpCode;

    private String message;

    private String detail;
}
