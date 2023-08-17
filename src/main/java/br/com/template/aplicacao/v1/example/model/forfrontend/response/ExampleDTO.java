package br.com.template.aplicacao.v1.example.model.forfrontend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("exampleDescription")
    private String exampleDescription;
    @JsonProperty("active")
    private Boolean active;
}
