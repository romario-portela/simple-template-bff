package br.com.template.aplicacao.exception.util;

import br.com.template.aplicacao.exception.constants.ExceptionConstants;
import br.com.template.aplicacao.exception.errortype.GenericException;
import br.com.template.aplicacao.exception.response.ErrorInfo;
import br.com.template.aplicacao.exception.response.ErrorSpec;
import br.com.template.aplicacao.exception.response.Issue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

    public static GenericException buildGenericException(@NonNull HttpStatus status, String message,
                                                         String suggestedUserAction,
                                                         String suggestedApplicationAction) {

        var msgSugestaoAcaoUsuario = MessageResource.getInstance()
                .getMessage(ExceptionConstants.MessageConstants.EXAMPLE_MESSAGE);

        var msgSugestaoAcaoAplicacao = MessageResource.getInstance()
                .getMessage(ExceptionConstants.MessageConstants.EXAMPLE_MESSAGE);

        return GenericException.builder()
                .status(status)
                .errorInfo(ErrorInfo.builder()
                        .errors(List.of(ErrorSpec.builder()
                                .suggestedUserActions(List.of(Objects.isNull(suggestedUserAction) ? msgSugestaoAcaoUsuario : suggestedUserAction))
                                .suggestedApplicationActions(List.of(Objects.isNull(suggestedApplicationAction) ? msgSugestaoAcaoAplicacao : suggestedApplicationAction))
                                .name(status.name())
                                .message(message)
                                .issues(List.of(Issue.builder()
                                        .issueText(message)
                                        .build()))
                                .httpStatusCodes(List.of(status))
                                .build()))
                        .build())
                .build();
    }

    public static GenericException buildBadRequestException(String message) {
        return buildGenericException(HttpStatus.BAD_REQUEST, message, null, null);
    }

    public static GenericException buildNotFoundException(String message) {
        return buildGenericException(HttpStatus.BAD_REQUEST, message, null, null);
    }

    public static GenericException buildNotPersistedException(String message) {
        return buildGenericException(HttpStatus.BAD_REQUEST, message, null, null);
    }
}
