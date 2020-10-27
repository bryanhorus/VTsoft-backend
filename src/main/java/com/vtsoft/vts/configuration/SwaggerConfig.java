package com.vtsoft.vts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vtsoft.vts"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata())
                .tags(new Tag("Authorization Rest API", "Defines endpoints that can be hit only when the user is not logged in. It's not secured by default."),
                        new Tag("User Rest API", "Defines endpoints for the logged in user. It's secured by default."));
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("VTApp API")
                .description("VTsoft Solutions")
                .version("1.0-SNAPSHOT")
                .license("VTApp License").licenseUrl("http://VTApp.com")//
                .contact(new Contact(null, null, "VTsolutions.sas@gmail.com"))
                .build();
    }

}
