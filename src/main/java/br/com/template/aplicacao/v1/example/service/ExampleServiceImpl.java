package br.com.template.aplicacao.v1.example.service;

import br.com.template.aplicacao.v1.example.client.ExampleClient;
import br.com.template.aplicacao.v1.example.mapper.ExampleMapper;
import br.com.template.aplicacao.v1.example.model.forfrontend.response.ExampleDTO;
import br.com.template.aplicacao.v1.example.model.forfrontend.request.ExampleRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleClient client;

    public ExampleServiceImpl(ExampleClient client) {
        this.client = client;
    }
    
    @Override
    public List<ExampleDTO> listAll() {
        return ExampleMapper
                .MAPPER
                .toListExampleDTO( client.listAll() );
    }

    @Override
    public ExampleDTO findById(Long id) {
        return ExampleMapper
                .MAPPER
                .toExampleDTO( client.findById(id) );
    }

    @Override
    public ExampleDTO save(ExampleRequest exampleRequest) {
        return ExampleMapper
                .MAPPER
                .toExampleDTO( client.save(exampleRequest) );
    }

    @Override
    public ExampleDTO update(ExampleRequest exampleRequest) {
        return ExampleMapper
                .MAPPER
                .toExampleDTO( client.update(exampleRequest) );
    }

    @Override
    public void deleteById(Long id) {
        client.deleteById(id);
    }

}
