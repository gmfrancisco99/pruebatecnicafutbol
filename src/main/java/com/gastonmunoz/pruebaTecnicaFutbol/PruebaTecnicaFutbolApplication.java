package com.gastonmunoz.pruebaTecnicaFutbol;

import org.springdoc.core.configuration.SpringDocDataRestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringDocDataRestConfiguration.class)
public class PruebaTecnicaFutbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaFutbolApplication.class, args);
	}

}
