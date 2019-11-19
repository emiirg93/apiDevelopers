package com.api.developers;

import com.api.developers.model.Developer;
import com.api.developers.repository.DeveloperRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevelopersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopersApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(DeveloperRepository developerRepository) {
		return (args) -> {
			developerRepository.save(new Developer("Emiliano","Rago",(long)26,"fullstack","Le gusta aprender nuevas tecnologias."));
			developerRepository.save(new Developer("Martin","Zarate",(long)30,"backend","Proactivo , busca soluciones creativas para nuevos problemas."));
			developerRepository.save(new Developer("Gonzalo","Costa",(long)25,"frontend","Capacidad para trabajar en equipo."));
			developerRepository.save(new Developer("Roberto","Mendez",(long)22,"backend","Encuentra los problemas en el codigo con facilidad."));
		};
	}

}
