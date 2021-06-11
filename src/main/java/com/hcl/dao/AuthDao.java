package com.hcl.dao;

import java.util.List;

import com.hcl.model.Authorities;

public interface AuthDao {
	
	void insertAuth(Authorities auth);
    void insertAuths(List<Authorities> auths);
    List<Authorities> getAllAuths();
    Authorities findById(long id);
}
