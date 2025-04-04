package com.platzi.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories //Habilita el uso de repositorios JPA en la app(para realizar consultas "prefabricadas" a la base de datos)
public class PlatziPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatziPizzeriaApplication.class, args);
	}

}
