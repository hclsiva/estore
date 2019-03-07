package com.app.estore.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.app.estore.controller",
                "com.app.estore.framework.cache",
                "com.app.estore.framework.services.api",
                "com.app.estore.framework.services.impl",                
                "com.app.estore.framework.cache"})
@EntityScan({"com.app.estore.framework.model"}) 
@EnableJpaRepositories({"com.app.estore.framework.repo"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreApplication.class, args);
	}

}
