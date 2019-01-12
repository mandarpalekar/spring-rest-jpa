package com.example.demo.springrestjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringRestJPAApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJPAApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringRestJPAApplication.class);
    }

	/*
	 * @Bean CommandLineRunner runner(CustomerService customerService){ return args
	 * -> { customerService.createNewCustomer(new Customer(2L, new Name("Sagar",
	 * "Suresh", "Palekar"), "SP", "Mr.", new Address("36", "Romsey Street",
	 * "Waitara", "NSW", "Australia", "2270"), "Male", "Married", 55L, true)); }; }
	 */

}
