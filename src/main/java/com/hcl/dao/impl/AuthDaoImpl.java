package com.hcl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.AuthDao;
import com.hcl.model.Authorities;
import com.hcl.repository.AuthRepository;

@Repository
public class AuthDaoImpl implements AuthDao{

	@Autowired
	private AuthRepository repo;
	
	public void insertAuth(Authorities auth) {
		repo.save(auth);
	}
	
    public void insertAuths(List<Authorities> auths) {
    	repo.saveAll(auths);
    }
    
    public List<Authorities> getAllAuths() {
    	return repo.findAll();
    }
    
    public Authorities findById(long id) {
    	return repo.findById(id).orElse(null);
    	
    }

}
