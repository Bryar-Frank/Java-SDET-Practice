package com.skillstorm.spring_data_jpa;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.skillstorm.spring_data_jpa.repositories.MovieRepository;

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
