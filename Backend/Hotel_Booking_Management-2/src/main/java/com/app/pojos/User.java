package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "user")
@Proxy(lazy = false)
public class User extends BaseEntity{
	
	@Column(name = "firstname", length = 20)
	
	private String firstname;
	
	@Column(name = "lastname", length = 20)
	
	private String lastname;
	
	@Column(length = 50)
	private String address;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 20)
	//@JsonProperty("mobilenumber")
	private String mobilenumber;
	
	//@Column(name = "birth_date")
	//private Date birthdate;
	
	@Column(name = "primemember")
	private int primeMember;
	
	public User() {
		this.firstname    = null;
		this.lastname     = null;
		this.address      = null;
		this.email        = null;
		this.password     = null;
		this.mobilenumber = null;
		//this.birthdate    = null;
		this.primeMember  = 0;
	}

	public User(String firstName, String lastName, String address, String email, String password, String mobileNumber) {

		this.firstname    = firstName;
		this.lastname     = lastName;
		this.address      = address;
		this.email        = email;
		this.password     = password;
		this.mobilenumber = mobileNumber;
		//this.birthdate    = birthDate;
		this.primeMember  = 0;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobileNumber) {
		this.mobilenumber = mobileNumber;
	}

	//public Date getBirthDate() {
		//return birthdate;
	//}

	//public void setBirthDate(Date birthDate) {
		//this.birthdate = birthDate;
	//}

	public int getPrimemember() {
		return primeMember;
	}

	public void setPrimemember(int primeMember) {
		this.primeMember = primeMember;
	}
	
	
	
}
