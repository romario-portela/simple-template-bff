package br.com.template.aplicacao.v1.example.client;

import br.com.template.aplicacao.v1.example.model.externalapi.ExampleResponse;
import br.com.template.aplicacao.v1.example.model.forfrontend.request.ExampleRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(value = "example", url = "${external.api.example.uri}")
public interface ExampleClient {

    @GetMapping("v1/example")
    List<ExampleResponse> listAll();

    @GetMapping("v1/example/{id}")
    ExampleResponse findById(Long id);

    @PostMapping("v1/example/")
    ExampleResponse save(ExampleRequest exampleRequest);

    @PutMapping("v1/example/")
    ExampleResponse update(ExampleRequest exampleRequest);

    @DeleteMapping("v1/example/{id}")
    void deleteById(Long id);
}
