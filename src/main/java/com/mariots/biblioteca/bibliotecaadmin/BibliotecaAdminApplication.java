package com.mariots.biblioteca.bibliotecaadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"model", "repository", "service", "controller"})
@EnableJpaRepositories("repository")
@SpringBootApplication
public class BibliotecaAdminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaAdminApplication.class, args);
		System.out.println("Inicio de la aplicación 2");
	}
	//Para arrancar con el war en apache tomcat not embebed
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BibliotecaAdminApplication.class);
	}
}
