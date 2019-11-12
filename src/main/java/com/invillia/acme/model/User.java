package com.invillia.acme.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The field name is required")
	private String name;
	
	@NotNull(message = "The field email is required")
	@Email(message= "The field email is invalid")
	private String email;
	
	@NotNull(message = "The field password is required")
	@Size(min = 6, max = 15, message = "The password's size must fit in {min} and {max}")
	private String password;

	@ManyToOne
	@JoinColumn(name = "store_id")
	@NotNull(message = "The field store_id is required")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Store store;
	
	@OneToMany(mappedBy ="user")
	@JsonIgnore
	private List<Orders> orders;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	

}
