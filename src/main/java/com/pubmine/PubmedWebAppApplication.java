package com.pubmine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PubmedWebAppApplication {

	public static void main(String[] args) {
		/*ApplicationContext context = */SpringApplication.run(PubmedWebAppApplication.class, args);
		/*
		AbstractRepository repo = context.getBean(AbstractRepository.class);
		repo.findOne(1279184).forEach(System.out::println);
		*/
	}
}
 