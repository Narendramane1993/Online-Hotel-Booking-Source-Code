package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends BaseEntity{
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	public Admin() {
		this.firstName = null;
		this.lastName  = null;
		this.email     = null;
		this.password  = null;
	}

	public Admin(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.email     = email;
		this.password  = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
