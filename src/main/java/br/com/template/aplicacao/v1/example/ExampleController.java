package br.com.template.aplicacao.v1.example;

import br.com.template.aplicacao.exception.response.ErrorInfo;
import br.com.template.aplicacao.v1.example.model.externalapi.ExampleResponse;
import br.com.template.aplicacao.v1.example.model.forfrontend.response.ExampleDTO;
import br.com.template.aplicacao.v1.example.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/example")
@Api(tags = "Example Controller")
public class ExampleController {

    @Autowired
    private ExampleService service;

    @PostMapping
    @ApiOperation(code = 201, value = "Create a Example", produces = "application/json")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Example created successfully", response = ExampleResponse.class),
            @ApiResponse(code = 400, message = "Informed data are invalid", response = ErrorInfo.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorInfo.class)
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<List<ExampleDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

}
