package com.examPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.examPortal.*" })
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class SpringBootApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new com.examPortal.config.ErrorConfig();
	}

}