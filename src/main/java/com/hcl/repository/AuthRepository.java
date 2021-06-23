package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Authority;

public interface AuthRepository extends JpaRepository <Authority, Long>{
}
