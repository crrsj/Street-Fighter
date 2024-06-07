package br.com.api.sf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API-Street Fighter",
			version = "1.0",
			description = "Documentando uma API com o tema:Street Fighter",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class StreetFighterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreetFighterApplication.class, args);
	}

}
