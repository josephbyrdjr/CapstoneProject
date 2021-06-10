package com.hcl.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@Table(name="users")
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "id")
	private long id;
	private String username;
	private String password;
	private boolean enabled;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Authorities authorities = new Authorities();

	public User(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		enabled = true;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", username=" + username + ", pwd=" + password + "]";
	}

	
}
