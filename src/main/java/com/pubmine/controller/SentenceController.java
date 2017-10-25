package com.pubmine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SentenceController {

	@GetMapping("/pmid/{pmid}")
	public String sentenceDetail(Model model, @PathVariable Integer pmid){
		model.addAttribute("pmid", pmid);
		return "abstract";
	}
	
}
