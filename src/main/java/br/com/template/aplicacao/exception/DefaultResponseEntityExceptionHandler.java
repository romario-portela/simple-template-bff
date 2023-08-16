package br.com.template.aplicacao.exception;

import br.com.template.aplicacao.exception.domain.*;
import br.com.template.aplicacao.v1.example.model.forfrontend.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class DefaultResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllException(Exception ex) {
        log.error(" HANDLING >> Generic exception", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        log.error(" HANDLING >> Method argument not valid exception", ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), getFieldErrorMessage(ex.getBindingResult().getFieldErrors()),
                        ex.toString()));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ExceptionResponse> handleWebExchangeBindException(WebExchangeBindException ex) {
        log.error(" HANDLING >> Web exchange method argument not valid exception", ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), getFieldErrorMessage(ex.getBindingResult().getFieldErrors()),
                        ex.toString()));
    }

    private String getFieldErrorMessage(List<FieldError> fieldErrors) {
        List<String> mensagens = new ArrayList<>();
        fieldErrors.forEach(e -> mensagens.add("Campo '" + e.getField() + "': "
                + messageSource.getMessage(e, LocaleContextHolder.getLocale())));

        return String.join("; ", mensagens);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex) {
        log.error(" HANDLING >> Business exception", ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(NotPersistedException.class)
    public ResponseEntity<ExceptionResponse> handleNotPersistedException(BusinessException ex) {
        log.error(" HANDLING >> Not Persisted exception", ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BusinessException ex) {
        log.error(" HANDLING >> Bad Request exception", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
        log.error(" HANDLING >> Not found exception", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.toString()));
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(UnauthorizedException ex) {
        log.error(" HANDLING >> Unauthorized exception", ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage(), ex.toString()));
    }


}
