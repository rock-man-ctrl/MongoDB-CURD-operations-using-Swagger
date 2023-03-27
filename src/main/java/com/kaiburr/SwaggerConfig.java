package com.kaiburr;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.kaiburr")).build().apiInfo(apiInfo());
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/v1.*"), regex("/*"));
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}

	/*
	 * private ApiInfo apiInfo() { return new ApiInfo( "My REST API", //title
	 * "Some custom description of API.", //description "Version 1.0", //version
	 * "Terms of service", //terms of service URL new
	 * Contact("Bhanuka Dissanayake", "www.example.com",
	 * "myeaddress@company.com"), "License of API", "API license URL",
	 * Collections.emptyList()); // contact info }
	 */

}
