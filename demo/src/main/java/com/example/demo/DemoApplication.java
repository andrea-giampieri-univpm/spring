package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.utils.Config;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	
	public static void main(String[] args) {
		
		//Prendo la configurazione indispensabile per il funzionamento da config.json
		Config.initialize();
		
		//avvio app spring
		SpringApplication.run(DemoApplication.class, args);

		/*
		 * ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		 * System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}*/
	}


	

}
