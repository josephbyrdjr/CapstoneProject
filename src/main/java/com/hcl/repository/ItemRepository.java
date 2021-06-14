package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	

}
