package com.hcl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authorities")
public class Authority {

	@Id 
	private long id;
	private String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	
}
