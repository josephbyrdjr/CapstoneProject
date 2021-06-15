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
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled;
	
	//personal info
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String apartmentNumber;
	private String city;
	private String state;
	private String zip;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable( name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authorities_id"))
	Set<Authorities> auths = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	Set<Order> orders = new HashSet<>();
	
	public void addAuth(Authorities auth){
		auths.add(auth);
	}
}
