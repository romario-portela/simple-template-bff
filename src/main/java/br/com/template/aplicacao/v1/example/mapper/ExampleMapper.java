package br.com.template.aplicacao.v1.example.mapper;


import br.com.template.aplicacao.v1.example.model.externalapi.ExampleResponse;
import br.com.template.aplicacao.v1.example.model.forfrontend.response.ExampleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExampleMapper {

    ExampleMapper MAPPER = Mappers.getMapper(ExampleMapper.class);

    List<ExampleDTO> toListExampleDTO(List<ExampleResponse> merchant);

    @Mapping(target = "exampleDescription", source = "description")
    ExampleDTO toExampleDTO(ExampleResponse exampleResponse);
}
