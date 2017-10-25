package com.pubmine.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubmine.model.Abstract;
import com.pubmine.repository.AbstractRepository;

@RestController
@RequestMapping("/pubmine/v1")
public class AbstractRestController {

	private AbstractRepository repo;
	
	public AbstractRestController(AbstractRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/abstract/{pmid}")
	public List<Abstract> findOne(@PathVariable Integer pmid){
		return repo.findOne(pmid);
	}
	
}
