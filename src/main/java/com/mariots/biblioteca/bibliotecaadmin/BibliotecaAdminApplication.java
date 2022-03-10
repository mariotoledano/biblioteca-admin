package com.mariots.biblioteca.bibliotecaadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"model", "repository", "service", "controller"})
@EnableJpaRepositories("repository")
@SpringBootApplication
public class BibliotecaAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaAdminApplication.class, args);
		System.out.println("Inicio de la aplicación 2");
	}

}
