package com.lbg.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.Repos.FamilyRepo;
import com.lbg.demo.domain.Family;

@Service
public class FamilyService {
	private FamilyRepo repo;

	public FamilyService(FamilyRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Family> getFamily() {
		return this.repo.findAll();
	}

	public ResponseEntity<Family> getFamily(int id) {
		Optional<Family> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
		Family body = found.get();
		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Family> createFamily(Family family) {

		Family created = this.repo.save(family);
		return new ResponseEntity<Family>(created, HttpStatus.CREATED);
	}

	public ResponseEntity<Family> updateFamily(int id, Family family) {
		Optional<Family> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
		Family existing = found.get();
		if (family.getName() != null) {
			existing.setName(family.getName());
		}
		if (family.getProfession() != null) {
			existing.setProfession(family.getProfession());
		}
		if (family.getRelation() != null) {
			existing.setRelation(family.getRelation());
		}
		Family updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);

	}

	public boolean deleteFamily(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}
}
