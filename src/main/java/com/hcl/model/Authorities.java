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
public class Authorities {

	@Id 
	private long id;
	private String authority;
	
//	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "auths")
//	@JsonIgnore
//	Set<User> users = new HashSet<>();

//	public void addUser(User user){
//		users.add(user);
//	}
}
