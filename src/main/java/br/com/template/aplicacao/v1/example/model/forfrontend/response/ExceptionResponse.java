//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.template.aplicacao.v1.example.model.forfrontend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    @JsonProperty("httpCode")
    private String httpCode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("detail")
    private String detail;
}
