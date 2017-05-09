package com.fiivirtualcatalog.login;
import com.fiivirtualcatalog.login.models.User;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan("com.fiivirtualcatalog.login")
public class FiiVirtualCatalogLogin {
    public static void main(String[] args) {

        SpringApplication.run(FiiVirtualCatalogLogin.class, args);
    }
}
