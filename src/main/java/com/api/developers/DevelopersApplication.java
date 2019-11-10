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
			developerRepository.save(new Developer("Emiliano","Rago","Full Stack"));
			developerRepository.save(new Developer("Mario","Perez","BackEnd"));
		};
	}

}
