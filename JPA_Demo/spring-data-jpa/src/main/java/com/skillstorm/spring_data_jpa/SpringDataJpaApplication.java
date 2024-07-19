package com.skillstorm.spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner(MovieRepository repo) {
	// 	return (args) -> {
	// 		System.out.println(repo.findById(1));
	// 	};
	// }

}
