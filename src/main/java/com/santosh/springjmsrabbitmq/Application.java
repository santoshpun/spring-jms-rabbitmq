package com.santosh.springjmsrabbitmq;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot RabbitMQ",
                version = "1.0",
                description = "Sample app for use of RabbitMQ in Spring Boot app")
)
@EnableAspectJAutoProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
