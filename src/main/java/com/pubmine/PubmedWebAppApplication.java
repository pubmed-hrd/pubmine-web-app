package com.pubmine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pubmine.service.MeshKeywordService;

@SpringBootApplication
public class PubmedWebAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		/*ApplicationContext context = */SpringApplication.run(PubmedWebAppApplication.class, args);
		/*
		AbstractRepository repo = context.getBean(AbstractRepository.class);
		repo.findOne(1279184).forEach(System.out::println);
		*/
	}

	@Autowired
	MeshKeywordService meshService;
	
	@Override
	public void run(String... arg0) throws Exception {
		//meshService.meshSearchAndSave();
	}
	
}
 