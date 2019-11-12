package com.invillia.acme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "The field address is required")
	private String address;
	
	@NotNull(message = "The field confirmationDate is required")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date confirmationDate;
	
	@NotNull(message = "The field status is required")
	private String status = "Pending";

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "The field user_id is required")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	@NotNull(message = "The field store_id is required")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Store store;
		
	@OneToMany(mappedBy = "order")
    public List<OrdersItem> items;
	
	@OneToMany(mappedBy ="order")
	@JsonIgnore
	private List<Payment> payments;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<OrdersItem> getItems() {
		return items;
	}

	public void setItems(List<OrdersItem> items) {
		this.items = items;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}
