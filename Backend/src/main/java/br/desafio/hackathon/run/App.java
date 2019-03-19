package br.desafio.hackathon.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages= {"br.desafio.hackathon.model"})
@ComponentScan(basePackages= {"br.**"})
@EnableJpaRepositories(basePackages= {"br.desafio.hackathon.repository"})
@EnableTransactionManagement
@EnableWebMvc
@EnableAutoConfiguration
public class App  extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	
	}
	
}
