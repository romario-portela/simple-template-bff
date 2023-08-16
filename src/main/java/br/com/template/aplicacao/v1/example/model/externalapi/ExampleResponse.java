package br.com.template.aplicacao.v1.example.model.externalapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleResponse {

    private Long id;

    private String description;

    private Boolean active;

    private Integer limitUses;

    private LocalDateTime startDate;

    private Short discountType;

    private BigDecimal price;
}