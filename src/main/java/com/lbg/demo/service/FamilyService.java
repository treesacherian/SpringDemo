package com.lbg.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Family;

@Service
public class FamilyService {
	private List<Family> families = new ArrayList<>();

	public List<Family> getFamily() {
		return families;
	}

	public ResponseEntity<Family> createFamily(Family family) {
		this.families.add(family);
		Family newFamily = this.families.get(this.families.size() - 1);
		return new ResponseEntity<>(newFamily, HttpStatus.CREATED);
	}

	public ResponseEntity<Family> getFamily(int id) {
		if (id < 0 || id >= this.families.size())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Family member = this.families.get(id);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	public ResponseEntity<Family> updateFamily(int id, Family family) {
		if (id < 0 || id >= this.families.size())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		families.set(id, family);
		Family member = this.families.get(id);
		return new ResponseEntity<>(member, HttpStatus.OK);

	}

	public String deleteFamily(int id) {

		this.families.remove(id);
		return families.toString();
	}
}
