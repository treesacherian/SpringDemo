package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Family;

@RestController
public class FamilyController {
	private List<Family> families = new ArrayList<>();

	@GetMapping("/get")

	public List<Family> getFamily() {
		return families;
	}

	@PostMapping("/create")
	public ResponseEntity<Family> createFamily(@RequestBody Family family) {
		this.families.add(family);
		Family newFamily = this.families.get(this.families.size() - 1);
		return new ResponseEntity<>(newFamily, HttpStatus.CREATED);
//		return this.families.get(this.families.size() - 1);
	}

//	public Family createFamily(@RequestBody Family newFamily) {
//		this.families.add(newFamily);
//		return this.families.get(this.families.size() - 1);
//	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Family> getFamily(@PathVariable int id) {
		if (id < 0 || id >= this.families.size())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Family member = this.families.get(id);
//		return ResponseEntity.ok(member);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Family> updateFamily(@PathVariable int id, @RequestBody Family family) {
		if (id < 0 || id >= this.families.size())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		families.set(id, family);
		Family member = this.families.get(id);
		return new ResponseEntity<>(member, HttpStatus.OK);

	}

//	public String updateFamily(@PathVariable int id, @RequestBody Family family) {
//		families.set(id, family);
//		return families.toString();
//
//	}

//	public Family updateFamily(@PathVariable int id, @RequestBody Family family) {
//		return this.families.set(id,family);
//		
//	}

//	public String updateFamily(@PathVariable int id, @RequestBody String prof) {
//		this.families.get(id).setProfession(prof);
//		return families.toString();
//	}

//	

	@DeleteMapping("/delete/{id}")

	public String deleteFamily(@PathVariable int id) {

		this.families.remove(id);
		return families.toString();
	}
}
