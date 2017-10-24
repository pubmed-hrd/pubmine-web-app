package com.pubmine;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pubmine.model.Sentence;
import com.pubmine.service.SentenceService;
import com.pubmine.ultility.Pagable;

@SpringBootApplication
public class PubmedWebAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PubmedWebAppApplication.class, args);
		
		SentenceService s = context.getBean(SentenceService.class);
		Pagable p = new Pagable();
		p.setPage(1125);
		p.setLimit(10);
		
		List<Sentence> se = s.search("the most", p);
		System.out.println(p);
		se.forEach(System.out::println);
		
	}
}
 