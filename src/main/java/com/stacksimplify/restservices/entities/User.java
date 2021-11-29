package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstname","lastname"}) -- Static Filter JsonIgnore
//@JsonFilter(value = "userFilter") -- Used for MappingJacksonValue
public class User   {
	
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private long id;
	
	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name= "USER_NAME", length=50, nullable=false, unique=true)
	@JsonView(Views.External.class)
	private String username;
	
	@Size(min=2, message="FirstName should have atleast 2 characters")
	@Column(name= "FIRST_NAME", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String firstname;
	
	@Column(name= "LAST_NAME", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String lastname;
	
	@Column(name= "EMAIL_ADDRESS", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String email;
	
	@Column(name= "ROLE", length=50, nullable=false)
	@JsonView(Views.Internal.class)
	private String role;
	
	@Column(name= "SSN", length=50, nullable=false, unique=true)
	@JsonView(Views.Internal.class)
	//@JsonIgnore 
	private String ssn;

	@OneToMany(mappedBy="user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	// No-argument Constructor
	public User() {
		super();
	}

	// Fields Constructor
	public User(long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Optionnal
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
