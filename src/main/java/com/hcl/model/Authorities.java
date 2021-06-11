package com.hcl.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@Table(name="authorities")
public class Authorities {

	@Id 
	private long id;
	private String authority;
	
	@ManyToMany(mappedBy = "auths")
	Set<User> users;
}
