package com.hcl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable( name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authorities_id"))
	Set<Authority> auths = new HashSet<>();
	
	@OneToMany(mappedBy = "user",  fetch=FetchType.LAZY)
	@JsonBackReference
	Set<Order> orders = new HashSet<>();
	
	public void addAuth(Authority auth){
		auths.add(auth);
	}

	public void addOrder(Order order){
		orders.add(order);
	}

	public User(String username, String pwd, boolean enabled, String firstName, String lastName, String email,
			String phoneNumber, String address, String apartmentNumber, String city, String state, String zip) {
		this.username = username;
		this.password = pwd;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//Constructor to make JUnit testing a lot easier
		public User(long id, String username, String firstName, String lastName) {
			this.id = id;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
		}
	
	
}
