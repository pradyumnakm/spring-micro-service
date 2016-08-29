package com.prady.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServer {

	private static final Logger log = LoggerFactory.getLogger(UserServer.class);

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user-server");
		SpringApplication.run(UserServer.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Prady", "Mohanty"));
			repository.save(new User("Jaj", "Behera"));
			repository.save(new User("Sandy", "Biswal"));
			repository.save(new User("Deb", "Das"));
			//repository.save(new User("Sanat", "Mohanty"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
            User customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Behera'):");
			log.info("--------------------------------------------");
			for (User bauer : repository.findByLastName("Behera")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
	}

}
