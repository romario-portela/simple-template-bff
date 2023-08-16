package br.com.template.aplicacao.security.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SecurityScheme(
        name = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class SpringDocConfiguration {

    @Autowired
    BuildProperties buildProperties;


    @Bean
    public GroupedOpenApi publicApiV1() {
        return GroupedOpenApi.builder()
                .packagesToScan("br.com.template.aplicacao.v1")
                .group("v1")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {

        Server s = new Server().url("localhost:9091");

        return new OpenAPI().addServersItem(s)
                .info(new Info().title(buildProperties.getName())
                        .version(buildProperties.getVersion())
                        .description("BFF"));
    }
}
