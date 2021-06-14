package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.AuthDao;
import com.hcl.model.Authorities;
import com.hcl.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	AuthDao authDao;
	
	public void insertAuth(Authorities auth) {
		authDao.insertAuth(auth);
	}
    public void insertAuths(List<Authorities> auths) {
    	authDao.insertAuths(auths);
    }
    public List<Authorities> getAllAuths() {
    	return authDao.getAllAuths();
    }
    
    public Authorities findById(long id) {
		System.out.println("in auth service");
    	return authDao.findById(id);
    }

	public void deleteById(long id){
		authDao.deleteById(id);
	}
}
