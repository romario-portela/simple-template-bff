package br.com.template.aplicacao.exception.errortype;

import br.com.template.aplicacao.exception.response.ErrorInfo;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericException extends RuntimeException {

    private ErrorInfo errorInfo;

    private HttpStatus status;
}