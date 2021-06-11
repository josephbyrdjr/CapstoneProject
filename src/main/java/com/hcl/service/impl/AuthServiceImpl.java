package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.AuthDao;
import com.hcl.model.Authorities;

@Service
public class AuthServiceImpl {
	
	@Autowired
	AuthDao authDao;
	
	void insertAuth(Authorities auth) {
		authDao.insertAuth(auth);
	}
    void insertAuths(List<Authorities> auths) {
    	authDao.insertAuths(auths);
    }
    List<Authorities> getAllAuths() {
    	return authDao.getAllAuths();
    }
    
}
