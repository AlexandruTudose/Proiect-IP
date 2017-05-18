package com.fiivirtualcatalog.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class FiiVirtualCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiiVirtualCatalogApplication.class, args);
	}
}
