//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.template.aplicacao.v1.example.model.forfrontend.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleRequest {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("limitUses")
    private Integer limitUses;
    @JsonProperty("startDate")
    private LocalDateTime startDate = null;
    @JsonProperty("discountType")
    private Short discountType = null;
    @JsonProperty("price")
    private BigDecimal price = null;

}
