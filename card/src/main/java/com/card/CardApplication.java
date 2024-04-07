package com.card;

import com.card.Dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(

		info=@Info(title = "Cards Microservices REST API Documentation",
		description = "Public Bank Cards REST API Doc",
		version = "V1",
		contact = @Contact(name = "Sandeep Kumar Verma",
		email = "sk9366026@gmail.com"),
		license = @License(name = "Apache 2.0")),
		externalDocs = @ExternalDocumentation(

				description = "Cards microservices REST API Documentations"
		)


)
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
