package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.AuthDao;
import com.hcl.model.Authority;
import com.hcl.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	AuthDao authDao;
	
	public void insertAuth(Authority auth) {
		authDao.insertAuth(auth);
	}

    public List<Authority> getAllAuths() {
    	return authDao.getAllAuths();
    }
    
    public Authority findById(long id) {
		System.out.println("in auth service");
    	return authDao.findById(id);
    }

	public void deleteById(long id){
		authDao.deleteById(id);
	}

	public void updateAuth(Authority auth){
		authDao.updateAuth(auth);
	}
}
