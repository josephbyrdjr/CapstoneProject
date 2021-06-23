package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
//    @Query(value = "select * from items where description = ? or name = ? or genre = ?;")
//    Set<Item> searchAllItems(String search);

    Item getItemByName(String name);
}
