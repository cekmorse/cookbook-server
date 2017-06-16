package com.github.cekmorse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableSpringDataWebSupport
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
