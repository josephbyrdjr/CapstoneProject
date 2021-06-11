package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Authorities;

public interface AuthRepository extends JpaRepository <Authorities, Long>{
	
	

}
