package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

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

	public Family createFamily(@RequestBody Family newFamily) {
		this.families.add(newFamily);
//		return newFamily.toString();
//		to use the above return statem,ent, the return type should be String
		return families.get(this.families.size() - 1);
	}

	@GetMapping("/get/{id}")
	public Family getFamily(@PathVariable int id) {
		return this.families.get(id);
	}

	@PutMapping("/update/{id}")

	public String updateFamily(@PathVariable int id, @RequestBody Family family) {
		families.set(id, family);
		return families.toString();
	}

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
