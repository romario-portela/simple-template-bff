package br.com.template.aplicacao.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

    private String id;
    private String errorCode;
    private String issueText;
}
