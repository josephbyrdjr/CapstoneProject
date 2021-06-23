package com.hcl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.AuthDao;
import com.hcl.model.Authority;
import com.hcl.repository.AuthRepository;

@Repository
public class AuthDaoImpl implements AuthDao{

	@Autowired
	private AuthRepository authRepo;
	
	public void insertAuth(Authority auth) {
		authRepo.save(auth);
	}
    
    public List<Authority> getAllAuths() {
    	return authRepo.findAll();
    }
    
    public Authority findById(long id) {
    	return authRepo.findById(id).orElse(null);
    }

	public void deleteById(long id){
		authRepo.deleteById(id);
	}

	public void updateAuth(Authority auth){
		authRepo.save(auth);
	}
}
