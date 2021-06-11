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
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable( name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authorities_id"))
	Set<Authorities> auths; 
	
	
}
