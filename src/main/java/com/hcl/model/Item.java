package com.hcl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name="items")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double price;
	private String name;
	private String thumbnail;
	private String category;
	private String description;
	private long inventoryLeft;

	//Allows for auto-generated id's
	public Item(double price, String name, String thumbnail, String category, String description, long inventoryLeft) {
		this.price = price;
		this.name = name;
		this.thumbnail = thumbnail;
		this.category = category;
		this.description = description;
		this.inventoryLeft = inventoryLeft;
	}
}
