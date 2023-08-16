package br.com.template.aplicacao.v1.example.service;


import br.com.template.aplicacao.v1.example.model.forfrontend.response.ExampleDTO;
import br.com.template.aplicacao.v1.example.model.forfrontend.request.ExampleRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


public interface ExampleService {

    @Retryable(
            retryFor = ConnectTimeoutException.class,
            maxAttemptsExpression  = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}")
    )
    List<ExampleDTO> listAll();

    @Retryable(
            retryFor = ConnectTimeoutException.class,
            maxAttemptsExpression  = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}")
    )
    ExampleDTO findById(Long id);

    @Retryable(
            retryFor = ConnectTimeoutException.class,
            maxAttemptsExpression  = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}")
    )
    ExampleDTO save(ExampleRequest exampleRequest);

    @Retryable(
            retryFor = ConnectTimeoutException.class,
            maxAttemptsExpression  = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}")
    )
    ExampleDTO update(ExampleRequest exampleRequest);

    @Retryable(
            retryFor = ConnectTimeoutException.class,
            maxAttemptsExpression  = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}")
    )
    void deleteById(Long id);

}
