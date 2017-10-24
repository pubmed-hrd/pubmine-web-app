package com.pubmine.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubmine.model.Sentence;
import com.pubmine.model.SentenceFilter;
import com.pubmine.service.SentenceService;
import com.pubmine.ultility.Pagable;
import com.pubmine.ultility.response.PagableResponse;

@RestController
@RequestMapping("/pubmine/v1")
public class SentenceRestController {
	
	private SentenceService sentenceService;
	
	@Autowired
	public SentenceRestController(SentenceService sentenceService) {
		this.sentenceService = sentenceService;
	}
	
	@GetMapping("/sentence")
	public PagableResponse findAll(Pagable pagable, SentenceFilter filter){
		
		System.out.println(String.format("%s, %s", pagable, filter));
		List<Sentence> sentences = sentenceService.search(filter.getQuery(), pagable);
		
		return new PagableResponse(sentences, pagable);
	}
	
}
