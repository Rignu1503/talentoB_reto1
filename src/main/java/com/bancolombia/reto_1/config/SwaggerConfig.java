package com.bancolombia.reto_1.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = " Rigoberto de Jesus Miranda Nuñez ",
                        url = "",
                        email = "rigoberto.miranda1503@gmail.com "),
                license = @License(name = "fleetnav", url = "https://github.com/fleetnav/fleetNav-microservices  LICENSE"),
                title = "Documentación: Reto 1: Talento B",
                version = "1.0",
                description = "The fleetNav API documentation provides detailed information on the endpoints available to interact with the fleet management platform. Use this API to integrate vehicle tracking, route management and data analysis functionalities into your own application. The fleetNav API provides a RESTful interface that allows you to access and manipulate fleet management related data efficiently and securely."))
public class SwaggerConfig {
    
}
