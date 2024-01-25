package com.lbg.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Family;

public interface FamilyRepo extends JpaRepository<Family, Integer> {

}
