package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Family;
import com.lbg.demo.service.FamilyService;

@RestController
public class FamilyController {
	private FamilyService service;

	public FamilyController(FamilyService service) {
		super();
		this.service = service;
	}

	@GetMapping("/get")
	public List<Family> getFamily() {
		return this.service.getFamily();
	}

	@PostMapping("/create")
	public ResponseEntity<Family> createFamily(@RequestBody Family family) {
		return this.service.createFamily(family);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Family> getFamily(@PathVariable int id) {
		return this.service.getFamily(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Family> updateFamily(@PathVariable int id, @RequestBody Family family) {
		return this.service.updateFamily(id, family);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteFamily(@PathVariable int id) {

		return this.service.deleteFamily(id);
	}
}
