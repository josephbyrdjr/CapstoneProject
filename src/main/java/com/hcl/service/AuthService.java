package com.hcl.service;

import java.util.List;

import com.hcl.model.Authorities;


public interface AuthService {

	void insertAuth(Authorities auth);
    void insertAuths(List<Authorities> auths);
    List<Authorities> getAllAuths();
    Authorities findById(long id);
    void deleteById(long id);
    
}
