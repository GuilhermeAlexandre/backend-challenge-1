package com.invillia.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique=true)
	@NotNull(message = "The field sku is required")
	private String sku;
	
	@NotNull(message = "The field description is required")
	private String description;
	
	@NotNull(message = "The field price is required")
	private Double price;
	
	@NotNull(message = "The field amount is required")
	private Integer amount;
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	@NotNull(message = "The field store_id is required")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Store store;
	
	public Item() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer quantity) {
		this.amount = quantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void updateAmount(OrdersItem orderItem) {
	  Integer amount = orderItem.getItem().getAmount() - orderItem.getQuantity();
	  this.setAmount(amount);
	}
	
	
	
	
}
