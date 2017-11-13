package com.pubmine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pubmine.service.MeshKeywordService;

@RestController
public class MeshRestController {
	
	@Autowired
	private MeshKeywordService meshService;;
	
	@GetMapping("/api/save-mesh")
	public void searchAndSaveMesh(){
		meshService.meshSearchAndSave();
	}
	
}
