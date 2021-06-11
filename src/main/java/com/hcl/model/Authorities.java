package com.hcl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="authorities")
public class Authorities {

	@Id 
	private long id;
	private String authority;
	
	@ManyToMany(mappedBy = "auths")
	Set<User> users;
}
