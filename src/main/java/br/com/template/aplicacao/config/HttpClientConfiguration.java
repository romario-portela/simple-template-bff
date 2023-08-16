package br.com.template.aplicacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public RestOperations restTemplate() {
        RestTemplate restClient = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

            request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);

            return execution.execute(request, body);
        }));

        return restClient;
    }
}