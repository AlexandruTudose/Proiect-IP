package com.fiivirtualcatalog.login;
import com.fiivirtualcatalog.login.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class FiiVirtualCatalogLogin {
    public static void main(String[] args) {
        SpringApplication.run(FiiVirtualCatalogLogin.class, args);
    }
}
