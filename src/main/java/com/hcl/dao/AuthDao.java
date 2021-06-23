package com.hcl.dao;

import java.util.List;

import com.hcl.model.Authority;

public interface AuthDao {
	
	void insertAuth(Authority auth);
    List<Authority> getAllAuths();
    Authority findById(long id);
    void deleteById(long id);
    void updateAuth(Authority auth);
}
