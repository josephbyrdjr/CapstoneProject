package com.hcl.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;


@Entity
@Data
@Table(name="users")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany
	@JoinTable( name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authorities_id"))
	Set<Authorities> auths; 
	
	
}
